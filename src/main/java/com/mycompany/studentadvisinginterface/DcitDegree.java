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
 *
 * @author Leah
 */
public abstract class DcitDegree {
    protected int semester;
    protected String status;
    protected double gpa = 0.0;
    protected int numCourses = 2;
    protected boolean exempt;


    protected ArrayList<String> s1CourseList; 
    protected ArrayList<String> s2CourseList;
    protected ArrayList<String> List ;
    protected ArrayList<String> courses;

    //accessors
    public int getSemester(){
        return semester;
    }
    public String getStatus(){
        return status;
    }
    public double getGpa(){
        return gpa;
    }
    public boolean getExempt(){
        return exempt;
    }
    
    public ArrayList<String> getS1CourseList(){
        return s1CourseList;

    }
    public ArrayList<String> getS2CourseList(){
        return s2CourseList;

    }


    //mutators
    public void setSemester(int semester){
        this.semester = semester;
    }
    public void setSatus(String status){
        this.status = status;
    }
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    
    
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

    public ArrayList<String> checkCourseList(int semester,ArrayList<String> s1CourseList,ArrayList<String> s2CourseList){
        //ArrayList<String> List ;
        if (semester == 1){
            List = s1CourseList;
        }else{
            List = s2CourseList;
        }
        return List;
    }
    
    //Strategy Methods
    public abstract void loadSem1CourseLists();
    public abstract void loadSem2CourseLists();
    public abstract int checkNumCourses(String status, double gpa);

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

    //Template Method
    public final String recommendCourses(int semester,String status,double gpa,ArrayList<String>s1CourseList,ArrayList<String>s2CourseList,boolean exempt){
        loadSem1CourseLists();
        loadSem2CourseLists();
        checkCourseList(semester,s1CourseList,s2CourseList);
        checkNumCourses(status,gpa);
        return  printList(exempt);


    }

}
