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

    // TODO: add fields (map, arrays for stations/units/incidents, counters, tick, etc.)
    // We need to create attributes here

    public int width; //creates city width
    public int height; //creates city height

    // make number of each 'thing'
    public int MAX_STATIONS = 20;
    public int MAX_UNITS = 50;
    public int MAX_INCIDENTS = 200;

    // lists of said 'things'
    public ArrayList<Station> stations = new ArrayList<Station>();

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
        if ((name.equals(""))) {
            throw new InvalidNameException("Name is invalid");
        }
        if ((0 <= x && x < width) && (0 <= y && y < height) && (city_map.checkForObstacle(x, y))) {
            throw new InvalidLocationException("Location is invalid");
        }
        if (stations.size() < MAX_STATIONS) {
            Station new_station = new Station(name, x, y, station_ID++);
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

    @Override //9
    public int addUnit(int stationId, UnitType type) throws IDNotRecognisedException, InvalidUnitException, IllegalStateException {
        
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //10
    public void decommissionUnit(int unitId) throws IDNotRecognisedException, IllegalStateException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
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
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //16
    public void cancelIncident(int incidentId) throws IDNotRecognisedException, IllegalStateException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //17
    public void escalateIncident(int incidentId, int newSeverity) throws IDNotRecognisedException, InvalidSeverityException, IllegalStateException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //18
    public int[] getIncidentIds() {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //19
    public String viewIncident(int incidentId) throws IDNotRecognisedException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //20
    public void dispatch() {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
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
