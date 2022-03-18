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
        vragen.add(new Vraag("Europa", "Noord-Amerika", "a", "Tot welk continent hoort Groenland?"));
        vragen.add(new Vraag("Ja", "Nee", "a", "Is er een land met de naam Chad?"));
        vragen.add(new Vraag("Pangea", "Eritrea", "a", "Hoe heet het supercontinent ongeveer 230 miljoen jaar geleden?"));
        vragen.add(new Vraag("Algerije", "Turkije", "a", "Waar grenst de Zwarte Zee aan?"));
        vragen.add(new Vraag("Ja", "Nee", "a", "Is Vaticaanstad een eigen staat?"));
        vragen.add(new Vraag("Zuid-Amerika", "Azië", "a", "Waar ligt de Andes gebergte?"));
        vragen.add(new Vraag("Zuid-Amerika", "Afrika", "a", "Waar ligt het land Paraguay?"));
        vragen.add(new Vraag("Islamabad", "Kabul", "a", "Wat is de hoofdstad van Afghanistan?"));
        vragen.add(new Vraag("Ottawa", "Ontario", "a", "Wat is de hoofdstad van Canada?"));

    }
    public void examen2() {
        vragen.add(new Vraag("Blade Runner", "Zwemmen", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Coca Cola", "Netflix", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Epilepsie", "Nicki Minaj", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Rocky", "Twerken", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Massage", "Wii Sports", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Thunderbirds", "Yosemite National Park", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Tetris", "Charles Darwin", "a", "Welke optie heeft meer Google searches?"));
        vragen.add(new Vraag("Italië", "David Bowie", "a", "Welke optie heeft meer Google searches?"));
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
       Scanner sc = new Scanner(System.in);
       int aantalVragen = 1;
       int aantalGoedeAntwoorden = 0;
       Collections.shuffle(vragen); //randomize vragen order
       //begin doorlopen examens.
       System.out.println("Welkom bij het examen " + naam +". U hoeft alleen A of B in te voeren.");
       for (Vraag j : vragen){
           System.out.printf("Vraag : %d. \n", aantalVragen);
           System.out.println(j.getVraagStelling());
           System.out.println("A : " + j.getAntwoord_A());
           System.out.println("B : " + j.getAntwoord_B());
           System.out.print("Vul uw antwoord in :");
           System.out.println();
           if(sc.nextLine().equalsIgnoreCase(j.getCorrectAntwoord())){
               aantalGoedeAntwoorden++;
           }
           aantalVragen++;
       }
       vragen.removeAll(vragen);

       return aantalGoedeAntwoorden;
    }
    public boolean checkVoldoende (int aantalGoedeAntwoorden){
        if (aantalGoedeAntwoorden >= minCorrect){

            System.out.println(aantalGoedeAntwoorden + "/" + minCorrect);
            System.out.println("Gefeliciteert u bent geslaagd voor het examen : " + naam);
            return true;
        }
        else {
            System.out.println(aantalGoedeAntwoorden + "/" + minCorrect);
            System.out.println("Helaas , u bent gezakt voor het examen : " + naam);
            return false;
        }
    }
}
