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
        CompanyManager companyManager = new CompanyManager();
        ArrayList<Company> companies = companyManager.getCompaniesList();

        InputReader input = new InputReader();

        int option = 0;
        int secOption = 0;

        do {
            System.out.println("\n*** Gestão de Recursos Humanos ***");
            System.out.println("1. Ver Lista de Empresas");
            System.out.println("2. Adicionar uma Empresa");
            System.out.println("3. Remover uma Empresa");
            System.out.println("4. Editar uma Empresa");
            System.out.println("0. Sair do Programa");

            option = input.getIntegerNumber("Escolha uma opção");

            switch (option) {
                case 1 -> {
                    if (!companyManager.showCompanies()) {
                        System.out.println("\nNão existem empresas dentro da lista.");
                    }
                    break;
                }

                case 2 -> {
                    String nomeEmpresa = input.getText("\nEscolha um nome para a empresa");

                    if (companyManager.getCompany(nomeEmpresa) == null) {
                        companies.add(new Company(nomeEmpresa));
                        System.out.println("A empresa " + nomeEmpresa + " foi adicionada com sucesso!");
                    } else {
                        System.out.println("Nome já utilizado!");
                    }
                    break;
                }

                case 3 -> {
                    if (companyManager.showCompanies()) {
                        String nomeEmpresa = input.getText("Empresa que pretende remover");
                        companyManager.setSelectedCompany(companyManager.getCompany(nomeEmpresa));
                        System.out.println(companyManager.getSelectedCompany().getName());
                        if (companyManager.getSelectedCompany() != null) {
                            companies.remove(companyManager.getSelectedCompany());
                            System.out.println("A empresa " + nomeEmpresa + " foi removida com sucesso!");
                        } else {
                            System.out.println("Empresa não encontrada");
                        }
                    } else {
                        System.out.println("\nNão existem empresas dentro da lista.");
                    }
                    break;
                }

                case 4 -> {
                    if (companyManager.showCompanies()) {
                        String nomeEmpresa = input.getText("\nEmpresa que pretende editar");
                        companyManager.setSelectedCompany(companyManager.getCompany(nomeEmpresa));
                        Company selectedCompany = companyManager.getSelectedCompany();
                        if (selectedCompany != null) {
                            //<editor-fold desc="Menu de gestão de uma empresa">
                            do {
                                System.out.println("\n*** Gestão de Recursos Humanos ***");
                                System.out.println(selectedCompany + "\n");
                                System.out.println("1. Adicionar Empregado");
                                System.out.println("2. Pesquisar Empregado");
                                System.out.println("3. Carregar Lista de Empregados");
                                System.out.println("4. Número de Empregados de uma Categoria");
                                System.out.println("5. Consultar Fichas de Empregados");
                                System.out.println("6. Consultar Fichas de Empregados, filtrados por categoria");
                                System.out.println("7. Total de Salários a Pagar");
                                System.out.println("8. Custos Trimestrais, Semestrais e Anuais com Salários");
                                System.out.println("9. Guardar Lista de Empregados");
                                System.out.println("10. Alterar Informações da Empresa");
                                System.out.println("11. Incrementar Dias Trabalhados");
                                System.out.println("0. Voltar ao menu");

                                secOption = input.getIntegerNumber("Escolha uma opção");

                                switch (secOption) {
                                    case 1 ->
                                        selectedCompany.addEmployee();

                                    case 2 -> {
                                        int code = input.getIntegerNumber("Código do Empregado");
                                        selectedCompany.employeeRecord(code);
                                    }

                                    case 3 -> {
                                        try {
                                            ArrayList<Employee> employees = selectedCompany.getEmployeesFromFile();
                                            selectedCompany.addMultipleEmployees(employees);
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

                                        System.out.println("Nº de Empregados na Categoria: " + selectedCompany.totalEmployeesInCategory(employeeCategory));
                                    }

                                    case 5 ->
                                        selectedCompany.employeeRecords();

                                    case 6 ->
                                        selectedCompany.employeeRecordsByCategory();

                                    case 7 ->
                                        selectedCompany.totalInSalaries();

                                    case 8 ->
                                        selectedCompany.showCosts();

                                    case 9 ->
                                        selectedCompany.writeEmployeesToFile();

                                    case 10 -> {
                                        String changeName = input.getText("Alterar nome da empresa (S/N)");

                                        if (changeName.toUpperCase().equals("S")) {
                                            selectedCompany.setName(input.getText("Novo nome"));
                                        } else if (!changeName.toUpperCase().equals("N")) {
                                            System.out.println("Resposta inválidada!");
                                        }

                                        String changeValues = input.getText("Alterar valores fixados (S/N)");
                                        if (changeValues.toUpperCase().equals("S")) {
                                            double workdayValue = input.getRealNumber("Valor por dia de trabalho");
                                            double kilometerValue = input.getRealNumber("Valor por quilómetro");
                                            double salesPercentage = input.getRealNumber("Percentagem de vendas");
                                            selectedCompany.changeCompanyValues(workdayValue, kilometerValue, salesPercentage);
                                        } else if (!changeName.toUpperCase().equals("N")) {
                                            System.out.println("Resposta inválidada!");
                                        }
                                    }
                                    case 11 -> {
                                        String incrementAll = input.getText("Incrementar dias de trabalho a todos os empregados (S/N)");
                                        if (incrementAll.toUpperCase().equals("S")) {
                                            selectedCompany.increaseWorkedDays();
                                        } else if (incrementAll.toUpperCase().equals("N")) {
                                            int employeeCode = input.getIntegerNumber("Código do empregado a incrementar dias");
                                            Employee employeeToIncrement = selectedCompany.getEmployee(employeeCode);
                                            if (employeeToIncrement != null) {
                                                int month = input.getIntegerNumber("Mês a incrementar");
                                                int days = input.getIntegerNumber("Número de dias trabalhados");
                                                if (month - 1 >= 0 && month - 1 <= 11) {
                                                    if (days > 0 && days <= 22) {
                                                        employeeToIncrement.setWorkedDays(month, days);
                                                        System.out.println("Dias incrementados com sucesso!");
                                                    } else System.out.println("Número de dias inválido");
                                                } else System.out.println("Mês inválido");
                                            }
                                        }
                                    }
                                    case 0 -> {
                                        System.out.println("Regressando ao menu...\n\n");
                                        break;
                                    }
                                    default -> {
                                        System.out.println("Opção inválida!");
                                        break;
                                    }
                                }
                            } while (secOption != 0);
                        } //</editor-fold>}
                        else {
                            System.out.println("Empresa não encontrada");
                        }
                    } else {
                        System.out.println("\nNão existem empresas dentro da lista.");
                    }
                    break;
                }

                case 0 -> {
                    System.out.println("Obrigado por usar o nosso programa!");
                    break;
                }
                default -> {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (option != 0);
    }
}
