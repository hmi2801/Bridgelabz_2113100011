package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 850.50),
                new Product("Smartphone", 450.99)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
        System.out.println(jsonArray);
    }
}

