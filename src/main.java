
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
//import JSON
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    //create main method
    public static void main(String[] args) {
        // Start any objects now like the loading from shit.
        readJson();

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
    @SuppressWarnings("unchecked")
    public static void readJson(){
               //JSON parser object to parse read file
               JSONParser parser = new JSONParser(); 
         
               try (FileReader reader = new FileReader("students.json"))
               {
                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                //System.out.println(jsonObject);
               
                jsonObject.forEach((key, value) -> {
                    Student student = new Student(key.toString());
                    System.out.println(student.getNaam());
                    for (String i : value) {
                        
                    }
                    //System.out.println(key + " : " + value);
                });
                  

        
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (ParseException e) {
                   e.printStackTrace();
               }

    }



}
