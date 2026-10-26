/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade.oob.geekverse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author fabiano
 */
public class GerenciarUsuarios {
    private List<Participante> listaParticipantes = new ArrayList<>();
    private List<Organizador> listaOrganizadores = new ArrayList<>();
    
    public void cadastrarParticipante(int codParticipante, String nome, 
            String email, String telefone, String cpf, String senha){
        
        Participante participante = new Participante(codParticipante, nome, email, telefone, cpf, senha);
        
        listaParticipantes.add(participante);
        
    }
    
    public void cadastrarOrganizador(Cargo cargo, String endereco, String nome, 
            String email, String telefone, String cpf, String senha){
        
            Organizador organizador = new Organizador(cargo,endereco, nome, email, telefone, cpf, senha);
          
            listaOrganizadores.add(organizador);
    }
    
    public GerenciarUsuarios(){
        
    }
    
    public void exibirParticipantes() {
        for(int i=0; i < listaParticipantes.size(); i++){
           System.out.println((i+1) + ". "+ this.listaParticipantes.get(i).getNome()); 
        }
    }
    
    public void exibirOrganizadores() {
        for(int i=0; i < listaOrganizadores.size(); i++){
           System.out.println((i+1) + ". "+ this.listaOrganizadores.get(i).getNome()); 
        }
    }
    
    public void pesquisaParticipante(String nome){
        boolean achado = false;
        for(int i=0; i < listaParticipantes.size(); i++){
           if(nome.equalsIgnoreCase(listaParticipantes.get(i).getNome())){
               achado = true;
               System.out.println("Participante encontrado!!");
               listaParticipantes.get(i).exibirDados();
               break;
           } 
        }
        
        if(!achado){System.out.println("Participante não encontrado!");}
    }
    
    public void cadastroEvento(String nomeOrganizador, String nomeEvento, String local, LocalDate data,
            BigDecimal preco, String descricaoEvento) {
        boolean achado = false;
        
        for(int i=0; i < listaOrganizadores.size(); i++){
            if(nomeOrganizador.equalsIgnoreCase(listaOrganizadores.get(i).getNome())){
                achado = true;
                listaOrganizadores.get(i).cadastrarEvento(nomeEvento, local, data, preco, descricaoEvento);
            }
        }
        
        if(!achado){System.out.println("Erro! Não existe Organizador com esse nome!");}
    }
    
    
    public void exibirEvento(String nomeOrganizador, String nomeEvento){
        boolean achadoOrganizador = false;
        boolean achadoEvento = false;
        
        for(int i=0; i < listaOrganizadores.size(); i++){
            if(nomeOrganizador.equalsIgnoreCase(listaOrganizadores.get(i).getNome())){
                achadoOrganizador = true;
                achadoEvento = listaOrganizadores.get(i).achouEvento(nomeEvento);
                break;
            }
        }
        
        if(!achadoOrganizador || !achadoEvento){
            System.out.println("Erro! Não existe Organizador ou Evento com esse nome!");
        }
    }
    
    public Participante buscarParticipante(String email){
        
        for(int i=0; i < listaParticipantes.size(); i++){
           if(email.equalsIgnoreCase(listaParticipantes.get(i).getEmail())){
               return listaParticipantes.get(i);
           }  
        }
        System.out.println("e-mail não cadastrado");
        return null;
    }
    
    public Organizador buscarOrganizador(String email){
        
        for(int i=0; i < listaOrganizadores.size(); i++){
           if(email.equalsIgnoreCase(listaOrganizadores.get(i).getEmail())){
               return listaOrganizadores.get(i);
           }     
        }
        
        System.out.println("e-mail não cadastrado");
        return null;
    }
    
    
    public Evento buscarEvento(String nomeOrganizador, String nomeEvento){
        
        for(int i=0; i < listaOrganizadores.size(); i++){
            if(nomeOrganizador.equalsIgnoreCase(listaOrganizadores.get(i).getNome())){
                
                Evento evento = listaOrganizadores.get(i).retornaEvento(nomeEvento);
                return evento;
            }
        }

        return null;
    }
    
    
}
