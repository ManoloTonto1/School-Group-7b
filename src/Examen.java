import java.util.ArrayList;

public class Examen {
    Vraag vraag;
    private String naam;
    private int minCorrect;
    private ArrayList<Vraag> vragen;

    public Examen(String naam){
        this.naam = naam;
    }
    //Getters
    public String getNaam(){
        return naam;
    }
    public int getMinCorrect(){
        return minCorrect;
    }
    public ArrayList<Vraag> getVragen(){
        return vragen;
    }
}
