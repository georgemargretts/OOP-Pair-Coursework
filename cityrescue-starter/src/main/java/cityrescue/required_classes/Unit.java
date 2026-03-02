
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

public abstract class Unit extends GridSpace{
    //Attributes
    public UnitStatus status = UnitStatus.IDLE;
    public UnitType type; // This will be overridden in the subclasses
    public IncidentType type_to_handle;
    public static int nextID = 1;
    public int UnitID;
    public int HOME;
    public String WORK;

    //Constructors
    public Unit(int x_coord, int y_coord) {
        super(x_coord, y_coord);
        this.UnitID = nextID++;
    }

    //Methods
    public void setID(int ID) {
        this.UnitID = ID;
    }

    public void setstatus(UnitStatus newstatus) {
        this.status = newstatus;
    }

    public UnitType getType() {
        return type;
    }

    public UnitStatus getStatus() {
        return status;
    }

}