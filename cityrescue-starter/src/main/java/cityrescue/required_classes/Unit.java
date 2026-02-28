
package cityrescue.required_classes;

import cityrescue.enums.*;

/**
 * Unit Class
 * 
 * Child to the GridSpace class
 */

// Example viewUnit() format U#2 TYPE=FIRE_ENGINE HOME=2 LOC=(3,1) STATUS=AT_SCENE INCIDENT=1 WORK=2

public abstract class Unit extends GridSpace{
    //Attributes
    public UnitStatus status = UnitStatus.IDLE;
    public UnitType type;
    public IncidentType type_to_handle;
    public int UnitID;

    //Constructors
    public Unit(int x_coord, int y_coord) {
        super(x_coord, y_coord);
    }

    //Methods
    public void setID(int ID) {
        this.UnitID = ID;
    }
}