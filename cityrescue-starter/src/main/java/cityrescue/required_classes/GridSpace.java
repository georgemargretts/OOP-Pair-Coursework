
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
    public int ID;
    
    // Constructor
    public GridSpace(int x_coord, int y_coord) {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    // Methods

    public int[] getLocation() {
        int[] location = {x_coord, y_coord};
        return location;
    }

    public String getStrLocation() {
        String str_location = "(";
        str_location = str_location + Integer.toString(x_coord) + "," + Integer.toString(y_coord) + ")";
        return str_location;
    }
}