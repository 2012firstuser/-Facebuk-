import java.util.ArrayList;
import java.util.HashMap;

public class Moment implements ourObject{

    private String _name;
    private Image _image;
    private HashMap<Account, Float> _participants = new HashMap<Account, Float>();

    public Moment (String name, Image image, ArrayList<Account> participants, ArrayList<Float> smileValues){
        _name = name;
        _image = image;
        for(int i = 0; i < participants.size(); i++){
            _participants.put(participants.get(i), smileValues.get(i));
        }
    }

    public String getName(){
        return _name;
    }

    public Image getImage(){
        return _image;
    }

    public HashMap<Account, Float> getParticipants() {
        return _participants;
    }

    public boolean equals (Object o) {
        if (o instanceof ourObject) {
            return ((ourObject) o).getName().equals(this.getName());
        }

        return false;
    }
}