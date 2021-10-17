package fm.magicworld;

public class Scout extends  Player {
    private final String cIntro;
    private final String cClass;

    /**
     * Builder of the Scout
     * Customization of the attributes 'class presentation' and 'battle cry'.
     * Customization of basic and special attacks.
     * @param pName player name
     * @param pLevel player level
     * @param pHP player health points
     * @param pStrength player strength
     * @param pAgility player dexterity
     * @param pIntel player intelligence
     */
    public Scout(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel, pHP, pStrength, pAgility, pIntel);
        this.cClass = "I'm a Scout";
        this.cIntro = "*appears from behind discreetly* ";
        this.setBasicAttack("Arrows");
        this.setSpecialAttack("concentration");
    }

    /**
   	 * Implements the Scout description
     * @return battle cry, class intro, and description of player characteristics
     * @see Player # description ()
     */
    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
    /**
     * The basic attack of the Scount against an opponent 'player'
     * Deals damage equal to the Rider's agility.
     * Displays the life points lost by the opponent.
     * Updates the opponent's health points.
     * Checks if the opponent is dead (zero hit points)
     * @param player opponent
     */
    @Override
    public void attackBasic(Player player){
        int damages = this.getpAgility();
        System.out.println(getpName()+" use "+getBasicAttack()+" to inflict "+damages+" damages");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" loses "+ damages+ " Health Point.");
        if(player.getpHP()<=0){
            System.out.println(player.getpName() + " is dead.");
            System.out.println(player.getpName()+" Lost!");
        }
    }
    /**
     * The Scout's special attack
     * The player gains his level divided by 2 in agility.
     * Updates the agility points of the scout and displays it.
     * @param player the Scout himself
     */
    @Override
    public void attackSpecial(Player player){
        int concentration = this.getpLevel()/2;
        System.out.println(getpName()+" use "+getSpecialAttack()+" to win "+concentration+" points to agility");
        this.setpAgility(this.getpAgility() + concentration);
    }
}