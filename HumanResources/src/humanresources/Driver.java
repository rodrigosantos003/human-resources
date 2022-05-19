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
public class Driver extends Employee {

    private double kilometers;

    public Driver(String name, int code, Date entryDate, Values values) {
        super(name, code, entryDate, "Motorista", values);
        this.kilometers = 0;
    }

    public double getKilometers() {
        return this.kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public String toString() {
        return super.toString() + "Quilómetros Percorridos: " + kilometers + "\n";
    }

    @Override
    public double calculateSalary() {
        double total = calculateBaseSalary();
        
        total += getKilometers() * getValues().getKilometerValue();
        
        return total;
    }
    
    @Override
    public double calculateMaxSalary() {
        double total = calculateMaxBaseSalary();
        
        total += getKilometers() * getValues().getKilometerValue();
        
        return total;
    }
}
