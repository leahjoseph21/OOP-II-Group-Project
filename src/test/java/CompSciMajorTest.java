import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.mycompany.studentadvisinginterface.CompSciMajor;

/**
 * Suite which tests the functions of the CompSciMajor class
 * @author Niko
 */
public class CompSciMajorTest {

    /**
     * Tests the ability to get the semester using getSemester as well as update the semester using setSemester
     */
    @Test
    public void testGetAndSetSemester(){
        CompSciMajor CSTest = new CompSciMajor();
        int expected = 0;
        int actual = CSTest.getSemester();
        assertEquals(expected, actual);
        CSTest.setSemester(1);
        expected = 1;
        actual = CSTest.getSemester();
        assertEquals(expected, actual);        
    }

    /**
     * Tests the ability to get the full/part-time status of the student using getSemester as well as update it using setSemester
     */
    @Test
    public void testGetAndSetStatus(){
        CompSciMajor CSTest = new CompSciMajor();
        String expected = null;
        String actual = CSTest.getStatus();
        assertEquals(expected, actual);
        CSTest.setSatus("Part-Time");
        expected = "Part-Time";
        actual = CSTest.getStatus();
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to get the GPA of the student using getGPA as well as update it using setGPA
     */
    @Test
    public void testGetAndSetGPA(){
        CompSciMajor CSTest = new CompSciMajor();
        double expected = 0.0;
        double actual = CSTest.getGpa();
        assertEquals(expected, actual, 0.00001);
        CSTest.setGpa(2.3);
        expected = 2.3;
        actual = CSTest.getGpa();
        assertEquals(expected, actual, 0.00001);
    }

    /**
     * Tests the ability to get the course lists with their associated functions
     */
    @Test
    public void testGetAndSetS1CourseList(){
        CompSciMajor CSTest = new CompSciMajor();
        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = CSTest.getS1CourseList();
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to extract the degree data as expected using the degeeListMaker function
     * @throws IOException
     */
    @Test
    public void testDegreeListMaker() throws IOException{
        CompSciMajor CSTest = new CompSciMajor();
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
            actual = CSTest.degreeListMaker();
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
        CompSciMajor CSTest = new CompSciMajor();
        CSTest.loadSem1CourseLists();
        ArrayList<String> expected = CSTest.getS1CourseList();
        ArrayList<String> s1 = CSTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        ArrayList<String> actual = CSTest.checkCourseList(1, s1, s2);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to load courses into and obtain courses from the semester 2 list
     */
    @Test
    public void testCheckAndLoadS2List(){
        CompSciMajor CSTest = new CompSciMajor();
        CSTest.loadSem2CourseLists();
        ArrayList<String> expected = CSTest.getS2CourseList();
        ArrayList<String> s1 = new ArrayList<String>();
        ArrayList<String> s2 = CSTest.getS2CourseList();
        ArrayList<String> actual = CSTest.checkCourseList(2, s1, s2);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to print the list of recommended courses for a semester to the student, using semester 1 for the example
     */
    @Test
    public void testPrintList(){
        CompSciMajor CSTest = new CompSciMajor();
        CSTest.loadSem1CourseLists();
        ArrayList<String> s1 = CSTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        CSTest.checkCourseList(1, s1, s2);
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n\n";
        expected += "Number of credits: 6";
        String actual = CSTest.printList(true);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to populate the degree and print the full list of recommended courses to the student using the recommendCourses function
     */
    @Test
    public void testRecommend(){
        CompSciMajor CSTest = new CompSciMajor();
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n\n";
        expected += "Number of credits: 6";
        ArrayList<String> s1 = CSTest.getS1CourseList();
        ArrayList<String> s2 = CSTest.getS2CourseList();
        String actual = CSTest.recommendCourses(1, "Part-Time", 2.3, s1, s2, true);
        assertEquals(expected, actual);
    }
}
