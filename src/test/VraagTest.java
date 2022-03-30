package test;

import static org.junit.Assert.*;

import app.Vraag;
import org.junit.Assert;
import org.junit.Test;

public class VraagTest {
    @Test
    public void testStudent() {
        //Arrange
        Vraag vraagtest = new Vraag("antwoordA","antwoordB","goedAntwoord","deVraag");
        String verwachtResultaatGetAntwoord_A = "antwoordA";
        String verwachtResultaatGetAntwoord_B = "antwoordB";
        String verwachtResultaatGetGoedAntwoord = "goedAntwoord";
        String verwachtResultaatGetVraagStelling = "deVraag";
        //Act
        String testResultaatGetAntwoord_A = vraagtest.getAntwoord_A();
        String testResultaatGetAntwoord_B = vraagtest.getAntwoord_B();
        String testResultaatGetGoedAntwoord = vraagtest.getCorrectAntwoord();
        String testResultaatGetVraagStelling = vraagtest.getVraagStelling();
        //Assert
        assertEquals(verwachtResultaatGetAntwoord_A, testResultaatGetAntwoord_A);
        assertEquals(verwachtResultaatGetAntwoord_B, testResultaatGetAntwoord_B);
        assertEquals(verwachtResultaatGetGoedAntwoord,testResultaatGetGoedAntwoord);
        assertEquals(verwachtResultaatGetVraagStelling,testResultaatGetVraagStelling);
    }
}
