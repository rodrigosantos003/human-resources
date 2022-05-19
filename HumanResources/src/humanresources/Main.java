/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package humanresources;

/**
 *
 * @authors Rodrigo Santos & João Fernandes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TESTS
        Company company = new Company("XPTO");
        company.addEmployee();
        //company.addEmployee();
        company.increaseWorkedDays();
        company.employeeRecordsByCategory();

        System.out.println(company);
        company.showCosts();
    }
}
