
package cityrescue.required_classes;

/**
 * Station Class
 * 
 * Child to the GridSpace class
 */

public class Station extends GridSpace{
    // Attributes
    public String type = "Station"; // overrides type
    public int capacity = 1;
    public int current_no_held = 0;
    public int ID;

    // Constructor
    public Station(String name, int x_coord, int y_coord, int ID) {
        super(x_coord, y_coord);
        this.ID = ID;
    }
    
    // Methods
    public void setCapacity(int new_capacity) { //sets the new capacity
        this.capacity = new_capacity;
    }

    public int getID() { //returns the ID of the station
        return ID;
    }
    
    public boolean isEmpty() { //returns if the station is empty or not
        return (current_no_held == 0);
    }

    public int getMaxUnits() { //returns the capacity
        return capacity;
    }

    public int getCurrentUnits() {
        return current_no_held;
    }

    public int[] getLocation() {
        int[] location = {x_coord, y_coord};
        return location;
    }

}