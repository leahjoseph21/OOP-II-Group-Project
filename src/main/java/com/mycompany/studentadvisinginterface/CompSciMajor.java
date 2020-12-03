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
public class CompSciMajor extends DcitDegree {
    
    ArrayList<String> s1CourseList = new ArrayList<String>();
    ArrayList<String> s2CourseList = new ArrayList<String>();

    
    public ArrayList<String> getS1CourseList(){
        return s1CourseList;

    }
    public ArrayList<String> getS2CourseList(){
        return s2CourseList;

    }
    
    public int checkNumCourses(String status, double gpa){
    int size;

        if ((status.equals("Part-time"))||(gpa > 0.0 && gpa < 2.0)){
            size = List.size();
            if (size > 2){
                numCourses = 3;
            }else{
                numCourses = List.size();
            }
        }else{
            numCourses = List.size();
        }
        return numCourses;
    }
    public void loadSem1CourseLists() {
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
                if (courses.get(i).equals("CompSciMajorSem1")){
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
                if (courses.get(i).equals("CompSciMajorSem2")){
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
   
    
}
