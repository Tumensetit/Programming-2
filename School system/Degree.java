//package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Degree {

    private static final int MAX_COURSES = 50;
    private int count2 = 0, count = 0, count3 = 0;
    private double creditcounter = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<>(MAX_COURSES);
    

    public List<StudentCourse> getCourses(){
        return myCourses;
    }

    public void addStudentCourses(List<StudentCourse> courses){
        if (courses != null && count < MAX_COURSES) {
            for (StudentCourse course : courses) {
                addStudentCourse(course);
                count2++;
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course){
        if (course != null && count < MAX_COURSES) {
            myCourses.set(count, course);
            count++;
            return true;
        } else {
            return false;
        }
    }

    public String getDegreeTitle(){
        return this.degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle){
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }

    public String getTitleOfThesis(){
        return this.titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis){
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    public double getCreditsByBase(Character base){
        count3 = 0;
        creditcounter = 0;
        while (count3 < myCourses.size()) {
            if(base == myCourses.get(count3).getCourse().getCourseBase()){
                creditcounter += myCourses.get(count3).getCourse().getCredits();
            }
            count3++;
        }
        return creditcounter;
    }
    
    public double getCreditsByType(final int courseType){
        count3 = 0;
        creditcounter = 0;
        while (count3 < myCourses.size()) {
            if(courseType == myCourses.get(count3).getCourse().getCourseType()){
                creditcounter += myCourses.get(count3).getCourse().getCredits();
            }
            count3++;
        }
        return creditcounter;
    }

    public double getCredits(){
        count3 = 0;
        creditcounter = 0;
        while (count3 < myCourses.size()) {
            creditcounter += myCourses.get(count3).getCourse().getCredits();
            count3++;
        }
        return creditcounter;
    }

    private boolean isCourseCompleted(StudentCourse c){
        if (c != null && c.isPassed() == true) {
            return true;
        } else {
            return false;
        }
    }

    public void printCourses(){
        count3 = 0;
        while (count3 < myCourses.size()) {
            myCourses.get(count3).toString();
            count3++;
        }
    }

    public List<Double> getGPA(int type){
        
    }

    public String toString(){
        return "Degree [Title: "+ getDegreeTitle() +" (courses: "+ this.count +") \nThesis title: "+ getTitleOfThesis() +"";
    }
}