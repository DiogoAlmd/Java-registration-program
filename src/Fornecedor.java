/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Fornecedor {
    
    private String nome;
    private String CNPJ;

    public Fornecedor(String nome, String CNPJ) {
        this.nome = nome;
        this.CNPJ = CNPJ;
    }
    
    public Fornecedor() {}
    
    
    public void copiaFornecedor (Fornecedor copia){
        this.CNPJ = copia.getCNPJ();
        this.nome = copia.getNome();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    
     public void imprimeDados() {
        System.out.println("Nome do Fornecedor: " + this.nome);
        System.out.println("CNPJ do Fornecedor: " + this.CNPJ);
    }
    
}
