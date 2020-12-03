import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.mycompany.studentadvisinginterface.CompSciSpecial;

public class CompSciSpecialTest {

    @Test
    public void testGetAndSetSemester(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        int expected = 0;
        int actual = CSSTest.getSemester();
        assertEquals(expected, actual);
        CSSTest.setSemester(1);
        expected = 1;
        actual = CSSTest.getSemester();
        assertEquals(expected, actual);        
    }

    @Test
    public void testGetAndSetStatus(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        String expected = null;
        String actual = CSSTest.getStatus();
        assertEquals(expected, actual);
        CSSTest.setSatus("Part-Time");
        expected = "Part-Time";
        actual = CSSTest.getStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAndSetGPA(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        double expected = 0.0;
        double actual = CSSTest.getGpa();
        assertEquals(expected, actual, 0.00001);
        CSSTest.setGpa(2.3);
        expected = 2.3;
        actual = CSSTest.getGpa();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testGetAndSetS1CourseList(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = CSSTest.getS1CourseList();
        assertEquals(expected, actual);
    }

    @Test
    public void testDegreeListMaker() throws IOException{
        CompSciSpecial CSSTest = new CompSciSpecial();
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
            actual = CSSTest.degreeListMaker();
        }catch(Exception e){
            System.out.println("Exception encountered");
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckAndLoadS1List(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        CSSTest.loadSem1CourseLists();
        ArrayList<String> expected = CSSTest.getS1CourseList();
        ArrayList<String> s1 = CSSTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        ArrayList<String> actual = CSSTest.checkCourseList(1, s1, s2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckAndLoadS2List(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        CSSTest.loadSem2CourseLists();
        ArrayList<String> expected = CSSTest.getS2CourseList();
        ArrayList<String> s1 = new ArrayList<String>();
        ArrayList<String> s2 = CSSTest.getS2CourseList();
        ArrayList<String> actual = CSSTest.checkCourseList(2, s1, s2);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintList(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        CSSTest.loadSem1CourseLists();
        ArrayList<String> s1 = CSSTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        CSSTest.checkCourseList(1, s1, s2);
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n\n";
        expected += "Number of credits: 6";
        String actual = CSSTest.printList(true);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecommend(){
        CompSciSpecial CSSTest = new CompSciSpecial();
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n";
        expected += "INFO 1600 - Introduction to Information Technology Concepts\n";
        expected += "       **You are not required to take MATH 1115**\n\n";
        expected += "Number of credits: 9";
        ArrayList<String> s1 = CSSTest.getS1CourseList();
        ArrayList<String> s2 = CSSTest.getS2CourseList();
        String actual = CSSTest.recommendCourses(1, "Part-Time", 2.3, s1, s2, true);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
