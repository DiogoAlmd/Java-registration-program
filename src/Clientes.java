/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

public class Clientes {
    
    private String nome;
    private String email;
    private String documento;//retirar doc
    
    public Clientes (String nome, String email, String documento){
        this.nome = nome;
        this.email = email;
        this.documento = documento;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
}
