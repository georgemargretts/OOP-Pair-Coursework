/**
 * Unit setup
 */
// Example viewUnit() format U#2 TYPE=FIRE_ENGINE HOME=2 LOC=(3,1) STATUS=AT_SCENE INCIDENT=1 WORK=2
public class Unit {
    //Attributes
    public String unitId = 1++;
    public String type = "N/A";
    public int HOME = "N/A";
    public int[] LOC = {};
    public String STATUS = "IDLE";
    public String INCIDENT = "0";
    public String WORK = "0";

    //Constructors
    public Unit (String, HOME, LOC, STATUS, INCIDENT, WORK) {
        this.HOME = HOME
        this.LOC = LOC
        this.STATUS = STATUS
        this.INCIDENT = INCIDENT
        this.WORK = WORK
    }

    //Methods
    public setLOC (newLOC) {
        this.LOC = newLOC
    }

    public setSTATUS (newSTATUS) {
        this.STATUS = newSTATUS
    }

    public setINCIDENT (newINCIDENT) {
        this.INCIDENT = newINCIDENT
    }

    public setWORK (newWORK) {
        this.WORK = newWORK
    }
}