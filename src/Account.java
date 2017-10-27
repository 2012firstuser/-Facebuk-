/*
    Todo: Name of Class
    Todo: Class Info
 */

import java.util.ArrayList;
import java.util.HashMap;


public abstract class Account implements Object {
    private String _name;
    private Image _image;
    private ArrayList<Account> _friends;
    private ArrayList<Moment> _moments;

    public String getNameame() {
        return this._name;
    }

    public Image getImage () {
        return this._image;
    }

    public ArrayList<Moment> getMoments () {
        return this._moments;
    }

    public ArrayList<Account> getFriends() {
        return this._friends;
    }

    public void setFriends (ArrayList<Account> friends) {
        this._friends = friends;
    }

    public void setMoments (ArrayList<Moment> moments) {
        this._moments = moments;
    }

    public void setName(String _name) {this._name = _name;}

    public void setImage(Image image) {this._image = image;}

    public boolean equals (Object o) {
        return this._name.equals(o.getName());
    }

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
            if(happiestFriend == null || (friendMap.get(happiestFriend)/friendCount.get(happiestFriend)) < (friendMap.get(a)/friendCount.get(a))){
                happiestFriend = a;
            }
        }

        return happiestFriend;
    }

    public Moment getOverallHappiestMoment (){
        Moment happiestMoment = null;
        for(Moment m : _moments) {
            if (happiestMoment == null || momentMeanValue(m) > momentMeanValue(happiestMoment)) {
                happiestMoment = m;
            }
        }
        return happiestMoment;
    }

    protected float momentMeanValue(Moment m){
        float totalHappiness = 0;
        HashMap<Account, Float> parsMap = m.getParticipants();

        for(Account par : parsMap.keySet()){
            totalHappiness += parsMap.get(par);
        }

        return totalHappiness / parsMap.size();
    }

    public ArrayList<Account> findMaximumCliqueOfFriends () {
        return this.analyzeNode(this, new ArrayList<Account>());
    }

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

    public static boolean isClique (ArrayList<Account> set) {
        for (Account a : set) {
            int matches = 0;

            for(Account friend: a.getFriends()) {
                if(set.contains(friend)) {
                    matches++;
                }
                else {
                    return false;
                }
            }

            if(matches < set.size() - 1) {
                return false;
            }
        }

        return true;
    }
}
