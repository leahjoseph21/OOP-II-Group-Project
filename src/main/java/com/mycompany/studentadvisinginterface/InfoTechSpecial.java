/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentadvisinginterface;
import java.util.*;
import java.io.IOException;
/**
 * Class that models an Information Technology (Special) degree and its courses
 * @author Leah
 */
public class InfoTechSpecial extends DcitDegree{

    /**
     * Boolean to check if the student needs to take MATH1115 or not
     */
    public boolean exempt = false;
    ArrayList<String> s1CourseList = new ArrayList<String>();
    ArrayList<String> s2CourseList = new ArrayList<String>();
    
    
    /** 
     * Returns the course list for semester 1
     * @return ArrayList
     */
    public ArrayList<String> getS1CourseList(){
        return s1CourseList;

    }
    
    /** 
     * Returns the course list for semester 2
     * @return ArrayList
     */
    public ArrayList<String> getS2CourseList(){
        return s2CourseList;

    }
    
    
    /** 
     * Determines the number of courses that should be taken based on GPA and enrollment type
     * @param status full/part-time status of the student
     * @param gpa GPA of the student
     * @return int
     */
    public int checkNumCourses(String status, double gpa){

        if ((status.equals("Part-time"))||(gpa > 0.0 && gpa < 2.0)){
            numCourses = 3;
        }else{
            numCourses = List.size();
        }
        return numCourses;
    }
    
    /**
     * Populates the s1CourseList with the appropriate courses
     */
    public void loadSem1CourseLists(){
        try {
            courses = degreeListMaker();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        boolean found = false;
        int pos = 0;
        int l = courses.size();
        int i;
    
        while(found == false){
            for(i = 0; i < l;i++){
                if (courses.get(i).equals("InfoTechSpecialSem1")){
                    found = true;
                    pos = i;
                }
            }

        }
        i = pos + 1;
    
        while(!(courses.get(i).equals("-"))){
            s1CourseList.add(courses.get(i));
            i++;
        }

    }

    /**
     * Populates the s2CourseList with the appropriate courses
     */
    public void loadSem2CourseLists(){
        try {
            courses = degreeListMaker();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        boolean found = false;
        int pos = 0;
        int l = courses.size();
        int i;
    
        while(found == false){
            for(i = 0; i < l;i++){
                if (courses.get(i).equals("InfoTechSpecialSem2")){
                    found = true;
                    pos = i;
                }
            }

        }
        i = pos + 1;
    
        while(!(courses.get(i).equals("-"))){
            s2CourseList.add(courses.get(i));
            i++;
        }
    }
    
    
    

    
    /** 
     * Prints the list of courses recommended, with a special case in place if MATH1115 does not need to be taken
     * @param exemption
     * @return String
     */
    @Override
    public String printList(boolean exemption) {
        String course;
        int a = 0;
        String studentList = "Your recommended courses are: " + '\n' + '\n';
        

            for (int i = 0; i < numCourses; i++){
                course = List.get(i);
                if (course.equals("MATH 1115 - Fundamental Mathematics for the General Sciences I")&&(exemption == true)){
                    studentList = studentList + "       **You are not required to take MATH 1115**" + '\n';
                }else{
                studentList = studentList + List.get(i) + '\n';
                a+=3;
                }
            }

        studentList = studentList + '\n' + "Number of credits: " + a;
        return studentList;
    
    }
    
    
}
