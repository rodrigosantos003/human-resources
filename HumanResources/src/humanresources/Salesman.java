/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Comercial
 *
 * @author João Fernandes
 * @author Rodrigo Santos
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

    /**
     * Método seletor do atributo sales
     *
     * @return Valor do atributo sales
     */
    public int getSales() {
        return this.sales;
    }

    /**
     * Método modificador do atributo sales
     *
     * @param sales Novo valor a atribuir
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * Calcula o salário de um comercial
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateSalary() {
        double total = calculateBaseSalary();

        total += sales * getValues().getSalesPercentage();

        return total;
    }

    /**
     * Calcula o salário máximo de um comercial
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateMaxSalary() {
        double total = calculateMaxBaseSalary();

        total += sales * getValues().getSalesPercentage();

        return total;
    }

    /**
     * Retorna a informação de um comercial em formato de cadeia de caracteres
     *
     * @return Informação de um comercial
     */
    @Override
    public String toString() {
        String output = super.toString();

        output += "\nVendas Realizadas: " + sales;

        return output;
    }
}
