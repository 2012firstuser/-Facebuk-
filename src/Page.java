public abstract class Page {
    private String _name;
    private Image _image;

    public void setName(String newName) {
        this._name = newName;
    }

    public String getName() {
        return this._name;
    }

    public void setImage(Image newImage) {
        this._image = newImage;
    }

    public Image getImage() {
        return this._image;
    }

    public boolean equals (Object o) {
        if (o instanceof Page) {
            return ((Page) o).getName().equals(this.getName());
        }

        return false;
    }
}
