package entity.monster;

import entity.Coordinates;
import entity.Monster;
import entity.spell.Morsure;

/**
 * Created by jamatofu on 29/10/16.
 */
public class Crabe extends Monster {
    public Crabe() {
        super("Crabe", null, 30, 80, 30, 50);
        this.spell.add(new Morsure());
    }
}
