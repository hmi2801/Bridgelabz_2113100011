package Assignment12;

public class Animal {
    private String name;
    private int age;

    void makeSound() {
        System.out.println("This is the sound of an animal");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("This is the sound of a dog");
    }

}

class Cat extends Animal {

    @Override
    void makeSound() {
        System.out.println("This is the sound of a cat");
    }
}

class Bird extends Animal {

    @Override
    void makeSound() {
        System.out.println("This is the sound of a bird");
    }

}

