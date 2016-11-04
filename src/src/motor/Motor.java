package motor;

import java.util.Scanner;

import entity.Hero;
import entity.Monster;
import entity.monster.Crabe;

/**
 * Created by jamatofu on 26/10/16.
 */
public class Motor {
    private Scanner scanner = new Scanner(System.in);
    private boolean leaveGame = false;

    private Hero hero = new Hero("Arthur", null, 200, 100, 30);

    public String askAction() {
        System.out.println("Que voulez-vous faire? Attendre (ATTENDRE) - Se battre (FIGHT) - Partir (PARTIR)");
        String action;
        boolean isAction = false;

        do {
            action = scanner.nextLine();
            for(PotentialAction potentialAction : PotentialAction.values()) {
                if(potentialAction.equals(action)) isAction = true;
            }
        } while (isAction);

        return action;
    }

    public void makeAction() {
        String actionToDo = askAction();

        switch (actionToDo) {
            case "ATTENDRE":
                hero.waitTour();
                break;
            case "FIGHT":
                System.out.println("Engageons le combat!\n");
                fight();
                break;
            case "PARTIR":
                System.out.println("Quittez cette aventure avec honneur!");
                leaveGame = true;
                break;
        }
    }

    public void fight() {
        System.out.println("\nLe combat débute!\n");
        new FightInterface(hero, new Crabe()).update();
    }


    public boolean isLeaveGame() {
        return leaveGame;
    }
}
