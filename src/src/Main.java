/**
 * Created by jamatofu on 26/10/16.
 */

import entity.*;
import entity.spell.FireBall;
import entity.spell.Spell;
import motor.Motor;

public class Main {
    public static void main(String[] args) {
        Motor motor = new Motor();

        do {
            motor.makeAction();
        } while (!motor.isLeaveGame());

    }
}
