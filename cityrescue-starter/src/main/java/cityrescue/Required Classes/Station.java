
// The class for stations

public class Station{
    // Attributes
    public String name;
    public int location;
    public int capacity = 1;
    public int ID = 1++;

    // Constructor
    public Station(String name, int xcoord, int ycoord){
        this.name = name
        this.location = (xcoord, ycoord)
    }
    
    // Methods
    public setCapacity(new_capacity) { //sets the new capacity
        this.capacity = new_capacity;
    }

    public getID() { //returns the ID of the station
        return ID
    }
    

}