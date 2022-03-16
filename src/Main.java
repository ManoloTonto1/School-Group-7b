
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    //create main method
    public static void main(String[] args) {
        // create arraylists for the students an exams
        ArrayList studenten = new ArrayList<Student>();
        ArrayList examens = new ArrayList<Examen>();

        ArrayList examsToAdd = new ArrayList<String>();
        examsToAdd.add("Scheikunde");
        examsToAdd.add("Rekenen");

        ArrayList examsToAdd2 = new ArrayList<String>();
        examsToAdd2.add("Scheikunde");
        examsToAdd2.add("Rekenen");
        examsToAdd2.add("Wiskunde");

        // Temp fill list of students
        studenten.add(new Student("Martijn", 12345678, examsToAdd));
        studenten.add(new Student("Manuel", 11234567, examsToAdd2));

        // Temp examens
        examens.add(new Examen("Scheikunde"));
        examens.add(new Examen("Rekenen"));

        showStudentMostExams(studenten);
        showExams(examens);
        showStudents(studenten);
    }

    @SuppressWarnings("unchecked")
    public static void showStudentMostExams(ArrayList<Student> studenten) {
        // create an arraylist for the number of exams of every student
        ArrayList studentExams = new ArrayList<Integer>();

        // fill studentexams with everyones number of exams
        for(int i = 0; i < studenten.size(); i++) {
            studentExams.add(studenten.get(i).getGehaaldeExamens().size());
        }

        int max = (int) Collections.max(studentExams);
        for(int i = 0; i < studenten.size(); i++) {
            if(studenten.get(i).getGehaaldeExamens().size() == max) {
                System.out.println("Meeste examens gehaald: " + studenten.get(i).getNaam() + " - " + studenten.get(i).getStudentNummer() + "aantal gehaalde examens: " + max);
            }
        }
    }

    public static void showExams(ArrayList<Examen> examens) {
        for(int i = 0; i < examens.size(); i++) {
            System.out.println("Examen " + i + ": " + examens.get(i).getNaam());
        }
    }

    public static void showStudents(ArrayList<Student> studenten) {
        for(int i = 0; i < studenten.size(); i++) {
            System.out.println("student " + i + ": " + studenten.get(i).getNaam() + " - " + studenten.get(i).getStudentNummer());
        }
    }
}
