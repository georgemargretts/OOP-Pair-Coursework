
package cityrescue.required_classes.unit_subclasses;

import cityrescue.required_classes.Unit;
import cityrescue.enums.UnitType;

// Class for ambulances

public class Ambulance extends Unit {
    // Attributes

    // Constructor
    public Ambulance(int x_coord, int y_coord, UnitType type) {
        super(x_coord, y_coord, UnitType.AMBULANCE);

    }
}