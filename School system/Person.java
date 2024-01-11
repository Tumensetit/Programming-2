//package dev.m3s.programming2.homework3;
import java.util.Random;

public abstract class Person{
    private String firstName;
    private String lastName;
    private String birthDate;

    public Person(String lname, String fname){
        if (lname != null){
            this.lastName = lname;
        } else {
            this.lastName = "No name";
        }

        if (fname != null){
            this.firstName = fname;
        } else {
            this.firstName = "No name";
        }

        this.birthDate = "Not available";
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getBirthDate(){
        return this.birthDate;
    }

    public String setBirthDate(String personId){
/*      if (personID.setPersonID(personId) == "Ok") {
            this.birthDate=personId.substring(0, 2) + '.' + personId.substring(2, 4) + '.' + vuosituhat(personId) + personId.substring(4, 6);
        }*/
        return "jotia";
    }

    protected int getRandomId(final int min, final int max){
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public abstract String getIdString();

    public int vuosituhat(String PersonID){
        if (PersonID.charAt(6) == 'A') {
            return 20;
        }
        if (PersonID.charAt(6) == '+') {
            return 18;
        }
        if (PersonID.charAt(6) == '-') {
            return 19;
        }
        return 0;
    }
}