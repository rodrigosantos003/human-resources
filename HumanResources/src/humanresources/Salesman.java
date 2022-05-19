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
public class Salesman extends Employee {

    private int sales;

    public Salesman(String name, int code, Date entryDate, Values values) {
        super(name, code, entryDate, "Comercial", values);
        this.sales = 0;
    }

    public int getSales() {
        return this.sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return super.toString() + "Vendas Realizadas: " + sales + "\n";
    }
    
    @Override
    public double calculateSalary() {
        double total = calculateBaseSalary();
        
        total += sales * getValues().getSalesPercentage();
        
        return total;
    }
    
    @Override
    public double calculateSalary(int month) {
        double total = calculateBaseSalary(month);
        
        total += sales * getValues().getSalesPercentage();
        
        return total;
    }
}
