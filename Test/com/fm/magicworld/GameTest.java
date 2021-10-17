package fm.magicworld;
import static org.junit.Assert.*;
import org.junit.Test;


public class GameTest {

	@Test
	public void Given_PlayerHPGetsToZero_GameStops(){
        Warrior player1 = new Warrior("Test Player", 3, 5, 2, 2, 2);
        Wizard player2 = new Wizard("Test Player2", 88, 44, 2, 2, 55);
        player2.attackBasic(player1);
        String expectedResult = "GAME OVER!";
        String result = Game.stop();
        assertEquals(expectedResult, result);
    }

}
