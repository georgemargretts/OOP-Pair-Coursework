
package cityrescue.required_classes;

// This is the abstract class for unit
// Example viewUnit() format U#2 TYPE=FIRE_ENGINE HOME=2 LOC=(3,1) STATUS=AT_SCENE INCIDENT=1 WORK=2

public abstract class Unit extends GridSpace{
    //Attributes

    //Constructors
    public Unit(int x_coord, int y_coord) {
        super(x_coord, y_coord);
    }

    //Methods
}