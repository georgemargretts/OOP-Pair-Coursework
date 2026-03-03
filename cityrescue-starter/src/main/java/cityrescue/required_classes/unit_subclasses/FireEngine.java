
package cityrescue.required_classes.unit_subclasses;

import cityrescue.required_classes.Unit;
import cityrescue.enums.UnitType;

// Class for ambulances

public class FireEngine extends Unit {
    // Attributes
    public UnitType type = UnitType.FIRE; //Overrides the type

    // Constructor
    public FireEngine(int x_coord, int y_coord) {
        super(x_coord, y_coord);

    }

    // Methods
}