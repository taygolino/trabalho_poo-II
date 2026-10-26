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
public class Organizador extends Pessoa{
   private Cargo cargo;
   private String endereco;
   
   private List<Evento> listaEventos = new ArrayList<>();

    // Feito com refractor
    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public Organizador(Cargo cargo, String endereco, String nome, 
            String email, String telefone, String cpf, String senha){
        super(nome, email, telefone, cpf);
        this.setSenha(senha);
        this.cargo = cargo;
        this.endereco = endereco;
    }
    
    public Organizador(){
        super();
        this.cargo = cargo.ORGANIZADOR;
        this.endereco = "";
    }
    
    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Cargo: "+ this.cargo);
        System.out.println("Endereço: "+ this.endereco);
    }
    
    public void cadastrarEvento(String nomeEvento, String local, LocalDate data,
            BigDecimal preco, String descricaoEvento){
        
        Evento evento = new Evento(nomeEvento, local, data, preco, descricaoEvento);
        
        listaEventos.add(evento);
    }
    
    public Boolean achouEvento(String nomeEvento){
        boolean achou = false;
        
        for(int i=0; i < listaEventos.size(); i++){
            if(nomeEvento.equalsIgnoreCase(listaEventos.get(i).getNomeEvento())){
                achou = true;
                System.out.println("Evento Encontrado!");
                listaEventos.get(i).exibirDados();
                break;
            }
        }
        
        return achou;
    }
    
    public Evento retornaEvento(String nomeEvento){
        for(int i=0; i < listaEventos.size(); i++){
            if(nomeEvento.equalsIgnoreCase(listaEventos.get(i).getNomeEvento())){             
                return listaEventos.get(i);
            }
        }
        
        return null;
    }
    
    public void cancelarInscricao(Participante participante, Evento evento){
        if(this.isLogado()){
            Inscricao inscricao = evento.buscarInscricao(participante);
            if(inscricao != null){
                participante.cancelarInscricao(inscricao);
                evento.cancelarInscricaoEvento(inscricao);
            
                evento.atualizarFaturamento(false);
            
                System.out.println("Sucesso! O participante foi chutado com sucesso! Não vai participar mais");
            }else{
                System.out.println("Falha! Inscrição não localizada");
            }                   
        }else {
            System.out.println("Falha! Você deve estar logado para continuar");
            
        }
    }
}
