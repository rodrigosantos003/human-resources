/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Estrutura com capacidade de armazenar o estado de uma entidade Empresa
 *
 * @author João Fernandes
 * @author Rodrigo Santos
 */
public class Company {

    private String name;
    private ArrayList<Employee> employees;
    private Values values;

    /**
     * Construtor da classe Company
     *
     * @param name Nome da empresa
     */
    public Company(String name) {
        if (validateCompanyName(name)) {
            this.name = name;
            this.employees = new ArrayList<>();
            this.values = new Values(68.18, 3.25, 0.2, 22);
        } else {
            throw new IllegalArgumentException("Nome da empresa em branco");
        }
    }

    /* Validação de dados*/
    private boolean validateCompanyName(String name) {
        return !name.isBlank();
    }

    /**
     * Método seletor do atributo name
     *
     * @return Valor do atributo name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método modificador do atributo name
     *
     * @param name Novo valor a tribuir
     */
    public void setName(String name) {
        try {
            if (!name.isBlank()) {
                this.name = name;
            } else {
                throw new IllegalArgumentException("O nome introduzido está em branco");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Nome não alterado: " + e.getMessage());
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
        values.setWorkDayValue(workdayValue);
        values.setKilometerValue(kilometerValue);
        values.setSalesPercentage(salesPercentage);
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
        String employeeName;
        String category;
        Date entryDate;
        Employee newEmployee;

        //leitura do nome
        employeeName = input.getText("Nome");

        //leitura da categoria
        category = input.getText("Categoria");

        //atribuição do código
        code = getTotalEmployees() + 1;

        //incrementar o código enquanto existir um empregado com empregado com o mesmo
        while (getIndexOfEmployee(code) != -1) {
            code++;
        }

        //atribuição da data de entrada
        entryDate = new Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());

        switch (category.toUpperCase()) {
            case "GESTOR" -> {
                try {
                    newEmployee = new Manager(employeeName, code, entryDate, this.values);
                    employees.add(newEmployee);
                    System.out.println("Empregado adicionado com sucesso!");
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro: " + e.getMessage());
                }
            }
            case "MOTORISTA" -> {
                try {
                    newEmployee = new Driver(employeeName, code, entryDate, this.values);
                    employees.add(newEmployee);
                    System.out.println("Empregado adicionado com sucesso!");
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro: " + e.getMessage());
                }
            }
            case "COMERCIAL" -> {
                try {
                    newEmployee = new Salesman(employeeName, code, entryDate, this.values);
                    employees.add(newEmployee);
                    System.out.println("Empregado adicionado com sucesso!");
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro: " + e.getMessage());
                }
            }
            default -> {
                try {
                    newEmployee = new NormalEmployee(employeeName, code, entryDate, this.values);
                    employees.add(newEmployee);
                    System.out.println("Empregado adicionado com sucesso!");
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Adicona todos os empregados de uma lista
     *
     * @param employees Lista de empregados a adicionar
     */
    public void addMultipleEmployees(ArrayList<Employee> employees) {
        ArrayList<Employee> employeesToAdd = new ArrayList<>();
        
        //Adicionar empregados que não existem
        for(Employee employee : employees){
            if(getIndexOfEmployee(employee.getCode()) == -1){
                employeesToAdd.add(employee);
            }
        }
        
        try {
            if (employees != null) {
                this.employees.addAll(employeesToAdd);
                System.out.println("Lista carregada com sucesso com sucesso!");
            } else {
                throw new IllegalArgumentException("Lista inexistente");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lista não carregada: " + e.getMessage());
        }
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

    /**
     * Devolve o índice de um empregado com um determinado código, se existir
     *
     * @param code Código do empregado
     * @return Índice do empregado na ArrayList (caso exista) ou -1 (caso não
     * exista)
     */
    private int getIndexOfEmployee(int code) {
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
     * @return Empregado obtido
     */
    public Employee getEmployee(int code) {
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
    private void employeeRecords(EmployeeCategory category) {
        for (Employee employee : employees) {
            if (employee.getCategory() == category) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Obtém as fichas dos empregados, filtrados por categoria
     */
    public void employeeRecordsByCategory() {
        System.out.println("GESTORES (" + totalEmployeesInCategory(EmployeeCategory.MANAGER) + "): ");
        employeeRecords(EmployeeCategory.MANAGER);
        System.out.println("");

        System.out.println("MOTORISTAS (" + totalEmployeesInCategory(EmployeeCategory.DRIVER) + "): ");
        employeeRecords(EmployeeCategory.DRIVER);
        System.out.println("");

        System.out.println("COMERCIAIS (" + totalEmployeesInCategory(EmployeeCategory.SALESMAN) + "): ");
        employeeRecords(EmployeeCategory.SALESMAN);
        System.out.println("");

        System.out.println("EMPREGADOS NORMAIS (" + totalEmployeesInCategory(EmployeeCategory.NORMAL) + "): ");
        employeeRecords(EmployeeCategory.NORMAL);
        System.out.println("");
    }

    /**
     * Devolve o número total de empregados de uma dada categoria
     *
     * @param category Categoria de empregados
     * @return Número total de empregados da categoria
     */
    public int totalEmployeesInCategory(EmployeeCategory category) {
        int total = 0;
        for (Employee employee : employees) {
            if (employee.getCategory() == category) {
                total++;
            }
        }

        return total;
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

    /**
     * Calcula os custos com salários num dado intervalo de tempo
     *
     * @param startingMonth Mês do início do cálculo
     * @param finalMonth Mês do fim do cálculo
     * @return Valor total de custos
     */
    private double calculateCosts(int startingMonth, int finalMonth) {
        double total = 0.0;
        for (Employee employee : this.employees) {
            total += employee.calculateMultipleSalaries(startingMonth, finalMonth);
        }
        return total;
    }

    /**
     * Mostra os custos trimestrais, semestrais e anuais com salários
     */
    public void showCosts() {
        double cost;

        System.out.println("*** CUSTOS TRIMESTRAIS ***");

        System.out.print("Primeiro trimestre: ");
        cost = calculateCosts(0, 2);
        System.out.println(String.format("%,.2f", cost) + " €");

        System.out.print("Segundo trimestre: ");
        cost = calculateCosts(3, 5);
        System.out.println(String.format("%,.2f", cost) + " €");

        System.out.print("Terceiro trimestre: ");
        cost = calculateCosts(6, 8);
        System.out.println(String.format("%,.2f", cost) + " €");

        System.out.print("Quarto trimestre: ");
        cost = calculateCosts(9, 11);
        System.out.println(String.format("%,.2f", cost) + " €");

        System.out.println("\n\n*** CUSTOS SEMESTRAIS ***");

        System.out.print("Primeiro semestre: ");
        cost = calculateCosts(0, 5);
        System.out.println(String.format("%,.2f", cost) + " €");

        System.out.print("Segundo semestre: ");
        cost = calculateCosts(6, 11);
        System.out.println(String.format("%,.2f", cost) + " €");

        System.out.print("\n\n*** CUSTO ANUAL:");
        cost = calculateCosts(0, 11);
        System.out.println(String.format("%,.2f", cost) + " €");
    }

    /**
     * Escreve no ficheiro de empregados
     */
    public void writeEmployeesToFile() {
        try {
            FileWriter fileWriter = new FileWriter("employees.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            for (Employee employee : employees) {
                printWriter.println(employee.toString());
                printWriter.println("");
            }

            printWriter.flush();
            printWriter.close();

            System.out.println("Escrita no ficheiro realizada com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    /**
     * Carrega os empregados do ficheiro de texto
     *
     * @return Lista de empregados do ficheiro
     * @throws FileNotFoundException FileNotFoundException
     * @throws IOException IOException
     */
    public ArrayList<Employee> getEmployeesFromFile() throws FileNotFoundException, IOException {
        ArrayList<Employee> newEmployees = new ArrayList<>();

        File file = new File("employees.txt");
        
        if(!file.exists()){
            throw new FileNotFoundException("File not found");
        }
        
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String readCode;
        readCode = reader.readLine();
        while (readCode != null) {
            //Leitura das linhas do ficheiro
            String readName = reader.readLine();
            String readCategory = reader.readLine();
            String readDate = reader.readLine();
            reader.readLine();

            //Separação das strings
            String[] codeSplit = readCode.split(": ", 2);
            String[] nameSplit = readName.split(": ", 2);
            String[] categorySplit = readCategory.split(": ", 2);
            String[] dateSplit = readDate.split(": ", 2);
            String[] separatedDate = dateSplit[1].split("/", 3);

            //Extração dos dados pretendidos das strings
            int employeeCode = Integer.parseInt(codeSplit[1]);
            String employeeName = nameSplit[1];
            String employeeCategory = categorySplit[1];
            int entryDay = Integer.parseInt(separatedDate[0]);
            int entryMonth = Integer.parseInt(separatedDate[1]);
            int entryYear = Integer.parseInt(separatedDate[2]);
            Date employeeEntryDate = new Date(entryDay, entryMonth, entryYear);

            Employee employee = null;

            switch (employeeCategory.toUpperCase()) {
                case "GESTOR" -> {
                    try {
                        employee = new Manager(employeeName, employeeCode, employeeEntryDate, this.values);
                        employees.add(employee);
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro: " + e.getMessage());
                    }
                }
                case "MOTORISTA" -> {
                    try {
                        employee = new Driver(employeeName, employeeCode, employeeEntryDate, this.values);
                        employees.add(employee);
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro: " + e.getMessage());
                    }
                }
                case "COMERCIAL" -> {
                    try {
                        employee = new Salesman(employeeName, employeeCode, employeeEntryDate, this.values);
                        employees.add(employee);
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro: " + e.getMessage());
                    }
                }
                default -> {
                    try {
                        employee = new NormalEmployee(employeeName, employeeCode, employeeEntryDate, this.values);
                        employees.add(employee);
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro: " + e.getMessage());
                    }
                }
            }

            newEmployees.add(employee);
            readCode = reader.readLine();
        }

        reader.close();
        
        System.out.println("Empregados carregados com sucesso!");
        
        return newEmployees;
    }

    /**
     * Retorna a informação da empresa em formato de cadeia de caracteres
     *
     * @return Informação da empresa
     */
    @Override
    public String toString() {
        String output = "";

        output += "Empresa: " + this.name;
        output += "\nTotal de Empregados: " + getTotalEmployees();

        return output;
    }
}
