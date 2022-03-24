package test;

import static org.junit.Assert.*;

import app.Student;
import app.Utility;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;



public class StudentTest {
   static Utility utility = Utility.getInstance();
    @Test
    public void testVraag() {
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

    @Test
    public void testDeleteStuent(){

        //make students
        ArrayList<Student> studenten = new ArrayList<>();
        studenten.add(new Student(696969));
        assertTrue(utility.DeleteStudent(studenten,1));
    }
}
