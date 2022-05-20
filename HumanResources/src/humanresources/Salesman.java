/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Comercial
 *
 * @author Rodrigo Santos & João Fernnandes
 */
public class Salesman extends Employee {

    private int sales;

    /**
     * Construtor da classe Salesman
     *
     * @param name Nome do empregado
     * @param code Código do empregado
     * @param entryDate Data de entrada na empresa
     * @param values Valores fixados pela empresa
     */
    public Salesman(String name, int code, Date entryDate, Values values) {
        super(name, code, entryDate, EmployeeCategory.SALESMAN, values);
        this.sales = 0;
    }

    public int getSales() {
        return this.sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return super.toString() + "Vendas Realizadas: " + sales + "\n";
    }

    @Override
    public double calculateSalary() {
        double total = calculateBaseSalary();

        total += sales * getValues().getSalesPercentage();

        return total;
    }

    @Override
    public double calculateMaxSalary() {
        double total = calculateMaxBaseSalary();

        total += sales * getValues().getSalesPercentage();

        return total;
    }
}
