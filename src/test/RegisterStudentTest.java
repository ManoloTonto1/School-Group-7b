package test;

// imports
import app.Student;
import app.Utility;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class RegisterStudentTest {

    ArrayList<Student> studenten = new ArrayList<>();
    Student student = new Student(1245678);

    // Test om te checken of de student kan worden toegevoegd in de ArrayList
    @Test
    public void RegisterStudent_NewStudent_ExpectTrue () {
        // Voer de functie uit
        Utility.RegisterStudent(studenten, student);

        // Checkt of de student in de array is toegevoegd
        assertTrue(studenten.contains(student));
    }

    @Test
    public void RegisterStudent_AlreadyExists_ExpectFalse () {
        studenten.add(student);

        // checkt of de student al bestaat in de array
        assertFalse(Utility.RegisterStudent(studenten, student));
    }
}