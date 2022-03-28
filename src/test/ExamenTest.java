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

        //Act

        //Assert
        Examen examenTest = new Examen("Topo Toets", 6);
        ArrayList<Vraag> vraagtest = new ArrayList<Vraag>();
        vraagtest.add(new Vraag ("Bulgarije", "Servië", "a", "Van welk land is de hoofdstad Sofia?"));
        assertEquals("Topo Toets", examenTest.getNaam());
        assertEquals(6, examenTest.getMinCorrect());
        assertEquals(vraagtest.get(0),examenTest.getVragen().get(0));
    }
}