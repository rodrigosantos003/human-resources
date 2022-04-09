/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 *
 * @author Rodrigo Santos
 */
public class CompanyValues {
    private double workDayValue;
    private double kilometerValue;
    private double salesPercentage;
    private double seniorityAward;
    private double foodAllowance;
    
    public CompanyValues(){
        workDayValue = 32.48;
        kilometerValue = 10;
        salesPercentage = 2.3;
        seniorityAward = 0.5;
        foodAllowance = 4.79;
    }
    
    public double getWorkDayValue(){
        return workDayValue;
    }
    
    public double getKilometerValue(){
        return kilometerValue;
    }
    
    public double getSalesPercentage(){
        return salesPercentage;
    }
    
    public double getSeniorityAward(){
        return seniorityAward;
    }
    
    public double getFoodAllowance(){
        return foodAllowance;
    }
    
    public void setWorkDayValue(double value){
        workDayValue = value;
    }
    
    public void setKilometerValue(double value){
        kilometerValue = value;
    }
    
    public void setSalesPercentage(double value){
        salesPercentage = value;
    }
}
