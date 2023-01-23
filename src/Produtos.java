/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.NumberFormat;

public class Produtos {
    
    private String nome;
    private double preco;
    private String Descricao;
    private Fornecedor fornecedor;

    public Produtos(String nome, double preco, String Descricao, Fornecedor fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.Descricao = Descricao;
        this.fornecedor = fornecedor;
    }
    
    public Produtos (){
    }
    
    public void copiaProduto (Produtos produto){
        //poupa tempo
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.Descricao = produto.getDescricao();
        this.fornecedor = produto.getFornecedor();
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return Descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void imprimeDados (){
        //formato de certo
        NumberFormat formatter = NumberFormat.getCurrencyInstance(); 
        System.out.println("Nome do Produto: " + this.nome);
        System.out.println("Preço do Produto: " + formatter.format(this.preco));
        System.out.println("Descrição do Produto: " + this.Descricao);
        System.out.println("Fornecedor do Produto: " + this.fornecedor.getNome());
    }    
}
