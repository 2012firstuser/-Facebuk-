/*
    Todo: Name of Class
    Todo: Class Info
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Account {
    private String name;
    private Image image;
    private ArrayList<Account> friends;
    private ArrayList<Moment> moments;

    public String getName () {
        return this.name;
    }

    public Image getImage () {
        return this.image;
    }

    public ArrayList<Moment> getMoments () {
        return this.moments;
    }

    public ArrayList<Account> getFriends() {
        return this.friends;
    }

    public void setFriends (ArrayList<Account> friends) {
        this.friends = friends;
    }

    public void setMoments (ArrayList<Moment> moments) {
        this.moments = moments;
    }

    public boolean equals (Object o) {
        return this.name.equals(o.getName());
    }

    public Account getFriendWithWhomIAmHappiest (){
        HashMap<Account, Float> friendMap = new HashMap<>();
        Account happiestFriend = null;

        for(Account a : this.friends){
            friendMap.put(a, (float) 0);
        }

        for(Moment m : this.moments){
            for(Account par : m.getParticipants().keySet()){
                if(friendMap.containsKey(par)){
                    friendMap.put(par, friendMap.get(par) + m.getParticipants().get(par));
                }
            }
        }

        for(Account a : friendMap.keySet()){
            if(happiestFriend == null || friendMap.get(happiestFriend) < friendMap.get(a)){
                happiestFriend = a;
            }
        }

        return happiestFriend;
    }

    public Moment getOverallHappiestMoment (){
        Moment happiestMoment = null;

        for(Moment m : moments){
            if(happiestMoment == null || happiestMoment.getParticipants().get(this) < m.getParticipants().get(this)){
                happiestMoment = m;
            }
        }

        return happiestMoment;
    }

    public ArrayList<Account> findMaximumCliqueOfFriends () {
        //TODO: Change this function
        return new ArrayList<Account>();
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
            ArrayList<Account> currentClique = analyzeNode(node, currentVisitedNodes);

            if(currentClique.size() > biggestCliqueCount) {
                biggestCliqueCount = currentClique.size();
                biggestClique = new ArrayList<>(currentClique);
            }
        }

        return biggestClique;
    }
}
