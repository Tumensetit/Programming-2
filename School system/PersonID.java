//package dev.m3s.programming2.homework3;
import java.lang.Math;

import javax.print.FlavorException;

public class PersonID {
    
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    private String numbersOnly;
    private double numero1;
    private double numero2;
    private double numero3;

    public String getBirthdate(){
        return this.birthDate;
    }

    public String setPersonID(final String personID){
        String birthdate = personID.substring(0, 2) + '.' + personID.substring(2, 4) + '.' + vuosituhat(personID) + personID.substring(4, 6);
        int year = Integer.parseInt(personID.substring(4, 6));
        year += (year <= (2023 - 2000)) ? 2000 : 1900;
        birthdate = birthdate.substring(0, 6) + year + birthdate.substring(8);
        
        if (!checkBirthdate(birthdate)) {
            return "Invalid birthday!";
        }
    
        if (!checkValidCharacter(personID)) {
            return "Incorrect check mark!";
        }
    
        this.birthDate = birthdate.substring(0, 2) + "." + birthdate.substring(2, 4) + "." + birthdate.substring(4, 8);
        return "Ok";
    }
    
    
    private boolean checkPersonIDNumber(final String joku){
        if (joku.length() == 11){
            if (joku.charAt(6) == '+' || joku.charAt(6) == '-' || joku.charAt(6) == 'A') {
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }
    

    private boolean checkLeapYear(int year){
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkValidCharacter(final String personID){
        numbersOnly = personID.replaceAll("[^0-9]", "");
        numero1 = Double.parseDouble(numbersOnly);
        numero2 = numero1/31;
        numero3 = Math.round((fractionOf(numero2)) * 31);
        String validChar[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "U", "V", "W", "X", "Y" };
        if (validChar[(int)numero3].charAt(0) == personID.charAt(10)) {
            return true;
        }
        return false;
    }

    private boolean checkBirthdate(final String date){
        int päivä = Integer.parseInt(date.substring(0, 2));
        int kuukausi = Integer.parseInt(date.substring(3, 5));
        int vuosi = Integer.parseInt(date.substring(6, 10));
        if (kuukausi > 12 || kuukausi < 1) {
            return false;
        }
        if (päivä < 1 || päivä > 31) {
            return false;
        }
        switch (kuukausi) {
            case 0:
                return false;
            case 1:
                if (päivä >= 31) {
                    return false;
                }
                break;
            case 2:
                if (checkLeapYear(vuosi) == true) {
                    if (päivä >= 29) {
                        return false;
                    }
                } else {
                    if (päivä >= 28) {
                        return false;
                    }
                }
                break;
            case 3:
                if (päivä >= 31) {
                    return false;
                }
                break;
            case 4:
                if (päivä >= 30) {
                    return false;
                }
                break;
            case 5:
                if (päivä >= 31) {
                    return false;
                }
                break;
            case 6:
                if (päivä >= 30) {
                    return false;
                }
                break;
            case 7:
                if (päivä >= 31) {
                    return false;
                }
                break;
            case 8:
                if (päivä >= 31) {
                    return false;
                }
                break;
            case 9:
                if (päivä >= 30) {
                    return false;
                }
                break;
            case 10:
                if (päivä >= 31) {
                    return false;
                }
                break;
            case 11:
                if (päivä >= 30) {
                    return false;
                }
                break;
            case 12:
                if (päivä >= 31) {
                    return false;
                }
                break;
        }
        return true;
    }

    public static double fractionOf(double x){
        return Math.abs(x - (int) x);
    }

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