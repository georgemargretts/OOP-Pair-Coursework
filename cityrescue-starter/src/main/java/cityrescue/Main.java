
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
        int u1 = cr.addUnit(s, UnitType.POLICE_CAR);
        int u2 = cr.addUnit(s, UnitType.POLICE_CAR);

        int i1 = cr.reportIncident(IncidentType.CRIME, 2, 2, 2);

        cr.dispatch();

        String inc = cr.viewIncident(i1);

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(inc);
    }
}