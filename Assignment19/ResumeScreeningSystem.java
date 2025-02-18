package Bridgelabz_2113100011.Assignment19;

import java.util.List;

abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() { return candidateName; }
    public int getExperienceYears() { return experienceYears; }

    public abstract void evaluateResume();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Software Engineer Resume - " + getCandidateName() +
                ", Experience: " + getExperienceYears() + " years.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Data Scientist Resume - " + getCandidateName() +
                ", Experience: " + getExperienceYears() + " years.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Product Manager Resume - " + getCandidateName() +
                ", Experience: " + getExperienceYears() + " years.");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        jobRole.evaluateResume();
    }
}

public class ResumeScreeningSystem {
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole jobRole : resumes) {
            jobRole.evaluateResume();
        }
    }

    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer("Alice", 5);
        DataScientist ds = new DataScientist("Bob", 3);
        ProductManager pm = new ProductManager("Charlie", 7);

        Resume<SoftwareEngineer> resume1 = new Resume<>(se);
        Resume<DataScientist> resume2 = new Resume<>(ds);
        Resume<ProductManager> resume3 = new Resume<>(pm);

        List<JobRole> resumeList = List.of(se, ds, pm);
        screenResumes(resumeList);
    }
}

