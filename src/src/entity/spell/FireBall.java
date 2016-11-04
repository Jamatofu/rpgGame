package entity.spell;

/**
 * Created by jamatofu on 27/10/16.
 */
public class FireBall extends Spell {
    public FireBall() {
        super(5, 5, 1, "Boule de feu");
        this.countdown =  2;
    }
}
