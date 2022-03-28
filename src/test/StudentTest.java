package test;

import static org.junit.Assert.*;

import app.Student;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class StudentTest {
    @Test
    public void testVraag() {
        //Arrange

        //Act

        //Assert
        ArrayList<String> studentTestArray = new ArrayList<String>();
        studentTestArray.add("Topo Toets");
        Student studentTest = new Student("Akasha", 18104355, studentTestArray);
        boolean testArray=false;
        if(studentTestArray.get(0).equals(studentTest.getGehaaldeExamens().get(0))){
            testArray=true;
        }
        assertEquals("Akasha", studentTest.getNaam());
        assertEquals(18104355, studentTest.getStudentNummer());
        assertTrue(testArray);
    }
}
