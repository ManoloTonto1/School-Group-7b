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
        ArrayList<String> studentTestArray = new ArrayList<String>();
        studentTestArray.add("Topo Toets");
        Student studentTest = new Student("Akasha", 18104355, studentTestArray);
        boolean testArray=false;
        String verwachtResultaatGetNaam = "Akasha";
        int verwachtResultaatGetStudentNummer = 18104355;
        //Act
        String testResultaatGetNaam = studentTest.getNaam();
        int testResultaatGetStudentNummer = studentTest.getStudentNummer();
        if(studentTestArray.get(0).equals(studentTest.getGehaaldeExamens().get(0))){
            testArray=true;
        }
        //Assert
        assertEquals(verwachtResultaatGetNaam, testResultaatGetNaam);
        assertEquals(verwachtResultaatGetStudentNummer, testResultaatGetStudentNummer);
        assertTrue(testArray);
    }
}
