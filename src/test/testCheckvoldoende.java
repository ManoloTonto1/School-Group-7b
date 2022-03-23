package test;
import app.Examen;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class testCheckvoldoende {


    @Test
    public void testCheckVoldoende(){
    Examen examen = new Examen("testExamen", 2);
    assertTrue(examen.checkVoldoende(2));
    assertFalse(examen.checkVoldoende(0));
    }
}
