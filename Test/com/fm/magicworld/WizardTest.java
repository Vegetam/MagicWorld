package fm.magicworld;

import static org.junit.Assert.*;

import org.junit.Test;


public class WizardTest {

	    /**
	     * description()
	     */
	    @Test
	    public void Given_WizardClass_ThenPrintsWizardDescription() {
	    	Wizard player1 = new Wizard("Test Player", 3, 15, 10, 2, 2);
	        String expectedResult = "I await a guardian!!!! I'm a Wizard level 3 with 15 Health Point. I have a strenght of 10, agility of 2, and intellect of 2."
	        		+ "";
	        String result = player1.description();
	        assertEquals(expectedResult, result);
	    }

	    /**
	     * attackBasic()
	     */
	    @Test
	    public  void GivenBasicAttackWizardIntel_EqualsDamages() {
	    	Wizard player1 = new Wizard("Test Player", 3, 15, 10, 2, 2);
	        int expectedResult = 2;
	        int result = player1.getpIntel();
	        assertEquals(expectedResult, result);

	        String expectedStringResult = "Test Player use Fireball and deal 2 damage";
	        String stringResult = player1.getpName()+" use "+player1.getBasicAttack()+" and deal "+result+" damage";
	        assertEquals(expectedStringResult, stringResult);
	    }
	    @Test
	    public void GivenBasicAttack_10Damages_Player2Loses10HealthPoints() {
	    	Wizard player1 = new Wizard("Test Player", 3, 15, 10, 2, 10);
	    	Wizard player2 = new Wizard("Test Player2", 3, 15, 2, 2, 55);
	        int damages = player1.getpIntel();
	        int expectedResult = 5;
	        int result = player2.getpHP() - damages;
	        assertEquals(expectedResult, result);

	        String expectedStringResult = "Test Player2 loses 10 Health Point";
	        String stringResult = player2.getpName()+" loses "+ damages+ " Health Point";
	        assertEquals(expectedStringResult, stringResult);
	    }
	    @Test
	    public void GivenBasicAttack_LostHealthPointsBasicAttack_PlayerHealthPointsUpDates() {
	    	Wizard player1 = new Wizard("Test Player", 3, 5, 10, 2, 10);
	    	Wizard player2 = new Wizard("Test Player2", 3, 15, 2, 2, 55);
	        int damages = player1.getpIntel();
	        player2.setpHP(player2.getpHP() - damages);
	        int expectedResult = 5;
	        int result = player2.getpHP();
	        assertEquals(expectedResult, result);
	    }
	    @Test
	    public void GivenBasicAttack_PrintsAllStrings() {
	    	Wizard player1 = new Wizard("Test Player", 3, 5, 20, 2, 10);
	    	Wizard player2 = new Wizard("Test Player2", 3, 15, 2, 2, 55);
	        player1.attackBasic(player2);
	        String expectedStringResult = "Test Player use Fireball and inflict 10 damage\nTest Player2 loses 10 Health Points\n";
	        String stringResult = player1.getpName()+" use "+player1.getBasicAttack()+" and inflict "+player1.getpIntel()+" damage\n"+player2.getpName()+" loses "+player1.getpIntel()+" Health Points\n";
	        assertEquals(expectedStringResult, stringResult);
	    }

	    /**
	     * attackSpecial()
	     */

	    @Test
	   public void GivenSpecialAttack_Soin_WizardMakesCureForTwiceItsIntel() {
	    	Wizard player1 = new Wizard("Test Player", 4, 5, 10, 2, 2);
	        int expectedResult = 4;
	        int result = player1.getpIntel()*2;
	        assertEquals(expectedResult, result);
	    }
	    @Test
	    public void GivenSpecialAttack_Soin_WizardAppliesCureAndGainsHealthPoints_MaxedOutToInitialHealthPoints() {
	    	Wizard player1 = new Wizard("Test Player", 2, 10, 10, 2, 10);
	        player1.setpHP(5);
	        player1.checkCure();
	        int expectedResult = 5;
	        int result = player1.checkCure();
	        assertEquals(expectedResult, result);
	    }
	    @Test
	    public void GivenSpecialAttack_Soin_PlayerHealthPointsUpDates() {
	    	Wizard player1 = new Wizard("Test Player", 2, 10, 10, 2, 10);
	        player1.setpHP(5);
	        player1.attackSpecial(player1);
	        int expectedResult = 10;
	        int result = player1.getpHP();
	        assertEquals(expectedResult, result);
	    }
	    @Test
	    public void GivenSpecialAttack_PrintsAllStrings(){
	    	Wizard player1 = new Wizard("Test Player", 2, 10, 10, 2, 10);
	        player1.setpHP(5);
	        String stringExpectedResult = "Test Player use Care and win 5 Health Point";
	        String stringResult = player1.getpName()+" use "+player1.getSpecialAttack()+" and win "+player1.checkCure()+" Health Point";
	        assertEquals(stringExpectedResult, stringResult);
	    }


}
