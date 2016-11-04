package motor;

import entity.FightingEntity;
import entity.Hero;
import entity.Monster;
import entity.monster.MonsterInterface;
import entity.spell.Spell;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handle fight between two fighting entities
 *
 * Created by jamatofu on 26/10/16.
 */
public class FightInterface {

    private Hero hero;
    private Monster monster;
    private MonsterInterface monsterInterface;
    private int countTour = 1;

    public FightInterface(FightingEntity hero, FightingEntity monster) {
        this.hero = (Hero) hero;
        this.monster = (Monster) monster;
        this.monsterInterface = new MonsterInterface((Monster) monster);
    }

    public void update() {
        while(hero.isAlive() && monster.isAlive()) {
            Scanner scanner = new Scanner(System.in);
            int idSpell = 0;
            String action = "";
            boolean actionIsPossible = false;
            boolean isAction = false;

            System.out.println("Quelle action voulez-vous faire?");

                do {

                    while (isAction != true) {
                            action = scanner.nextLine();
                            for (FightingAction fightingAction : FightingAction.values()) {
                                if (action.equals(fightingAction.getAction())) isAction = true;
                            }

                            if (isAction == false) System.out.println("Action inconnue. Quelle action voulez-vous faire?");
                        }


                    if (action.equals("ATTAQUER_SORT")) {

                        System.out.print("Sort à lancer : ");
                        idSpell = scanner.nextInt();
                        ArrayList<Spell> spell = hero.getSpell();

                        if (idSpell < spell.size()) {
                            if (spell.get(idSpell).canUseSpell(hero.getMana())) {
                                actionIsPossible = true;
                            }
                        }
                        else {
                            System.out.println("Nous n'avez pas encore ce sort");
                        }
                    }

                } while (actionIsPossible != true);




            // on reduit le cd des sorts

            switch (action) {
                case "LISTE_SORT":
                    hero.displaySpell();
                    break;
                case "ATTAQUER_SORT":
                    hero.attackSpell(monster, idSpell);
                    break;
                case "ATTAQUER_ARME":
                    hero.attack(monster);
                    hero.reduceCDSpell();
                    break;
                case "UTILISER_OBJET":

                    break;
            }

            switch (monsterInterface.chooseAction()) {
                case "ATTAQUER_SORT":
                    monster.attackSpell(hero, monsterInterface.getIdSpellToUse() - 1);
                    break;
                case "ATTAQUER_ARME":
                    monster.attack(hero);
                    monster.reduceCDSpell();
                    break;
                case "UTILISER_OBJET":

                    break;

            }

            countTour++;
        }

        if(!hero.isAlive()) System.out.println(hero.getName() + " est mort au combat.\n");
        if(!monster.isAlive()) {
            System.out.println(hero.getName() + " a tué " + monster.getName() + ".\n");
            System.out.print(hero.getName() + " gagne " + monster.getGivenExperience() + " xp.\n");
            hero.setExperience(monster.getGivenExperience());

            if(hero.isLevelUp()) {
                hero.levelUp();
                System.out.println(hero.getName() + " a gagné un niveau! Son niveau est de " + hero.getLevel() + ".\n");
            }

        }
    }


    public int getCountTour() {
        return countTour;
    }
}
