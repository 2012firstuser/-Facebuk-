public class Moment {

    private String name;
    private Image image;
    private map<Account, int> participants

    public Moment (String name, Image image, ArrayList participants, ArrayList smileValues){
        this.name = name;
        this.image = image;
        for(int i = 0; i < participants.length; i ++){
            this.participants.put(participants.get(i), smileValues.get(i));
        }
    }
}