package Assignment13;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private String diagnosis;
    private String medicalHistory;
    private double dailyCharge;
    private int daysAdmitted;

    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }

    public void addRecord(String record) {
        this.diagnosis = record;
    }

    public String viewRecords() {
        return "Diagnosis: " + diagnosis + ", Medical History: " + medicalHistory;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private String diagnosis;
    private String medicalHistory;
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        this.diagnosis = record;
    }

    public String viewRecords() {
        return "Diagnosis: " + diagnosis + ", Medical History: " + medicalHistory;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient inPatient = new InPatient("P001", "John Doe", 45, 200.0, 5);
        Patient outPatient = new OutPatient("P002", "Jane Smith", 30, 50.0);

        System.out.println(inPatient.getPatientDetails());
        System.out.println("Total Bill: " + inPatient.calculateBill());

        System.out.println(outPatient.getPatientDetails());
        System.out.println("Total Bill: " + outPatient.calculateBill());

        MedicalRecord medicalRecordInPatient = (MedicalRecord) inPatient;
        medicalRecordInPatient.addRecord("Admitted with severe infection");
        System.out.println(medicalRecordInPatient.viewRecords());

        MedicalRecord medicalRecordOutPatient = (MedicalRecord) outPatient;
        medicalRecordOutPatient.addRecord("Consulted for routine checkup");
        System.out.println(medicalRecordOutPatient.viewRecords());
    }
}

