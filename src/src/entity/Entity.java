package entity;


/**
 * @author Jamatofu on 25/10/16.
 */
abstract public class Entity {
    protected String name;
    protected Coordinates coordinates;
    protected boolean isTargeting;

    public Entity(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.coordinates = null;
    }

    public String getName() { return name; }
}
