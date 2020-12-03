import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.mycompany.studentadvisinginterface.InfoTechSpecial;

public class InfoTechSpecialTest {

    @Test
    public void testGetAndSetSemester(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        int expected = 0;
        int actual = ITSTest.getSemester();
        assertEquals(expected, actual);
        ITSTest.setSemester(1);
        expected = 1;
        actual = ITSTest.getSemester();
        assertEquals(expected, actual);        
    }

    @Test
    public void testGetAndSetStatus(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        String expected = null;
        String actual = ITSTest.getStatus();
        assertEquals(expected, actual);
        ITSTest.setSatus("Part-Time");
        expected = "Part-Time";
        actual = ITSTest.getStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAndSetGPA(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        double expected = 0.0;
        double actual = ITSTest.getGpa();
        assertEquals(expected, actual, 0.00001);
        ITSTest.setGpa(2.3);
        expected = 2.3;
        actual = ITSTest.getGpa();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testGetAndSetS1CourseList(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = ITSTest.getS1CourseList();
        assertEquals(expected, actual);
    }

    @Test
    public void testDegreeListMaker() throws IOException{
        InfoTechSpecial ITSTest = new InfoTechSpecial();
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
            actual = ITSTest.degreeListMaker();
        }catch(Exception e){
            System.out.println("Exception encountered");
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckAndLoadS1List(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        ITSTest.loadSem1CourseLists();
        ArrayList<String> expected = ITSTest.getS1CourseList();
        ArrayList<String> s1 = ITSTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        ArrayList<String> actual = ITSTest.checkCourseList(1, s1, s2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckAndLoadS2List(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        ITSTest.loadSem2CourseLists();
        ArrayList<String> expected = ITSTest.getS2CourseList();
        ArrayList<String> s1 = new ArrayList<String>();
        ArrayList<String> s2 = ITSTest.getS2CourseList();
        ArrayList<String> actual = ITSTest.checkCourseList(2, s1, s2);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintList(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        ITSTest.loadSem1CourseLists();
        ArrayList<String> s1 = ITSTest.getS1CourseList();
        ArrayList<String> s2 = new ArrayList<String>();
        ITSTest.checkCourseList(1, s1, s2);
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n\n";
        expected += "Number of credits: 6";
        String actual = ITSTest.printList(true);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecommend(){
        InfoTechSpecial ITSTest = new InfoTechSpecial();
        String expected = "Your recommended courses are: \n\n";
        expected += "COMP 1600 - Introduction to Computing Concepts\n";
        expected += "COMP 1601 - Computer Programming I\n";
        expected += "INFO 1600 - Introduction to Information Technology Concepts\n";
        expected += "       **You are not required to take MATH 1115**\n\n";
        expected += "Number of credits: 9";
        ArrayList<String> s1 = ITSTest.getS1CourseList();
        ArrayList<String> s2 = ITSTest.getS2CourseList();
        String actual = ITSTest.recommendCourses(1, "Part-Time", 2.3, s1, s2, true);
        assertEquals(expected, actual);
    }
}
