import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.mycompany.studentadvisinginterface.CompSciManagement;

/**
 *
 * @author Niko
 */
public class CompSciManageTest {

    /**
     * Tests the ability to get the semester using getSemester as well as update the semester using setSemester
     */
    @Test
    public void testGetAndSetSemester(){
        CompSciManagement CSManTest = new CompSciManagement();
        int expected = 0;
        int actual = CSManTest.getSemester();
        assertEquals(expected, actual);
        CSManTest.setSemester(1);
        expected = 1;
        actual = CSManTest.getSemester();
        assertEquals(expected, actual);        
    }

    /**
     * Tests the ability to get the full/part-time status of the student using getSemester as well as update it using setSemester
     */
    @Test
    public void testGetAndSetStatus(){
        CompSciManagement CSManTest = new CompSciManagement();
        String expected = null;
        String actual = CSManTest.getStatus();
        assertEquals(expected, actual);
        CSManTest.setSatus("Part-Time");
        expected = "Part-Time";
        actual = CSManTest.getStatus();
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to get the GPA of the student using getGPA as well as update it using setGPA
     */
    @Test
    public void testGetAndSetGPA(){
        CompSciManagement CSManTest = new CompSciManagement();
        double expected = 0.0;
        double actual = CSManTest.getGpa();
        assertEquals(expected, actual, 0.00001);
        CSManTest.setGpa(2.3);
        expected = 2.3;
        actual = CSManTest.getGpa();
        assertEquals(expected, actual, 0.00001);
    }

    /**
     * Tests the ability to get the course lists with their associated functions
     */
    @Test
    public void testGetAndSetS1CourseList(){
        CompSciManagement CSManTest = new CompSciManagement();
        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = CSManTest.getS1CourseList();
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to extract the degree data as expected using the degeeListMaker function
     * @throws IOException
     */
    @Test
    public void testDegreeListMaker() throws IOException{
        CompSciManagement CSManTest = new CompSciManagement();
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
            actual = CSManTest.degreeListMaker();
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
        CompSciManagement CSManTest = new CompSciManagement();
        CSManTest.loadSem1CourseLists();
        ArrayList<String> expected = CSManTest.getS1CourseList();
        ArrayList<String> s1 = CSManTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        ArrayList<String> actual = CSManTest.checkCourseList(1, s1, s2);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to load courses into and obtain courses from the semester 2 list
     */
    @Test
    public void testCheckAndLoadS2List(){
        CompSciManagement CSManTest = new CompSciManagement();
        CSManTest.loadSem2CourseLists();
        ArrayList<String> expected = CSManTest.getS2CourseList();
        ArrayList<String> s1 = new ArrayList<String>();
        ArrayList<String> s2 = CSManTest.getS2CourseList();
        ArrayList<String> actual = CSManTest.checkCourseList(2, s1, s2);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to print the list of recommended courses for a semester to the student, using semester 1 for the example
     */
    @Test
    public void testPrintList(){
        CompSciManagement CSManTest = new CompSciManagement();
        CSManTest.loadSem1CourseLists();
        ArrayList<String> s1 = CSManTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        CSManTest.checkCourseList(1, s1, s2);
        String expected = "Your recommended courses are: \n\n";
        expected += "ACCT 1002 - Introduction to Financial Accounting\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n\n";
        expected += "Number of credits: 6";
        String actual = CSManTest.printList(true);
        assertEquals(expected, actual);
    }

    /**
     * Tests the ability to populate the degree and print the full list of recommended courses to the student using the recommendCourses function
     */
    @Test
    public void testRecommend(){
        CompSciManagement CSManTest = new CompSciManagement();
        String expected = "Your recommended courses are: \n\n";
        expected += "ACCT 1002 - Introduction to Financial Accounting\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n";
        expected += "ECON 1001 - Introduction to Microeconomics\n\n";
        expected += "Number of credits: 12";
        ArrayList<String> s1 = CSManTest.getS1CourseList();
        ArrayList<String> s2 = CSManTest.getS2CourseList();
        String actual = CSManTest.recommendCourses(1, "Part-Time", 2.3, s1, s2, true);
        assertEquals(expected, actual);
    }
}
