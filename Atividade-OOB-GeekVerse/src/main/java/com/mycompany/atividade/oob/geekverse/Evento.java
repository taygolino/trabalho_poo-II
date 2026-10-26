/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade.oob.geekverse;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author fabiano
 */
public class Evento implements Exibivel {
    private String nomeEvento;
    private String local;
    private LocalDate data;
    private List<Inscricao> listaInscricoes = new ArrayList<>();
    private String descricaoEvento;
    private BigDecimal preco;
    private BigDecimal faturamento;

    // Feito com o refrator
    /**
     * @return the nomeEvento
     */
    public String getNomeEvento() {
        return nomeEvento;
    }

    /**
     * @param nomeEvento the nomeEvento to set
     */
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * @return the listaInscricoes
     */
    public List<Inscricao> getListaInscricoes() {
        return listaInscricoes;
    }

    /**
     * @param listaInscricoes the listaInscricoes to set
     */
    public void setListaInscricoes(List<Inscricao> listaInscricoes) {
        this.listaInscricoes = listaInscricoes;
    }

    /**
     * @return the descricaoEvento
     */
    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    /**
     * @param descricaoEvento the descricaoEvento to set
     */
    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }
    
    /**
     * @return the preco
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    /**
     * @return the faturamento
     */
    public BigDecimal getFaturamento() {
        return faturamento;
    }

    /**
     * @param faturamento the faturamento to set
     */
    public void setFaturamento(BigDecimal faturamento) {
        this.faturamento = faturamento;
    }
    
    public Evento(){
        this.nomeEvento = "";
        this.local = "";
        this.data = LocalDate.now();
        this.preco = BigDecimal.ZERO;
        this.descricaoEvento = "";
        this.listaInscricoes = new ArrayList<>();
        this.faturamento = BigDecimal.ZERO;
    }
    
    public Evento(String nomeEvento, String local, LocalDate data, BigDecimal preco, String descricaoEvento){
        this.nomeEvento = nomeEvento;
        this.local = local;
        this.data = data;
        this.preco = preco;
        this.descricaoEvento = descricaoEvento;
        this.listaInscricoes = new ArrayList<>();
        this.faturamento = BigDecimal.ZERO;
        
    }
    
    @Override
    public void exibirDados(){
        System.out.println("Dados do Evento");
        System.out.println("Nome do Evento: "+ this.nomeEvento);
        System.out.println("Local: "+ this.local);
        System.out.println("Data: "+ this.data);
        System.out.println("Preço do Ingresso: R$"+ this.preco);
        System.out.println("Descrição: "+ this.descricaoEvento);
    }
    
    public void exibirInscricoes(){
        System.out.println("Lista de participantes:");
        
        for(int i=0; i < this.listaInscricoes.size(); i++){
            System.out.println((i+1) + ". "+ this.listaInscricoes.get(i).getParticipante().getNome());
        }
        System.out.println("------ Fim da listagem");
    }

    public void adicionarInscricao(Inscricao inscricao){
        this.listaInscricoes.add(inscricao);
    }
    
    public Inscricao buscarInscricao(Participante participante){
        
        for(int i=0; i < listaInscricoes.size(); i++){
            if(this.listaInscricoes.get(i).getParticipante() == participante){
                return this.listaInscricoes.get(i);
            }else {
                System.out.println("Que preguiça ficar fazendo esses elses haha");
            }
        }
        
        return null;
    }
    
    public void cancelarInscricaoEvento(Inscricao inscricao){
        this.listaInscricoes.remove(inscricao);
    }
    
    public void atualizarFaturamento(boolean adicionarReceita){
        if(adicionarReceita){
            this.faturamento = this.faturamento.add(this.preco);
        }else{
            this.faturamento = this.faturamento.subtract(preco);
                    
        }
        
    }
    
}
