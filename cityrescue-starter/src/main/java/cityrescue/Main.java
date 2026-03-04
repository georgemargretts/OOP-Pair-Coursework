
package cityrescue;

import cityrescue.enums.*;
import cityrescue.exceptions.*;
import cityrescue.required_classes.*;
import cityrescue.required_classes.unit_subclasses.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        CityRescueImpl cr = new CityRescueImpl();
        cr.initialise(6, 6);

        int s = cr.addStation("A", 0, 0);
        int u = cr.addUnit(s, UnitType.AMBULANCE);

        int i = cr.reportIncident(IncidentType.MEDICAL, 1, 0, 1);
        cr.dispatch();

        cr.tick(); // should arrive at (0,1) in one tick
        String a = cr.viewUnit(u);
        System.out.println(a);

        cr.tick();
        cr.tick();
        String b = cr.viewIncident(i);
        String c = cr.viewUnit(u);
        System.out.println(b);
        System.out.println(c);
    }
}