package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarJsonConverter {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Toyota", "Camry", 2023);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        System.out.println(jsonString);
    }
}
