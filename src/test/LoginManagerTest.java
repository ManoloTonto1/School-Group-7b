package test;
import java.util.ArrayList;
import app.Student;
import app.LoginManager;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginManagerTest {

    ArrayList<Student> studenten = new ArrayList<>();
    LoginManager manager = LoginManager.getInstance();

    void studentenSetup() {
        if(studenten.size() > 0) {studenten.clear();}
        Student student = new Student(01234567);
        student.setNaam("testNaam");
        studenten.add(student);
    }

    @Test
    public void LoginManager_GetStudentWhenNotLoggedIn_ExpectNull() {
        // // Checkt of er een student is ingelogd en kan dus geen Student object terug geven
        if(manager.getStudent() == null) {
            assertNull(manager.getStudent());
        }
    }

    @Test
    public void LoginManager_LoginCorrectCredentials_ExpectTrue() {
        
        // Array vullen
        studentenSetup();

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 01234567;

        // Voert de functie uit en checkt of deze true terug geeft (omdat het opgegeven studentnummer in de array voorkomt)
        assertTrue(manager.Login(studenten, studentNummer));
        
    }

    @Test
    public void LoginManager_LoginIncorrectCredentials_ExpectFalse() {
        
        // Array vullen
        studentenSetup();

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 76543210;

        // Voert de functie uit en checkt of deze false terug geeft (omdat het opgegeven studentnummer niet in de array voorkomt)
        assertFalse(manager.Login(studenten, studentNummer));
    }

    @Test
    public void LoginManager_LoginWhenNoStudentsExist_ExpectFalse() {

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 01234567;
        
        // Controleren of de functie false terug geeft (er zijn geen studenten ingeschreven, waardoor er niet kan worden ingelogd)
        assertFalse(manager.Login(studenten, studentNummer));
    }

    @Test
    public void LoginManager_GetStudentWhenLoggedIn_ExpectTrue() {

        // Array vullen
        studentenSetup();

        // Deze int wordt normaal door een scanner opgevraagd
        int studentNummer = 01234567;

        // Inloggen in de loginmanager
        manager.Login(studenten, studentNummer);

        // Checkt of de functie het student object van de ingelogde student terug geeft
        assertNotNull(manager.getStudent());
    }
}
