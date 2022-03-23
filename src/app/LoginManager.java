package app;

import java.util.ArrayList;

public class LoginManager {

    private Student studentLoggedIn;

    public boolean Login(ArrayList<Student> students, int studentNumber) {
  
        boolean loginSucces = false;

        for (Student student : students) {
            if (studentNumber == student.getStudentNummer()) {
                setStudent(student);
                loginSucces = true;
            }
        }

        if (loginSucces) {
            System.out.println(
                    "[i] Ingelogd als: " + studentLoggedIn.getNaam() + " (" + studentLoggedIn.getStudentNummer() + ")");
            return true;
        } else {
            System.out.println("[!] Studentnummer '" + studentNumber + "' niet gevonden.");
            return false;
        }
    }

    public void setStudent(Student student) {
        this.studentLoggedIn = student;
    }

    public Student getStudent() {
        return this.studentLoggedIn;
    }
}