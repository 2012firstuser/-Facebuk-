import java.util.ArrayList;

//
public class Person extends Account{
    private ArrayList<Pet> pets;
    private ArrayList<Possession> possesions;

    public ArrayList<Pet> getPets() {return this.pets;}
    public ArrayList<Possession> getPosessions() {return this.possesions;}

    public void setPets (ArrayList<Pet> pets) {
        this.pets = pets;
    }
    public void setPossesions (ArrayList<Possession> possesions) { this.possesions = possesions; }

    public Person (String name, Image image) {
        this.setName(name);
        this.setImage(image);
    }
}

