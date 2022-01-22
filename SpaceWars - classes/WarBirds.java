package OODCwk;

import java.io.Serializable;

public class WarBirds extends Force implements Serializable {

    public WarBirds(String ref, String name, int fee, int strength, Boolean cloak, String force){
        super(ref, name, fee, strength, cloak, force);
    }
}
