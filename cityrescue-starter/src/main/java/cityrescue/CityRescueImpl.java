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

    public ArrayList<String> stations = new ArrayList<>(); //variable array for station names

    public int tick = 0;
    public int counters = 0;
    public CityMap city_map = new CityMap(width, height);

    // Constructor
    public CityRescueImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Methods

    @Override //1
    public void initialise(int width, int height) throws InvalidGridException {
        // start a new simulation
    }

    @Override //2
    public int[] getGridSize() {
        int[] size = city_map.getGridSize();
        return size;
    }

    @Override //3
    public void addObstacle(int x, int y) throws InvalidLocationException {
        if ((0 <= x && x < width) && (0 <= y && y < height)) {
            city_map.updateObstacle(true, x, y);
        }
    }

    @Override //4
    public void removeObstacle(int x, int y) throws InvalidLocationException {
        if ((0 <= x && x < width) && (0 <= y && y < height)) {
            city_map.updateObstacle(false, x, y);
        }
    }

    @Override //5
    public int addStation(String name, int x, int y) throws InvalidNameException, InvalidLocationException {
        Station newStation = new Station(name, x, y);
    }

    @Override //6
    public void removeStation(int stationId) throws IDNotRecognisedException, IllegalStateException {
        //loop through the entire grid to find the station
        for (int i=0; i < width; i++) {
            for (int j=0; j < width; j++) {
                // if it is a station
                if (grid[i][j] instanceof Station) {
                    // check if it is empty
                    if (grid[i][j].isEmpty() == true) {
                        grid[i][j] = 'S';
                    }
                }
            }
        }
    }

    @Override //7
    public void setStationCapacity(int stationId, int maxUnits) throws IDNotRecognisedException, InvalidCapacityException {
        //loop through the entire grid to find the station
        for (int i=0; i < width; i++) {
            for (int j=0; j < width; j++) {
                // if it is a station
                if (grid[i][j] instanceof Station) {
                    // check capacity > 0 and chosen new max units > current units
                    if (grid[i][j].getMaxUnits() > 0) && (grid[i][j].getCurrentUnits() < maxUnits) {
                        grid[i][j].setCapacity(maxUnits);
                    }
                }
            }
        }
    }

    @Override //8
    public int[] getStationIds() {
        ArrayList<String> list_of_ids = new ArrayList<>();
        //loop through the entire grid to find the station
        for (int i=0; i < width; i++) {
            for (int j=0; j < width; j++) {
                // if it is a station
                if (grid[i][j] instanceof Station) {
                    // add to list
                    list_of_ids.add(grid[i][j].getID());
                }
            }
        list_of_ids.sort();
        System.out.println(list_of_ids);
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
