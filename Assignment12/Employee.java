package Assignment12;


public class Employee {

    private String name;
    private int id;
    private float salary;

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary:" + salary);
    }


}

class Manager extends Employee {

    private int teamSize;

    Manager(int teamSize){
        this.teamSize=teamSize;
    }

    @Override
    void displayDetails(){
        System.out.println("TeamSize: "+teamSize);

    }


}

class Developer extends Employee{

    private String programmingLanguage;

    Developer(String programmingLanguage){
        this.programmingLanguage=programmingLanguage;
    }

    @Override
    void displayDetails(){
        System.out.println("ProgrammingLanguage: "+programmingLanguage);

    }

}

class Intern extends Employee {
    private int internshipDays;

    Intern(int internshipDays){
        this.internshipDays=internshipDays;
    }

    @Override
    void displayDetails(){
        System.out.println("Internship Days: "+internshipDays);

    }


}
