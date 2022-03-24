package test;
import app.Examen;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class testCheckvoldoende {


    @Test
    public void test_CheckVoldoende_True(){
        //Arrange

        Examen examen = new Examen("testExamen", 6);

        //Act

        boolean result = examen.checkVoldoende(10);

        //Assert
        assertTrue(result);


    }
    @Test
    public void test_CheckVoldoende_False(){
        //Arrange

        Examen examen = new Examen("testExamen", 6);

        //Act

        boolean result = examen.checkVoldoende(1);
        //Assert
        assertFalse(result);

    }

}