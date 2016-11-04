package entity.spell;

/**
 * Created by jamatofu on 26/10/16.
 */

public class Spell {
    protected int damage;
    protected int manaCost;
    protected int neededLevel;
    protected int countdown, remainingCountdown;
    protected String name;

    public Spell(int damage, int manaCost, int neededLevel, String name) {
        this.damage = damage;
        this.manaCost = manaCost;
        this.neededLevel = neededLevel;
        this.name = name;
        this.remainingCountdown = 0;
    }

    public boolean canUseSpell(int manaEntity) {
        return ((manaEntity - manaCost) >= 0) && (remainingCountdown == 0);
    }

    public void display() {
        System.out.println(name + " => " + damage + " (damage) MC : " + manaCost);
    }

    public int getDamage() {
        return damage;
    }
    public int getManaCost() {
        return manaCost;
    }
    public int getNeededLevel() {
        return neededLevel;
    }
    public String getName() {
        return name;
    }
    public int getCooldown() {
        return countdown;
    }
    public int getRemainingCountdown() {
        return remainingCountdown;
    }
    public void decrementCoutdown() { remainingCountdown = (remainingCountdown - 1 >= 0) ? remainingCountdown - 1 : 0;}
    public void putToCountdown() {
        remainingCountdown = countdown;
    }
}
