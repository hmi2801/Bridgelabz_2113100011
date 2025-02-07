package Assignment12;

public class Book {
    private String title;
    private int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }

}

class Author extends Book {


    private String name;
    private String bio;

    Author(String title,int publicationYear,String name, String bio) {
        super(title,publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Name: " + name);
        System.out.println("Bio: " + bio);

    }
}
