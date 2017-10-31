import java.util.ArrayList;
import java.util.HashMap;


/**
 * Abstract Class Account
 *
 * We created this class because a Person and a Pet are effectively the same
 * object, with the exception being that a Person can have a Pet, and that
 * a Pet has a Person as an owner.
 *
 * Because of that situation, it would be inefficient to copy the similar
 * methods and attributes to both Person and Pet, so this class is a way
 * to modularize the program a bit more.
 */

public abstract class Account extends Page {
    private ArrayList<Account> _friends = new ArrayList<>();
    private ArrayList<Moment> _moments = new ArrayList<>();

    /**
     * Retrieve the moments of a child of Account
     * @return an {@link ArrayList<Moment>} of all of the moments of the
     *         child of Account
     */
    public ArrayList<Moment> getMoments () {
        return this._moments;
    }

    /**
     * Retrieve the friends of a child of Account
     * @return an {@link ArrayList<Account>} of all of the friends (Persons /
     *         Pets) of the child of Account
     */
    public ArrayList<Account> getFriends() {
        return this._friends;
    }

    /**
     * Set the friends of a child of Account
     * @param friends the new list of friends for the child of Account
     */
    public void setFriends (ArrayList<Account> friends) {
        this._friends = friends;
    }

    /**
     * Set the moments of a child of Account
     * @param moments the new list of moments for the child of Account
     */
    public void setMoments (ArrayList<Moment> moments) {
        this._moments = moments;
    }

    /**
     * Gets the friend who an account is most happiest with on average
     * @return an Account
     */
    public Account getFriendWithWhomIAmHappiest (){
        HashMap<Account, Float> friendMap = new HashMap<>();
        HashMap<Account, Integer> friendCount = new HashMap<>();
        Account happiestFriend = null;

        for(Account a : this._friends){
            friendMap.put(a, (float) 0);
            friendCount.put(a, 0);
        }

        for(Moment m : this._moments){
            for(Account par : m.getParticipants().keySet()){
                if(friendMap.containsKey(par)){
                    friendMap.put(par, friendMap.get(par) + m.getParticipants().get(par));
                    friendCount.put(par, friendCount.get(par) + 1);
                }
            }
        }

        for(Account a : friendMap.keySet()){
            if(!(friendCount.get(a) == 0) && (happiestFriend == null || (friendMap.get(happiestFriend)/friendCount.get(happiestFriend)) < (friendMap.get(a)/friendCount.get(a)))){
                happiestFriend = a;
            }
        }

        return happiestFriend;
    }

    /**
     * Gets the moment with the happiest average smile value
     * @return happiest moment
     */
    public Moment getOverallHappiestMoment (){
        Moment happiestMoment = null;

        for(Moment m : _moments) {
            if (happiestMoment == null || momentMeanValue(m) > momentMeanValue(happiestMoment)) {
                happiestMoment = m;
            }
        }

        return happiestMoment;
    }

    /**
     * Gets the mean value of happiness across moment participants
     * @param m a moment to get the mean happiness
     * @return mean value of happiness
     */
    private float momentMeanValue(Moment m){
        float totalHappiness = 0;
        HashMap<Account, Float> parsMap = m.getParticipants();

        for(Account par : parsMap.keySet()){
            totalHappiness += parsMap.get(par);
        }

        return totalHappiness / parsMap.size();
    }

    /**
     * Determines the maximum clique of friends for a single person. This is just a
     * trampoline for the recursive method {@see Account#analyzeNode} which determines
     * if each friend of an Account is part of the maximum clique
     *
     * @return  the biggest {@link ArrayList<Account>} of Accounts in wh`ich everybody
     *          is a friend with one another.
     */
    public ArrayList<Account> findMaximumCliqueOfFriends () {
        return this.analyzeNode(this, new ArrayList<Account>());
    }

    /**
     * Determines if the current Account part of the biggest Clique. Given the
     * current Account and the visited Accounts, will check if all of the friends
     * of the current Account are in the visited Accounts.
     *
     * If that is the case, then the function will recursively call itself on the
     * "new" friends of the current Account, and return the largest clique of those
     * results.
     * @param currentNode  the current Account that is being analyzed
     * @param visitedNodes the visited Accounts that are all part of a clique
     * @return             a {@link ArrayList<Account>} of the biggest clique
     */
    private ArrayList<Account> analyzeNode (Account currentNode, ArrayList<Account> visitedNodes) {
        int matchedNodes = 0;
        ArrayList<Account> unvisitedNodes = new ArrayList<Account>();

        for(Account a: currentNode.getFriends()) {
            if (visitedNodes.contains(a)) {
                matchedNodes++;
            }
            else {
                unvisitedNodes.add(a);
            }
        }

        if(matchedNodes < visitedNodes.size()) {
            return visitedNodes;
        }

        ArrayList<Account> currentVisitedNodes = new ArrayList<>(visitedNodes);
        currentVisitedNodes.add(currentNode);

        ArrayList<Account> biggestClique = new ArrayList<>();
        int biggestCliqueCount = 0;

        for(Account node: unvisitedNodes) {
            ArrayList<Account> currentClique = this.analyzeNode(node, currentVisitedNodes);

            if(currentClique.size() > biggestCliqueCount) {
                biggestCliqueCount = currentClique.size();
                biggestClique = new ArrayList<>(currentClique);
            }
        }

        return biggestClique;
    }

    /**
     * Determines if all the inputted Accounts are friends with one another
     * @param set a group of Accounts that is potentially a clique
     * @return    boolean on whether the set is a clique or not
     */
    public static boolean isClique (ArrayList<Account> set) {
        for (Account a : set) {
            int matches = 0;

            for(Account friend: a.getFriends()) {
                for(Account sub_account : set) {
                    if(friend.equals(sub_account)) {
                        matches++;
                    }
                }
            }

            if(matches < set.size() - 1) {
                return false;
            }
        }

        return true;
    }
}
