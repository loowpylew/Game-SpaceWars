package OODCwk;


import java.util.*;
import java.io.*;
import java.io.IOException;
/**
 * This class implements the behaviour expected from a SWAT
 * system as required for 6COM1037 - Nov 2021
 * 
 * @author/s 
 * @version 
 */

public class SpaceWars implements SWAT,Serializable {
    // Fields
    /**
     * The ArrayList 'unitedForcesFleet' will be used to load forces into the the array the instance they have been created.
     */
    private ArrayList<Force> unitedForcesFleet = new ArrayList<Force>();

    private ArrayList<Force> activeStarFleet = new ArrayList<Force>();

    private ArrayList<Battles> battles = new ArrayList<Battles>();

    /**
     * Given a default value of 1000 bitcoins so no need to pass param value in constructor. 
     */
    private int warChest = 1000;

    private final String admiral;

//**************** SWAT **************************  

    /**
     * Constructor requires the name of the admiral
     *
     * @param admiral the name of the admiral
     */
    public SpaceWars(String admiral) {
        this.admiral = admiral;
        setupForces();
        setupBattles();
    }

    /*public SpaceWars(String admiral, String fname) {
        this.admiral = admiral;
        setupForces();
        readBattles(fname);
    }*/


    /**
     * Returns a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * active Star Fleet(ASF),(or, "No forces" if Star Fleet is empty)
     *
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Star Fleet,(or, "No forces" if Star Fleet is empty)
     **/
    public String toString() {

        return "*******************Game******************" +
                "\nAdmiral: " + admiral + "\nWarChest Balance: "
                + getWarchest() + "\nDefeated: " + isDefeated() +
                "\nASF Forces:\n" + getASFleet();
    }

    /**
     * returns the number of bit coins in the war chest
     *
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest() {
        return warChest;

    }

    /**
     * returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     *
     * @returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     */
    public boolean isDefeated() {
        for (Force temp : unitedForcesFleet) {
            if (temp.getForceState() == ForceState.DOCKED) {
                return false;
            }
        }
        return activeStarFleet.size() == 0 && warChest <= 0;
    }

