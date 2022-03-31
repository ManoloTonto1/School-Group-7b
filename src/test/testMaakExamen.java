package test;

import app.Examen;
import app.Vraag;
import org.junit.Test;
import app.Vraag;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class testMaakExamen {
    @Test

    public void test_MaakExamen_10_GoedeAntwoorden() {

        // Arrange
        Examen examen = new Examen("testExamen", 6);
        examen.examen1();

        ArrayList<String> antwoordenExamenTest = new ArrayList<>();

        // Vult de arraylist met de goede antwoorden.
        for (Vraag v : examen.getVragen()) {
            antwoordenExamenTest.add(v.getCorrectAntwoord());
        }

        // Act
        int expectedResult = 10;
        int result = examen.maakExamen(antwoordenExamenTest);

        // Assert
        assertEquals(expectedResult, result);

    }

    @Test
    public void test_MaakExamen_0_GoedeAntwoorden(){

        //Arrange
        Examen examen = new Examen("testExamen" , 6);
        examen.examen1();

        ArrayList<String> antwoordenExamenTest = new ArrayList<>();

        // Vult de arraylist met de FOUTE antwoorden.
        for (Vraag v : examen.getVragen()){
            if(v.getCorrectAntwoord().equals("a")){
                antwoordenExamenTest.add("b");
            }
            else if (v.getCorrectAntwoord().equals("b")){
                antwoordenExamenTest.add("a");
            }
        }
    }
}