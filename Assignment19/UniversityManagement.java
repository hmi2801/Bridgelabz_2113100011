package Bridgelabz_2113100011.Assignment19;

import java.util.List;

abstract class CourseType {
    private String courseName;
    private int credits;

    public CourseType(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }

    public abstract void displayInfo();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void displayInfo() {
        System.out.println("Exam-Based Course: " + getCourseName() + ", Credits: " + getCredits());
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void displayInfo() {
        System.out.println("Assignment-Based Course: " + getCourseName() + ", Credits: " + getCredits());
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void displayInfo() {
        System.out.println("Research-Based Course: " + getCourseName() + ", Credits: " + getCredits());
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public void displayCourseDetails() {
        courseType.displayInfo();
    }
}

public class UniversityManagement {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayInfo();
        }
    }

    public static void main(String[] args) {
        ExamCourse math = new ExamCourse("Mathematics", 4);
        AssignmentCourse csLab = new AssignmentCourse("Computer Science Lab", 3);
        ResearchCourse aiResearch = new ResearchCourse("AI Research", 6);

        Course<ExamCourse> course1 = new Course<>(math);
        Course<AssignmentCourse> course2 = new Course<>(csLab);
        Course<ResearchCourse> course3 = new Course<>(aiResearch);

        List<CourseType> courseList = List.of(math, csLab, aiResearch);
        displayAllCourses(courseList);
    }
}

