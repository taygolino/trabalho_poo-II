/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade.oob.geekverse;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author fabiano
 */
public class Participante extends Pessoa{
    private int codParticipante;
    private List<Inscricao> inscricoesRealizadas = new ArrayList<>();

    // Refrator
    /**
     * @return the codParticipante
     */
    public int getCodParticipante() {
        return codParticipante;
    }

    /**
     * @param codParticipante the codParticipante to set
     */
    public void setCodParticipante(int codParticipante) {
        this.codParticipante = codParticipante;
    }

    /**
     * @return the inscricoesRealizadas
     */
    public List<Inscricao> getInscricoesRealizadas() {
        return inscricoesRealizadas;
    }

    /**
     * @param inscricoesRealizadas the inscricoesRealizadas to set
     */
    public void setInscricoesRealizadas(List<Inscricao> inscricoesRealizadas) {
        this.inscricoesRealizadas = inscricoesRealizadas;
    }
    
    public Participante(){
        super();
        this.codParticipante = 0;
    }
    
    public Participante(int codParticipante){
        super();
        this.codParticipante = codParticipante;
    }
    
    public Participante(int codParticipante, String nome, 
            String email, String telefone, String cpf, String senha){
        super(nome, email, telefone, cpf);
        this.setSenha(senha);
        this.codParticipante = codParticipante;  
    }
    
    // A ideia é que eu procure na lista de participantes cadastrados e retorne
    // o participante cujo código digitei
    public Participante buscarCodigo(int codPArticipante){
        
        return this;
    }
    
    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Código do Participante: "+ this.codParticipante);
    }
    
    public void realizarInscricao(Evento evento, Participacao tipoParticipacao, String atividade){
        
        if(this.isLogado()){
            Inscricao inscricao = new Inscricao(tipoParticipacao, atividade, evento, this);
            this.inscricoesRealizadas.add(inscricao);
            evento.adicionarInscricao(inscricao);
            evento.atualizarFaturamento(true);
            System.out.println("Sucesso! O participante foi inscrito com sucesso!");
            
        }else {
            System.out.println("Falha! Você deve estar logado para continuar");
            
        }
        
    }
    
    public void cancelarInscricao(Inscricao inscricao){
        boolean sucesso = this.inscricoesRealizadas.remove(inscricao);
        
        if(!sucesso){System.out.println("Falha! Não foi encontrada a inscrição");}
    }
            
}
