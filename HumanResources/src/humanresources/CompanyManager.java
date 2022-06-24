/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresources;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Santos
 */
public class CompanyManager {
    
    private ArrayList<Company> companies;
    private Company selectedCompany;

    /**
     * Construtor da classe CompanyManager
     */
    public CompanyManager() {
        this.companies = new ArrayList<>();
        this.selectedCompany = null;
    }
    
    /**
     * Método seletor do atributo companies
     * @return Valor do atributo companies
     */
    public ArrayList<Company> getCompaniesList(){
        return this.companies;
    }

    /**
     * Método para apresentar a lista de empresas
     * @return Verdadeiro se existirem empresas na lista, Falso caso contrário
     */
    public boolean showCompanies() {
        if (this.companies.isEmpty()) {
            return false;
        } else {
            System.out.println("\nLista de Empresas: \n");
            for (Company company : this.companies) {
                System.out.println(company + "\n");
            }
            return true;
        }
    }

    /**
     * Retorna uma empresa da lista, dado o seu nome
     * @param companyName Nome da empresa a retornar
     * @return Empresa pretendida
     */
    public Company getCompany(String companyName) {
        if (this.companies.isEmpty()) {
            return null;
        } else {
            for (Company company : companies) {
                if (company.getName().equals(companyName)) {
                    return company;
                }
            }
        }
        return null;
    }
    
    /**
     * Método seletor do atributo selectedCompany
     * @return Valor do atributo selectedCompany
     */
    public Company getSelectedCompany(){
        return this.selectedCompany;
    }
    
    /**
     * Método modificador do atributo selectedCompany
     * @param company Novo valor do atributo selectedCompany
     */
    public void setSelectedCompany(Company company){
        if(company != null){
            this.selectedCompany = company;
        }
    }
}
