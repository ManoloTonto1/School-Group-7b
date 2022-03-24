package test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.Utilities;

import app.Examen;
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

        assertTrue(studenten.get(0).getNaam().equals(Utility.showStudentMostExams(studenten)));
    }
    
    @Test
    public void testShowExams() {
        ArrayList<Examen> exams = new ArrayList<>();
        exams.add(new Examen("scheikunde"));
        exams.add(new Examen("wiskunde"));
        exams.add(new Examen("biologie"));

        ArrayList<Examen> exams2 = new ArrayList<>();
        assertTrue(Utility.showExams(exams));
        assertEquals(Utility.showExams(exams2), false);
    }

    @Test
    public void testShowStudents() {
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<Student> studenten2 = new ArrayList<>();
        ArrayList<String> exams = new ArrayList<>();
        Collections.addAll(exams, "scheikunde", "wiskunde", "biologie");
        studenten.add(new Student("Manuel Lopez", 123456, exams));

        ArrayList<String> exams2 = new ArrayList<>();
        Collections.addAll(exams2, "scheikunde", "wiskunde");
        studenten.add(new Student("Martijn Gelton", 123456, exams));

        assertTrue(Utility.showStudents(studenten));
        assertEquals(Utility.showStudents(studenten2), false);
    }
}
