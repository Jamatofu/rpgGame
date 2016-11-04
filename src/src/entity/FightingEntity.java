package entity;

import entity.spell.Spell;

import java.util.ArrayList;

/**
 * Created by jamatofu on 26/10/16.
 */
public class FightingEntity extends Entity {

    protected Inventory inventory;
    protected int health, maxHealth, mana, maxMana, dammage, level;
    protected int money;
    protected ArrayList<Effect> effect;
    protected ArrayList<Spell> spell = new ArrayList<Spell>();

    public FightingEntity(String name, Coordinates coordinates, int health, int mana, int dammage, int money) {
        super(name, coordinates);
        inventory = new Inventory();
        this.health = this.maxHealth = health;
        this.mana = this.maxMana = mana;
        this.dammage = dammage;
        this.money = money;
    }

    /**
     * Attack an entity with direct attack
     * @param entity the choosen entity
     */
    public void attack(FightingEntity entity) {
        System.out.println(name + " attaque " + entity.getName() + " et lui inflige " + dammage + " de degats.");
        entity.receiveDammage(dammage);
    }

    public void attackSpell(FightingEntity entity, int idSpell) {
        Spell spellToUse = spell.get(idSpell);
        if(spellToUse.canUseSpell(mana)) {
            System.out.println(name + " utilise " + spellToUse.getName() + " et inflige " + spellToUse.getDamage() + " à " + entity.getName() + ".");
            entity.receiveDammage(spellToUse.getDamage());
            mana -= spellToUse.getManaCost();
            spellToUse.putToCountdown();
            this.reduceCDSpell();
        }
        else {
            System.out.println("Vous ne pouvez pas lancer le sort. (" + mana + "mana restant " + spellToUse.getRemainingCountdown() + " tour restant).");
        }
    }

    /**
     * Receive dammage from an attack or something else. Die if health < 0
     * @param dammage dammage of the entity
     */
    public void receiveDammage(int dammage) {
        health = (health - dammage) > 0 ? health - dammage : 0;
        display();
    }

    public void reduceCDSpell() {
        for (Spell spe: spell) {
            spe.decrementCoutdown();
        }
    }


    /**
     * Check if the entity is alive or not
     * @return
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Show to the screen the informations of the entity
     */

    public void display() {
        System.out.println(name + " a " + health + " point de vie.");
    }

    /**
     * Update each stat of the entity. Have to count any additional stat added by the items
     */
    public void updateStat() {

    }

    public void addSpell(Spell spell) {
        this.spell.add(spell);
    }

    public void setDammage(int dammage) { this.dammage = dammage; }
    public int getLevel() { return level;}
    public ArrayList<Spell> getSpell() { return spell; }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getMana() { return mana;}
}
