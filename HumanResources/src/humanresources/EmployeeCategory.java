/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package humanresources;

/**
 *
 * @author Rodrigo Santos
 */
public enum EmployeeCategory {
    MANAGER, DRIVER, SALESMAN, NORMAL;
    
    @Override
    public String toString(){
        if(this == MANAGER){
            return "Gestor";
        } else if(this == DRIVER){
            return "Motorista";
        } else if(this == SALESMAN){
            return "Comercial";
        } else if(this == NORMAL){
            return "Normal";
        }
        
        return "";
    }
}
