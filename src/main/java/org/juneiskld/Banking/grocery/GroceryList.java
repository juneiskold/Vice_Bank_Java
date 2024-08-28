package org.juneiskld.Banking.grocery;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {

    private List<GroceryItem> items;

    public GroceryList() {
        this.items = new ArrayList<>();
    }

    public void addItem(GroceryItem item) {
        items.add(item);
    }

    public void removeItem(GroceryItem item) {
        items.remove(item);
    }

    public List<GroceryItem> getItems() {
        return items;
    }

}
