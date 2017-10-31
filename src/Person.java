import java.util.ArrayList;


public class Person extends Account{
    private ArrayList<Pet> pets;
    private ArrayList<Possession> possessions;

    /**
     * @return Pets person owns
     */
    public ArrayList<Pet> getPets() {return this.pets;}
    /**
     * @return Possessions person owns
     */
    public ArrayList<Possession> getPosessions() {return this.possessions;}

    /**
     * Initializes Person
     * @param name The name of the person
     * @param image An image of the person
     */
    public Person (String name, Image image) {
        this.setName(name);
        this.setImage(image);
    }

    /**
     * Sets the pets the person has
     * @param pets The pets tje person has
     */
    public void setPets (ArrayList<Pet> pets) {
        this.pets = pets;
    }

    /**
     * Sets the possessions the person has
     * @param possessions The possessions the person has
     */
    public void setPossessions (ArrayList<Possession> possessions) { this.possessions = possessions; }
}

