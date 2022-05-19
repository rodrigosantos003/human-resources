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
 * @lastmod 2022-05-06
 */
public class Company {

    private String name;
    private ArrayList<Employee> employees;
    private Values values;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.values = new Values(68.18, 3.25, 0.2, 22);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        }
    }

    /**
     * Altera os valores fixados pela empresa
     *
     * @param workdayValue valor por dia de trabalho
     * @param kilometerValue valor por quilómetro percorrido
     * @param salesPercentage valor da percentagem das vendas realizadas
     */
    public void changeCompanyValues(double workdayValue, double kilometerValue, double salesPercentage) {
        if (workdayValue > 0 && kilometerValue > 0 && salesPercentage > 0) {
            values.setWorkDayValue(workdayValue);
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

        switch (category.toUpperCase()) {
            case "GESTOR":
                newEmployee = new Manager(name, code, entryDate, this.values);
                break;
            case "MOTORISTA":
                newEmployee = new Driver(name, code, entryDate, this.values);
                break;
            case "COMERCIAL":
                newEmployee = new Salesman(name, code, entryDate, this.values);
                break;
            default:
                newEmployee = new NormalEmployee(name, code, entryDate, this.values);
                break;
        }

        employees.add(newEmployee);
    }
    
    public void addMultipleEmployees(ArrayList<Employee> employees){
        this.employees.addAll(employees);
    }

    /**
     * Devolve o índice de um empregado com um determinado código, se existir
     *
     * @param code Código do empregado
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
     * Devolve um objeto do tipo Empregado da ArrayList através do seu código
     *
     * @param code Código do empregado
     */
    private Employee getEmployee(int code) {
        int index = getIndexOfEmployee(code);
        if (index == -1) {
            System.out.println("ERRO: O empregado não existe!");
            return null;
        }

        return employees.get(index);
    }

    /**
     * Obtém a ficha de um empegado, através do seu código
     *
     * @param code Código do empregado
     */
    public void employeeRecord(int code) {
        System.out.println(getEmployee(code));
    }

    /**
     * Obtém as fichas de todos os empregados
     */
    public void employeeRecords() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * Obtém as fichas de todos os empregados de uma determinada categoria
     *
     * @param category Categoria de empregados
     */
    private void employeeRecords(String category) {
        for (Employee employee : employees) {
            if (employee.getCategory().toUpperCase().equals(category)) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Obtém as fichas dos empregados, filtrados por categoria
     */
    public void employeeRecordsByCategory() {
        System.out.println("GESTORES:");
        employeeRecords("GESTOR");
        System.out.println("");

        System.out.println("MOTORISTAS:");
        employeeRecords("MOTORISTA");
        System.out.println("");

        System.out.println("COMERCIAIS");
        employeeRecords("COMERCIAL");
        System.out.println("");
        
        System.out.println("NORMAIS");
        employeeRecords("NORMAL");
        System.out.println("");
    }

    /**
     * Devolve o total de salários a pagar
     *
     * @return Valor total de salários
     */
    public double totalInSalaries() {
        double total = 0.0;
        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }

        return total;
    }

    public void showCosts(){
        double cost = 0.0;
        System.out.println("*** CUSTOS TRIMESTRAIS ***");
        
        System.out.print("Primeiro trimestre: ");
        cost = calculateCosts(0,2);
        System.out.println(" " + cost);
        
        System.out.print("Segundo trimestre: ");
        cost = calculateCosts(3,5);
        System.out.println(" " + cost);
        
        System.out.print("Terceiro trimestre: ");
        cost = calculateCosts(6,8);
        System.out.println(" " + cost);
        
        System.out.print("Quarto trimestre: ");
        cost = calculateCosts(9,11);
        System.out.println(" " + cost);
        
        
        System.out.println("\n\n*** CUSTOS SEMESTRAIS ***");
        
        System.out.print("Primeiro semestre: ");
        cost = calculateCosts(0,5);
        System.out.println(" " + cost);
        
        System.out.print("Segundo semestre: ");
        cost = calculateCosts(6,11);
        System.out.println(" " + cost);
        
        
        System.out.print("\n\n*** CUSTO ANUAL:");
        cost = calculateCosts(0,11);
        System.out.println(" " + cost);
    }
    
    
    private double calculateCosts(int startingMonth, int finalMonth){
        double total = 0.0;
        for(Employee employee : this.employees){
            total += employee.calculateMultipleSalaries(startingMonth, finalMonth);
        }
        return total;
    }
    /**
     * Devolve o número total de empregados de uma dada categoria
     *
     * @param category Categoria de empregados
     * @return Número total de empregados da categoria
     */
    public int totalEmployeesInCategory(String category) {
        int total = 0;
        for (Employee employee : employees) {
            if (employee.getCategory().toUpperCase().equals(category)) {
                total++;
            }
        }

        return total;
    }

    /**
     * Incrementa o número de dias trabalhados dos empregados
     */
    public void increaseWorkedDays() {
        int month = LocalDate.now().getMonthValue() - 1;
        for (Employee employee : employees) {
            employee.setWorkedDays(month, employee.getWorkedDays() + 1);
        }
    }

    @Override
    public String toString() {
        return "Empresa: " + getName() + "\n"
                + "Total de empregados: " + getTotalEmployees() + "\n";
    }
}
