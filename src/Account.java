/*
    Todo: Name of Class
    Todo: Class Info
 */

import java.util.ArrayList;

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
        return moments;
    }

    public ArrayList<Account> getFriends() {
        return friends;
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

    public Moment getOverallHappiestMoment(){
        Moment happiestMoment;
        for(Moment m: this.moments.values()){
            if(happiestMoment == null || happiestMoment.getParticipants.get(this) < m.getParticipants.get(this)){
                happiestMoment = m;
            }
        }
        return happiestMoment;
    }
}
