
package cityrescue.required_classes;

/**
 * Incident Class
 * 
 * Child to the GridSpace class
 */

public class Incident extends GridSpace{
    // Attributes
    public String type = "Incident"; // overrides type
    public int severity;
    public int location;
    public String status = "Reported";
    public int unit;

    // Constructor
    public Incident(int x_coord, int y_coord, int severity) {
        super(x_coord, y_coord);
        this.severity = severity;
    }

    // Methods
    public void updateSeverity(int newseverity) {
        this.severity = newseverity;
    }

}