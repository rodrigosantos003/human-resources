/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Motorista
 *
 * @author João Fernandes
 * @author Rodrigo Santos
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

    /**
     * Método seletor do atributo kilometers
     *
     * @return Valor do aributo kilometers
     */
    public double getKilometers() {
        return this.kilometers;
    }

    /**
     * Método modificador do atributo kilometers
     *
     * @param kilometers Novo valor a atribuir
     */
    public void setKilometers(double kilometers) {
        try{
            if(kilometers >= 0){
                this.kilometers = kilometers;
            } else{
                throw new IllegalArgumentException("Quilómetros inválidos");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Quilómetros não alterados: " + e.getMessage());
        }
    }

    /**
     * Calcula o salário de um motorista
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateSalary() {
        double total = calculateBaseSalary();

        total += getKilometers() * getValues().getKilometerValue();

        return total;
    }

    /**
     * Calcula o salário máximo de um motorista
     *
     * @return Valor total do salário
     */
    @Override
    public double calculateMaxSalary() {
        double total = calculateMaxBaseSalary();

        total += getKilometers() * getValues().getKilometerValue();

        return total;
    }

    /**
     * Retorna a informação de um motorista em formato de cadeia de caracteres
     *
     * @return Informação de um motorista
     */
    @Override
    public String toString() {
        String output = super.toString();

        output += "\nQuilómetros Percorridos: " + kilometers;

        return output;
    }
}
