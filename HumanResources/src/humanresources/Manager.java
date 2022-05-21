/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Gestor
 *
 * @author João Fernandes
 * @author Rodrigo Santos
 */
public class Manager extends Employee {

    private double bonus;

    /**
     * Construtor da classe Manager
     *
     * @param name Nome do empregado
     * @param code Código do empregado
     * @param entryDate Data de entrada na empresa
     * @param values Valores fixados pela empresa
     */
    public Manager(String name, int code, Date entryDate, Values values) {
        super(name, code, entryDate, EmployeeCategory.MANAGER, values);
        this.bonus = 0.15;
    }

    /**
     * Método seletor do atributo bonus
     *
     * @return Valor do atributo bonus
     */
    public double getBonus() {
        return this.bonus;
    }

    /**
     * Calcula o salário de um gestor
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateSalary() {
        double total = calculateBaseSalary();

        total += total * bonus;

        return total;
    }

    /**
     * Calcula o salário máximo de um gestor
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateMaxSalary() {
        double total = calculateMaxBaseSalary();

        total += total * bonus;

        return total;
    }
}
