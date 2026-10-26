/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade.oob.geekverse;

/**
 *
 * @author fabiano
 */
public abstract class Usuario {
    private String email;
    private String senha;
    private boolean logado;
    
    public boolean autenticar(String email, String senha){
        
        this.setLogado(false);
        
        if(this.email == null || this.senha == null){System.out.println("Falha ao logar");}
        else{
            // Deixei como true enquanto penso uma forma de realizar o login
            if(this.email.equalsIgnoreCase(email) && this.senha.equals(senha)){
                this.setLogado(true);
            }else{
                System.out.println("Falha ao logar");

            }
        }
        return logado;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the logado
     */
    public boolean isLogado() {
        return logado;
    }

    /**
     * @param logado the logado to set
     */
    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
