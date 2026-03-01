
package cityrescue.required_classes;

/**
 * GridSpace Class
 * 
 * This is the parent class to every Incident, Station and Unit.
 * 
 * It holds the location of the object (in x_coord and y_coord)
 */

public class GridSpace{
    // Attributes
    public int x_coord;
    public int y_coord;
    public String type = "Empty";
    public int ID;

    // Constructor
    public GridSpace(int x_coord, int y_coord) {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    // Methods
    public int getID() { // Returns the ID of the incident
        return ID;
    }

    public int[] getLocation() {
        int[] location = {x_coord, y_coord};
        return location;
    }
}