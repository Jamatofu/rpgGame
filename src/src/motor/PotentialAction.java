package motor;

/**
 * Created by jamatofu on 26/10/16.
 */
public enum PotentialAction {
    ATTAQUER("FIGHT"),
    ATTENDRE("ATTENDRE"),
    PARTIR("PARTIR");

    private String action;

    PotentialAction(String action) {
        this.action = action;
    }

    public String getAction() { return action;}
}
