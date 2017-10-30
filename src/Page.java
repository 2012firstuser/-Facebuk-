/**
 * Abstract Class Page
 *
 * We created this class because all objects in this program have a name, image, and an equals function.
 * Therefore, by abstracting these attributes / methods to a singular class at the top level, we can
 * effectively remove redundancy, an create more modular code to make it easier to edit in the future.
 */

public abstract class Page {
    private String _name;
    private Image _image;

    /**
     * Set the name of a child of Page
     * @param newName The new value for the name
     */
    public void setName(String newName) {
        this._name = newName;
    }

    /**
     * Retrieve the name of a child of Page
     * @return the name of the child
     */
    public String getName() {
        return this._name;
    }

    /**
     * Set the image of a child of Page
     * @param newImage The new value for the Image
     */
    public void setImage(Image newImage) {
        this._image = newImage;
    }

    /**
     * Retrieve the image of a child of Page
     * @return the image of the child
     */
    public Image getImage() {
        return this._image;
    }

    /**
     * Determines if 2 objects are equal. First checks to see if the inputted
     * object is a child of Page. If so, then it means that there is a getName
     * method. Then simply compares the names for the final result.
     * @param o Any object to compare with this one
     * @return  A boolean if the names of the two objects match
     */
    public boolean equals (Object o) {
        if (o instanceof Page) {
            return ((Page) o).getName().equals(this.getName());
        }

        return false;
    }
}
