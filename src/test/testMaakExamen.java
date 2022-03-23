package test;
import app.Examen;
import app.Vraag;
import org.junit.Test;
import app.Vraag;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class testMaakExamen {
    @Test
    public void testMaakExamen(){
        Examen examen = new Examen("testExamen" , 1);
        Vraag vraag = new Vraag("a","b","a" , "a of b");
        examen.examen1();
        assertEquals(1 , examen.maakExamen());
    }


}
