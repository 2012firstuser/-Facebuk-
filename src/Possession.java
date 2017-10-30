public class Possession implements ourObject {
    private String name;
    private Image image;
    private Person owner;
    private Float price;

    public String getName() {return name;}
    public Image getImage() {return image;}
    public Person getOwner() {return owner;}
    public Float getPrice() {return price;}

    void setOwner (Person owner) { this.owner = owner; }

    public Possession (String name, Image image, float price){
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public boolean equals (Object o) {
        if (o instanceof ourObject) {
            return ((ourObject) o).getName().equals(this.getName());
        }

        return false;
    }
}
