
package cityrescue.required_classes;

/**
 * Station Class
 * 
 * Child to the GridSpace class
 */

public class Station extends GridSpace{
    // Attributes
    public String type = "Station"; // overrides type
    public int capacity = 50;
    public int current_no_held = 0;
    public int ID = 0;
    public static int nextID = 1;
    public String name;

    // Constructor
    public Station(String name, int x_coord, int y_coord) {
        super(x_coord, y_coord);
        this.ID = nextID++;
        this.name = name;
    }
    
    // Methods
    public int getID() { // Returns the ID of the incident
        return ID;
    }

    public void setCapacity(int new_capacity) { //sets the new capacity
        this.capacity = new_capacity;
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

    public void incrementUnits() {
        this.current_no_held++;
    }

    public void decrementUnits() {
        this.current_no_held--;
    }
}