//package dev.m3s.programming2.homework3;
public class Employee {
    private String empId;
    private int startYear = 2023;
    private double salary;

    public Employee(String lname, String fname){
        
    }

    public String getIdString(){
        return empId;
    }

    public int getStartYear(){
        if(startYear > 2000 && startYear <= 2023){
            return startYear;
        } else {
            return 2023;
        }
    }

    public void setStartYear(final int startYear){
        if (startYear > 2000 && startYear < 2024) {
            this.startYear = startYear;
        } else {
            this.startYear = 2023;
        }
    }

    public double getSalary(){
        return this.salary;
    }

    public void setSalary(final double salary){
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public double calculatePayment(){
        return this.salary*1.5;
    }

    public String getEmpleyeeIdString(){
        return "OY_";
    }

    public String toString(){
        return ".";
    }
}