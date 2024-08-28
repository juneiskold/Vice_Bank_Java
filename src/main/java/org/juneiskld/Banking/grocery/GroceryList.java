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
        return new ArrayList<>(items);
    }

    public double getTotalCost() {
        return items.stream().mapToDouble(GroceryItem::getTotalPrice).sum();
    }

    public void clear() {
        items.clear();
    }

    public int getItemCount() {
        return items.size();
    }

    public GroceryItem findItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
