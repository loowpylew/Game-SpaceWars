package OODCwk;

import java.io.Serializable;

public class Battles implements Serializable {
    // Battle will also extend SpaceWars so that various battles can be compared to with the current forces activated.
    private static int battleNoIncrement = 1; /** This value will auto increment when a new instance of the class is loaded into the battles array within the SpaceWars class,
     * This will allow the new instance to access the previous value of battleNo and use it within a method to increment the existing value by 1
     */
    private int battleNo;
    private BattleType type;
    private String enemy;
    private int enemyStrength;
    private int losses;
    private int gains;

    public Battles(BattleType typ, String enem, int enemStrength, int loss, int gain){
        battleNo = battleNoIncrement++;
        type = typ;
        enemy = enem;
        enemyStrength = enemStrength;
        losses = loss;
        gains = gain;
    }

    public String toString() {
        return "\nBattle No: " + battleNo + "\nBattle Type: " + type + "\nEnemy: " + enemy + "\nEnemy Strength" + enemyStrength + "\nLosses: " + losses + "\nGains: " + gains;
    }

    public int getBattleNo(){
        return battleNo;
    }

    public BattleType getBattleType(){
        return type;
    }

    public int getEnemyStrength(){
        return enemyStrength;
    }

    public int getLosses(){
        return losses;
    }

    public int getGains(){
        return gains;
    }

}
