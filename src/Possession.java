public class Possession implements Object {
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
        return this.name.equals(o.getName());
    }


}
