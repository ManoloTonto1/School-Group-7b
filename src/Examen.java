import java.util.ArrayList;
import java.util.Scanner;

public class Examen {
    private String naam;
    private int minCorrect;
    private final ArrayList<Vraag> vragen = new ArrayList<>();

    public Examen(String naam, int minCorrect){
        this.naam=naam;
        this.minCorrect=minCorrect;
    }
    public Examen(String naam){
        this.naam = naam;
    }
    public void examen1() {
        vragen.add(new Vraag ("Bulgarije", "Servië", "Bulgarije", "Van welk land is de hoofdstad Sofia?"));
        vragen.add(new Vraag("Europa", "Noord-Amerika", "Noord-Amerika", "Tot welk continent hoort Groenland?"));
        vragen.add(new Vraag("Ja", "Nee", "Ja", "Is er een land met de naam Chad?"));
        vragen.add(new Vraag("Pangea", "Eritrea", "Pangea", "Hoe heet het supercontinent ongeveer 230 miljoen jaar geleden?"));
        vragen.add(new Vraag("Algerije", "Turkije", "Turkije", "Waar grenst de Zwarte Zee aan?"));
        vragen.add(new Vraag("Ja", "Nee", "Ja", "Is Vaticaanstad een eigen staat?"));
        vragen.add(new Vraag("Zuid-Amerika", "Azië", "Zuid-Amerika", "Waar ligt de Andes gebergte?"));
        vragen.add(new Vraag("Zuid-Amerika", "Afrika", "Zuid-Amerika", "Waar ligt het land Paraguay?"));
        vragen.add(new Vraag("Islamabad", "Kabul", "Kabul", "Wat is de hoofdstad van Afghanistan?"));
        vragen.add(new Vraag("Ottawa", "Ontario", "Ottawa", "Wat is de hoofdstad van Canada?"));

    }
    public void examen2() {
        vragen.add(new Vraag("Blade Runner", "Zwemmen", "Blade Runner", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Coca Cola", "Netflix", "Netflix", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Epilepsie", "Nicki Minaj", "Nicki Minaj", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Rocky", "Twerken", "Twerken", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Massage", "Wii Sports", "Massage", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Thunderbirds", "Yosemite National Park", "Yosemite National Park", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Tetris", "Charles Darwin", "Tetris", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Italië", "David Bowie", "David Bowie", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Uganda", "Rijk", "Uganda", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Het Weer", "Spa", "Het weer", "Welke optie heeft meer Google searches?"));

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
