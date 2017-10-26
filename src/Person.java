import java.util.ArrayList;

//
public class Person extends Account{
    private ArrayList<Pet> pets;
    private ArrayList<Possession> possessions;

    public ArrayList<Pet> getPets() {return this.pets;}
    public ArrayList<Possession> getPosessions() {return this.possessions;}

    public void setPets (ArrayList<Pet> pets) {
        this.pets = pets;
    }
    public void setPossessions (ArrayList<Possession> possesions) { this.possessions = possesions; }

    public Person (String name, Image image) {
        this.setName(name);
        this.setImage(image);
    }
}

