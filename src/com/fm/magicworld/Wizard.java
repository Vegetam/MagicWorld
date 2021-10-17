package fm.magicworld;

public class Wizard extends Player {
    private final String cIntro;
    private final String cClass;
    /**
     * Wizard Builder
     * Customization of the attributes 'class presentation' and 'battle cry'.
     * Customization of basic and special attacks.
     * @param pName player name
     * @param pLevel player level
     * @param pHP player health points
     * @param pStrength player strength
     * @param pAgility player dexterity
     * @param pIntel player Intellect
     */
    public Wizard(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel, pHP, pStrength, pAgility, pIntel);
        this.cClass = "I'm a Wizard ";
        this.cIntro = "I await a guardian!!!! ";
        this.setBasicAttack("Fireball");
        this.setSpecialAttack("Care");
    }
    /**
     * Implements the description of the Wizard
     * @return battle cry, class intro, and description of player characteristics
     * @see Player # description ()
     */
    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
    /**
     * The Wizard's basic attack against a player opponent
     * Deals damage equal to player's intelligence on the opponent.
     * Displays the life points lost by the opponent.
     * Updates the opponent's health points.
     * Checks if the opponent is dead (zero hit points)
     * @param player opponent
     */
    @Override
    public void attackBasic(Player player){
        int damages = this.getpIntel();
        System.out.println(getpName()+" uses "+getBasicAttack()+" to inflict "+damages+" damage");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" loses "+ damages+ " health points.");
        if(player.getpHP()<=0){
            System.out.println(player.getpName() + " is dead.");
            System.out.println(player.getpName()+" lost!");
        }
    }
    /**
     * The Wizard's special attack
     * The player heals his health and regains his amount of intelligence times 2 health points.
     * He can't have more life than he started out with.
     * Updates the wizard's health points and displays it.
     * @param player the Wizard itself
     * @see #checkCure ()
     */
    @Override
    public void attackSpecial(Player player){
        int cure = checkCure();
        System.out.println(getpName()+" use "+getSpecialAttack()+"and get "+cure+" health points");
        this.setpHP(this.getpHP()+cure);
    }

    /**
     * Check that the Wizard does not gain more life points than he initially had
     * We recover the starting life points of the magician
     * We calculate the life points gained by the care spell
     * We subtract in order to apply the maximum possible value to recover
     * @return the number of hit points recovered by the healing spell
     */
    public int checkCure(){
        int intel = this.getpIntel()*2;
        int hp = this.getpHP();
        int startHP = this.getpLevel()*5;
        int cure = hp + intel;
        int possibleCure = startHP - hp;
        if(cure>possibleCure)cure = possibleCure;
        return cure;
    }
}
