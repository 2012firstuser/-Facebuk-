import java.util.ArrayList;
import java.util.HashMap;

public class Moment {

    private String name;
    private Image image;
    private HashMap<Account, Float> participants = new HashMap<Account, Float>();

    public Moment (String name, Image image, ArrayList<Account> participants, ArrayList<Float> smileValues){
        this.name = name;
        this.image = image;
        for(int i = 0; i < participants.size(); i++){
            this.participants.put(participants.get(i), smileValues.get(i));
        }
    }

    public String getName(){
        return this.name;
    }

    public Image getImage(){
        return this.image;
    }

    public HashMap<Account, Float> getParticipants() {
        return this.participants;
    }

    public boolean equals (Object o) {
        if (o instanceof ourObject) {
            return ((ourObject) o).getName().equals(this.getName());
        }
        return false;
    }
}