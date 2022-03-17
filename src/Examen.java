import java.util.ArrayList;
import java.util.Scanner;

public class Examen {
    Vraag vraag;
    private String naam;
    private int minCorrect;
    private ArrayList<Vraag> vragen;

    public Examen(String naam, int minCorrect, ArrayList<Vraag> vragen){

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

    public void maakExamen(ArrayList<Vraag> vragen){
        int vragenGoedBeantwoord = 0;
         Scanner sc = new Scanner(System.in);
        for (Vraag i : vragen){
            System.out.println(i.getVraagStelling());
            System.out.printf("A: %s" , i.getAntwoord_A());
            System.out.printf("B: %s" , i.getAntwoord_B());
            System.out.print("Vul uw antwoord in : ");
            if (sc.nextLine().equalsIgnoreCase(i.getCorrectAntwoord())){
                vragenGoedBeantwoord++;
            }
        }
        if (vragenGoedBeantwoord >= minCorrect){
            //add examen to student
        }
    }
}
