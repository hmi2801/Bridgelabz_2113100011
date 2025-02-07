package Assignment12;


public class Main {

    public static void main(String[] args) {

//        Animal a = new Animal();
//        a.makeSound();
//        Dog d = new Dog();
//        Cat c = new Cat();
//        Bird b = new Bird();
//
//        d.makeSound();
//        c.makeSound();
//        b.makeSound();

//        -------------------------------------------------------------

//        Manager manager = new Manager(10);
//        Developer developer = new Developer("Java");
//        Intern intern = new Intern(90);
//
//        System.out.println("Manager Details:");
//        manager.displayDetails();
//
//        System.out.println("\nDeveloper Details:");
//        developer.displayDetails();
//
//        System.out.println("\nIntern Details:");
//        intern.displayDetails();

//        -------------------------------------------------------------------


//        Vehicle[] vehicles = new Vehicle[]{
//                new Car(200, "Petrol", 5),
//                new Truck(120, "Diesel", 10),
//                new Motorcycle(180, "Petrol", false)
//        };
//
//        for (Vehicle v : vehicles) {
//            v.displayInfo();
//            System.out.println();
//        }

//        ---------------------------------------------------------

//        Book b = new Book("The Vinci", 1999);
//        Author a = new Author("The Vinci", 1999, "Rudyard Kipling", "Non Fictional Writer");
//
//        b.displayInfo();
//        System.out.println();
//        a.displayInfo();

//        ------------------------------------------------------------

//        Device device1 = new Device("D001", "Online");
//        Thermostat thermostat = new Thermostat("T001", "Online", 22.5);
//
//        device1.displayStatus();
//        System.out.println();
//        thermostat.displayStatus();

//        --------------------------------------------------------------------

//        Order order = new Order(101, "2025-02-07");
//        ShippedOrder shippedOrder = new ShippedOrder(102, "2025-02-06", 56789);
//        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "2025-02-05", 98765, 20250207);
//
//        order.getOrderStatus();
//        System.out.println();
//        shippedOrder.getOrderStatus();
//        System.out.println();
//        deliveredOrder.getOrderStatus();

//        Course course = new Course("Mathematics", 10);
//        OnlineCourse onlineCourse = new OnlineCourse("Java Programming", 8, "Udemy", true);
//        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Data Science", 12, "Coursera", true, 500, 20);
//
//        course.displayDetails();
//        System.out.println();
//        onlineCourse.displayDetails();
//        System.out.println();

//        -------------------------------------------------------------------------------

//        SavingsAccount savingsAccount = new SavingsAccount(101, 5000.0, 4.5);
//        CheckingAccount checkingAccount = new CheckingAccount(102, 3000.0, 1000);
//        FixedDepositAccount fdAccount = new FixedDepositAccount(103, 20000.0, 15000);
//
//        System.out.println("Savings Account Details:");
//        savingsAccount.displayAccountDetails();
//        savingsAccount.displayAccountType();
//
//        System.out.println("\nChecking Account Details:");
//        checkingAccount.displayAccountDetails();
//        checkingAccount.displayAccountType();
//
//        System.out.println("\nFixed Deposit Account Details:");
//        fdAccount.displayAccountDetails();
//        fdAccount.displayAccountType();

//        -----------------------------------------------------------------------------------

//        Teacher teacher = new Teacher("Alice", 30, "Mathematics");
//        Student student = new Student("Bob", 16, "10th Grade");
//        Staff staff = new Staff("Charlie", 40, "Administration");
//
//        System.out.println("Teacher Details:");
//        teacher.displayDetails();
//        teacher.displayRole();
//
//        System.out.println("\nStudent Details:");
//        student.displayDetails();
//        student.displayRole();

//        -----------------------------------------------------------------------------

//        Chef chef = new Chef("John", 101, "Italian Cuisine");
//        Waiter waiter = new Waiter("Alice", 102, "Section A");
//
//        System.out.println("Chef Details:");
//        chef.displayDetails();
//        chef.performDuties();
//
//        System.out.println("\nWaiter Details:");
//        waiter.displayDetails();
//        waiter.performDuties();

//        ---------------------------------------------------------------------------

        ElectricVehicle electricVehicle = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Toyota Corolla", 180, 50);

        System.out.println("Electric Vehicle Details:");
        electricVehicle.displayDetails();
        electricVehicle.charge();

        System.out.println("\nPetrol Vehicle Details:");
        petrolVehicle.displayDetails();
        petrolVehicle.refuel();
    }


}
