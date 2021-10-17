package fm.magicworld;

import static org.junit.Assert.*;

import org.junit.Test;


public class ScoutTest  extends PlayerTest {


	    /**
	     * description()
	     */
	    @Test
	    public void Given_ScoutClass_ThenPrintsScoutDescription() {
	        Player player1 = new Scout("Test Player", 3, 15, 10, 2, 2);
	        String expectedResult = "*appears from behind discreetly* I'm a Scoutlevel 3 with 15 Health Point. I have a strenght of 10, agility of 2, and intellect of 2.";
	        String result = player1.description();
	        assertEquals(expectedResult, result);
	    }

	    /**
	     * attackBasic()
	     */
	    @Test
	    public void GivenBasicAttack_ScoutAgility_EqualsDamages() {
	        Player player1 = new Scout("Test Player", 3, 15, 10, 2, 2);
	        int expectedResult = 2;
	        int result = player1.getpAgility();
	        assertEquals(expectedResult, result);

	        String expectedStringResult = "Test Player use Arrows and inflicts 2 damage";
	        String stringResult = player1.getpName()+" use "+player1.getBasicAttack()+" and inflicts "+result+" damage";
	        assertEquals(expectedStringResult, stringResult);
	    }
	    @Test
	    public void GivenBasicAttack_2Damages_Player2Loses2HealthPoints() {
	        Player player1 = new Scout("Test Player", 3, 15, 10, 2, 10);
	        Player player2 = new Scout("Test Player2", 3, 15, 2, 2, 55);
	        int damages = player1.getpAgility();
	        int expectedResult = 13;
	        int result = player2.getpHP() - damages;
	        assertEquals(expectedResult, result);

	        String expectedStringResult = "Test Player2 perd 2 points de vie.";
	        String stringResult = player2.getpName()+" perd "+ damages+ " points de vie.";
	        assertEquals(expectedStringResult, stringResult);
	    }
	    @Test
	    public void GivenBasicAttack_LostHealthPointsBasicAttack_PlayerHealthPointsUpDates() {
	        Player player1 = new Scout("Test Player", 3, 5, 10, 2, 10);
	        Player player2 = new Scout("Test Player2", 3, 15, 2, 2, 55);
	        int damages = player1.getpAgility();
	        player2.setpHP(player2.getpHP() - damages);
	        int expectedResult = 13;
	        int result = player2.getpHP();
	        assertEquals(expectedResult, result);
	    }
	    @Test
	    public void GivenBasicAttack_PrintsAllStrings() {
	        Player player1 = new Scout("Test Player", 3, 5, 20, 2, 10);
	        Player player2 = new Scout("Test Player2", 3, 15, 2, 2, 55);
	        player1.attackBasic(player2);
	        String expectedStringResult = "Test Player use Arrows and inflict 2 damage";
	        String stringResult = player1.getpName()+" use "+player1.getBasicAttack()+" and inflict "+player1.getpAgility()+" damage";
	        assertEquals(expectedStringResult, stringResult);
	    }

	    /**
	     * attackSpecial()
	     */
	    @Test
	    public void Given_Concentration_ItEqualsScoutLevelDividedBy2() {
	        Player player1 = new Scout("Test Player", 4, 5, 10, 2, 2);
	        int expectedResult = 2;
	        int result = player1.getpLevel() / 2;
	        assertEquals(expectedResult, result);
	    }
	    @Test
	    public void Given_Concentration_ScoutsAgilityUpdatesToInitialAgilityPlusScoutLevelDividedBy2(){
	        Player player1 = new Scout("Test Player", 4, 20, 10, 2, 2);
	        player1.attackSpecial(player1);
	        int expectedResult = 4;
	        int result = player1.getpAgility();
	        assertEquals(expectedResult, result);
	    }
	    @Test
	    public void GivenSpecialAttack_PrintsAllStrings(){
	        Player player1 = new Scout("Test Player", 4, 20, 10, 2, 10);
	        String stringExpectedResult = "Test Player use concentration and win 2 point of agility";
	        String stringResult = player1.getpName()+" use "+player1.getSpecialAttack()+" and win "+player1.getpLevel() / 2+" point of agility";
	        assertEquals(stringExpectedResult, stringResult);
	    }

	}

