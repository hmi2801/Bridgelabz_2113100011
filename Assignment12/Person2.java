package Assignment12;

interface Worker {
    void performDuties();
}

class Person2 {

    private String name;
    private int id;

    Person2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person2 implements Worker {

    private String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef is cooking the food. Specialty: " + specialty);
    }
}

class Waiter extends Person2 implements Worker {

    private String section;

    Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter is serving food in section: " + section);
    }
}