package entity;

import java.util.ArrayList;

/**
 *
 * Store every item owned by the entity
 *
 * @author jamatofu on 25/10/16.
 */
public class Inventory {
    private ArrayList<Item> listItem = new ArrayList<Item>();

    public Inventory() {
        listItem = null;
    }

    public Inventory(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    /**
     * Add an item to the inventory
     * @param item the item to add
     */
    public void addItem(Item item) {

    }

    /**
     * remove an item from the list. How to remove? Could we give an ID to each item?
     * @param item
     */
    public void removeItem(Item item) {

    }

    /**
     * Write all the item of the inventory into the console
     */
    public void displayInventory() {

    }

    public ArrayList<Item> getListItem() { return listItem; }
}
