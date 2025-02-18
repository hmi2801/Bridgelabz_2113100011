package Bridgelabz_2113100011.Assignment19;

abstract class Category {
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class BookCategory extends Category {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends Category {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends Category {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProductInfo() {
        System.out.println("Product: " + name + ", Price: $" + price + ", Category: " + category.getCategoryName());
    }
}

public class MarketPlace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied! New price of " + product.getName() + ": $" + product.getPrice());
    }

    public static void main(String[] args) {
        BookCategory bookCat = new BookCategory();
        ClothingCategory clothingCat = new ClothingCategory();
        GadgetCategory gadgetCat = new GadgetCategory();

        Product<BookCategory> book = new Product<>("The Alchemist", 500.0, bookCat);
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 1200.0, clothingCat);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 25000.0, gadgetCat);

        book.displayProductInfo();
        shirt.displayProductInfo();
        phone.displayProductInfo();

        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        applyDiscount(phone, 5);
    }
}

class Main {
    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));
        groceriesStorage.addItem(new Groceries("Rice"));
        furnitureStorage.addItem(new Furniture("Sofa"));


        System.out.println("Displaying Electronics:");
        WareHouse.displayItems(electronicsStorage.getItems());
        System.out.println("\nDisplaying Groceries:");
        WareHouse.displayItems(groceriesStorage.getItems());

        System.out.println("\nDisplaying Furniture:");
        WareHouse.displayItems(furnitureStorage.getItems());
    }


}


