package cityrescue;

import cityrescue.enums.*;
import cityrescue.exceptions.*;
import cityrescue.required_classes.*;
import cityrescue.required_classes.unit_subclasses.*;

import java.util.ArrayList;

/**
 * CityRescueImpl (Starter)
 *
 * Your task is to implement the full specification.
 * You may add additional classes in any package(s) you like.
 */

public class CityRescueImpl implements CityRescue {

    public static void main(String[] args) {
        System.out.println("Hello");
    }

    // We need to create attributes here

    public int width; //creates city width
    public int height; //creates city height

    // make number of each 'thing'
    public int MAX_STATIONS = 20;
    public int MAX_UNITS = 50;
    public int MAX_INCIDENTS = 200;

    // lists of said 'things'
    public ArrayList<Station> stations = new ArrayList<Station>();
    public ArrayList<Incident> incidents = new ArrayList<Incident>();
    public ArrayList<Unit> units = new ArrayList<>();

    public int tick = 0;
    public int counters = 0;
    public CityMap city_map;

    public int station_ID = 1;
    public int unit_ID = 1;
    public int incident_id = 1;

    // Methods

    @Override //1
    public void initialise(int width, int height) throws InvalidGridException {
        city_map = new CityMap(width, height);
    }

    @Override //2 #done
    public int[] getGridSize() {
        int[] size = city_map.getGridSize();
        return size;
    }

    @Override //3 #done
    public void addObstacle(int x, int y) throws InvalidLocationException {
        if ((0 <= x && x < width) && (0 <= y && y < height)) {
            city_map.updateObstacle(true, x, y);
        }
    }

    @Override //4 #done
    public void removeObstacle(int x, int y) throws InvalidLocationException {
        if ((0 <= x && x < width) && (0 <= y && y < height)) {
            city_map.updateObstacle(false, x, y);
        }
    }

    @Override //5
    public int addStation(String name, int x, int y) throws InvalidNameException, InvalidLocationException, CapacityExceededException {
        if ((name.equals(""))) { // Does the name equal ""
            throw new InvalidNameException("Name is invalid");
        }
        if ((0 <= x && x < width) && (0 <= y && y < height) && (city_map.checkForObstacle(x, y))) { // Is the location valid
            throw new InvalidLocationException("Location is invalid");
        }
        if (stations.size() < MAX_STATIONS) { // Can we create another station without going over the limit
            Station new_station = new Station(name, x, y, station_ID++); // creates the station
            stations.add(new_station);
            return new_station.getID();
        } else {
            throw new CapacityExceededException("Max number os stations reached");
        }
    }

    @Override //6
    public void removeStation(int stationId) throws IDNotRecognisedException, IllegalStateException {
        for (int a = 0; a < stations.size(); a++) { // loops through all stations in station list
            int current_ID = stations.get(a).getID(); // gets the id of the current station
            if (current_ID == stationId) { // compares ids
                if (stations.get(a).isEmpty() == true) { // checks if it is empty
                    stations.remove(a);
                    return;
                }
                else {
                    throw new IllegalStateException("Station is not empty");
                }
            }
        }
        throw new IDNotRecognisedException("ID not found in list of stations");
    }

    @Override //7
    public void setStationCapacity(int stationId, int maxUnits) throws IDNotRecognisedException, InvalidCapacityException {
        for (int a = 0; a < stations.size(); a++) { // loops through all stations in station list
            int current_ID = stations.get(a).getID(); // gets the id of the current station
            if (current_ID == stationId) { // compares ids
                if (stations.get(a).getMaxUnits() > 0 && stations.get(a).getCurrentUnits() < maxUnits) { // checks if maxUnits is an acceptable number
                    stations.get(a).setCapacity(maxUnits);
                    return;
                }
                else {
                    throw new InvalidCapacityException("New MaxUnits is an invalid input");
                }
            }
        }
        throw new IDNotRecognisedException("ID not found in list of stations");
    }

    @Override //8
    public int[] getStationIds() {
        int[] list_of_ids;
        list_of_ids = new int[stations.size()];
        for (int a = 0; a < stations.size(); a++) {
            int current_ID = stations.get(a).getID();
            list_of_ids[a] = current_ID;
        }
        return list_of_ids;
    }

    @Override //9 #done i think?
    public int addUnit(int stationId, UnitType type) throws IDNotRecognisedException, InvalidUnitException, IllegalStateException {
        for (int a = 0; a < stations.size(); a++) { // loops through all stations in station list
            Station station = stations.get(a);
            int current_ID = station.getID(); // gets the id of the current station
            if (current_ID == stationId) { // compares ids
                if (station.getMaxUnits() > station.getCurrentUnits()) {
                    if (type != null) {
                        int[] location = station.getLocation();
                        Unit new_unit = switch(type) {
                            case AMBULANCE -> new Ambulance(location[0], location[1]);
                            case FIRE_ENGINE -> new FireEngine(location[0], location[1]);
                            case POLICE_CAR -> new PoliceCar(location[0], location[1]);
                            default -> throw new InvalidUnitException("Invalid unit type");
                        };
                        new_unit.HOME = station.getID(); // Assigns a home to the unit (the station's Id)
                        units.add(new_unit);  // Added to units with unique Id
                        station.incrementUnits();  // Update station
                        return new_unit.getID();
                    } else {
                        throw new IllegalStateException("Null unit type");
                    }
                } else {
                    throw new IllegalStateException("Station already at capacity");
                }
            }
        }
        throw new IDNotRecognisedException("Station ID not found" + stationId);
    }

