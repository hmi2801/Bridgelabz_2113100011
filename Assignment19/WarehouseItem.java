package Bridgelabz_2113100011.Assignment19;

import java.util.ArrayList;
import java.util.List;

public abstract class WarehouseItem {
    private String itemName;

    public WarehouseItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public abstract void displayInfo();

}

class Electronics extends WarehouseItem {

    Electronics(String itemName) {
        super(itemName);
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics Item: " + getItemName());
    }

}

class Groceries extends WarehouseItem {
    public Groceries(String itemName) {
        super(itemName);
    }

    @Override
    public void displayInfo() {
        System.out.println("Grocery Item: " + getItemName());
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String itemName) {
        super(itemName);
    }

    public void displayInfo() {
        System.out.println("Furniture Item: " + getItemName());
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

}

class WareHouse {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();

        }
    }
}




