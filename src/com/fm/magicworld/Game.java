package fm.magicworld;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    /**
     * Start the game from the 'main'.
     * Calls the instantiation of the two characters
     * Start the fights with player.attack ()
     * @see Player # attack (Player)
     * Battles revolve around until a player's health points drop to zero.
     * /
     */
    static void start() {
        System.out.println("Welcome to Magic World!!!!");
        System.out.println("Creation of first character");
        Player player1 = enterPlayer();
        player1.setpName("First Character");
        System.out.println(player1.description());
        System.out.println("Creation of the second character");
        Player player2 = enterPlayer();
        player2.setpName("Second Character");
        System.out.println(player2.description());
        do {
            player1.attack(player2);
            if(player2.getpHP() > 0) {
                player2.attack(player1);
            }
        }while((player1.getpHP()>0)&&(player2.getpHP()>0));

    }
    /**
     * Calls the chooseClass () method to know the player's choice of class.
     * Depending on the choice, we instantiate an 'empty' character of the corresponding class.
     * @see Warrior
     * @see Scout
     * @see Wizard
     * We launch setStats to build the character.
     * We return the created character.
     * @return the instantiated player
     */
    private static Player enterPlayer() {
        int uClass = chooseClass();
        if (uClass == 1) {
            Warrior player = new Warrior("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        } else if (uClass == 2) {
            Scout player = new Scout("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        } else if (uClass == 3) {
        	Wizard player = new Wizard("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        }
        return enterPlayer();
    }
    /**
     * Once the character class has been chosen, the player is asked to enter the characteristics of the character.
     * The characteristics are then injected into the character constructor. 
     * @see Player
     */
    private static void setStats(Player player){
        player.setpLevel(levelSetUp());
        player.setpHP(player.getpLevel()*5);
        player.setpStrength(strengthSetUp(player));
        player.setpAgility(agilitySetUp(player));
        player.setpIntel(intelSetUp(player));
    }

    /**
     * Choice of the level 'level of the character by the player.
     * Cannot be zero, and is at most 100.
     * @return the player's level as an integer
     */
    @SuppressWarnings("resource")
	private static int levelSetUp(){
        int level = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("level: ");
                level = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong entry, your choice is not a number");
                sc.next();
            }finally {
                if (level < 1 || level > 100) {
                    System.out.println("Your choice is not between 1 and 100");
                }}
        } while ((level < 1) || (level > 100));
        return level;
    }
    /**
   * Choice of the 'strength' of the character by the player.
     * Can be zero, and is maximum 100.
     * Must not exceed level.
     * @return the strength of the player as an integer
     */
    @SuppressWarnings("resource")
	private static int strengthSetUp(Player player){
        int strength = 0;
        int totalLeft = player.getpLevel();
        Scanner sc = new Scanner(System.in);
        boolean catched;
        do {
            try {
                catched = false;
                System.out.print("Force: ");
                strength = sc.nextInt();
            } catch (InputMismatchException e2) {
                System.out.println("Wrong entry, your choice is not a number");
                catched = true;
                sc.next();
            }finally {
                if(strength>totalLeft){
                    catched = false;
                    System.out.println("The total sum of your stats must not exceed your level");
                    System.out.println("You still have " + totalLeft + " points to assign");
                }
            }
        } while ((strength < 0) || (strength > 100)||(strength>totalLeft)||(catched));
        return strength;
    }
    /**
     * Choice of the dexterity 'agility' of the character by the player.
     * Can be zero, and is maximum 100.
     * Must not exceed the sum of level and strength.
     * @return the dexterity of the player as an integer
     */
    @SuppressWarnings("resource")
	private static int agilitySetUp(Player player){
        int agility = 0;
        boolean catched;
        int totalLeft = player.getpLevel()-player.getpStrength();
        Scanner sc = new Scanner(System.in);
        do {
            try {
                catched = false;
                System.out.print("Agility: ");
                agility = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong entry, your choice is not a number");
                catched = true;
                sc.next();
            }finally {

                if(agility>totalLeft){
                    System.out.println("The total sum of your stats must not exceed your level");
                    System.out.println("You still have " + totalLeft + " points to assign");
                }
            }
        } while ((agility < 0) || (agility > 100)||(agility>totalLeft)||(catched));
        return agility;
    }
    /**
     
* Choice of the 'intellect' intelligence of the character by the player.
     * Can be zero, and is maximum 100.
     * Must not exceed the sum of level, strength and agility.
     * @return player intellect as an integer
     */
    @SuppressWarnings("resource")
	private static int intelSetUp(Player player){
        int intel = 0;
        boolean catched;
        int totalLeft = player.getpLevel()-player.getpStrength()-player.getpAgility();
        Scanner sc = new Scanner(System.in);
        do {
            try {
                catched = false;
                System.out.print("Intellect: ");
                intel = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong entry, your choice is not a number");
                catched = true;
                sc.next();
            }finally {
                if(intel>totalLeft){
                    System.out.println("The total sum of your stats must not exceed your level");
                    System.out.println("You still have " + totalLeft + " points to assign");
                }
            }
        } while ((intel < 0) || (intel > 100)||(intel>totalLeft)||(catched));
        return intel;
    }
    /**
    * Choice of character class by the player.
     * Choice 1, 2 or 3.
     * @return the player's character class choice as an integer  
     **/
    @SuppressWarnings("resource")
	private static int chooseClass(){
        Scanner sc = new Scanner(System.in);
        int uClass = 0;
        do {
            try{
                System.out.print("\r\n"
                		+ "Please choose your character class: 1 - Warrior, 2 - Ranger, 3 - Wizard:");
                uClass = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Wrong entry, your choice is not a number");
                sc.next();
            }
        } while ((uClass != 1) && (uClass != 2) && (uClass != 3));
        return uClass;
    }

    /**
    * Once attacks are stopped and a player has lost, displays GAME OVER.
     * @return the character string GAME OVER
     */
    public static String stop(){
        String endgame = "GAME OVER!";
        System.out.println(endgame);
        return endgame;
    }
}