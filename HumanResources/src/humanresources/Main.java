/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package humanresources;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author João Fernandes
 * @author Rodrigo Santos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TESTS
        InputReader input = new InputReader();
        Company company = new Company("XPTO");
        
        int option;
        
        do {
            System.out.println("*** Gestão de Recursos Humanos ***");
            System.out.println(company + "\n");
            System.out.println("1. Adicionar Empregado");
            System.out.println("2. Pesquisar Empregado");
            System.out.println("3. Carregar Lista de Empregados");
            System.out.println("4. Número de Empregados de uma Categoria");
            System.out.println("5. Consultar Fichas de Empregados");
            System.out.println("6. Consultar Fichas de Empregados, filtrados por categoria");
            System.out.println("7. Total de Salários a Pagar");
            System.out.println("8. Custos Trimestrais, Semestrais e Anuais com Salários");
            System.out.println("9. Guardar Lista de Empregados");
            System.out.println("0. Sair do Programa");
            
            option = input.getIntegerNumber("Escolha uma opção");
            
            switch (option) {
                case 1 ->
                    company.addEmployee();
                
                case 2 -> {
                    int code = input.getIntegerNumber("Código do Empregado");
                    company.employeeRecord(code);
                }
                
                case 3 -> {
                    try {
                        ArrayList<Employee> employees = company.getEmployeesFromFile();
                        company.addMultipleEmployees(employees);
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro: " + e.getMessage());
                    }
                }
                
                case 4 -> {
                    EmployeeCategory employeeCategory;
                    String category = input.getText("Categoria");
                    
                    employeeCategory = switch (category.toUpperCase()) {
                        case "GESTOR" ->
                            EmployeeCategory.MANAGER;
                        case "MOTORISTA" ->
                            EmployeeCategory.DRIVER;
                        case "COMERCIAL" ->
                            EmployeeCategory.SALESMAN;
                        default ->
                            EmployeeCategory.NORMAL;
                    };
                    
                    System.out.println("Nº de Empregados na Categoria: " + company.totalEmployeesInCategory(employeeCategory));
                }
                
                case 5 ->
                    company.employeeRecords();
                
                case 6 ->
                    company.employeeRecordsByCategory();
                
                case 7 ->
                    company.totalInSalaries();
                
                case 8 ->
                    company.showCosts();
                
                case 9 ->
                    company.writeEmployeesToFile();
                
                case 0 ->
                    System.exit(0);
                
                default -> {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (option != 0);
    }
}
