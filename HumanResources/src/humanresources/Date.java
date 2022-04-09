/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;
import java.time.LocalDate;
/**
 *
 * @author Rodrigo Santos
 */
public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {

        if (validateDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            this.day = 15;
            this.month = 10;
            this.year = 1582;
        }
    }

    private boolean validateDate(int day, int month, int year) {
        if( year < 1582 ){
            return false;
        }
        if( month < 1 || month > 12){
            return false;
        }
        if( day < 1 || day > daysOfMonth(month,year) ){
            return false;
        }
        if( year == 1582 ){
            if(month < 10 || month==10 && day<15){
                return false;
            }
        }
        return true;
    }

    private int daysOfMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        return 0;
    }

    private boolean isLeapYear(int year) {
        // O ano é bissexto se for divisível por quatro, exceto anos múltiplos
        // de 100 que não são múltiplos de 400:
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (validateDate(day, this.month, this.year)) {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (validateDate(this.day, month, this.year)) {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (validateDate(this.day, this.month, year)) {
            this.year = year;
        }
    }

    public int getYearsTillToday() {  // era getAge
        int yearsTillToday = getCurrentYear() - year;
        if (month > getCurrentMonth() || month == getCurrentMonth() && day > getCurrentDay()) {
            yearsTillToday -= 1;
        }

        return yearsTillToday;
    }

    private int getCurrentYear() {
        return LocalDate.now().getYear();
    }

    private int getCurrentMonth() {
        return LocalDate.now().getMonthValue();
    }

    private int getCurrentDay() {
        return LocalDate.now().getDayOfMonth();
    }

    @Override
    public String toString()
    {
        return day + "/" + month + "/" + year;
    }
}
