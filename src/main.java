
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//import JSON

class Main {
    // create main method
    public static void main(String[] args) {
        // Start any objects now like the loading from shit.
        ArrayList<Student> studenten = new ArrayList<Student>();
        ArrayList<Examen> examens = new ArrayList<>();
        examens.add(new Examen("Java"));
        LoadStudents(studenten);

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
                    saveStudents(studenten);
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
                    Student student = RegisterStudent();
                    boolean studentAlreadyExists = false;


                    int studentNumberLimit = 8;
                    boolean studentNumberOverLimit = false;


                    for (Student _student : studenten) {
                        if (_student.getStudentNummer() == student.getStudentNummer()) {

                            studentAlreadyExists = true;
                        }

                        String studentNumberString = ""+student.getStudentNummer()+"";
                        if(studentNumberString.length() > studentNumberLimit) {
                            studentNumberOverLimit = true;
                        }
                    }
                


                    if(!studentAlreadyExists) {
                        if(!studentNumberOverLimit) {

                            studenten.add(student);
                            System.out.println("[i] Student succesvol ingeschreven.");
                            saveStudents(studenten);
                        } 
                        else {
                            System.out.println("[!] Student nummer heeft te veel characters.");
                            
                        }
                    }
                    

                    System.out.println("===========================");
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    hasStudentPassedExam(studenten);
                    break;
                case 7:
                    showStudentExams(studenten);
                    break;
                case 8:
                showStudentMostExams(studenten);

                    break;
                 default:
                    System.out.println("[!] Invalid input");
                    break;
            }

            
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Student> LoadStudents(ArrayList<Student> studenten) {
        // JSON parser object to parse read file
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("students.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            // System.out.println(jsonObject);

            jsonObject.forEach((key, value) -> {
                Student student = new Student(Integer.parseInt(key.toString()));

                // get children from the object
                JSONObject objectChild = (JSONObject) value;
                JSONArray arrayChild = (JSONArray) objectChild.get("gehaaldeExamens");

                // Set student nummer
                student.setNaam(objectChild.get("naam").toString());

                // create array list and set the avlues to the object
                ArrayList<String> list = new ArrayList<String>();

                for (int i = 0; i < arrayChild.size(); i++) {
                    list.add(arrayChild.get(i).toString());
                }

                student.setGehaaldeExamens(list);
                studenten.add(student);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return studenten;

    }

    @SuppressWarnings("unchecked")
    public static void saveStudents(ArrayList<Student> studenten) {
        // create the JSON object where we will store the data from the Array list
        JSONObject root = new JSONObject();
        JSONObject students = new JSONObject();

        for (Student student : studenten) {
            // Create the child nodes to match the Schema of the JSON file
            JSONObject objectChild = new JSONObject();
            JSONArray arrayChild = new JSONArray();

            // put the name and the student number in the root of the JSON object
            objectChild.put("naam", student.getNaam());
            objectChild.put("studentNummer", student.getStudentNummer());

            if (student.getGehaaldeExamens() != null) {
                // add the examen to the array
                for (String examen : student.getGehaaldeExamens()) {
                    arrayChild.add(examen);
                }
            }

            // finish up the object before writing it to the JSON file
            objectChild.put("gehaaldeExamens", arrayChild);
            root.put(student.getStudentNummer(), objectChild);

        }
        students.put("students", root);

        try (FileWriter file = new FileWriter("students.json")) {
            file.write(root.toJSONString());
            file.flush();
            System.out.println("Successfully saved File.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student RegisterStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Naam student: ");
        String naam = scanner.nextLine();

        System.out.print("Studentnummer: ");
        int studentenNummer = scanner.nextInt();

        Student student = new Student(studentenNummer);
        student.setNaam(naam);
        //scanner.close();

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
    public static void showStudentExams(ArrayList<Student> studenten) {
        System.out.println("Welke student wilt u opzoeken?");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i < studenten.size(); i++) {
            if(input.equals(studenten.get(i).getNaam())) {
                int examsAmount = studenten.get(i).getGehaaldeExamens().size();
                if (examsAmount > 0) {
                    for (int j = 0; j < studenten.get(i).getGehaaldeExamens().size(); j++) {
                        System.out.println("Examen " + j + ": " + studenten.get(i).getGehaaldeExamens().get(j));
                    }
                } else {
                    System.out.println("Student met de naam: " + studenten.get(i).getNaam() + " heeft nog geen examens gehaald.");
                }
            }
        }
    }
    public static void hasStudentPassedExam(ArrayList<Student> studenten){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welke student wilt u opzoeken?");
        String studentInput = scanner.nextLine();

        System.out.println("Welk examen wilt u opzoeken?");
        String examenInput = scanner.nextLine();
        Boolean geslaagd = false;
        for (int i = 0; i < studenten.size(); i++) {
            if(studentInput.equals(studenten.get(i).getNaam())) {
                int examsAmount = studenten.get(i).getGehaaldeExamens().size();
                if (examsAmount > 0) {
                    for (int j = 0; j < studenten.get(i).getGehaaldeExamens().size(); j++) {
                        if(examenInput.equals(studenten.get(i).getGehaaldeExamens().get(j))) {
                            System.out.println("Student met de naam: " + studenten.get(i).getNaam() + " heeft het examen: " + examenInput + " gehaald");
                            geslaagd = true;
                        }
                    }
                } else {
                    System.out.println("Student met de naam: " + studenten.get(i).getNaam() + " heeft nog geen examens gehaald.");

                }
            }
        }
        if (!geslaagd) {
            System.out.println("Student met de naam: " + studentInput + " heeft het examen: " + examenInput + " niet gehaald");
        }
    }
}