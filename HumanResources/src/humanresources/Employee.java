/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.time.LocalDate;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Empregado
 *
 * @author João Fernandes
 * @author Rodrigo Santos
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
     * @param entryDate Data de entrada do empregado na empresa
     * @param category Categoria do empregado
     * @param values Valores fixados pela empresa
     */
    public Employee(String name, int code, Date entryDate, EmployeeCategory category, Values values) {
        if (validateEmployeeData(name, code, entryDate, values)) {
            this.name = name;
            this.code = code;
            this.entryDate = entryDate;
            this.values = values;
            this.category = category;
            this.workedDays = new int[12];
        } else {
            throw new IllegalArgumentException("Dados do empregado inválidos");
        }
    }

    /* Validação de dados */
    private boolean validateEmployeeData(String name, int code, Date entryDate, Values values) {
        if (name.isBlank() || name.matches(".*[0-9].*")){
            return false;
        }
        if (code <= 0) {
            return false;
        }
        if (entryDate == null) {
            return false;
        }
        return values != null;
    }

    /**
     * Método seletor do atributo name
     *
     * @return Valor do atributo name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método seletor do atributo code
     *
     * @return Valor do atributo code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Método seletor do atributo entryDate
     *
     * @return Valor do atributo entryDate
     */
    public Date getEntryDate() {
        return this.entryDate;
    }

    /**
     * Método seletor do atributo workedDays
     *
     * @return Número de dias trabalhados no mês atual
     */
    public int getWorkedDays() {
        int month = LocalDate.now().getMonthValue() - 1;
        return this.workedDays[month];
    }

    /**
     * Método seletor do atributo category
     *
     * @return Valor do atributo category
     */
    public EmployeeCategory getCategory() {
        return this.category;
    }

    /**
     * Método seletor do atributo values
     *
     * @return Valor do atributo values
     */
    public Values getValues() {
        return this.values;
    }

    /**
     * Método modificador do atributo workedDays
     *
     * @param month Mês a alterar
     * @param days Número de dias trabalhados
     */
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
        return entryDate.getYearsTillToday();
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

            //subsídio férias/natal
            if (month == 5 || month == 10) {
                total += calculateMaxSalary();
            }
        }

        return total;
    }

    /**
     * Método abstrato para cálculo do salário de um empregado
     * @return Valor total do salário
     */
    public abstract double calculateSalary();

    /**
     * Método abstrato para cálculo do salário máximo de um empregado
     * @return Valor total do salário
     */
    public abstract double calculateMaxSalary();

    /**
     * Retorna a informação de um empregado em formato de cadeia de caracteres
     *
     * @return Informação de um empregado
     */
    @Override
    public String toString() {
        String output = "";

        output += "Código: " + code;
        output += "\nNome: " + name;
        output += "\nCategoria: " + category;
        output += "\nData Entrada: " + entryDate;

        return output;
    }
}
