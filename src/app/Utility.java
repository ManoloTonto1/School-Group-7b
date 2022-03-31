package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeToggleAction;


public class Utility {
    static JSON json = JSON.getInstance();
    static LoginManager session = LoginManager.getInstance();

    private Utility() {
    }

    public static Utility getInstance() {
        
        return new Utility();
    }

    public boolean DeleteStudent(ArrayList<Student> studenten){
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kies de student dat je wilt verwijderen, gebruik de nummers.");
        for(int i =0; i<studenten.size();i++){
            System.out.println((i+1)+ " " + studenten.get(i).getNaam() +" :: "+ studenten.get(i).getStudentNummer());
        }
        int choice = scanner.nextInt();
        //check if user chose a correct input
        if(choice > studenten.size() || choice <= 0){
            System.out.println("De student dat je wilt verwijderen bestaat niet, probeer nogmaals");
            return false;
        }

        System.out.println("[i] Student "+studenten.get((choice-1)).getNaam()+" verwijderd.");
        studenten.remove((choice-1));
        json.saveStudents(studenten);
        return true;
    }
    public boolean DeleteStudent(ArrayList<Student> studenten, int input){
        
        
        
        System.out.println("Kies de student dat je wilt verwijderen, gebruik de nummers.");
        for(int i =0; i<studenten.size();i++){
            System.out.println((i+1)+ " " + studenten.get(i).getNaam() +" :: "+ studenten.get(i).getStudentNummer());
        }
        int choice = input;
        //check if user chose a correct input
        if(choice > studenten.size() || choice <= 0){
            System.out.println("De student dat je wilt verwijderen bestaat niet, probeer nogmaals");
            return false;
        }

        studenten.remove((choice-1));
        System.out.println("[i] Student "+studenten.get(choice-1).getNaam()+" verwijderd.");
        
        json.saveStudents(studenten);
        return true;
    }

