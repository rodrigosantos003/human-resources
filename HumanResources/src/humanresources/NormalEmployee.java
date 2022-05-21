/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Empregado
 * Normal
 *
 * @author João Fernandes
 * @author Rodrigo Santos
 */
public class NormalEmployee extends Employee {

    /**
     * Construtor da classe NormalEmployee
     *
     * @param name Nome do empregado
     * @param code Código do empregado
     * @param entryDate Data de entrada na empresa
     * @param values Valores fixados pela empresa
     */
    public NormalEmployee(String name, int code, Date entryDate, Values values) {
        super(name, code, entryDate, EmployeeCategory.NORMAL, values);
    }

    /**
     * Calcula o salário de um empregado normal
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateSalary() {
        return calculateBaseSalary();
    }

    /**
     * Calcula o salário máximo de um empregado normal
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateMaxSalary() {
        return calculateMaxBaseSalary();
    }
}
