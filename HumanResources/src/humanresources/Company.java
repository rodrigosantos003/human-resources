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
    private double workDayValue;
    
    public Company(){
        employees = new ArrayList<>();
        workDayValue = 32.48;
    }
    
    public Company(double workDayValue){
        employees = new ArrayList<>();
        if(workDayValue > 0){
            this.workDayValue = workDayValue;
        }
    }
    
    //devolve o total de empregados da empresa
    public int getTotalEmployees(){
        return employees.size();
    }
    
    //devolve o índice de um empregado com um determinado código, se existir
    public int getIndexOfEmployee(int code){
        for(Employee employee : employees){
            if(employee.getCode() == code){
                return employees.indexOf(employee);
            }
        }
        
        return -1;
    }
    
    //adiciona uma ficha de empregado
    public void addEmployee(){  
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int code = 0;
        String name;
        Date entryDate;
        Employee newEmployee;
        
        name = scanner.nextLine();
        do{
            code = random.nextInt(getTotalEmployees()) + 1;
        }while(getIndexOfEmployee(code) != -1);
        entryDate = new Date(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        String category = scanner.nextLine();
        
        newEmployee = new Employee(name, code, entryDate, category);
        employees.add(newEmployee);
    }
    
   //obtém a ficha de um empregado, através do seu código
    public void employeeRecord(int code){
        for(Employee employee : employees){
            if(employee.getCode() == code){
                System.out.println("Nome: " + employee.getName());
                System.out.println("Código: " + employee.getCode());
                System.out.println("Data de Entrada: " + employee.getEntryDate());
                System.out.println("Categoria: " + employee.getCategory());
            }
        }
    }
    
    //obtém as fichas de todos os empregados
    public void employeeRecords(){
        for(Employee empregado : employees){
            System.out.println("Nome: " + empregado.getName());
            System.out.println("Código: " + empregado.getCode());
            System.out.println("Data de Entrada: " + empregado.getEntryDate());
            System.out.println("Categoria: " + empregado.getCategory());
        }
    }
    
    //obtém as fichas de todos os empregados de uma determinada categoria
    public void employeeRecords(String category){
        for(Employee employee : employees){
            if(employee.getCategory().equals(category)){
                System.out.println("Nome: " + employee.getName());
                System.out.println("Código: " + employee.getCode());
                System.out.println("Data de Entrada: " + employee.getEntryDate());
                System.out.println("Categoria: " + employee.getCategory());
            }
        }
    }
}
