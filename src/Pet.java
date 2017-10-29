public class Pet extends Account{
    private Person owner;

    public Person getOwner() {return owner;}

    void setOwner(Person owner){this.owner = owner;}

    Pet (String name, Image image) {
        this.setName(name);
        this.setImage(image);
    }

}
