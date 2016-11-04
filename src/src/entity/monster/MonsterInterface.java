package entity.monster;

import entity.Monster;
import entity.spell.Spell;

import java.util.ArrayList;
import java.util.Random;

/**
 * The purpose of this class is to handle the fight of a monster. We can say it is an IA
 *
 * Created by jamatofu on 29/10/16.
 */
public class MonsterInterface {
    private Monster monster;
    private int idSpellToUse;

    public MonsterInterface(Monster monster) {
        this.monster = monster;
    }

    /**
     * CHoose between use a spell, use hand weapon or use item
     */
    public String chooseAction() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        if(randomNumber <= 50) { // use a spell
            ArrayList<Spell> spells = monster.getSpell();

            int count = 1;
            for(Spell spe : spells) {
                if(spe.canUseSpell(monster.getMana())) {
                    idSpellToUse = count;
                    return "ATTAQUER_SORT";
                }
                count++;
            }
        }

        return "ATTAQUER_ARME";
    }

    public int getIdSpellToUse() {
        return idSpellToUse;
    }
}
