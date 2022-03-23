package test;
import java.util.ArrayList;
import app.Student;
import app.LoginManager;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginManagerTest {

    @Test
    public void CheckIfLoginReturnsTrueWithCorrectCredentials() {
        
        ArrayList<Student> studenten = new ArrayList<>();
        Student student = new Student(01234567);
        student.setNaam("testNaam");
        studenten.add(student);

        int studentNummer = 01234567;

        LoginManager manager = new LoginManager();
        assertTrue(manager.Login(studenten, studentNummer));
        
    }

    @Test
    public void CheckIfLoginReturnsFalseWithIncorrectCredentials() {
        
        ArrayList<Student> studenten = new ArrayList<>();
        Student student = new Student(01234567);
        studenten.add(student);

        int studentNummer = 76543210;

        LoginManager manager = new LoginManager();
        assertFalse(manager.Login(studenten, studentNummer));
    }

    @Test
    public void CheckIfLoginReturnsFalseIfStudentsIsEmpty() {
        ArrayList<Student> studenten = new ArrayList<>();
        int studentNummer = 01234567;

        LoginManager manager = new LoginManager();
        assertFalse(manager.Login(studenten, studentNummer));
    }

    @Test
    public void TestIfGetStudentMethodReturnsStudentIfNotLoggedIn() {
        
        LoginManager manager = new LoginManager();
        assertNull(manager.getStudent());
    }

    @Test
    public void TestIfGetStudentMethodReturnsStudentIfLoggedIn() {
        
        ArrayList<Student> studenten = new ArrayList<>();
        Student student = new Student(01234567);
        student.setNaam("testNaam");
        studenten.add(student);

        int studentNummer = 01234567;

        LoginManager manager = new LoginManager();
        manager.Login(studenten, studentNummer);
        assertNotNull(manager.getStudent());
    }
}
