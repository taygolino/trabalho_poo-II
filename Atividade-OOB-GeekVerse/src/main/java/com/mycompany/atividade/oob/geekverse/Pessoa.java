/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade.oob.geekverse;

/**
 *
 * @author fabiano
 */
public class Pessoa extends Usuario implements Exibivel{
    private String nome;
    private String telefone;
    private String cpf;

    // Usei o Refrator para criar os getters e setters :)
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nomePessoa to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Pessoa(){
        this.nome = "";
        this.setEmail("");
        this.telefone = "";
        this.cpf = "";
    }
    
    public Pessoa(String nome, 
            String email, String telefone, String cpf){
        this.nome = nome;
        this.setEmail(email);
        this.telefone = telefone;
        this.cpf = cpf;
    }
    
    @Override
    public void exibirDados(){
        System.out.println("Dados Pessoais");
        System.out.println("Nome: "+ this.nome);
        System.out.println("Email: "+ this.getEmail());
        System.out.println("Telefone: "+ this.telefone);
        System.out.println("CPF: "+ this.cpf);
    }
}
