/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Pedido {
    
    private int id;
    private GregorianCalendar data;
    private double total;
    private boolean pago;
    private ArrayList <ItemPedido> itens = new ArrayList();
    Clientes cliente;

    public void setPedido(int id, GregorianCalendar data, boolean pago, Clientes cliente) {
        this.id = id;
        this.data = data;
        this.pago = pago;
        this.cliente = cliente;
    }
    
    public Pedido (){
    
    }
    
    public void calculaTotal(){
        
        for (ItemPedido item : itens) {
            this.total += item.setValorItem();
        }
    }
    
    public void addItem (ItemPedido item){
        this.itens.add(item);
    }
    
    public void removeItem (ItemPedido item){
        this.itens.remove(item);
    }
    
    public ItemPedido getItem (int indice){
        return this.itens.get(indice);
    }

    public int getId() {
        return id;
    }

    public GregorianCalendar getData() {
        return data;
    } 

    public double getTotal() {
        return total;
    }

    public boolean isPago() {
        return pago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }   
    
    public void imprimeDados (){
        
        String status;
        if (this.pago){
            status = "Pago";
        }
        else {
            status = "Em Aberto";
        }
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Id: " + this.id);
        System.out.println("Data: " + 
                this.data.get(data.DAY_OF_MONTH) + "/" + (this.data.get(data.MONTH) + 1) + "/" + this.data.get(data.YEAR));
        System.out.println("Nome do Cliente: " + this.cliente.getNome());
        System.out.println("Documento do Cliente: " + this.cliente.getDocumento());
        System.out.println("Quantidade de Itens: " + this.itens.size());
        System.out.println("Status: " + status);
        System.out.println("Total: " + formatter.format(this.total));
    }
    
    public void imprimeDadosDatelhados (){
        
        String status;
        if (this.pago){
            status = "Pago";
        }
        else {
            status = "Em Aberto";
        }
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance(); 
        System.out.println("Id: " + this.id);
        System.out.println("Data: " + 
                this.data.get(data.DAY_OF_MONTH) + "/" + (this.data.get(data.MONTH) + 1) + "/" + this.data.get(data.YEAR));
        System.out.println("Nome do Cliente: " + this.cliente.getNome());
        System.out.println("Documento do Cliente: " + this.cliente.getDocumento());
        System.out.println("Quantidade de Itens: " + this.itens.size());
        System.out.println("\n");
        
        for (ItemPedido item : itens) {
            item.imprimeDados();
        }
        
        System.out.println("\n");
        System.out.println("Status: " + status);
        System.out.println("Total: " + formatter.format(this.total));
    }
}
