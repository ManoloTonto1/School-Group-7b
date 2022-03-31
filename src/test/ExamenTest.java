package test;

import static org.junit.Assert.*;

import app.Examen;
import app.Vraag;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class ExamenTest {
    @Test
    public void testExamen() {
        //Arrange
        Examen examenTest = new Examen("Topo Toets", 6);
        examenTest.examen1();
        ArrayList<Vraag> vraagtest = new ArrayList<>();
        vraagtest.add(new Vraag ("Bulgarije", "Servië", "a", "Van welk land is de hoofdstad Sofia?"));
        String verwachtResultaatGetNaam = "Topo Toets";
        int verwachtResultaatGetMinCorrect = 6;
        String verwachtResultaatGetVragen = vraagtest.get(0).getVraagStelling();
        //Act
        String testResultaatGetNaam = examenTest.getNaam();
        int testResultaatGetMinCorrect = examenTest.getMinCorrect();
        String testResultaatGetVragen = examenTest.getVragen().get(0).getVraagStelling();
        //Assert
        assertEquals(verwachtResultaatGetNaam, testResultaatGetNaam);
        assertEquals(verwachtResultaatGetMinCorrect, testResultaatGetMinCorrect);
        assertEquals(verwachtResultaatGetVragen,testResultaatGetVragen);

    }
}