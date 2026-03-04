
package cityrescue.required_classes.unit_subclasses;

import cityrescue.required_classes.Unit;
import cityrescue.enums.UnitType;

// Class for ambulances

public class PoliceCar extends Unit {
    // Attributes

    // Constructor
    public PoliceCar(int x_coord, int y_coord, UnitType type) {
        super(x_coord, y_coord, UnitType.POLICE_CAR);

    }
}
