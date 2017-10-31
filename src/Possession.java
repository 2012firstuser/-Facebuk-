public class Possession extends Page {
    private Person owner;
    private Float price;

    /**
     * @return The owner of the possession
     */
    public Person getOwner() {return owner;}
    /**
     * @return The price of the possession
     */
    public Float getPrice() {return price;}

    /**
     * Sets the owner of the possession
     * @param owner The owner of the possession
     */
    void setOwner (Person owner) { this.owner = owner; }

    /**
     * Initializes the possession
     * @param name Name of possession
     * @param image Image of possession
     * @param price Price of Possession
     */
    public Possession (String name, Image image, float price) {
        this.setName(name);
        this.setImage(image);
        this.price = price;
    }
}
