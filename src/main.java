
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    //create main method
    public static void main(String[] args) {
        // create arraylists for the students an exams
        ArrayList studenten = new ArrayList<Student>();
        ArrayList examens = new ArrayList<Examen>();

        // Temp fill list of students
        studenten.add(new Student("Martijn", 12345678));
        studenten.add(new Student("Manuel", 11234567));

        // Temp examens
        

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
            System.out.println("----------------------------------------------------");

            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    System.out.println("Goodbye");
                    x = 0;
                    break;
                case 1:
                    System.out.println("===========================");
                    //add shit here.
                    System.out.println("===========================");
                    break;
                case 2:
                    System.out.println("===========================");
                    //add shit here
                    System.out.println("===========================");
                    break;
                case 3:

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

                    break;
            }

        }
        scanner.close();
    }
}
