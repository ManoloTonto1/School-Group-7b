package test;

// imports
import app.Student;
import app.Utility;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class RegisterStudentTest {

    // Test om te checken of de student kan worden toegevoegd in de ArrayList
    @Test
    public void RegisterStudent_NewStudent_ExpectTrue () {

        // Nieuwe student array aanmaken voor het testen
        ArrayList<Student> studenten = new ArrayList<>();

        // Nieuw student object aanmaken voor het testen
        Student student = new Student(1245678);

        // Voer de functie uit
        Utility.RegisterStudent(studenten, student);

        // Checkt of de student in de array is toegevoegd
        assertTrue(studenten.contains(student));
    }

    @Test
    public void RegisterStudent_InvalidCredentials_ExpectFalse () {

        // Nieuwe student array aanmaken voor het testen
        ArrayList<Student> studenten = new ArrayList<>();

        // Nieuw student object aanmaken met een te lang studentnummer voor het testen 
        Student student = new Student(123456789);

        // checkt of de functie false terug geeft
        assertFalse(Utility.RegisterStudent(studenten, student));

        // checkt of de student niet in de array is gezet
        assertFalse(studenten.contains(student));
    }

    @Test
    public void RegisterStudent_AlreadyExists_ExpectFalse () {

        // Nieuwe student array aanmaken voor het testen
        ArrayList<Student> studenten = new ArrayList<>();

        // Nieuw student object aanmaken voor het testen
        Student student = new Student(12345678);
        studenten.add(student);

        // checkt of de student al bestaat in de array
        assertFalse(Utility.RegisterStudent(studenten, student));
    }
}