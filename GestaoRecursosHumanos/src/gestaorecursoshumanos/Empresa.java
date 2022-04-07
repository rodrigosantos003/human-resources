/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaorecursoshumanos;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Santos
 */
public class Empresa {
    private ArrayList<Empregado> empregados;
    
    public Empresa(){
        empregados = new ArrayList<>();
    }
    
    //devolve o total de empregados da empresa
    public int getTotalEmpregados(){
        return empregados.size();
    }
    
    //adiciona uma ficha de empregado
    public void adicionarEmpregado(Empregado empregado){
        empregados.add(empregado);
    }
    
   //obtém a ficha de um empregado, através do seu código
    public void fichaEmpregado(int codigo){
        for(Empregado empregado : empregados){
            if(empregado.getCodigo() == codigo){
                System.out.println("Nome: " + empregado.getNome());
                System.out.println("Código: " + empregado.getCodigo());
                System.out.println("Data de Entrada: " + empregado.getDataEntrada());
                System.out.println("Categoria: " + empregado.getCategoria());
            }
        }
    }
    
    //obtém as fichas de todos os empregados
    public void fichaEmpregados(){
        for(Empregado empregado : empregados){
            System.out.println("Nome: " + empregado.getNome());
            System.out.println("Código: " + empregado.getCodigo());
            System.out.println("Data de Entrada: " + empregado.getDataEntrada());
            System.out.println("Categoria: " + empregado.getCategoria());
        }
    }
    
    //obtém as fichas de todos os empregados de uma determinada categoria
    public void fichaEmpregados(String categoria){
        for(Empregado empregado : empregados){
            if(empregado.getCategoria().equals(categoria)){
                System.out.println("Nome: " + empregado.getNome());
                System.out.println("Código: " + empregado.getCodigo());
                System.out.println("Data de Entrada: " + empregado.getDataEntrada());
                System.out.println("Categoria: " + empregado.getCategoria());
            }
        }
    }
}
