/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade.oob.geekverse;

/**
 *
 * @author fabiano
 */
public class Inscricao {
    private Participacao tipoParticipacao;
    private String atividade;
    private Evento evento;
    private Participante participante;

    // Feito com getters e setters
    /**
     * @return the tipoParticipacao
     */
    public Participacao getTipoParticipacao() {
        return tipoParticipacao;
    }

    /**
     * @param tipoParticipacao the tipoParticipacao to set
     */
    public void setTipoParticipacao(Participacao tipoParticipacao) {
        this.tipoParticipacao = tipoParticipacao;
    }

    /**
     * @return the atividade
     */
    public String getAtividade() {
        return atividade;
    }

    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the participante
     */
    public Participante getParticipante() {
        return participante;
    }

    /**
     * @param participante the participante to set
     */
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
    public Inscricao(Participacao tipoParticipacao, String atividade, Evento evento, Participante participante){
        this.tipoParticipacao = tipoParticipacao;
        this.atividade = atividade;
        this.evento = evento;
        this.participante = participante;
    }
    
}
