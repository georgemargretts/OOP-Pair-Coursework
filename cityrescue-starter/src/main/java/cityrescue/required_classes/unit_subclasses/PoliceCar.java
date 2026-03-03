
package cityrescue.required_classes.unit_subclasses;

import cityrescue.required_classes.Unit;
import cityrescue.enums.UnitType;

// Class for ambulances

public class PoliceCar extends Unit {
    // Attributes
    public UnitType type = UnitType.POLICE_CAR; //Overrides the type

    // Constructor
    public PoliceCar(int x_coord, int y_coord) {
        super(x_coord, y_coord);

    }

    // Methods
}