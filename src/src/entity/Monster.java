package entity;

/**
 * @author  jamatofu on 25/10/16.
 */
public class Monster extends FightingEntity {

    private int givenExperience = 5;

    public Monster(String name, Coordinates coordinates, int health, int mana, int dammage, int money) {
        super(name, coordinates, health, mana, dammage, money);
    }


    public int getGivenExperience() {
        return givenExperience;
    }
    public int getGivenMoney() { return  money;}
}
