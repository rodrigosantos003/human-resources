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

    public Salesman(String name, int code, Date entryDate) {
        super(name, code, entryDate, "Comercial");
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
}
