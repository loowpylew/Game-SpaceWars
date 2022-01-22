/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import OODCwk.SpaceWars;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import OODCwk.SWAT;

/**
 *
 * @author aam
 */
public class T4BattleTest {
    SWAT game;

    Battles battle1;
    Battles battle2;
    Battles battle3;
    Battles battle4;
    Battles battle5;
    Battles battle6;
    Battles battle7;
    Battles battle8;
    
    public T4BattleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

        //game = new SpaceWars("Lewis");

        battle1 = new Battles(BattleType.FIGHT, "Borg", 200, 300, 100);
        battle2 = new Battles(BattleType.SKIRMISH, "Kardassians", 700, 200, 120);
        battle3 = new Battles(BattleType.AMBUSH, "Ferengi", 100, 400, 150);
        battle4 = new Battles(BattleType.FIGHT, "Ewoks", 600, 600, 200);
        battle5 = new Battles(BattleType.AMBUSH, "Borg", 500, 400, 90);
        battle6 = new Battles(BattleType.SKIRMISH, "Groaners", 150, 100, 100);
        battle7 = new Battles(BattleType.FIGHT, "Borg", 150, 500, 300);
        battle8 = new Battles(BattleType.AMBUSH, "Wailers", 300, 300, 300);

    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void autoIncrementAbilityLocal(){
        // In order to tests this locally, we need to comment out the SpaceWars instance in Setup.
        // Otherwise the BattleNo will start from the last loaded battle with Space Wars.
        // The purpose of this test is to see whether the battles auto increment once a battle instance is declared

        int actual1 = battle1.getBattleNo();
        int actual2 = battle2.getBattleNo();
        int actual3 = battle3.getBattleNo();
        int actual4 = battle4.getBattleNo();
        int actual5 = battle5.getBattleNo();
        int actual6 = battle6.getBattleNo();
        int actual7 = battle7.getBattleNo();
        int actual8 = battle8.getBattleNo();

        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
        assertEquals(4, actual4);
        assertEquals(5, actual5);
        assertEquals(6, actual6);
        assertEquals(7, actual7);
        assertEquals(8, actual8);
    }

    @Test
    public void autoIncrementAbilityGame(){

        // In order to tests this, we need to comment out the battle instances in Setup.

        Boolean actual1 = game.isBattle(1);
        Boolean actual2 = game.isBattle(2);
        Boolean actual3 = game.isBattle(3);
        Boolean actual4 = game.isBattle(4);
        Boolean actual5 = game.isBattle(5);
        Boolean actual6 = game.isBattle(6);
        Boolean actual7 = game.isBattle(7);
        Boolean actual8 = game.isBattle(8);

        assertEquals(true, actual1);
        assertEquals(true, actual2);
        assertEquals(true, actual3);
        assertEquals(true, actual4);
        assertEquals(true, actual5);
        assertEquals(true, actual6);
        assertEquals(true, actual7);
        assertEquals(true, actual8);
    }

    @Test
    public void wingFacingSkirmishWins() {
        int expected = 900;
        game.activateForce("IW1");
        game.doBattle(6);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingSkirmishLoseOnStrength() {
        int expected = 600;
        game.activateForce("IW1");
        game.doBattle(2);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingAmbushWins() {
        int expected = 950;
        game.activateForce("IW1");
        game.doBattle(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingAmbushLoseOnSkill() {
        int expected = 400;
        game.activateForce("IW1");
        game.doBattle(5);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingBattleNotAllowed() {
        int expected = 500;
        game.activateForce("IW1");
        game.doBattle(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingSkirmishWins() {
        int expected = 650;
        game.activateForce("SS6");
        game.doBattle(6);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingSkirmishLoseOnStrength() {
        int expected = 500;
        game.activateForce("SS2");
        game.doBattle(2);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingAmbushNotAllowed() {
        int expected = 300;
        game.activateForce("SS2");
        game.doBattle(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingBattleWins() {
        int expected = 650;
        game.activateForce("SS6");
        game.doBattle(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingBattleLoseOnStrength() {
        int expected = 580;
        game.activateForce("SS7");
        game.doBattle(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdFacingSkirmishNotAllowed() {
        int expected = 600;
        game.activateForce("WB9");
        game.doBattle(6);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdNoCloakingFacingAmbushNotAllowed() {
        int expected = 300;
        game.activateForce("WB9");
        game.doBattle(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdWithCloakingFacingAmbushWins() {
        int expected = 750;
        game.activateForce("WB5");
        game.doBattle(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdWithCloakingFacingAmbushLoseOnStrength() {
        int expected = 200;
        game.activateForce("WB5");
        game.doBattle(5);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdFacingBattleWinsOnStrength() {
        int expected = 700;
        game.activateForce("WB5");
        game.doBattle(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdFacingBattleLoseOnStrength() {
        int expected = 100;
        game.activateForce("WB3");
        game.doBattle(4);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void recallingDestroyedForceInFightDoesntAffectWarchest() {
        int expected = 600;
        game.activateForce("IW1");
        game.doBattle(2);
        game.recallForce("IW1");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void recallingDestroyedInFightForceDoesntAffectWarchestOnReactivation() {
        int expected = 600;
        game.activateForce("IW1");
        game.doBattle(2);
        game.activateForce("IW1");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNotDefeatedWhileStillActiveForces() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.doBattle(4);
        game.doBattle(5);
        assertFalse(game.isDefeated());
    }
    
    @Test
    public void checkDefeatedWhenGoingBust() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.doBattle(4);
        game.doBattle(5);
        game.doBattle(4);
        assertTrue(game.isDefeated());
    }
}
