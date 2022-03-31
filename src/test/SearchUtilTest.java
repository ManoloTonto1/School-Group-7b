package test;

import java.beans.Transient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    public void showStudentMostExams_getStudentWithMostExams_returnsMartijn() {
        //Arrange
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<String> exams = new ArrayList<>();
        Collections.addAll(exams, "scheikunde", "wiskunde", "biologie");
        studenten.add(new Student("Manuel Lopez", 123456, exams));
        ArrayList<String> exams2 = new ArrayList<>();
        Collections.addAll(exams2, "scheikunde", "wiskunde");
        studenten.add(new Student("Martijn Gelton", 123456, exams));
        Boolean expectedResult = true;
        Boolean actualResult = false;

        //Act
        actualResult = studenten.get(0).getNaam().equals(Utility.showStudentMostExams(studenten)); 

        //Assert
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void showExams_onlyShowsExamsWhenFilled_returnsTrueAndFalse() {
        //Arrange
        ArrayList<Examen> exams = new ArrayList<>();
        exams.add(new Examen("scheikunde"));
        exams.add(new Examen("wiskunde"));
        exams.add(new Examen("biologie"));
        ArrayList<Examen> exams2 = new ArrayList<>();
        int midResult1 = 0;
        int midResult2 = 0;
        int expectedResult = 2;
        int actualResult = 0;

        //Act
        midResult1 = Utility.showExams(exams) ? 1 : 0;
        midResult2 = Utility.showExams(exams2) ? 0 : 1;
        actualResult = midResult1 + midResult2;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void showStudents_onlyShowsStudentsWhenFilled_returnsTrueAndFalse() {
        //Arrange
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<Student> studenten2 = new ArrayList<>();
        ArrayList<String> exams = new ArrayList<>();
        Collections.addAll(exams, "scheikunde", "wiskunde", "biologie");
        studenten.add(new Student("Manuel Lopez", 123456, exams));
        ArrayList<String> exams2 = new ArrayList<>();
        Collections.addAll(exams2, "scheikunde", "wiskunde");
        studenten.add(new Student("Martijn Gelton", 123456, exams));
        int midResult1 = 0;
        int midResult2 = 0;
        int expectedResult = 2;
        int actualResult = 0;

        //Act
        midResult1 = Utility.showStudents(studenten) ? 1 : 0;
        midResult2 = Utility.showStudents(studenten2) ? 0 : 1;
        actualResult = midResult1 + midResult2;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void studentPassedExams_returnsCorrectValueDependingOnIfYouPassed_returnTrueWhenPassed() {
        //Arrange
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<String> exams = new ArrayList<>();
        Collections.addAll(exams, "scheikunde", "wiskunde", "biologie");
        studenten.add(new Student("Manuel Lopez", 123456, exams));
        ArrayList<String> exams2 = new ArrayList<>();
        Collections.addAll(exams2, "scheikunde", "wiskunde");
        studenten.add(new Student("Martijn Gelton", 123456, exams2));
        int midResult1 = 0;
        int midResult2 = 0;
        int expectedResult = 2;
        int actualResult = 0;

        //Act
        midResult1 = Utility.hasStudentPassedExam(studenten, "Manuel Lopez", "biologie") ? 1 : 0;
        midResult2 = Utility.hasStudentPassedExam(studenten, "Martijn Gelton", "biologie") ? 0 : 1;
        actualResult = midResult1 + midResult2;
    
        //Assert
        assertEquals(expectedResult, actualResult);
    }
}
