package fm.magicworld;

import static org.junit.Assert.*;

import org.junit.Test;


public class WarriorTest extends PlayerTest {



    /**
     * description()
     */
    @Test
   public void Given_WarriorClass_ThenPrintsWarriorDescription() {
        Player player1 = new Warrior("Test Player", 3, 15, 10, 2, 2);
        String expectedResult = "Beware!!!!!I'm a Warrior level 3 with 15 Health Point. I have a strenght of 10, agility of 2, and intellect of 2.";
        String result = player1.description();
        assertEquals(expectedResult, result);
    }
    /**
     * attackBasic()
     */
    @Test
    public void GivenBasicAttack_WarriorStrength_EqualsDamages() {
        Player player1 = new Warrior("Test Player", 3, 15, 10, 2, 2);
        int expectedResult = 10;
        int result =  player1.getpStrength();
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player use Sword Strike and inflict 10 damages";
        String stringResult = player1.getpName()+" use "+player1.getBasicAttack()+" and inflict "+result+" damages";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    public void GivenBasicAttack_10Damages_Player2Loses10HealthPoints() {
        Player player1 = new Warrior("Test Player", 3, 15, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpStrength();
        int expectedResult = 5;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player2 perd 10 points de vie.";
        String stringResult = player2.getpName()+" perd "+ damages+ " points de vie.";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    public void GivenBasicAttack_LostHealthPointsBasicAttack_PlayerHealthPointsUpDates() {
        Player player1 = new Warrior("Test Player", 3, 5, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpStrength();
        player2.setpHP(player2.getpHP() - damages);
        int expectedResult = 5;
        int result = player2.getpHP();
        assertEquals(expectedResult, result);
    }
    @Test
    public void GivenBasicAttack_PrintsAllStrings() {
        Player player1 = new Warrior("Test Player", 3, 5, 20, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        player1.attackBasic(player2);
        String expectedStringResult = "Test Player use Sword Strike and inflict 20 damages\n";
        String stringResult = player1.getpName()+" use "+player1.getBasicAttack()+" and inflict "+player1.getpStrength()+" damages\n";
        assertEquals(expectedStringResult, stringResult);
    }

    /**
     * attackSpecial()
     */
    @Test
    public void GivenSpecialAttack_CoupDeRage_DamagesEqualsWarriorStrengthMultiplies2() {
        Player player1 = new Warrior("Test Player", 4, 5, 10, 2, 2);
        int expectedResult = 20;
        int result = player1.getpStrength()*2;
        assertEquals(expectedResult, result);
    }
    @Test
    public void GivenSpecialAttack_20Damages_Player2Loses20HealthPoint() {
        Player player1 = new Warrior("Test Player", 4, 5, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 5, 25, 2, 2, 55);
        int damages = player1.getpStrength()*2;
        int expectedResult = 5;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);
    }
    @Test
    public void GivenSpecialAttack_LostHealthPoints_PlayerHealthPointsUpDates() {
        Player player1 = new Warrior("Test Player", 4, 20, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 5, 25, 2, 2, 55);
        int damages = player1.getpStrength() * 2;
        int expectedResult = 5;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);
    }

    @Test
    public void GivenSpecialAttack_WarriorAttackBackfiresAndLosesHealthPoints_ByOwnStrengthDividedBy2() {
        Player player1 = new Warrior("Test Player", 4, 5, 10, 2, 2);
        int expectedResult = 5;
        int result = player1.getpStrength() / 2;
        assertEquals(expectedResult, result);
    }
    @Test
    public void GivenSpecialAttack_WarriorAttackBackfired_PlayerHealthPointsUpDates(){
        Player player1 = new Warrior("Test Player", 4, 20, 10, 2, 2);
        int backfire = player1.getpStrength() / 2;
        int expectedResult = 15;
        int result = player1.getpHP() - backfire;
        assertEquals(expectedResult, result);
    }
    @Test
    public void GivenSpecialAttack_PrintsAllStrings() {
        Player player1 = new Warrior("Test Player", 50, 250, 20, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        player1.attackSpecial(player2);
        String expectedStringResult = "Test Player use Rage and inflict 40 damage\nTest Player2 loses 20 Health Points.\nTest Player loses 10 Health Points.\n";
        String stringResult = player1.getpName()+" use "+player1.getSpecialAttack()+" and inflict "+player1.getpStrength()*2+" damage\n"+player2.getpName()+" loses "+player1.getpStrength()+" Health Points.\n"+player1.getpName()+" loses "+player1.getpStrength()/2+" Health Points.\n";
        assertEquals(expectedStringResult, stringResult);
    }
}