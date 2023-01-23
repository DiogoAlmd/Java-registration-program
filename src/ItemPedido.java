/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.NumberFormat;

public class ItemPedido {
    
    private Produtos item;
    private int qtdItens;
    private double valorItem;

    public ItemPedido(Produtos item, int qtdItens) {
        this.item = item;
        this.qtdItens = qtdItens;
    }

    public Produtos getItem() {
        return item;
    }
    
    public double setValorItem(){
        this.valorItem = this.qtdItens * item.getPreco();
        return this.valorItem;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setItem(Produtos item) {
        this.item = item;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }
    
    public void imprimeDados(){
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance(); 
        this.item.imprimeDados();
        System.out.println("Total do Item: " +  formatter.format(this.valorItem));
    }
    
}
