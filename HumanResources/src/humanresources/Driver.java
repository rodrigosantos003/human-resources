/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Motorista
 *
 * @author Rodrigo Santos & João Fernnandes
 */
public class Driver extends Employee {

    private double kilometers;

    /**
     * Construtor da classe Driver
     *
     * @param name Nome do empregado
     * @param code Código do empregado
     * @param entryDate Data de entrada na empresa
     * @param values Valores fixados pela empresa
     */
    public Driver(String name, int code, Date entryDate, Values values) {
        super(name, code, entryDate, EmployeeCategory.DRIVER, values);
        this.kilometers = 0;
    }

    public double getKilometers() {
        return this.kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public String toString() {
        return super.toString() + "Quilómetros Percorridos: " + kilometers + "\n";
    }

    @Override
    public double calculateSalary() {
        double total = calculateBaseSalary();

        total += getKilometers() * getValues().getKilometerValue();

        return total;
    }

    @Override
    public double calculateMaxSalary() {
        double total = calculateMaxBaseSalary();

        total += getKilometers() * getValues().getKilometerValue();

        return total;
    }
}