    /**
     * Returns true if force is in the United Forces Fleet(UFF), else false
     *
     * @param ref reference of the force
     * @return a boolean true if the force with the given reference is  in the United Forces Fleet(UFF), else false
     **/
    public boolean isInUFFleet(String ref) {
        for (Force temp : unitedForcesFleet) {
            if (temp.getReferenceNo().equals(ref)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String representation of all forces in the United Forces Fleet(UFF)
     *
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     **/
    public String getUFFleet() {
        String wings = "******************Wings*********************";
        String warBirds = "*****************WarBirds*******************";
        String starShip = "*****************StarShip*******************";

        int i = 0;

        for (Force temp : unitedForcesFleet) {
            if (temp == null) {
                i++;
            } else if (temp.getForceType().equals("Wing")) {
                wings += "\n" + temp.toString() + "\n";
            } else if (temp.getForceType().equals("WarBird")) {
                warBirds += "\n" + temp.toString() + "\n";
            } else if (temp.getForceType().equals("StarShip")) {
                starShip += "\n" + temp.toString() + "\n";
            }
        }
        if (i != unitedForcesFleet.size()) {
            String val = "************United Forces Fleet************\n\n";

            if (!wings.equals("******************Wings*********************")) {
                val += wings + "\n********************************************\n";
            } else {
                val += wings + "\nNo Wings in UFF" + "\n********************************************\n";
            }
            if (!warBirds.equals("*****************WarBirds*******************")) {
                val += warBirds + "\n********************************************\n";
            } else {
                val += warBirds + "\nNo WarBirds in UFF" + "\n********************************************\n";
            }
            if (!starShip.equals("\n*****************StarShip*******************")) {
                val += starShip + "\n********************************************\n";
            } else {
                val += starShip + "\nNo StarShip in UFF" + "\n********************************************\n";
            }

            return val;
        }

        return "************United Forces Fleet************\n\n" + "No forces in UFF" + "\n\n*******************************************";
    }

    /**
     * Returns details of the force in the game with the given reference code
     *
     * @return details of the force in the game with the given reference code
     **/
    public String getForceDetails(String ref) {
        for (Force temp : unitedForcesFleet) {
            if (temp.getReferenceNo().equals(ref)) {
                return temp.toString();
            }
        }
        for (Force temp : activeStarFleet) {
            if (temp.getReferenceNo().equals(ref)) {
                return temp.toString();
            }
        }
        return "\nNo such force";
    }


    // ***************** active Star Fleet Forces ************************

    /**
     * Allows a force to be activated into the active Star Fleet(ASF), but
     * only if there are enough resources for the activation fee.The force's
     * state is set to "active"
     *
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the UFF
     * 2 if not enough money, -1 if no such force
     **/
    public int activateForce(String ref) {
        int i = 0;
        for (Force temp : unitedForcesFleet) {
            i++;
            if (temp.getReferenceNo().equals(ref)) {

                if (warChest >= temp.getFee() && temp.getForceState() == ForceState.DOCKED) {
                    temp.changeForceState("Active");
                    activeStarFleet.add(temp);
                    unitedForcesFleet.remove(temp);
                    warChest -= temp.getFee();
                    return 0;
                } else if (warChest < temp.getFee()) {
                    return 2;
                }
            } else if (i == unitedForcesFleet.size()) {
                for (Force temp1 : activeStarFleet) {
                    if (temp1.getReferenceNo().equals(ref)) {
                        return 1;
                    }
                }
            }
        }

        return -1;
    }


    /**
     * Returns true if the force with the reference code is in
     * the active Star Fleet(ASF), false otherwise.
     *
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the active Star Fleet(ASF), false otherwise.
     **/
    public boolean isInASFleet(String ref) {
        for (Force temp : activeStarFleet) {
            if (temp.getReferenceNo().equals(ref)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Recalls a force from the Star Fleet(ASF) back to the UFF dock, but only
     * if they are in the active Star Fleet(ASF)
     * pre-condition: isInASFleet(ref)
     *
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref) {

        List<Force> list = new ArrayList<Force>();

        for (Force temp : activeStarFleet) {
            if (temp.getReferenceNo().equals(ref) && temp.getForceState() == ForceState.ACTIVE) {
                temp.changeForceState("Docked");
                warChest += temp.getFee() / 2;
                list.add(temp);
            }
        }
        unitedForcesFleet.addAll(list);
        activeStarFleet.removeAll(list);
    }

    /**
     * Returns a String representation of the forces in the active
     * Star Fleet(ASF), or the message "No forces activated"
     *
     * @return a String representation of the forces in the active
     * Star Fleet, or the message "No forces activated"
     **/
    public String getASFleet() {
        String wings = "******************Wings*********************";
        String warBirds = "*****************WarBirds*******************";
        String starShip = "*****************StarShip*******************";

        int i = 0;

        for (Force temp : activeStarFleet) {
            if (temp == null) {
                i++;
            } else if (temp.getForceType().equals("Wing")) {
                wings += "\n" + temp.toString() + "\n";
            } else if (temp.getForceType().equals("WarBird")) {
                warBirds += "\n" + temp.toString() + "\n";
            } else if (temp.getForceType().equals("StarShip")) {
                starShip += "\n" + temp.toString() + "\n";
            }
        }
        if (i != activeStarFleet.size()) {
            String val = "*************Active Star Fleet*************\n\n";

            if (!wings.equals("******************Wings*********************")) {
                val += wings + "\n********************************************\n";
            } else {
                val += wings + "\nNo Wings in ASF" + "\n********************************************\n";
            }
            if (!warBirds.equals("*****************WarBirds*******************")) {
                val += warBirds + "\n********************************************\n";
            } else {
                val += warBirds + "\nNo WarBirds in ASF" + "\n********************************************\n";
            }
            if (!starShip.equals("*****************StarShip*******************")) {
                val += starShip + "\n********************************************\n";
            } else {
                val += starShip + "\nNo StarShip in ASF" + "\n********************************************\n";
            }

            return val;
        }

        return "*************Active Star Fleet*************\n\n" + "No forces in ASF" + "\n\n*******************************************";
    }

//**********************Battles************************* 

    /**
     * returns true if the number represents a battle
     *
     * @param num is the number of the required battle
     * @returns true if the number represents a battle
     **/
    public boolean isBattle(int num) {
        for (Battles temp : battles) {
            if (temp.getBattleNo() == num) {
                return true;
            }
        }
        return false;
    }


    /**
     * Provides a String representation of a battle given by
     * the battle number
     *
     * @param num the number of the battle
     * @return returns a String representation of a battle given by
     * the battle number
     **/
    public String getBattle(int num) {
        System.out.println("\n*************Battle " + "(" + num + ")*******************");
        for (Battles temp : battles) {
            if (temp.getBattleNo() == num) {
                return temp.toString() + "\n*******************************************";
            }
        }
        return "No such battle";
    }

    /**
     * Provides a String representation of all battles
     *
     * @return returns a String representation of all battles
     **/
    public String getAllBattles() {
        String allBattles = "\n******************All Battles********************";

        for (Battles temp : battles) {
            allBattles += temp.toString();
        }
        if (battles.size() != 0) {
            return allBattles += "\n*************************************************";
        }

        return "No Battles";
    }


    /**
     * Retrieves the battle represented by the battle number.Finds
     * a force from the active Star Fleet which can engage in the battle.The
     * results of battle will be one of the following:
     * 0 - Battle won, battle gains added to the warchest,
     * 1 - Battle lost as no suitable force available, battle losses
     * deducted from warchest
     * 2 - Battle lost on battle strength , battle losses
     * deducted from warchest and force destroyed
     * 3 - If a battle is lost and admiral completely defeated (no resources and
     * no forces to recall)
     * -1 - no such battle
     *
     * @param battleNo is the number of the battle
     * @return an int showing the result of the battle
     */
    public int doBattle(int battleNo) {
        for (Battles battle : battles) {
            if (battle.getBattleNo() == battleNo) {
                for (Force force : activeStarFleet) {
                    if (force.getForceState() == ForceState.ACTIVE) {
                        if (battle.getBattleType() == BattleType.SKIRMISH) {
                            if (force.getForceType().equals("Wing") || force.getForceType().equals("StarShip")) {
                                if (battle.getEnemyStrength() < force.getForceStrength()) {
                                    warChest += battle.getGains();
                                    return 0;
                                } else {
                                    warChest -= battle.getLosses();
                                    force.changeForceState("Destroyed");
                                    return 2;
                                }
                            } else {
                                warChest -= battle.getLosses();
                                return 1;
                            }
                        } else if (battle.getBattleType() == BattleType.AMBUSH) {
                            if (force.getForceType().equals("Wing") || (force.getForceType().equals("WarBird") && force.possesCloaking())) {
                                if (battle.getEnemyStrength() < force.getForceStrength()) {
                                    warChest += battle.getGains();
                                    return 0;
                                } else {
                                    warChest -= battle.getLosses();
                                    force.changeForceState("Destroyed");
                                    return 2;
                                }
                            } else {
                                warChest -= battle.getLosses();
                                return 1;
                            }
                        } else if (battle.getBattleType() == BattleType.FIGHT) {
                            if (force.getForceType().equals("StarShip") || force.getForceType().equals("WarBird")) {
                                if (battle.getEnemyStrength() < force.getForceStrength()) {
                                    warChest += battle.getGains();
                                    return 0;
                                } else {
                                    warChest -= battle.getLosses();
                                    force.changeForceState("Destroyed");
                                    return 2;
                                }
                            } else {
                                warChest -= battle.getLosses();
                                return 1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    //**********************private methods*****************************
    private void setupForces() {
        Force wings = new Wings("IW1", "Twisters", 200, 200, 10, "Wing");
        unitedForcesFleet.add(wings);
        Force wings2 = new Wings("IW4", "Wingers", 200, 400, 20, "Wing");
        unitedForcesFleet.add(wings2);
        Force wings3 = new Wings("IW10", "Flyers", 200, 400, 5, "Wing");
        unitedForcesFleet.add(wings3);
        Force warBird = new WarBirds("WB3", "Droop", 300, 100, false, "WarBird");
        unitedForcesFleet.add(warBird);
        Force warBird2 = new WarBirds("WB5", "Hang", 400, 300, true, "WarBird");
        unitedForcesFleet.add(warBird2);
        Force warBird3 = new WarBirds("WB9", "Hover", 300, 400, false, "WarBird");
        unitedForcesFleet.add(warBird3);
        Force starShip = new StarShip("SS2", "Enterprise", 300, 200, 10, 20, "StarShip");
        unitedForcesFleet.add(starShip);
        Force starShip2 = new StarShip("SS6", "Voyager", 450, 200, 15, 10, "StarShip");
        unitedForcesFleet.add(starShip2);
        Force starShip3 = new StarShip("SS7", "Explorer", 120, 65, 4, 5, "StarShip");
        unitedForcesFleet.add(starShip3);
    }

    private void setupBattles() {
        Battles battle1 = new Battles(BattleType.FIGHT, "Borg", 200, 300, 100);
        battles.add(battle1);
        Battles battle2 = new Battles(BattleType.SKIRMISH, "Kardassians", 700, 200, 120);
        battles.add(battle2);
        Battles battle3 = new Battles(BattleType.AMBUSH, "Ferengi", 100, 400, 150);
        battles.add(battle3);
        Battles battle4 = new Battles(BattleType.FIGHT, "Ewoks", 600, 600, 200);
        battles.add(battle4);
        Battles battle5 = new Battles(BattleType.AMBUSH, "Borg", 500, 400, 90);
        battles.add(battle5);
        Battles battle6 = new Battles(BattleType.SKIRMISH, "Groaners", 150, 100, 100);
        battles.add(battle6);
        Battles battle7 = new Battles(BattleType.FIGHT, "Borg", 150, 500, 300);
        battles.add(battle7);
        Battles battle8 = new Battles(BattleType.AMBUSH, "Wailers", 300, 300, 300);
        battles.add(battle8);
    }

    //*******************************************************************************
    //*******************************************************************************

    //These methods are not needed until Task 4.5
    // ***************   file write/read  *********************

    /**
     * Writes whole game to the specified file
     *
     * @param fname name of file storing requests
     */
    public void saveGame(String fname) {   // uses object serialisation
        try {
            ObjectOutputStream outf = new ObjectOutputStream(new FileOutputStream(fname));

            SpaceWars prevGame = new SpaceWars(admiral);
            List<Force> list = new ArrayList<Force>(prevGame.unitedForcesFleet);

            prevGame.unitedForcesFleet.removeAll(list);
            prevGame.unitedForcesFleet.addAll(unitedForcesFleet);
            prevGame.activeStarFleet.addAll(activeStarFleet);

            prevGame.warChest = warChest;

            outf.writeObject(prevGame);
            outf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads all information about the game from the specified file
     * and returns a SpaceWars object
     *
     * @param fname name of file storing the game
     */
    public SpaceWars restoreGame(String fname) {   // uses object serialisation
        try {
            ObjectInputStream inf = new ObjectInputStream(new FileInputStream(fname));

            SpaceWars f = null;

            f = (SpaceWars) inf.readObject();

            return f;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private void readBattles(String fname) {
        try {
            File f = new File(fname);
            Scanner sc = new Scanner(f);
            BattleType type = null;
            String enemy;
            int enemyStrength;
            int losses;
            int gains;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split(",");

                for (int i = 0; i <= details.length; i++) {
                    if (i == 0 || i == ((i * 4) + i)) {
                        if (Objects.equals(details[i], "Fight")) {
                            type = BattleType.FIGHT;
                        } else if (Objects.equals(details[i], "Skirmish")) {
                            type = BattleType.SKIRMISH;
                        } else if (Objects.equals(details[i], "Ambush")) {
                            type = BattleType.AMBUSH;
                        }

                        enemy = details[1];
                        enemyStrength = Integer.parseInt(details[2]);
                        losses = Integer.parseInt(details[3]);
                        gains = Integer.parseInt(details[4]);
                    }

                    if (i != 0 && i == ((i * 4) + (i + 1))) {
                        enemy = details[i];

                    } else {
                        enemy = null;
                    }
                    if ((i != 0 && i != 1) && i == ((i * 4) + (i + 2))) {
                        enemyStrength = Integer.parseInt(details[i]);
                    } else {
                        enemyStrength = 0;
                    }
                    if ((i != 0 && i != 1 && i != 2) && i == ((i * 4) + (i + 3))) {
                        losses = Integer.parseInt(details[i]);
                    } else {
                        losses = 0;
                    }
                    if ((i != 0 && i != 1 && i != 2 && i != 3) && i == ((i * 4) + (i + 4))) {
                        gains = Integer.parseInt(details[i]);
                    } else {
                        gains = 0;
                    }

                    if (i == 0) {
                        Battles battle1 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle1);
                    } else if (i == 1) {
                        Battles battle2 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle2);

                    } else if (i == 2) {
                        Battles battle3 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle3);

                    } else if (i == 3) {
                        Battles battle4 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle4);

                    } else if (i == 4) {
                        Battles battle5 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle5);

                    } else if (i == 5) {
                        Battles battle6 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle6);

                    } else if (i == 6) {
                        Battles battle7 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle7);

                    } else if (i == 7) {
                        Battles battle8 = new Battles(type, enemy, enemyStrength, losses, gains);
                        battles.add(battle8);

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}



