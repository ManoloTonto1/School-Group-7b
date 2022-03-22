package app;

//imoprt java natives
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import JSON
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON {

    private JSON() {
    }

    public static JSON getInstance() {
        return new JSON();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Student> LoadStudents(ArrayList<Student> studenten) {
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
    public boolean saveStudents(ArrayList<Student> studenten) {
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
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
