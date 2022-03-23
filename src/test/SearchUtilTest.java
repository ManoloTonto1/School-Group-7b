package test;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.Utilities;

import app.Student;
import app.Utility;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class SearchUtilTest {
    @Test
    public void testStudentMostExams() {
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<String> exams = new ArrayList<>();
        Collections.addAll(exams, "scheikunde", "wiskunde", "biologie");
        studenten.add(new Student("Manuel Lopez", 123456, exams));

        ArrayList<String> exams2 = new ArrayList<>();
        Collections.addAll(exams2, "scheikunde", "wiskunde");
        studenten.add(new Student("Martijn Gelton", 123456, exams));

        assertEquals(studenten.get(0).getNaam(), Utility.showStudentExams(studenten));
    }
}