    @Override //10 #done i think?
    public void decommissionUnit(int unitId) throws IDNotRecognisedException, IllegalStateException {
        for (int a = 0; a < units.size(); a++) { // loops through all units in units list
            Unit unit = units.get(a); 
            if (unit.getStatus() == UnitStatus.IDLE) {
                if (unitId == unit.getID() ) {

                    Station station = null; // Needs to exist before statements
                    for (Station s : stations) { // Finds the units home
                        if (s.getID() == unit.HOME) {
                            station = s;
                            break;
                        }
                    }
                    
                    if (station == null) {
                        throw new IllegalStateException("Unit's home station not found");
                    }
                    units.remove(a); // Removes unit from array
                    station.decrementUnits(); // Removes 1 space from the station
                    return;
                }
            } else {
                throw new IllegalStateException("Unit is busy");
            }
        }
        throw new IDNotRecognisedException("Unit ID not found");
    }

    @Override //11
    public void transferUnit(int unitId, int newStationId) throws IDNotRecognisedException, IllegalStateException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //12
    public void setUnitOutOfService(int unitId, boolean outOfService) throws IDNotRecognisedException, IllegalStateException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //13
    public int[] getUnitIds() {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //14
    public String viewUnit(int unitId) throws IDNotRecognisedException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //15
    public int reportIncident(IncidentType type, int severity, int x, int y) throws InvalidSeverityException, InvalidLocationException {
        if (severity <= 5) { // Is the severity valid
            throw new InvalidSeverityException("Severity is invalid");
        }
        if ((0 <= x && x < width) && (0 <= y && y < height) && (city_map.checkForObstacle(x, y))) { // Is the location valid
            throw new InvalidLocationException("Location is invalid");
        }
        if (type != null) {
            Incident new_incident = new Incident(x, y, severity, type, incident_id++);
            incidents.add(new_incident);
            return new_incident.getID();
        } else {
            throw new IllegalStateException("Invalid type of incident");
        }
    }

    @Override //16
    public void cancelIncident(int incidentId) throws IDNotRecognisedException, IllegalStateException {
        for (int a = 0; a < incidents.size(); a++) { // loops through all stations in station list
            int current_ID = incidents.get(a).getID(); // gets the id of the current station
            if (current_ID == incidentId) { // compares ids
                incidents.get(a).updateStatus(IncidentStatus.CANCELLED);
                return;
            }
        }
        throw new IDNotRecognisedException("ID not found in list of stations");
    }

    @Override //17
    public void escalateIncident(int incidentId, int newSeverity) throws IDNotRecognisedException, InvalidSeverityException, IllegalStateException {
        if (newSeverity < 1 && newSeverity > 5) {
            throw new InvalidSeverityException("Invalid severity change");
        }
        for (int a = 0; a < incidents.size(); a++) { // loops through all stations in station list
            int current_ID = incidents.get(a).getID(); // gets the id of the current station
            if (current_ID == incidentId) { // compares ids
                incidents.get(a).updateSeverity(newSeverity);
            }
        }
        throw new IDNotRecognisedException("ID not found in list of stations");
    }

    @Override //18
    public int[] getIncidentIds() {
        int[] list_of_ids;
        list_of_ids = new int[incidents.size()];
        for (int a = 0; a < incidents.size(); a++) {
            int current_ID = incidents.get(a).getID();
            list_of_ids[a] = current_ID;
        }
        return list_of_ids;
    }

    @Override //19
    public String viewIncident(int incidentId) throws IDNotRecognisedException {
        // format : I#1 TYPE=FIRE SEV=4 LOC=(3,1) STATUS=IN_PROGRESS UNIT=2
        for (int a = 0; a < incidents.size(); a++) {
            int current_ID = incidents.get(a).getID(); // gets the id of the current station
            if (current_ID == incidentId) {
                IncidentType type = incidents.get(a).getType();
                int severity = incidents.get(a).getSeverity();
                int[] location = incidents.get(a).getLocation();
                IncidentStatus status = incidents.get(a).getStatus();
                int unit = incidents.get(a).getUnit();
                String output = String.format(
                    "I#%d TYPE=%s SEV=%d LOC=(%d, %d) STATUS=%s UNIT=%d",
                    incidentId, type, severity, location, status, unit    
                );
                return output;
            }
        }
        throw new IDNotRecognisedException("ID not found");
    }    

    @Override //20
    public void dispatch() {
        /* 
        Assigns units to waiting incidents :
        Find each REPORTED incident
        For each incident (lower id - higher id):
            1. find units in closeness (manhattan distance)
            2. check for the closest that is the correct type
            3. is there is a tie-break, do the tie-break so it is always the same
        Set incident to DISPATCH
        Set chosen Unit to EN_ROUTE
        */
        for (int a = 0; a < incidents.size(); a++) {
            
        }
    }

    @Override //21
    public void tick() {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //22
    public String getStatus() {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
