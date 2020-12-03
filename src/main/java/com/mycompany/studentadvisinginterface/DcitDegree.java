/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentadvisinginterface;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Abstract class used as a template for the various degrees
 * @author Leah
 */
public abstract class DcitDegree {

    /**
     * The selected semester
     */
    protected int semester;

    /**
     * Whether a student is part-time or full-time
     */
    protected String status;

    /**
     * The student's GPA
     */
    protected double gpa = 0.0;

    /**
     * The number of courses that should be taken
     */
    protected int numCourses = 2;

    /**
     * Whether a student doing certain degrees need to take specific courses or not
     */
    protected boolean exempt;

    /**
     * The list of courses for the first semester
     */
    protected ArrayList<String> s1CourseList; 

    /**
     * The list of courses for the second semester
     */
    protected ArrayList<String> s2CourseList;

    /**
     * A list used to hold courses for certain functions
     */
    protected ArrayList<String> List ;

    /**
     * A list of courses
     */
    protected ArrayList<String> courses;

    
    /** 
     * Returns the semester for which courses are being recommended
     * @return int
     */
    //accessors
    public int getSemester(){
        return semester;
    }
    
    /** 
     * Returns the full-time or part-time status of the student
     * @return String
     */
    public String getStatus(){
        return status;
    }
    
    /** 
     * Returns the GPA of the student
     * @return double
     */
    public double getGpa(){
        return gpa;
    }
    
    /** 
     * Returns whether a student is exempt from select courses
     * @return boolean
     */
    public boolean getExempt(){
        return exempt;
    }
    
    
    /** 
     * Returns the first semester's list of courses
     * @return ArrayList
     */
    public ArrayList<String> getS1CourseList(){
        return s1CourseList;

    }
    
    /** 
     * Returns the second semesters list of courses
     * @return ArrayList
     */
    public ArrayList<String> getS2CourseList(){
        return s2CourseList;

    }


    
    /** 
     * Sets the semester for which courses are being recommended
     * @param semester the semester to be set
     */
    //mutators
    public void setSemester(int semester){
        this.semester = semester;
    }
    
    /** 
     * Sets the full-time or part-time status of the student
     * @param status the full/part-time status to be set
     */
    public void setSatus(String status){
        this.status = status;
    }
    
    /** 
     * Sets the student's GPA
     * @param gpa the GPA to be set
     */
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    
    
    
    /** 
     * Adds the list of courses for a degree to the courses variable
     * @return ArrayList
     * @throws IOException
     */
    public ArrayList<String> degreeListMaker() throws IOException {
        String path = "src/DcitDegreeList.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> courses = new ArrayList<>();
        String line = br.readLine();
        while(line !=null){
            courses.add(line);
            line = br.readLine();

        }
        br.close();
        return courses;
    }

    
    /** 
     * Returns the course list for the semester supplied
     * @param semester the semester for which the list is to be obtained
     * @param s1CourseList the list of semester 1 courses for the degree
     * @param s2CourseList the list of semester 2 courses for the degree
     * @return ArrayList
     */
    public ArrayList<String> checkCourseList(int semester,ArrayList<String> s1CourseList,ArrayList<String> s2CourseList){
        //ArrayList<String> List ;
        if (semester == 1){
            List = s1CourseList;
        }else{
            List = s2CourseList;
        }
        return List;
    }
    
    
    /** 
     * Method which loads courses into the semester 1 ArrayList
     */
    //Strategy Methods
    public abstract void loadSem1CourseLists();
    
    /** 
     * Method which loads courses into the semester 2 ArrayList
     */
    public abstract void loadSem2CourseLists();
    
    /** 
     * Checks the number of courses to be recommended based on GPA and full/part-time status
     * @param status full/part-time status of the student
     * @param gpa GPA of the student
     * @return int
     */
    public abstract int checkNumCourses(String status, double gpa);

    
    /** 
     * Prints the courses which are recommended
     * @param exemptions boolean which is true if the student did Pure or N1 Math
     * @return String
     */
    public  String printList(boolean exemptions){
        //create a string
        //System.out.println("Your recommended courses are: " + '\n');
        //for (int i = 0; i < numCourses; i++)  
            //System.out.print(List.get(i)+ '\n');
        int a = 0;
        
        String studentList = "Your recommended courses are: " + '\n' + '\n';
        for (int i = 0; i < numCourses; i++){  
            studentList = studentList + List.get(i)+ '\n';
            a+=3;
        }
        studentList = studentList + '\n' + "Number of credits: " + a;
        return studentList;

    }

    
    /** 
     * Template method which generates a recommendation of courses based on the student information supplied
     * @param semester the semester which the student is in
     * @param status full/part-time status of the student
     * @param gpa GPA of the student
     * @param s1CourseList empty list to hold courses for semester 1
     * @param s2CourseList empty list to hold courses for semester 2
     * @param exempt boolean which is true if the student did Pure or N1 Math
     * @return String
     */
    public final String recommendCourses(int semester, String status, double gpa, ArrayList<String>s1CourseList, ArrayList<String>s2CourseList, boolean exempt){
        loadSem1CourseLists();
        loadSem2CourseLists();
        checkCourseList(semester,s1CourseList,s2CourseList);
        checkNumCourses(status,gpa);
        return  printList(exempt);


    }

}
