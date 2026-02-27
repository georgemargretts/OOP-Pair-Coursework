
package cityrescue.required_classes.unit_subclasses;

import cityrescue.required_classes.Unit;
import cityrescue.enums.UnitType;

// Class for ambulances

public class Ambulance extends Unit {
    // Attributes
    public UnitType type = UnitType.AMBULANCE; //Overrides the type

    // Constructor
    public Ambulance(int x_coord, int y_coord) {
        super(x_coord, y_coord);

    }

    // Methods
}