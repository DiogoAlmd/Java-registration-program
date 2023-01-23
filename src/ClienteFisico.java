/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ClienteFisico extends Clientes {
    
    private int maxParcelas;
    
    //contrutor que junta o cliente e o cliente fisico
    public ClienteFisico(String nome, String email, String documento, int parcelas) {
        super(nome, email, documento);
        this.maxParcelas = parcelas;
    }
    
    public int getMaxParcelas() {
        return maxParcelas;
    }

    public void setMaxParcelas(int maxParcelas) {
        this.maxParcelas = maxParcelas;
    }
    
    
    public void imprimeDados (){
        //não esquecer super ao mexer com os atributos da classe mãe cliente
        System.out.println("Nome do Cliente: " + super.getNome());
        System.out.println("Email do Cliente: " + super.getEmail());
        System.out.println("CPF do Cliente: " + super.getDocumento());
        System.out.println("Máximo de Parcelas Permitidas: " + this.maxParcelas);
    }
}
