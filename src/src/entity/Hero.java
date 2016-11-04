package entity;

import entity.spell.FireBall;
import entity.spell.Spell;

import java.util.Scanner;

/**
 * @author  jamatofu on 25/10/16.
 */
public class Hero extends FightingEntity {

    protected int experience;
    protected Weapon weapon;

    public Hero(String name, Coordinates coordinates, int health, int mana, int dammage) {
        super(name, coordinates, health, mana, dammage, 200);
        this.level = 1;
        this.spell.add(new FireBall());
    }

    /**
     * Check if the entity can level up
     * @return true if the hero get the necessary XP ELSE false
     */

    public boolean isLevelUp() {
        double experienceNeeded = Math.pow(level, 3);

        return (experience >= experienceNeeded);
    }

    public void waitTour() {
        int cureHealth = (int) (maxHealth*0.10);
        int cureMana = (int) (maxMana*0.10);

        int oldHealth = health;
        int oldMana = mana;

        health = (health + cureHealth > maxHealth) ? maxHealth : health + cureHealth;
        mana = (mana + cureMana > maxMana) ? maxMana : mana + cureMana;

        System.out.println("Votre vie passe de " + oldHealth + " à " + health + ".");
        System.out.println("Votre mana passe de " + oldMana + " à " + mana + ".");
    }

    public void displaySpell() {
        int i = 1;
        for(Spell spellEntity : spell) {
            System.out.print("#" + i + " : ");
            spellEntity.display();
            i++;
        }
    }

    /**
     * Add 1 to the level
     */
    public void levelUp() {
        this.level += 1;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }
}
