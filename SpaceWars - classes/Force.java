package OODCwk;

import java.io.Serializable;

public class Force implements Serializable {

    // UFF is a client class to the supplier classes Wings, WarBirds and StarShip.
    private String reference;
    private String name;
    private int fee;
    private int strength;
    private ForceState state; // State for all forces are initially docked hence the use of the 'DOCKED' enum within the constructor
    private String force;

    private Boolean cloaking; // will receive a value once param has been passed when loading instance of class in SpaceWars class

    public Force(String ref, String name, int fee, int strength, String force){
        reference = ref;
        this.name = name;
        this.fee = fee;
        this.strength = strength;
        state = ForceState.DOCKED;
        this.force = force;
    }

    public Force(String ref, String name, int fee, int strength, Boolean cloak, String force){
        reference = ref;
        this.name = name;
        this.fee = fee;
        this.strength = strength;
        state = ForceState.DOCKED;
        cloaking = cloak;
        this.force = force;
    }

    public String toString(){
        return "Force: " + force + "\nRef: " + reference + "\nName: " +
                name + "\nFee: " + fee + "\nStrength: " + strength + "\nForceState: " + state;
    }

    public String getReferenceNo(){

        return reference;
    }
    public String getName(){
        return name;
    }

    public int getFee(){
        return fee;
    }

    public int getForceStrength(){
        return strength;
    }

    public ForceState getForceState(){
        return state;
    }

    public void changeForceState(String st)
    {
        if(st.equals("Docked")){
            state = ForceState.DOCKED;
        }
        else if(st.equals("Active")){
            state = ForceState.ACTIVE;
        }
        else if(st.equals("Destroyed")){
            state = ForceState.DESTROYED; 
        }
    }


    public String getForceType(){

        return force;
    }

    public Boolean possesCloaking(){
        return cloaking;
    }

}
