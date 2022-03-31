package test;
import java.util.ArrayList;
import app.Student;
import app.LoginManager;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginManagerTest {

    @Test
    public void LoginManager_LoginCorrectCredentials_ExpectTrue() {
        
        // Array aanmaken
        ArrayList<Student> studenten = new ArrayList<>();
        Student student = new Student(01234567);
        student.setNaam("testNaam");
        studenten.add(student);

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 01234567;

        // Voert de functie uit en checkt of deze true terug geeft (omdat het opgegeven studentnummer in de array voorkomt)
        LoginManager manager = LoginManager.getInstance();
        assertTrue(manager.Login(studenten, studentNummer));
        
    }

    @Test
    public void LoginManager_LoginIncorrectCredentials_ExpectFalse() {
        
        // Array aanmaken
        ArrayList<Student> studenten = new ArrayList<>();
        Student student = new Student(01234567);
        studenten.add(student);

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 76543210;

        // Voert de functie uit en checkt of deze false terug geeft (omdat het opgegeven studentnummer niet in de array voorkomt)
        LoginManager manager = LoginManager.getInstance();
        assertFalse(manager.Login(studenten, studentNummer));
    }

    @Test
    public void LoginManager_LoginWhenNoStudentsExist_ExpectFalse() {

        // Array aanmaken
        ArrayList<Student> studenten = new ArrayList<>();

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 01234567;

        // Loginmanager object aanmaken
        LoginManager manager = LoginManager.getInstance();

        // Controleren of de functie false terug geeft (er zijn geen studenten ingeschreven, waardoor er niet kan worden ingelogd)
        assertFalse(manager.Login(studenten, studentNummer));
    }

    @Test
    public void LoginManager_GetStudentWhenNotLoggedIn_ExpectNull() {
        LoginManager manager = LoginManager.getInstance();

        // Checkt of er een student is ingelogd en kan dus geen Student object terug geven
        assertNull(manager.getStudent());
    }

    @Test
    public void LoginManager_GetStudentWhenLoggedIn_ExpectTrue() {

        // Array aanmaken
        ArrayList<Student> studenten = new ArrayList<>();
        Student student = new Student(01234567);
        student.setNaam("testNaam");
        studenten.add(student);

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 01234567;

        LoginManager manager = LoginManager.getInstance();

        // Inloggen in de loginmanager
        manager.Login(studenten, studentNummer);

        // Checkt of de functie het student object van de ingelogde student terug geeft
        assertNotNull(manager.getStudent());
    }
}
