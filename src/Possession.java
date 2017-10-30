public class Possession extends Page {
    private Person owner;
    private Float price;

    public Person getOwner() {return owner;}
    public Float getPrice() {return price;}

    void setOwner (Person owner) { this.owner = owner; }

    public Possession (String name, Image image, float price) {
        this.setName(name);
        this.setImage(image);
        this.price = price;
    }
}
