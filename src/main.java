
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



class Main {
    public static JSON json = new JSON();

    // create main method
    public static void main(String[] args) {
        // Start any objects now like the loading from shit.
        
        ArrayList<Student> studenten = new ArrayList<Student>();
        ArrayList<Examen> examens = new ArrayList<>();
        examens.add(new Examen("Java"));
        json.LoadStudents(studenten);

        Scanner scanner = new Scanner(System.in);
        int x = 1;
        // start the menu Loop
        while (x == 1) {
            System.out.println("----------------------------------------------------");
            System.out.println("0) Exit");
            System.out.println("1) Lijst met examens");
            System.out.println("2) Lijst met studenten");
            System.out.println("3) Nieuwe student inschrijven");
            System.out.println("4) Student verwijderen");
            System.out.println("5) Examen afnemen");
            System.out.println("6) Is student geslaagd voor test?");
            System.out.println("7) Welke examens heeft student gehaald?");
            System.out.println("8) Welke student heeft de meeste examens gehaald?");
            System.out.println();
            System.out.println("----------------------------------------------------");

            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    System.out.println("Goodbye");
                    x = 0;
                    json.saveStudents(studenten);
                    scanner.close();
                    break;
                case 1:
                    System.out.println("===========================");
                    // add shit here
                    showExams(examens);
                    System.out.println("===========================");
                    break;
                case 2:
                    System.out.println("===========================");
                    //studenten.forEach(student -> System.out.println(student.getNaam()));
                    showStudents(studenten);
                    System.out.println("===========================");
                    break;
                case 3:
                    System.out.println("===========================");
                    RegisterStudent(studenten);

                    System.out.println("===========================");
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                showStudentMostExams(studenten);

                    break;
                case default:
                    System.out.println("[!] Invalid input");
                    break;
            }
        }
    }

    
    public static void RegisterStudent(ArrayList<Student> studenten) {

        // Functie aanroepen om een Student object aan te maken
        Student student = CreateStudent();

        // Checks aanmaken
        boolean studentAlreadyExists = false;

        int studentNumberLimit = 8;
        boolean studentNumberOverLimit = false;

            // For loop om alle objecten in de arraylist 'studenten' te vergelijken met het nieuwe student object
            for (Student _student : studenten) {

                // Checkt of het studentnummer overeen komt
                if (_student.getStudentNummer() == student.getStudentNummer()) {

                    studentAlreadyExists = true;
                }

                // Checkt of het ingevoerde studentnummer langer is dan 8 cijfers
                String studentNumberString = ""+student.getStudentNummer()+"";
                if(studentNumberString.length() > studentNumberLimit) {
                    studentNumberOverLimit = true;
                }
            }
        
            // Wanneer beide checks onwaar zijn word de student ingeschreven
            if(!studentAlreadyExists) {
                if(!studentNumberOverLimit) {

                    studenten.add(student);
                    System.out.println("[i] Student succesvol ingeschreven.");

                    // Slaat direct de nieuwe array op
                    json.saveStudents(studenten);
                } 
                else {
                    System.out.println("[!] Student nummer heeft te veel characters.");
                    
                }
            }
                    
    }

    public static Student CreateStudent() {
        // Functie die wordt aangeroepen door 'RegisterStudent()'

        // Opent een scanner om data aan de gebruiker op te vragen
        Scanner studentData = new Scanner(System.in);

        // Registreerd de opgegeven naam
        System.out.print("Naam student: ");
        String naam = studentData.nextLine();

        // Registreerd het opgegeven studentnummer
        System.out.print("Studentnummer: ");
        int studentenNummer = studentData.nextInt();

        // Nieuw 'student' object wordt aangemaakt met opgegeven data
        Student student = new Student(studentenNummer);
        student.setNaam(naam);
        // studentData.close();

        // Het aangemaakte object wordt terug gegeven
        return student;

    }

    public static void showStudentMostExams(ArrayList<Student> studenten) {
        // create an arraylist for the number of exams of every student
        ArrayList<Integer> studentExams = new ArrayList<>();

        // fill studentexams with everyones number of exams
        for (int i = 0; i < studenten.size(); i++) {
            studentExams.add(studenten.get(i).getGehaaldeExamens().size());
        }

        int max = (int) Collections.max(studentExams);
        for (int i = 0; i < studenten.size(); i++) {
            if (studenten.get(i).getGehaaldeExamens().size() == max) {
                System.out.println("Meeste examens gehaald: " + studenten.get(i).getNaam() + " - "
                        + studenten.get(i).getStudentNummer() + "aantal gehaalde examens: " + max);
            }
        }
    }

    public static void showExams(ArrayList<Examen> examens) {
        for (int i = 0; i < examens.size(); i++) {
            System.out.println("Examen " + i + ": " + examens.get(i).getNaam());
        }
    }

    public static void showStudents(ArrayList<Student> studenten) {
        for (int i = 0; i < studenten.size(); i++) {
            System.out.println(
                    "student " + i + ": " + studenten.get(i).getNaam() + " - " + studenten.get(i).getStudentNummer());
        }

    }

}