import java.util.ArrayList;

public class Student {
    private String naam;
    private int studentNummer;
    private ArrayList<String> gehaaldeExamens;

    public Student(String naam, int studentNummer, ArrayList<String> gehaaldeExamens){
        this.naam = naam;
        this.studentNummer = studentNummer;
        this.gehaaldeExamens = gehaaldeExamens;
    }

    public Student(String naam, int studentNummer){
        this.naam = naam;
        this.studentNummer = studentNummer;
    }
    //Getters
    public void addGehaaldeExamen(String examen){
        gehaaldeExamens.add(examen);
    }
    //Getters
    public String getNaam() {
        return naam;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public ArrayList<String> getGehaaldeExamens() {
        return gehaaldeExamens;
    }

    //Setters
    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

}
