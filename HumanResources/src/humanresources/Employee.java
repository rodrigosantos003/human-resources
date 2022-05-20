/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.time.LocalDate;
import java.time.Period;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Empregado
 *
 * @author Rodrigo Santos & João Fernnandes
 */
public abstract class Employee {

    private String name;
    private int code;
    private Date entryDate;
    private int[] workedDays;
    private EmployeeCategory category;
    private Values values;

    /**
     * Construtor da classe Employee
     *
     * @param name Nome do empregado
     * @param code Código do empregado
     * @param entryDate Data de entrada na empresa
     * @param category Categoria do empregado
     * @param values Valores fixados pela empresa
     */
    public Employee(String name, int code, Date entryDate, EmployeeCategory category, Values values) {
        if (validateEmployeeData(name, code, entryDate, values)) {
            this.name = name;
            this.code = code;
            this.entryDate = entryDate;
            this.values = values;
        } else {
            this.name = "UNKNOWN";
            this.code = 5000;
            this.entryDate = new Date(1, 1, 2000);
            this.values = new Values(68.18, 3.25, 0.2, 22);
        }

        this.category = category;
        this.workedDays = new int[12];
    }

    /* Getters */
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

    public EmployeeCategory getCategory() {
        return category;
    }

    public Values getValues() {
        return this.values;
    }

    /* Setters */
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

    /**
     * Retorna a informação de um empregado em formato de cadeia de caracteres
     *
     * @return Informação de um empregado
     */
    @Override
    public String toString() {
        return "Código: " + code + "\n"
                + "Nome: " + name + "\n"
                + "Categoria: " + category + "\n"
                + "Data Entrada: " + entryDate.toString() + "\n";
    }

    /**
     * Calcula o salário base de um empregado
     *
     * @return Valor do salário base
     */
    public double calculateBaseSalary() {
        double total = 0.0;
        total += getWorkedDays() * getValues().getWorkdayValue();
        total += getWorkedDays() * getValues().getFoodAllowance();
        total += seniority() * getValues().getSeniorityAward();

        return total;
    }

    /**
     * Calcula o salário base máximo, i.e. com todos os dias trabalhados, de um
     * empregado
     *
     * @return Valor do salário base máximo
     */
    public double calculateMaxBaseSalary() {
        double total = 0.0;

        total += getValues().getMaxWorkDays() * getValues().getWorkdayValue();
        total += getValues().getMaxWorkDays() * getValues().getFoodAllowance();
        total += seniority() * getValues().getSeniorityAward();

        return total;
    }

    /**
     * Calcula o salário de um empregado, num dado intervalo de tempo
     *
     * @param startingMonth Mês de início do cálculo
     * @param finalMonth Mês de fim do cálculo
     * @return Valor final do cálculo
     */
    public double calculateMultipleSalaries(int startingMonth, int finalMonth) {
        double total = 0.0;

        for (int month = startingMonth; month <= finalMonth; month++) {
            total += calculateMaxSalary();

            if (month == 5 || month == 10) {
                total += calculateSubsidy();
            }
        }

        return total;
    }

    /**
     * Calcula um subsídio a acrescentar ao salário
     *
     * @return Valor do subsídio
     */
    public double calculateSubsidy() {
        double total = 0.0;

        total += getValues().getMaxWorkDays() * getValues().getWorkdayValue();
        total += getValues().getMaxWorkDays() * getValues().getFoodAllowance();
        total += seniority() * getValues().getSeniorityAward();

        return total;
    }

    public abstract double calculateSalary();

    public abstract double calculateMaxSalary();

    /* Validação de dados */
    private boolean validateEmployeeData(String name, int code, Date entryDate, Values values) {
        if (name.isBlank()) {
            return false;
        }
        if (code <= 0) {
            return false;
        }
        if (entryDate == null) {
            return false;
        }
        if (values == null) {
            return false;
        }
        return true;
    }

    /*
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
*/
}
