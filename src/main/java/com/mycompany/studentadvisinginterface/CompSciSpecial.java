/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentadvisinginterface;
import java.util.*;
import java.io.IOException;
/**
 *
 * @author Leah
 */
public class CompSciSpecial extends DcitDegree {
    public boolean exempt = false;
    ArrayList<String> s1CourseList = new ArrayList<String>();
    ArrayList<String> s2CourseList = new ArrayList<String>();
    
    public ArrayList<String> getS1CourseList(){
        return s1CourseList;

    }
    public ArrayList<String> getS2CourseList(){
        return s2CourseList;

    }
    
    public int checkNumCoures(String status, double gpa){

        if ((status.equals("Part-time"))||(gpa > 0.0 && gpa < 2.0)){
            numCourses = 3;
        }else{
            numCourses = List.size();
        }
        return numCourses;
    }
    
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
                if (courses.get(i).equals("CompSciSpecialSem1")){
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
                if (courses.get(i).equals("CompSciSpecialSem2")){
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
        //}
        /*else{
            for (int i = 0; i < numCourses; i++)  
                studentList = studentList + List.get(i)+ '\n'; 

        }*/
        
        studentList = studentList + '\n' + "Number of credits: " + a;
        return studentList;
    
    }
    
}
