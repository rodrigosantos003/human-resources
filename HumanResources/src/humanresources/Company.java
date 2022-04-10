/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;

/**
 *
 * @author Rodrigo Santos
 */
public class Company {

    private ArrayList<Employee> employees;
    private CompanyValues values;

    public Company() {
        employees = new ArrayList<>();
        values = new CompanyValues();
    }

    //devolve o total de empregados da empresa
    public int getTotalEmployees() {
        return employees.size();
    }

    //devolve o índice de um empregado com um determinado código, se existir
    public int getIndexOfEmployee(int code) {
        for (Employee employee : employees) {
            if (employee.getCode() == code) {
                return employees.indexOf(employee);
            }
        }

        return -1;
    }

    //adiciona uma ficha de empregado
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int code = 0;
        String name;
        Date entryDate;
        Employee newEmployee;

        System.out.print("Nome> ");
        name = scanner.nextLine();

        do {
            int totalEmployees = getTotalEmployees();
            if (totalEmployees != 0) {
                code = random.nextInt(totalEmployees) + 1;
            } else {
                code = 1;
            }
        } while (getIndexOfEmployee(code) != -1);

        entryDate = new Date(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());

        System.out.print("Categoria> ");
        String category = scanner.nextLine();

        newEmployee = new Employee(name, code, entryDate, category);
        employees.add(newEmployee);
    }

    //obtém a ficha de um empregado, através do seu código
    public void employeeRecord(int code) {
        int index = getIndexOfEmployee(code);
        if (index != -1) {
            employees.get(index);
        } else {
            System.out.println("O empregado não existe");
        }
    }

    //obtém as fichas de todos os empregados
    public void employeeRecords() {
        for (Employee employee : employees) {
            employee.showInformation();
        }
    }

    //obtém as fichas de todos os empregados de uma determinada categoria
    public void employeeRecords(String category) {
        for (Employee employee : employees) {
            if (employee.getCategory().equals(category)) {
                employee.showInformation();
            }
        }
    }

    //altera os valores fixados pela empresa
    public void changeCompanyValues(double workDayValue, double kilometerValue, double salesPercentage) {
        values.setWorkDayValue(workDayValue);
        values.setKilometerValue(kilometerValue);
        values.setSalesPercentage(salesPercentage);
    }

    //calcula o salário de um empregado
    public double employeeSalary(int employeeCode) {
        int index = getIndexOfEmployee(employeeCode);
        Employee employee = employees.get(index);
        double total = 0;
        Scanner scanner = new Scanner(System.in);

        total += values.getWorkDayValue() * employee.getWorkedDays();
        total += values.getSeniorityAward() * (LocalDate.now().getYear() - employee.getEntryDate().getYear());
        total += values.getFoodAllowance() * employee.getWorkedDays();

        switch (employee.getCategory().toUpperCase()) {
            case "GESTOR":
                total += total * 0.15;
            case "MOTORISTA":
                System.out.print("Quilómetros Percorridos> ");
                double kilometers = scanner.nextDouble();
                total += values.getKilometerValue() * kilometers;
            case "COMERCIAL":
                System.out.print("Vendas Realizadas> ");
                int sales = scanner.nextInt();
                total += values.getSalesPercentage() * sales;
        }

        return total;
    }
}
