public class Pet extends Account{
    private Person owner;

    /**
     * @return Owner of the pet
     */
    public Person getOwner() {return owner;}

    /**
     * Sets the owner of the pet.
     * @param owner The owner of the pet
     */
    void setOwner(Person owner){this.owner = owner;}

    /**
     * Initializes pet
     * @param name The name of the pet
     * @param image An image of the pet
     */
    Pet (String name, Image image) {
        this.setName(name);
        this.setImage(image);
    }

}
