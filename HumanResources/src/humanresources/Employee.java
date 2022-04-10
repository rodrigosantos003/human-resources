/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.time.LocalDate;

/**
 *
 * @author Rodrigo Santos
 */
public class Employee {

    private String name;
    private int code;
    private Date entryDate;
    private int[] workedDays;
    private String category;

    public Employee(String name, int code, Date entryDate, String category) {
        if (!name.equals("") && code > 0 && entryDate != null && !category.equals("")) {
            this.name = name;
            this.code = code;
            this.entryDate = entryDate;
            workedDays = new int[12];

            if (validateCategory(category)) {
                this.category = category;
            } else {
                this.category = "Normal";
            }
        } else {
            System.out.println("ERRO: Dados inválidos!");
        }
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getEntryDate() {
        return entryDate.toString();
    }

    public int getWorkedDays() {
        int month = LocalDate.now().getMonthValue() - 1;

        return workedDays[month];
    }

    public String getCategory() {
        return category;
    }

    public void setWorkedDays(int month, int days) {
        workedDays[month] = days;
    }

    private boolean validateCategory(String category) {
        switch (category.toUpperCase()) {
            case "GESTOR":
                return true;
            case "MOTORISTA":
                return true;
            case "COMERCIAL":
                return true;
            case "NORMAL":
                return true;
            default:
                break;
        }

        return false;
    }

    public void showInformation() {
        System.out.println("Nome: " + name);
        System.out.println("Código: " + code);
        System.out.println("Data de Entrada: " + entryDate);
        System.out.println("Categoria: " + category);
    }
}
