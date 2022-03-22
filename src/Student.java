import java.util.ArrayList;

public class Student {
    Examen examens;
    private String naam;
    private int studentNummer;

    private ArrayList<String> gehaaldeExamens = new ArrayList<>();

    public Student (String naam, int studentNummer , ArrayList<String>gehaaldeExamens){
        this.naam = naam;
        this.studentNummer=studentNummer;
        this.gehaaldeExamens=new ArrayList<>();
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