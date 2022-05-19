/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 *
 * @author Rodrigo Santos
 * @lastmod 2022-05-06
 */
public class Values {

    private double workdayValue;
    private double foodAllowance;
    private double seniorityAward;
    private double kilometerValue;
    private double salesPercentage;
    private double maxWorkDays;

    public Values(double workdayValue, double kilometerValue, double salesPercentage, int maxWorkDays) {
        if (validateValues(workdayValue, kilometerValue, salesPercentage, maxWorkDays)) {
            this.workdayValue = workdayValue;
            this.kilometerValue = kilometerValue;
            this.salesPercentage = salesPercentage;
            this.maxWorkDays = maxWorkDays;
        } else {
            this.workdayValue = 68.18;
            this.kilometerValue = 3.25;
            this.salesPercentage = 0.15;
            this.maxWorkDays = 22;
        }

        this.foodAllowance = 4.79;
        this.seniorityAward = 0.5;
    }

    public double getWorkdayValue() {
        return this.workdayValue;
    }

    public double getFoodAllowance() {
        return this.foodAllowance;
    }

    public double getSeniorityAward() {
        return this.seniorityAward;
    }

    public double getKilometerValue() {
        return this.kilometerValue;
    }

    public double getSalesPercentage() {
        return this.salesPercentage;
    }

    public void setWorkDayValue(double workdayValue) {
        this.workdayValue = workdayValue;
    }

    public void setKilometerValue(double kilometerValue) {
        this.kilometerValue = kilometerValue;
    }

    public void setSalesPercentage(double salesPercentage) {
        this.salesPercentage = salesPercentage;
    }

    public double getMaxWorkDays() {
        return maxWorkDays;
    }

    public void setMaxWorkDays(double maxWorkDays) {
        this.maxWorkDays = maxWorkDays;
    }

    /*
    Validação de dados
     */
    private boolean validateValues(double workdayValue, double kilometerValue, double salesPercentage, int maxWorkedDays) {
        if (workdayValue <= 0) {
            return false;
        }
        if (kilometerValue <= 0) {
            return false;
        }
        if  (salesPercentage <= 0) {
            return false;
        }
        return maxWorkedDays > 0;
    }
}
