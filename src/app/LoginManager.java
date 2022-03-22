package app;

import java.util.Scanner;
import java.util.ArrayList;

public class LoginManager {

    private Student studentLoggedIn;

    public boolean Login(ArrayList<Student> students) {
        Scanner loginManagerScanner = new Scanner(System.in);

        System.out.print("Voer je Studentnummer in: ");
        int studentNummer = loginManagerScanner.nextInt();

        boolean loginSucces = false;

        for (Student student : students) {
            if (studentNummer == student.getStudentNummer()) {
                setStudent(student);
                loginSucces = true;
            }
        }

        if (loginSucces) {
            System.out.println(
                    "[i] Ingelogd als: " + studentLoggedIn.getNaam() + " (" + studentLoggedIn.getStudentNummer() + ")");
            return true;
        } else {
            System.out.println("[!] Studentnummer '" + studentNummer + "' niet gevonden.");
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