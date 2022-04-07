/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaorecursoshumanos;
import java.time.LocalDate;
/**
 *
 * @author Rodrigo Santos
 */
public class Empregado {
    private String nome;
    private int codigo;
    private Data dataEntrada;
    private int[] diasTrabalhados;
    private String categoria;
    
    public Empregado(String nome, int codigo, Data dataEntrada, String categoria){
        if(!nome.equals("") && codigo > 0 && dataEntrada != null && !categoria.equals("")){
            this.nome = nome;
            this.codigo = codigo;
            this.dataEntrada = dataEntrada;
            diasTrabalhados = new int[12];
            this.categoria = categoria;
        } else{
            System.out.println("ERRO: Dados inválidos!");
        }
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getDataEntrada(){
        return dataEntrada.toString();
    }
    
    public int getDiasTrabalhados(){
        int mes = LocalDate.now().getMonthValue() - 1;
        
        return diasTrabalhados[mes];
    }
    
    public String getCategoria(){
        return categoria;
    }
}
