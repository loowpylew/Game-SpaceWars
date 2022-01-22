package OODCwk;

import java.io.Serializable;

public class StarShip extends Force implements Serializable {

    private int laserCannons; // will receive a value once param has been passed when loading instance of class in SuperWars class
    private int photonTorpedoes; // will receive a value once param has been passed when loading instance of class in SuperWars class

    public StarShip(String ref, String name, int fee, int strength, int lzCannon, int ptonTorps, String force) {
        super(ref, name, fee, strength, force);
        laserCannons = lzCannon;
        photonTorpedoes = ptonTorps;
    }

}
