/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Santos
 */
public class Company {
    private ArrayList<Employee> employees;
    
    public Company(){
        employees = new ArrayList<>();
    }
    
    //devolve o total de empregados da empresa
    public int getTotalEmployees(){
        return employees.size();
    }
    
    //adiciona uma ficha de empregado
    public void addEmployee(Employee employee){
        employees.add(employee);
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
