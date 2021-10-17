package fm.magicworld;

public class Warrior extends Player{
    private final String cIntro;
    private final String cClass;
    /**
     * Warrior Builder
     * Customization of the attributes 'class presentation' and 'battle cry'.
     * Customization of basic and special attacks.
     * @param pName player name
     * @param pLevel player level
     * @param pHP player health points
     * @param pStrength player strength
     * @param pAgility player dexterity
     * @param pIntel player intelligence
     */
    public Warrior(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel,pHP, pStrength, pAgility, pIntel);
        this.cClass = "I'm a Warrior ";
        this.cIntro = "Beware!!!!!";
        this.setBasicAttack("Sword Strike");
        this.setSpecialAttack("Rage");
    }
    /**
     * Implements the description of the Warrior
     * @return battle cry, class intro, and description of player characteristics
     * @see Player # description ()
     */
    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
    /**
     * The Warrior's basic attack against a player opponent
     * Deals damage equal to the player's strength on the opponent.
     * Displays the life points lost by the opponent.
     * Updates the opponent's health points.
     * Checks if the opponent is dead (zero hit points)
     * @param player opponent
     */
    @Override
    public void attackBasic(Player player){
        int damages = this.getpStrength();
        System.out.println(getpName()+" use "+getBasicAttack()+" to inflict "+damages+" Damage");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" loses  "+ damages+ " Health Point.");
        if(player.getpHP()<=0) {
            String dead = player.getpName() + " is Dead.";
            System.out.println(dead);
        }
    }
    /**
   * The Warrior's special attack against a player opponent
     * Deals damage equal to the player's strength times twice on the opponent.
     * The player launching the attack loses vitality: the value of his strength divided by 2.
     * Displays the life points lost by the opponent.
     * Updates the opponent's health points.
     * Displays the life points lost by the Warrior.
     * Updates the Warrior's health points.
     * Checks if the opponent is dead (zero hit points)
     * Check if the Warrior is dead (zero hit points)
     * @param player opponent
     */
    @Override
    public void attackSpecial(Player player){
        int damages = this.getpStrength()*2;
        System.out.println(getpName()+" uses "+getSpecialAttack()+" to inflict "+damages+" damages");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" loses "+ damages + " Health Points.");
        if(player.getpHP()<=0){
            System.out.println(player.getpName() + " is dead.");
            System.out.println(player.getpName()+" Lost!");
        }

        int backfire = this.getpStrength()/2;
        System.out.println(this.getpName()+" loses "+ backfire + " Health Points.");
        this.setpHP(this.getpHP()- backfire);
        if(this.getpHP()<=0){
            System.out.println(this.getpName()+" is Dead.");
            System.out.println(this.getpName()+" Lost!");
        }
    }

}

