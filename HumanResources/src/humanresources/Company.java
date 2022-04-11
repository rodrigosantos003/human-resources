/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @authors Rodrigo Santos & João Fernnandes
 * @lastmod 2022-04-11
 */
public class Company {

    private ArrayList<Employee> employees;
    private CompanyValues values;

    public Company() {
        employees = new ArrayList<>();
        values = new CompanyValues();
    }

    /**
     * Altera os valores fixados pela empresa
     *
     * @param workDayValue valor por dia de trabalho
     * @param kilometerValue valor por quilómetro percorrido
     * @param salesPercentage valor da percentagem das vendas realizadas
     */
    public void changeCompanyValues(double workDayValue, double kilometerValue, double salesPercentage) {
        if (workDayValue > 0 && kilometerValue > 0 && salesPercentage > 0) {
            values.setWorkDayValue(workDayValue);
            values.setKilometerValue(kilometerValue);
            values.setSalesPercentage(salesPercentage);
        } else {
            System.out.println("ERRO: Dados inválidos!");
        }
    }

    /**
     * Devolve o total de empregados da empresa
     *
     * @return Tamanho da ArrayList
     */
    public int getTotalEmployees() {
        return employees.size();
    }

    /**
     * Devolve o índice de um empregado com um determinado código, se existir
     *
     * @param code código do empregado
     * @return Índice do empregado na ArrayList (caso exista) ou -1 (caso não
     * exista)
     */
    public int getIndexOfEmployee(int code) {
        for (Employee employee : employees) {
            if (employee.getCode() == code) {
                return employees.indexOf(employee);
            }
        }

        return -1;
    }

    /**
     * Adiciona uma ficha de empregado
     */
    public void addEmployee() {
        InputReader input = new InputReader();
        LocalDate localDate = LocalDate.now();

        int code;
        String name;
        String category;
        Date entryDate;
        Employee newEmployee;

        //leitura do nome
        name = input.getText("Nome");

        //leitura da categoria
        category = input.getText("Categoria");

        //atribuição do código
        code = getTotalEmployees() + 1;

        //atribuição da data de entrada
        entryDate = new Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());

        newEmployee = new Employee(name, code, entryDate, category);
        employees.add(newEmployee);
    }

    /**
     * Obtém a ficha de um empegado, através do seu código
     *
     * @param code código do empregado
     */
    public void employeeRecord(int code) {
        int index = getIndexOfEmployee(code);
        if (index != -1) {
            employees.get(index).showInformation();
        } else {
            System.out.println("ERRO: O empregado não existe!");
        }
    }

    /**
     * Obtém as fichas de todos os empregados
     */
    public void employeeRecords() {
        for (Employee employee : employees) {
            employee.showInformation();
        }
    }

    /**
     * Obtém as fichas de todos os empregados de uma determinada categoria
     *
     * @param category categoria de empregados
     */
    public void employeeRecords(String category) {
        for (Employee employee : employees) {
            if (employee.getCategory().equals(category)) {
                employee.showInformation();
            }
        }
    }

    /**
     * Incrementa o número de dias trabalhados dos empregados
     */
    public void increaseWorkedDays() {
        int month = LocalDate.now().getMonthValue();

        for (Employee employee : employees) {
            employee.setWorkedDays(month, employee.getWorkedDays() + 1);
        }
    }

    /**
     * Devolve o salário de um empregado
     *
     * @param code código do empregado
     * @return Valor final do salário
     */
    public double employeeSalary(int code) {
        int index = getIndexOfEmployee(code);
        Employee employee = employees.get(index);

        if (index != -1) {
            double total = 0;
            InputReader input = new InputReader();

            total += values.getWorkDayValue() * employee.getWorkedDays();
            total += values.getSeniorityAward() * (LocalDate.now().getYear() - employee.getEntryDate().getYear());
            total += values.getFoodAllowance() * employee.getWorkedDays();

            switch (employee.getCategory().toUpperCase()) {
                case "GESTOR":
                    total += total * 0.15;
                case "MOTORISTA":
                    double kilometers = input.getRealNumber("Quilómetros percorridos");
                    total += values.getKilometerValue() * kilometers;
                case "COMERCIAL":
                    int sales = input.getIntegerNumber("Vendas realizadas");
                    total += values.getSalesPercentage() * sales;
                default:
                    break;
            }

            return total;
        }

        return -1;
    }
}