    public void Menu(){
        // Start any objects now like the loading from shit.
        
        ArrayList<Examen> examens = new ArrayList<>();
        examens.add(new Examen("Test"));
        // Demy files
        examens.add(new Examen("Topo Toets"));
        examens.add(new Examen("Higher Lower"));

        ArrayList<Student> studenten = new ArrayList<Student>();
        Student student = null;
        //
        //
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
            if(session.getStudent() != null) System.out.println("9) Welke examens heb ik gehaald?");
            
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
                    // studenten.forEach(student -> System.out.println(student.getNaam()));
                    showStudents(studenten);
                    System.out.println("===========================");
                    break;
                case 3:
                    System.out.println("===========================");
                    RegisterStudent(studenten);

                    System.out.println("===========================");
                    break;
                case 4:
                    System.out.println("===========================");
                    DeleteStudent(studenten);
                    System.out.println("===========================");

                    break;
                case 5:
                    System.out.println("===========================");
                        ExamenAfnemen(studenten, examens);
                    System.out.println("===========================");
                    break;
                case 6:
                    hasStudentPassedExam(studenten, examens);
                    break;
                case 7:
                    showStudentExams(studenten);
                    break;
                case 8:
                    showStudentMostExams(studenten);

                    break;
                case 9:
                    showMyExams(session.getStudent().getStudentNummer(), studenten);

                    break;
                default:
                    System.out.println("[!] Invalid input");
                    break;
            }
        }
    
    }
    public static void ExamenAfnemen(ArrayList<Student> studenten, ArrayList<Examen> examens) {

        Examen examen1 = new Examen("Topo Toets", 6);
        Examen examen2 = new Examen("Higher Lower", 6);

        
        Scanner loginScanner = new Scanner(System.in);

        System.out.print("Voer je Studentnummer in: ");
        int studentNummer = loginScanner.nextInt();

        if(session.Login(studenten, studentNummer)) {

            
            Scanner examenScanner = new Scanner(System.in);
            
            System.out.println("Welk examen wilt u maken? Voer het getal in van het examen:");
            
            showExams(examens);
            
            int l = examenScanner.nextInt();

            switch (l) {
                case 1 -> {
                    examen1.examen1();
                    if (examen1.checkVoldoende(examen1.maakExamen())){
                        if(!session.getStudent().getGehaaldeExamens().contains(examen1.getNaam())){
                            session.getStudent().addGehaaldeExamen(examen1.getNaam());
                            json.saveStudents(studenten);
                        }

                    }
                }
                case 2 -> {
                    examen2.examen2();
                    if (examen2.checkVoldoende(examen2.maakExamen())){

                        if(!session.getStudent().getGehaaldeExamens().contains(examen2.getNaam())){
                            session.getStudent().addGehaaldeExamen(examen2.getNaam());
                            json.saveStudents(studenten);
                        }
                    }
                }
            }
        }
        else {
            System.out.println("[!] Login mislukt");

        }
    }

    public static void RegisterStudent(ArrayList<Student> studenten) {
        
        // Functie aanroepen om een Student object aan te maken
        Student student = CreateStudent();

        RegisterStudent(studenten, student);
    }

    public static boolean RegisterStudent(ArrayList<Student> studenten, Student student) {

        // Checks aanmaken
        boolean studentAlreadyExists = false;

        int studentNumberLimit = 8;
        boolean studentNumberOverLimit = false;

        // Checkt of het ingevoerde studentnummer langer is dan 8 cijfers
        String studentNumberString = "" + student.getStudentNummer() + "";
        if (studentNumberString.length() > studentNumberLimit) {
            studentNumberOverLimit = true;
        }

        // For loop om alle objecten in de arraylist 'studenten' te vergelijken met het
        // nieuwe student object
        for (Student _student : studenten) {

            // Checkt of het studentnummer overeen komt
            if (_student.getStudentNummer() == student.getStudentNummer()) {

                studentAlreadyExists = true;
            }
        }

        // Wanneer beide checks onwaar zijn word de student ingeschreven
        if (!studentAlreadyExists) {
            if (!studentNumberOverLimit) {

                studenten.add(student);
                System.out.println("[i] Student succesvol ingeschreven.");
                
                // Slaat direct de nieuwe array op
                json.saveStudents(studenten);

                return true;
            } else {
                System.out.println("[!] Student nummer heeft te veel characters.");
                return false;

            }
        } else {

            System.out.println("[!] Student is al ingeschreven.");
            return false;
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

    public static String showStudentMostExams(ArrayList<Student> studenten) {
        // create an arraylist for the number of exams of every student
        ArrayList<Integer> studentExams = new ArrayList<>();

        // fill studentexams with everyones number of exams
        for (int i = 0; i < studenten.size(); i++) {
            studentExams.add(studenten.get(i).getGehaaldeExamens().size());
        }

        int max = (int) Collections.max(studentExams);
        for (int i = 0; i < studenten.size(); i++) {
            if (studenten.get(i).getGehaaldeExamens().size() == max) {
                System.out.println("Meeste examens gehaald: " + studenten.get(i).getNaam() + " - " + studenten.get(i).getStudentNummer() + " - aantal gehaalde examens: " + max);
                return studenten.get(i).getNaam();
            }
        }
        return null;
    }

    public static Boolean showExams(ArrayList<Examen> examens) {
        if(examens.size() > 0) {
            for (int i = 0; i < examens.size(); i++) {
                System.out.println("Examen " + i + ": " + examens.get(i).getNaam());
            }
            return true;
        } else {
            System.out.println("Geen Examens gevonden.");
            return false;
        }
        
    }

    public static Boolean showStudents(ArrayList<Student> studenten) {
        if(studenten.size() > 0) {
            for (int i = 0; i < studenten.size(); i++) {
                System.out.println(
                        "student " + (i + 1) + ": " + studenten.get(i).getNaam() + " - "
                                + studenten.get(i).getStudentNummer());
            }
            return true;
        } else {
            System.out.println("Geen Studenten gevonden.");
            return false;
        }
    }

    public static void showStudentExams(ArrayList<Student> studenten) {
        System.out.println("Welke student wilt u opzoeken?");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i < studenten.size(); i++) {
            if (input.equals(studenten.get(i).getNaam())) {
                int examsAmount = studenten.get(i).getGehaaldeExamens().size();
                if (examsAmount > 0) {
                    for (int j = 0; j < studenten.get(i).getGehaaldeExamens().size(); j++) {
                        System.out.println("Examen " + (j + 1) + ": " + studenten.get(i).getGehaaldeExamens().get(j));
                    }
                } else {
                    System.out.println(
                            "Student met de naam: " + studenten.get(i).getNaam() + " heeft nog geen examens gehaald.");
                }
            }
        }
    }

    public static boolean isNumeric(String string) {
        // Failsafe
        if (string == null) {
            return false;
        }

        // Proberen om een double van de ingevoerde string te maken
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static Student SearchStudent(ArrayList<Student> studenten, ArrayList<Examen> examens) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welke student wilt u opzoeken?");
        String studentInput = scanner.nextLine();

        boolean searchStudentByNumber = false;
        int studentNummer = 0;

        // als de ingevoerde string bestaat uit nummers, wordt er van uit gegaan dat de gebruiker een student wilt opzoeken via een studentnummer
        if(isNumeric(studentInput)) {
           searchStudentByNumber = true;
            studentNummer = Integer.parseInt(studentInput);
        }

        if(searchStudentByNumber) {

            // Student opzoeken via studentnummer

            for (Student student : studenten) {
                if(student.getStudentNummer() == studentNummer) {
                    
                    // Student gevonden

                    System.out.println("[i] Geselecteerde Student: " + student.getNaam() + " (" + student.getStudentNummer()+")");
                    System.out.println("----------------------------------------------------");

                    return student;
                }
            }
            System.out.println("[!] Student niet gevonden");
            System.out.println("----------------------------------------------------");
        } else {

            // Student opzoeken via naam

            for (Student student : studenten) {

                // naam vergelijken met de namen in de studenten array
                if(student.getNaam().toLowerCase().equals(studentInput.toLowerCase())) {
                    
                    // Student gevonden

                    System.out.println("[i] Geselecteerde Student: " + student.getNaam() + " (" + student.getStudentNummer()+")");
                    System.out.println("----------------------------------------------------");

                    return student;
                }
            }
            System.out.println("[!] Student niet gevonden");
            System.out.println("----------------------------------------------------");
        }

        return null;
    }

    public static boolean hasStudentPassedExam(ArrayList<Student> studenten, ArrayList<Examen> examens) {
        Scanner examenInput = new Scanner(System.in);
        Student student = SearchStudent(studenten, examens);

        System.out.println("[i] Selecteer een examen van de lijst");
        
        // Alle examens weergeven

        for (int i = 0; i < examens.size(); i++) {
                System.out.println((i+1)+") "+ examens.get(i).getNaam());
        }
        System.out.println("----------------------------------------------------");

        
        System.out.print("Uw selectie: ");
        int selection = examenInput.nextInt();
        System.out.println("----------------------------------------------------");

        Examen examen = examens.get(selection-1);
        ArrayList<String> gehaaldeExamens = student.getGehaaldeExamens();

        // Controleren of de lijst gehaalde examens leeg is

        if(gehaaldeExamens.isEmpty()) {
            System.out.println("[i] "+student.getNaam() + " ("+student.getStudentNummer()+") heeft nog geen examens gehaald." );
            return false;
        }

        // Controleren of de student het geselecteerde examen heeft gehaald
        boolean examenNietGevonden = true;
        for (String string : gehaaldeExamens) {
            if(string.toLowerCase().equals(examen.getNaam().toLowerCase())) {
                System.out.println("[i] "+student.getNaam() + " ("+student.getStudentNummer()+") heeft het examen " + examen.getNaam() + " gehaald");
                examenNietGevonden = true;
                return true;
            }
        }

        if(examenNietGevonden) {
            System.out.println("[i] "+student.getNaam() + " ("+student.getStudentNummer()+") heeft het examen " + examen.getNaam() + " (nog) niet gehaald");
        }
        return false;
    }

    public static boolean hasStudentPassedExam(ArrayList<Student> studenten, String input1, String input2) {
        System.out.println("Welke student wilt u opzoeken?");
        String studentInput = input1;

        System.out.println("Welk examen wilt u opzoeken?");
        String examenInput = input2;
        Boolean geslaagd = false;
        for (int i = 0; i < studenten.size(); i++) {
            if (studentInput.equals(studenten.get(i).getNaam())) {
                int examsAmount = studenten.get(i).getGehaaldeExamens().size();
                if (examsAmount > 0) {
                    for (int j = 0; j < studenten.get(i).getGehaaldeExamens().size(); j++) {
                        if (examenInput.equals(studenten.get(i).getGehaaldeExamens().get(j))) {
                            System.out.println("Student met de naam: " + studenten.get(i).getNaam()
                                    + " heeft het examen: " + examenInput + " gehaald");
                            geslaagd = true;
                        }
                    }
                } else {
                    System.out.println(
                            "Student met de naam: " + studenten.get(i).getNaam() + " heeft nog geen examens gehaald.");
                }
            }
        }
        if (!geslaagd) {
            System.out.println(
                    "Student met de naam: " + studentInput + " heeft het examen: " + examenInput + " niet gehaald");
        }
        return geslaagd;
    }


    public static void showMyExams(int studentnummer, ArrayList<Student> studenten) {
        for (int i = 0; i < studenten.size(); i++) {
            if (studentnummer == studenten.get(i).getStudentNummer()) {
                int examsAmount = studenten.get(i).getGehaaldeExamens().size();
                if (examsAmount > 0) {
                    System.out.println("Student met de naam: " + studenten.get(i).getNaam() + " heeft de volgende examens gehaald:");
                    System.out.println("===============================================================");
                    for (int j = 0; j < studenten.get(i).getGehaaldeExamens().size(); j++) {
                        System.out.println("Examen " + (j + 1) + ": " + studenten.get(i).getGehaaldeExamens().get(j));
                    }
                } else {
                    System.out.println(
                            "Student met de naam: " + studenten.get(i).getNaam() + " heeft nog geen examens gehaald.");
                }
            }
        }


    }

    
}
