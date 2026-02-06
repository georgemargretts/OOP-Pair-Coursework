package cityrescue;

import cityrescue.enums.*;
import cityrescue.exceptions.*;
import CityMap, Incident, Station, Unit

/**
 * CityRescueImpl (Starter)
 *
 * Your task is to implement the full specification.
 * You may add additional classes in any package(s) you like.
 */
public class CityRescueImpl implements CityRescue {

    // TODO: add fields (map, arrays for stations/units/incidents, counters, tick, etc.)
    // We need to create attributes here

    public int width = 1; //sets width
    public int height = 1; //sets height
    public char[][] grid = new int[width][height]; // creates the grid

    public ArrayList<String> stations = new ArrayList<>; //variable array for station names

    public int tick = 0
    public int counters = 0

    @Override //1
    public void initialise(int width, int height) throws InvalidGridException {
        grid = int[width][height];
        tick = 0
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //2
    public int[] getGridSize() {
        return {width, height}
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //3
    public void addObstacle(int x, int y) throws InvalidLocationException {
        if (0 <= x < width) & (0 <= y < height) {
            grid[x][y] = char "X";
        }
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //4
    public void removeObstacle(int x, int y) throws InvalidLocationException {
        if (0 <= x < width) & (0 <= y < height) {
            grid[x][y] = char "";
        }
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //5
    public int addStation(String name, int x, int y) throws InvalidNameException, InvalidLocationException {
        Station newStation = new Station(name, x, y);
        return(newStation.getID();)
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //6
    public void removeStation(int stationId) throws IDNotRecognisedException, IllegalStateException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //7
    public void setStationCapacity(int stationId, int maxUnits) throws IDNotRecognisedException, InvalidCapacityException {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //8
    public int[] getStationIds() {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override //9
    public int addUnit(int stationId, UnitType type) throws IDNotRecognisedException, InvalidUnitException, IllegalStateException {
        // TODO: implement
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
