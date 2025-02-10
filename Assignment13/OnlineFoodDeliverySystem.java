package Assignment13;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public void applyDiscount(double percentage) {
        discount = (getPrice() * percentage) / 100;
    }

    public String getDiscountDetails() {
        return "Discount: " + discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double additionalCharge = 2.0; // Additional charge for non-veg items
        return (getPrice() + additionalCharge) * getQuantity();
    }

    public void applyDiscount(double percentage) {
        discount = ((getPrice() + 2.0) * percentage) / 100;
    }

    public String getDiscountDetails() {
        return "Discount: " + discount;
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Veg Pizza", 12.0, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Burger", 10.0, 3);

        System.out.println(vegItem.getItemDetails());
        System.out.println("Total Price: " + vegItem.calculateTotalPrice());

        System.out.println(nonVegItem.getItemDetails());
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());

        Discountable discountableVeg = (Discountable) vegItem;
        discountableVeg.applyDiscount(10);
        System.out.println(discountableVeg.getDiscountDetails());

        Discountable discountableNonVeg = (Discountable) nonVegItem;
        discountableNonVeg.applyDiscount(15);
        System.out.println(discountableNonVeg.getDiscountDetails());
    }
}
