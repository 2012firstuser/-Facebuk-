import java.util.ArrayList;
import java.util.HashMap;

public class Moment extends Page {

    private HashMap<Account, Float> _participants = new HashMap<Account, Float>();

    public Moment (String name, Image image, ArrayList<Account> participants, ArrayList<Float> smileValues){
        this.setName(name);
        this.setImage(image);
        for(int i = 0; i < participants.size(); i++){
            this._participants.put(participants.get(i), smileValues.get(i));
        }
    }

    public HashMap<Account, Float> getParticipants() {
        return this._participants;
    }
}