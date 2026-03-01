
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
    public int ID;

    // Constructor
    public Incident(int x_coord, int y_coord, int severity, IncidentType type, int ID) {
        super(x_coord, y_coord);
        this.severity = severity;
        this.type = type;
        this.ID = ID;
    }

    // Methods
    public void updateSeverity(int newseverity) {
        this.severity = newseverity;
    }

    public void updateStatus(IncidentStatus new_status) {
        this.status = new_status;
    }

    public void updateUnit(int new_unit) {
        this.unit = new_unit;
    }

    public IncidentType getType() {
        return type;
    }

    public int getSeverity() {
        return severity;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public int getUnit() {
        return unit;
    }
}