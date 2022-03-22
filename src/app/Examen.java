package app;
import java.util.ArrayList;
import java.util.Collections;
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
        vragen.add(new Vraag ("Bulgarije", "Servië", "a", "Van welk land is de hoofdstad Sofia?"));
        vragen.add(new Vraag("Europa", "Noord-Amerika", "b", "Tot welk continent hoort Groenland?"));
        vragen.add(new Vraag("Ja", "Nee", "a", "Is er een land met de naam Chad?"));
        vragen.add(new Vraag("Pangea", "Eritrea", "a", "Hoe heet het supercontinent ongeveer 230 miljoen jaar geleden?"));
        vragen.add(new Vraag("Algerije", "Turkije", "b", "Waar grenst de Zwarte Zee aan?"));
        vragen.add(new Vraag("Ja", "Nee", "a", "Is Vaticaanstad een eigen staat?"));
        vragen.add(new Vraag("Zuid-Amerika", "Azië", "a", "Waar ligt de Andes gebergte?"));
        vragen.add(new Vraag("Zuid-Amerika", "Afrika", "a", "Waar ligt het land Paraguay?"));
        vragen.add(new Vraag("Islamabad", "Kabul", "b", "Wat is de hoofdstad van Afghanistan?"));
        vragen.add(new Vraag("Ottawa", "Ontario", "a", "Wat is de hoofdstad van Canada?"));

    }
    public void examen2() {
        vragen.add(new Vraag("Blade Runner", "Zwemmen", " a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Coca Cola", "Netflix", "b", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Epilepsie", "Nicki Minaj", "b", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Rocky", "Twerken", "b", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Massage", "Wii Sports", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Thunderbirds", "Yosemite National Park", "b", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Tetris", "Charles Darwin", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Italië", "David Bowie", "b", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Uganda", "Rijk", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Het Weer", "Spa", "a", "Welke optie heeft meer Google searches?"));

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

    public int maakExamen(){
        int vragenGoedBeantwoord = 0;
        Scanner sc = new Scanner(System.in);
        Collections.shuffle(vragen);
        for (Vraag i : vragen){
            System.out.println(i.getVraagStelling());
            System.out.println("A: " + i.getAntwoord_A());
            System.out.println("B: " + i.getAntwoord_B());
            System.out.print("Vul uw antwoord in : ");
            if (sc.nextLine().equalsIgnoreCase(i.getCorrectAntwoord())){
                vragenGoedBeantwoord++;
            }
        }
        return vragenGoedBeantwoord;
    }
    public boolean checkVoldoende(int vragenGoedBeantwoord){
        if (vragenGoedBeantwoord >= minCorrect){
            System.out.println("Gefeliciteert u bent geslaagd voor het examen : " + getNaam());
            return true;
        }
        else {
            System.out.println("Helaas u bent gezakt voor het examen : " + getNaam());
            return false;
        }
    }
}
