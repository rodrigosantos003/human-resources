/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author Rodrigo Santos
 * @lastmod 2022-05-06
 */
public class Employee {

    private String name;
    private int code;
    private Date entryDate;
    private int[] workedDays;
    private String category;

    public Employee(String name, int code, Date entryDate, String category) {
        if (validateEmployeeData(name, code, entryDate, category)) {
            this.name = name;
            this.code = code;
            this.entryDate = entryDate;
            this.category = category;
        } else {
            this.name = "UNKNOWN";
            this.code = 5000;
            this.category = "Normal";
        }

        this.workedDays = new int[12];
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public Date getEntryDate() {
        return entryDate;
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

    /**
     * Calcula a antiguidade de um empregado na empresa
     *
     * @return Antiguidade na empresa
     */
    public int seniority() {
        LocalDate localEntryDate = LocalDate.of(entryDate.getYear(), entryDate.getMonth(), entryDate.getDay());
        return Period.between(localEntryDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Código: " + code + "\n"
                + "Nome: " + name + "\n"
                + "Categoria: " + category + "\n"
                + "Data Entrada: " + entryDate.toString() + "\n";
    }

    /*
      Validação de dados
     */
    private boolean validateEmployeeData(String name, int code, Date entryDate, String category) {
        if (name.isBlank()) {
            return false;
        }
        if (code <= 0) {
            return false;
        }
        if (entryDate == null) {
            return false;
        }

        return validateCategory(category);
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
}
