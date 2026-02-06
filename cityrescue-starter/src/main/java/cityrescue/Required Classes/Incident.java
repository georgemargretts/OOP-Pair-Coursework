
// Class for incidents

public class Incident{
    // Attributes
    public String type;
    public int severity;
    public int location;
    public String status = "Reported";
    public int unit;

    // Constructor
    public Incident(type, xcoord, ycoord, severity) {
        this.type = type
        this.location = (xcoord, ycoord)
        this.severity = severity
    }

    // Methods
    public updateSeverity(newseverity) {
        this.severity = newseverity
    }

}