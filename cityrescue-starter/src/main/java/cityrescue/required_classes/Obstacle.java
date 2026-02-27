
package cityrescue.required_classes;

// Class for the obstacles

public class Obstacle extends GridSpace {
    // Attributes
    public String type = "Obstacle"; // overrides type

    // Constructor
    public Obstacle(int x_coord, int y_coord) {
        super(x_coord, y_coord);
    }

    // Methods
}
