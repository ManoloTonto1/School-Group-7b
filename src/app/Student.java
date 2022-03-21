package app;
import java.util.ArrayList;

public class Student {
    Examen examens;
    private String naam;
    private Integer studentNummer;

    private ArrayList<String> gehaaldeExamens;

    public Student(String naam, Integer studentNummer, ArrayList<String> gehaaldeExamens){
        this.naam = naam;
        this.studentNummer = studentNummer;
        this.gehaaldeExamens = gehaaldeExamens;
    }
    public Student(Integer studentNummer){
        this.studentNummer= studentNummer;
    }
    //Getters
    public void addGehaaldeExamen(Examen examens){

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
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setGehaaldeExamens(ArrayList<String> gehaaldeExamens) {
        this.gehaaldeExamens = gehaaldeExamens;
    }

}