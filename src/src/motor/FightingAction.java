package motor;

/**
 * Created by jamatofu on 27/10/16.
 */
public enum FightingAction {
    LISTE_SORT("LISTE_SORT"),
    ATTAQUER_SORT("ATTAQUER_SORT"),
    ATTAQUER_ARME("ATTAQUER_ARME"),
    UTILISER_OBJET("UTILISER_OBJET");


    private String action;

    FightingAction(String action) {
        this.action = action;
    }


    public String getAction() {
        return action;
    }
}
