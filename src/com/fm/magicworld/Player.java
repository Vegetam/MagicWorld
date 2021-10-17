package fm.magicworld;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    /**
    A player has the attributes:
    * name
    * level
    * point of view
    * strength
    * dexterity
    * intelligence
    * basic attack
    * special attack
   */
    private String pName;
    private int pLevel;
    private int pHP;
    private int pStrength;
    private int pAgility;
    private int pIntel;
    private String basicAttack;
    private String specialAttack;

    /**
  * Player manufacturer:
     * The points of life are the level multiplied by 5.
     * @param pName player name
     * @param pLevel player level
     * @param pHP player health points
     * @param pStrength player strength
     * @param pAgility player dexterity
     * @param pIntel player intellect
     */
    public Player(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        this.pName = pName;
        this.pLevel = pLevel;
        this.pHP = pLevel * 5;
        this.pStrength = pStrength;
        this.pAgility = pAgility;
        this.pIntel = pIntel;
    }

    /**
     * Returns the name of the player
     * @return the name of the player in the form of a character chain
     */
    public String getpName() { return pName; }
    /**
     * Returns the player's level
     * @return the level as an integer
     */
    public int getpLevel() { return pLevel;  }
    /**
     * Returns the player's life points
     * @return the HP as an integer
     */
    public int getpHP() { return pHP;  }
    /**
     * Returns the player's strength
     * @return the force as an integer
     */
    public int getpStrength() {return pStrength; }
    /**    
     * Returns the player's dexterity
     * @return the dexterity as an integer
     */
    public int getpAgility() {return pAgility; }
    /**
     * Returns the player's Intellect
     * @return the Intellect as an integer
     */
    public int getpIntel() {return pIntel; }
    /**
    * Returns the player's basic attack according to the chosen character class
     * @return the basic attack as a string
     * @see Warrior # getBasicAttack ()
     * @see Scout # getBasicAttack ()
     * @see Wizard # getBasicAttack ()
     */
    public String getBasicAttack() {return basicAttack; }
    /**
     * Returns the player's special attack according to the chosen character class
     * @return the special attack as a string
     * @see Warrior # getSpecialAttack ()
     * @see Scout # getSpecialAttack ()
     * @see Wizard # getSpecialAttack ()
     */
    public String getSpecialAttack() { return specialAttack; }

    /**
       * Update player name
     * @param pName name
     */
    public void setpName(String pName) { this.pName = pName;  }
    /**  
     * Updates player level
     * @param pLevel level
     */
    public void setpLevel(int pLevel) { this.pLevel = pLevel; }
    /**
    * Updates player life points
     * @param pHP life points
     */
    public void setpHP(int pHP) {this.pHP = pHP; }
    /**
     * Updates player strength
     * @param pStrength force
     */
    public void setpStrength(int pStrength) {this.pStrength = pStrength; }
    /**
     * Updates player dexterity
     * @param pAgility dexterity
     */
    public void setpAgility(int pAgility) {this.pAgility = pAgility; }
    /** 
     * Updates player intelligence
     * @param pIntel intelligence
     */
    public void setpIntel(int pIntel) {this.pIntel = pIntel;}
    /**
   * Updates the player's basic attack according to the chosen class
     * @param basicAttack basic attack
     * @see Warrior # setBasicAttack (String)
     * @see Scout # setBasicAttack (String)
     * @see Wizard # setBasicAttack (String)
     */
    void setBasicAttack(String basicAttack) {this.basicAttack = basicAttack;    }
    /**
     * Updates the player's special attack according to the chosen class
     * @param specialAttack special attack
     * @see Warrior # setSpecialAttack (String)
     * @see Scout # setBasicAttack (String)
     * @see Wizard # setSpecialAttack (String)
     */
    void setSpecialAttack(String specialAttack) {this.specialAttack = specialAttack; }

    /**
     * Displays the description of the characteristics of the final character
     * This description is overwritten in the different character classes,
     * in order to add a 'war cry' at the beginning of the sentence, and to announce the character's class.
     * @return the player's introductory phrase as a string, without the battle cry and without the class
     * @see Warrior # description ()
     * @see Scout # description ()
     * @see Wizard#description ()
     */
    public String description() {
        String phrase = "level " + pLevel + " with " + pHP + " Health Point. I have a strenght of " + pStrength + ", agility of " + pAgility + ", and intellect of " + pIntel + ".";
        return phrase;
    }

    /**
    * Calls the player to choose an attack action with actionchoice ()
     * With this choice, we call the basic attack or the special attack against the opponent 'player'
     * @param player opponent
     * @see #actionChoice ()
     */
    public void attack(Player player){
        int attackChoice = actionChoice();
        if (attackChoice == 1)attackBasic(player);
        else if (attackChoice == 2)attackSpecial(player);
    }

    /**
    * We launch a basic attack against the opponent 'player'
     * @param player opponent
     * @see Warrior # attackBasic (Player)
     * @see Scout # attackBasic (Player)
     * @see Wizard # attackBasic (Player)
     */
    public void attackBasic(Player player){ }

    /**
     * We launch a special attack against the opponent 'player'
     * @param player opponent
     * @see Warrior # attackSpecial (Player)
     * @see Scout # attackSpecial (Player)
     * @see Wizard # attackSpecial (Player)
     */
    public void attackSpecial(Player player){ }

    /**
     * Asks the player to choose between a basic or special attack to launch against their opponent
     * The choice must be 1 or 2.
     * @return the player's attack choice against his opponent as an integer
    */
    @SuppressWarnings("resource")
	private int  actionChoice(){
        int attackChoice = 0;
        boolean catched;
		Scanner sc = new Scanner(System.in);
        do {
            try {
                catched = false;
                System.out.println(pName + " (vitality " + pHP + "),please choose your action: 1- basic attack, 2- special attack: ");
                attackChoice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong entry, your choice is not a number");
                catched = true;
                sc.next();
            } finally {
                if ((attackChoice!=1) && (attackChoice!=2)) {
                    System.out.println("Wrong entry");
                    catched = false;
                }
            }
        }
        while(((attackChoice!=1) && (attackChoice!=2))|| (catched));
        return attackChoice;
    }
}

