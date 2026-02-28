
package cityrescue.required_classes;

import cityrescue.enums.*;

/**
 * Incident Class
 * 
 * Child to the GridSpace class
 */

public class Incident extends GridSpace{
    // Attributes
    public IncidentType type; // overrides type
    public int severity;
    public IncidentStatus status = IncidentStatus.REPORTED;
    public int unit;

    // Constructor
    public Incident(int x_coord, int y_coord, int severity, IncidentType type) {
        super(x_coord, y_coord);
        this.severity = severity;
        this.type = type;
    }

    // Methods
    public void updateSeverity(int newseverity) {
        this.severity = newseverity;
    }

}