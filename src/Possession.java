public class Possession {
    private String name;
    private Image image;
    private Person owner;
    private Float price;

    String getName() {return name;}
    Image getImage() {return image;}
    Person getOwner() {return owner;}
    Float getPrice() {return price;}

    void setOwner (Person owner) { this.owner = owner; }

    public Possession (String name, Image image, float price){
        this.name = name;
        this.image = image;
        this.price = price;
    }


}
