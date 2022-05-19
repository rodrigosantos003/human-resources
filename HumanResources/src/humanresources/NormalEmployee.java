/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

/**
 *
 * @author Rodrigo Santos
 * @lastmod 2022-05-06
 */
public class NormalEmployee extends Employee {

    public NormalEmployee(String name, int code, Date entryDate, Values values) {
        super(name, code, entryDate, "Normal", values);
    }
    
    @Override
    public double calculateSalary() {
        return calculateBaseSalary();
    }
    
    @Override
    public double calculateSalary(int month) {
        return calculateBaseSalary(month);
    }
}
