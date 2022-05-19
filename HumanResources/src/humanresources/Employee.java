/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author Rodrigo Santos
 * @lastmod 2022-05-06
 */
public abstract class Employee {

    private String name;
    private int code;
    private Date entryDate;
    private int[] workedDays;
    private String category;
    private Values values;

    public Employee(String name, int code, Date entryDate, String category, Values values) {
        if (validateEmployeeData(name, code, entryDate, category, values)) {
            this.name = name;
            this.code = code;
            this.entryDate = entryDate;
            this.category = category;
            this.values = values;
        } else {
            this.name = "UNKNOWN";
            this.code = 5000;
            this.entryDate = new Date(1, 1, 2000);
            this.values = new Values(68.18, 3.25, 0.2, 22);
            this.category = "UNKNOWN";
        }

        this.workedDays = new int[12];
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public int getWorkedDays() {
        int month = LocalDate.now().getMonthValue() - 1;
        return workedDays[month];
    }

    public String getCategory() {
        return category;
    }

    public void setWorkedDays(int month, int days) {
        if (days > 0 && days < this.values.getMaxWorkDays()) {
            workedDays[month] = days;
        }
    }

    /**
     * Calcula a antiguidade de um empregado na empresa
     *
     * @return Antiguidade na empresa
     */
    public int seniority() {
        LocalDate localEntryDate = LocalDate.of(entryDate.getYear(), entryDate.getMonth(), entryDate.getDay());
        return Period.between(localEntryDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Código: " + code + "\n"
                + "Nome: " + name + "\n"
                + "Categoria: " + category + "\n"
                + "Data Entrada: " + entryDate.toString() + "\n";
    }

    /*
      Validação de dados
     */
    private boolean validateEmployeeData(String name, int code, Date entryDate, String category, Values values) {
        if (name.isBlank()) {
            return false;
        }
        if (code <= 0) {
            return false;
        }
        if (entryDate == null) {
            return false;
        }
        if (!validateCategory(category)) {
            return false;
        }
        if (values == null) {
            return false;
        }
        return true;
    }

    private boolean validateCategory(String category) {
        switch (category.toUpperCase()) {
            case "GESTOR":
                return true;
            case "MOTORISTA":
                return true;
            case "COMERCIAL":
                return true;
            case "NORMAL":
                return true;
            default:
                break;
        }

        return false;
    }

    public double calculateBaseSalary() {
        double total = 0.0;
        total += getWorkedDays() * getValues().getWorkdayValue();
        total += getWorkedDays() * getValues().getFoodAllowance();
        total += seniority() * getValues().getSeniorityAward();

        return total;
    }
    
    public double calculateMaxBaseSalary() {
        double total = 0.0;

        total += getValues().getMaxWorkDays() * getValues().getWorkdayValue();
        total += getValues().getMaxWorkDays() * getValues().getFoodAllowance();
        total += seniority() * getValues().getSeniorityAward();

        return total;
    }
    
    public double calculateMultipleSalaries(int startingMonth, int finalMonth){
        double total = 0.0;
        
        for(int month = startingMonth; month <= finalMonth; month++){
            total += calculateMaxSalary();
            
            if(month == 5 || month == 10){
                total += calculateSubsidy();
            }
        }
        
        return total;
    }

    public double calculateSubsidy() {
        double total = 0.0;

        total += getValues().getMaxWorkDays() * getValues().getWorkdayValue();
        total += getValues().getMaxWorkDays() * getValues().getFoodAllowance();
        total += seniority() * getValues().getSeniorityAward();

        return total;
    }    
    
    public abstract double calculateSalary();
    
    public abstract double calculateMaxSalary();

    public Values getValues() {
        return this.values;
    }
}
