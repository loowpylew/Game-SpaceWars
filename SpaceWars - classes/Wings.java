package OODCwk;

import java.io.Serializable;

public class Wings extends Force implements Serializable {

    private int striker; // will receive a value once param has been passed when loading instance of class in SpaceWars class

    public Wings(String ref, String name, int fee, int strength, int striker, String force){
        super(ref, name, fee, strength, force);
        this.striker = striker;
    }

}
