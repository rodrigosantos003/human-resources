/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package humanresources;

/**
 * Estrutura com capacidade para armazenar uma entidade Categoria de Empregado
 *
 * @author Rodrigo Santos & João Fernandes
 */
public enum EmployeeCategory {
    MANAGER, DRIVER, SALESMAN, NORMAL;

    @Override
    public String toString() {
        if (null != this) {
            switch (this) {
                case MANAGER -> {
                    return "Gestor";
                }
                case DRIVER -> {
                    return "Motorista";
                }
                case SALESMAN -> {
                    return "Comercial";
                }
                case NORMAL -> {
                    return "Normal";
                }
            }
        }

        return "";
    }
}
