public class Vraag {
    private String antwoord_A;
    private String antwoord_B;
    private boolean correctAntwoord;
    private String vraagStelling;

    public Vraag(String antwoord_A, String antwoord_B, boolean correctAntwoord, String vraagStelling){

    }
    //Getters
    public String getAntwoord_A() {
        return antwoord_A;
    }
    public String getAntwoord_B() {
        return antwoord_B;
    }
    public boolean getCorrectAntwoord(){
        return correctAntwoord;
    }
    public String getVraagStelling(){
        return vraagStelling;
    }
}
