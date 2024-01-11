//package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person {
    private int id;
    private int startYear = 2023;
    private int graduationYear;
    private List<Degree> degrees = new ArrayList<>();

    public Student(String lname, String fname){
        super(lname, fname);
    }

    public int getId(){
        return this.id;
    }

    public void setId(final int id){
        if (id >= 1 && id <= 100){
            this.id = id;
        }
    }

    public int getStartYear (){
        return this.startYear;
    }

    public void setStartYear(final int vuosi){
        if (vuosi<=2023 && vuosi>=2001) {
            this.startYear = vuosi;
        }
    }

    public int getGraduationYear(){
        return this.graduationYear;
    }

    public String setGraduationYear(final int valmistumisvuosi){
        
        if (canGraduate() == false) {
            return "Check amount of required credits";
        }
        if (2023<valmistumisvuosi || valmistumisvuosi<startYear) {
            return "Check graduation year";
        } 
        else {
            this.graduationYear = valmistumisvuosi;
            return "Ok";
        }
    }

    public void setDegreeTitle(String dName){
        if(dName != null){
//            degree.setDegreeTitle(dName);
        }
    }

    public boolean addCourse(StudentCourse course){
        int count = 0;
        if (course != null && count <50) {
//            degree.addStudentCourse(course);
            count++;
            return true;
        } else {
            return false;
        }
    }

    public int addCourses(StudentCourse[] courses){
        int addedcourses= 0;
        int count = 0;
        while (count < courses.length && courses[count] != null && addedcourses < 50) {
            degrees.get(1).addStudentCourse(courses[count]);
            count++;
            addedcourses++;
        }
        return addedcourses;
    }

    public void printCourses(){
        degrees.get(1).printCourses();
    }

    public void printDegree(){
        System.out.println(degrees.toString());
    }

    public void setTitleOfThesis(String title, final int i){
        if (title != null && title != degrees.get(i).getTitleOfThesis()) {
            degrees.get(i).setTitleOfThesis(title);
        }
    }

    public boolean hasGraduated(){
        if (graduationYear<=2023 && canGraduate()==true && graduationYear>2000) {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean canGraduate(){
      if (degrees.get(0).getTitleOfThesis() != ConstantValues.NO_TITLE) {
            return true;
        } 
        return false; 
    }

    public int getStudyYears(){
        if (hasGraduated() == true) {
            return graduationYear - startYear;
        } else {
            return 2023-startYear;
        }
    }

    private int getRandomId(){
        Random randId = new Random();
        return id = randId.nextInt(100) + 1;
    }

    public String onkoValmistunut(){
        if (hasGraduated()==true) {
            return "The student has graduated in " + graduationYear;
        }
        else{
            return  "The student has not graduated, yet.";
        }
    }

    public String toStringinStartYear(){
        if (hasGraduated() == true) {
            return getStartYear() + " (studies lasted for " + getStudyYears() + " years)";
        } else {
            return getStartYear() + " (studies have lasted for " + getStudyYears() + " years)";
        }
    }

    public String getIdString(){
        return ".";
    }
}