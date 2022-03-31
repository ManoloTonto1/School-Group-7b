package app;
import java.util.ArrayList;

public class Student {
    private String naam;
    private Integer studentNummer;

    private ArrayList<String> gehaaldeExamens = new ArrayList<>();

    public Student(String naam, Integer studentNummer, ArrayList<String> gehaaldeExamens){
        this.naam = naam;
        this.studentNummer = studentNummer;
        this.gehaaldeExamens = gehaaldeExamens;
    }
    public Student(String naam, Integer studentNummer){
        this.naam = naam;
        this.studentNummer = studentNummer;
        
    }
    public Student(Integer studentNummer){
        this.studentNummer= studentNummer;
    }

    public void addGehaaldeExamen(String naamGehaaldeExamen){
        gehaaldeExamens.add(naamGehaaldeExamen);
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