import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.mycompany.studentadvisinginterface.CompSciMinor;

/**
 *
 * @author Niko
 */
public class CompSciMinorTest {

    /**
     * Tests the ability to get the semester using getSemester as well as update the semester using setSemester
     */
    @Test
    public void testGetAndSetSemester(){
        CompSciMinor CSMinTest = new CompSciMinor();
        int expected = 0;
        int actual = CSMinTest.getSemester();
        assertEquals(expected, actual);
        CSMinTest.setSemester(1);
        expected = 1;
        actual = CSMinTest.getSemester();
        assertEquals(expected, actual);        
    }

    /**
     * Tests the ability to get the full/part-time status of the student using getSemester as well as update it using setSemester
     */
    @Test
    public void testGetAndSetStatus(){
        CompSciMinor CSMinTest = new CompSciMinor();
        String expected = null;
        String actual = CSMinTest.getStatus();
        assertEquals(expected, actual);
        CSMinTest.setSatus("Part-Time");
        expected = "Part-Time";
        actual = CSMinTest.getStatus();
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to get the GPA of the student using getGPA as well as update it using setGPA
     */
    @Test
    public void testGetAndSetGPA(){
        CompSciMinor CSMinTest = new CompSciMinor();
        double expected = 0.0;
        double actual = CSMinTest.getGpa();
        assertEquals(expected, actual, 0.00001);
        CSMinTest.setGpa(2.3);
        expected = 2.3;
        actual = CSMinTest.getGpa();
        assertEquals(expected, actual, 0.00001);
    }

    /**
     * Tests the ability to get the course lists with their associated functions
     */
    @Test
    public void testGetAndSetS1CourseList(){
        CompSciMinor CSMinTest = new CompSciMinor();
        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = CSMinTest.getS1CourseList();
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to extract the degree data as expected using the degeeListMaker function
     * @throws IOException
     */
    @Test
    public void testDegreeListMaker() throws IOException{
        CompSciMinor CSMinTest = new CompSciMinor();
        String path = "src/DcitDegreeList.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> expected = new ArrayList<>();
        String line = br.readLine();
        while(line !=null){
            expected.add(line);
            line = br.readLine();

        }
        br.close();
        ArrayList<String> actual = new ArrayList<String>();
        try{
            actual = CSMinTest.degreeListMaker();
        }catch(Exception e){
            System.out.println("Exception encountered");
        }
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to load courses into and obtain courses from the semester 1 list
     */
    @Test
    public void testCheckAndLoadS1List(){
        CompSciMinor CSMinTest = new CompSciMinor();
        CSMinTest.loadSem1CourseLists();
        ArrayList<String> expected = CSMinTest.getS1CourseList();
        ArrayList<String> s1 = CSMinTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        ArrayList<String> actual = CSMinTest.checkCourseList(1, s1, s2);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to load courses into and obtain courses from the semester 2 list
     */
    @Test
    public void testCheckAndLoadS2List(){
        CompSciMinor CSMinTest = new CompSciMinor();
        CSMinTest.loadSem2CourseLists();
        ArrayList<String> expected = CSMinTest.getS2CourseList();
        ArrayList<String> s1 = new ArrayList<String>();
        ArrayList<String> s2 = CSMinTest.getS2CourseList();
        ArrayList<String> actual = CSMinTest.checkCourseList(2, s1, s2);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to print the list of recommended courses for a semester to the student, using semester 1 for the example
     */
    @Test
    public void testPrintList(){
        CompSciMinor CSMinTest = new CompSciMinor();
        CSMinTest.loadSem1CourseLists();
        ArrayList<String> s1 = CSMinTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        CSMinTest.checkCourseList(1, s1, s2);
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n\n";
        expected += "Number of credits: 6";
        String actual = CSMinTest.printList(true);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to populate the degree and print the full list of recommended courses to the student using the recommendCourses function
     */
    @Test
    public void testRecommend(){
        CompSciMinor CSMinTest = new CompSciMinor();
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n\n";
        expected += "Number of credits: 6";
        ArrayList<String> s1 = CSMinTest.getS1CourseList();
        ArrayList<String> s2 = CSMinTest.getS2CourseList();
        String actual = CSMinTest.recommendCourses(1, "Part-Time", 2.3, s1, s2, true);
        assertEquals(expected, actual);
    }
}
