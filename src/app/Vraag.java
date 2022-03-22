package app;
public class Vraag {
    private String antwoord_A;
    private String antwoord_B;
    private String correctAntwoord;
    private String vraagStelling;

    public Vraag(String antwoord_A, String antwoord_B, String correctAntwoord, String vraagStelling){
    this.antwoord_A=antwoord_A;
    this.antwoord_B=antwoord_B;
    this.correctAntwoord=correctAntwoord;
    this.vraagStelling=vraagStelling;
    }
    //Getters
    public String getAntwoord_A() {
        return antwoord_A;
    }
    public String getAntwoord_B() {
        return antwoord_B;
    }
    public String getCorrectAntwoord(){
        return correctAntwoord;
    }
    public String getVraagStelling(){
        return vraagStelling;
    }
}
