
package cityrescue.required_classes;

import cityrescue.enums.IncidentType;
import cityrescue.enums.UnitStatus;
import cityrescue.enums.UnitType;

/**
 * Unit Class
 * 
 * Child to the GridSpace class
 */

// Example viewUnit() format U#2 TYPE=FIRE_ENGINE HOME=2 LOC=(3,1) STATUS=AT_SCENE INCIDENT=1 WORK=2

public abstract class Unit extends GridSpace {

    //Attributes
    public UnitStatus status = UnitStatus.IDLE;
    public final UnitType type; // This will be overridden in the subclasses
    public int currentIncident = -1;
    public static int nextID = 1;
    public int ID;
    public int home;
    public int workTick = 0;

    //Constructors
    public Unit(int x_coord, int y_coord, UnitType type) {
        super(x_coord, y_coord);
        this.ID = nextID++;
        this.type = type;
    }

    //Methods

    public int getID() { // Returns the ID of the incident
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStatus(UnitStatus newstatus) {
        this.status = newstatus;
    }

    public UnitType getType() {
        return type;
    }

    public UnitStatus getStatus() {
        return status;
    }

    public IncidentType getIncidentType() {
        if (type == UnitType.AMBULANCE){
            return IncidentType.MEDICAL;
        } else if (type == UnitType.FIRE_ENGINE){
            return IncidentType.FIRE;
        } else if (type == UnitType.POLICE_CAR){
            return IncidentType.CRIME;
        }
        return null;
    }

    public void setHome(int new_home) {
        this.home = new_home;
    }

    public int getHome() {
        return home;
    }

    public int getIncidentId() {
        return currentIncident;
    }

    public void setIncidentID(int new_incident_id) {
        currentIncident = new_incident_id;
    }

    public void setLocation(int x_coord, int y_coord) {
    this.x_coord = x_coord;
    this.y_coord = y_coord;
    }

    public int getWorkTick() {
        return workTick;
    }

    public void decrementWorkTick() {
        workTick = workTick - 1;
        System.out.println("The work tick is now:" + workTick);
    }
    
    public void resetWorkTick() {
        if (type == UnitType.AMBULANCE) {
            workTick = 2;
        } else if (type == UnitType.FIRE_ENGINE) {
            workTick = 3;
        } else if (type == UnitType.POLICE_CAR) {
            workTick = 4;
        }
    }
}