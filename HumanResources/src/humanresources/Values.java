/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Valores
 * Fixados
 *
 * @author João Fernandes
 * @author Rodrigo Santos
 */
public class Values {

    private double workdayValue;
    private double foodAllowance;
    private double seniorityAward;
    private double kilometerValue;
    private double salesPercentage;
    private double maxWorkDays;

    /**
     * Construtor da classe Values
     *
     * @param workdayValue Valor por dias de trabalho
     * @param kilometerValue Valor por quilómetro
     * @param salesPercentage Percentagem de vendas
     * @param maxWorkDays Máximo de dias trabalhados por um empregado
     */
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
        if (salesPercentage <= 0) {
            return false;
        }
        return maxWorkedDays > 0;
    }

    /**
     * Método seletor do atributo workDayValue
     *
     * @return Valor do atributo workDayValue
     */
    public double getWorkdayValue() {
        return this.workdayValue;
    }

    /**
     * Método seletor do atributo foodAllowance
     *
     * @return Valor do atributo foodAllowance
     */
    public double getFoodAllowance() {
        return this.foodAllowance;
    }

    /**
     * Método seletor do atributo seniorityAward
     *
     * @return Valor do atributo seniorityAward
     */
    public double getSeniorityAward() {
        return this.seniorityAward;
    }

    /**
     * Método seletor do atributo kilometerValue
     *
     * @return Valor do atributo kilometerValue
     */
    public double getKilometerValue() {
        return this.kilometerValue;
    }

    /**
     * Método seletor do atributo salesPercentage
     *
     * @return Valor do atributo salesPercentage
     */
    public double getSalesPercentage() {
        return this.salesPercentage;
    }

    /**
     * Método seletor do atributo maxWorkDays
     *
     * @return Valor do atributo maxWrorkDay
     */
    public double getMaxWorkDays() {
        return maxWorkDays;
    }

    /**
     * Método modificador do atributo workdayValue
     *
     * @param workdayValue Novo valor a tribuir
     */
    public void setWorkDayValue(double workdayValue) {
        try {
            if (workdayValue > 0) {
                this.workdayValue = workdayValue;
            } else {
                throw new IllegalArgumentException("Valor tem de ser superior a zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Valor não alterado: " + e.getMessage());
        }
    }

    /**
     * Método modificador do atributo kilometerValue
     *
     * @param kilometerValue Novo valor a atribuir
     */
    public void setKilometerValue(double kilometerValue) {
        try {
            if (kilometerValue > 0) {
                this.kilometerValue = kilometerValue;
            } else {
                throw new IllegalArgumentException("Valor tem de ser superior a zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Valor não alterado: " + e.getMessage());
        }
    }

    /**
     * Método modificador do atributo salesPercentage
     *
     * @param salesPercentage Novo valor a atribuir
     */
    public void setSalesPercentage(double salesPercentage) {
        try {
            if (salesPercentage > 0) {
                this.salesPercentage = salesPercentage;
            } else {
                throw new IllegalArgumentException("Valor tem de ser superior a zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Valor não alterado: " + e.getMessage());
        }
    }

    /**
     * Método modificador do atributo maxWorkDays
     *
     * @param maxWorkDays Novo valor a atribuir
     */
    public void setMaxWorkDays(double maxWorkDays) {
        try {
            if (maxWorkDays > 0) {
                this.maxWorkDays = maxWorkDays;
            } else {
                throw new IllegalArgumentException("Valor tem de ser superior a zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Valor não alterado: " + e.getMessage());
        }
    }
}
