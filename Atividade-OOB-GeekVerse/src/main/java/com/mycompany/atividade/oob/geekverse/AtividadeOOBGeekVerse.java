/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividade.oob.geekverse;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Scanner;

 /*
 * @author fabiano
 */
public class AtividadeOOBGeekVerse {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        Scanner scan = new Scanner(System.in);
        
        // Criando um gerente
        GerenciarUsuarios gerente = new GerenciarUsuarios();
        
        gerente.cadastrarParticipante(1, "Rimoru", "slime@gmail.com",
                "(21)9.9999-9999", "444.777.666-66", "1234");
        
        gerente.cadastrarParticipante(2, "Shion", "oni@gmail.com",
                "(21)9.7779-9999", "777.333.656-65", "4321");
        
        gerente.cadastrarParticipante(3, "Hanza", "Lobao@gmail.com",
                "(21)9.9444-9499", "434.737.633-11", "2026");
        
        gerente.exibirParticipantes();
        
        System.out.println("Procurando pela Shion");
        gerente.pesquisaParticipante("Shion");
        
        System.out.println("Procurando pela Lana");
        gerente.pesquisaParticipante("Lana");
        
        // Cadastrando um organizador
        gerente.cadastrarOrganizador(Cargo.GERENTE, "Tempest", "Diablo", "noir@gmail.com",
                "(21) 9.8514-4563", "449.788.999-66", "2620");
        gerente.exibirOrganizadores();
        
        
        // Cadastrando e exibindo um evento
        System.out.println("-----------------\nVamos cadastrar o preço do ingresso do evento");
        
        // Hora do try Cath
        try{
            BigDecimal preco = new BigDecimal(scan.nextLine());
            preco = preco.abs();
            gerente.cadastroEvento("Diablo", "Torneio de Magia", 
                "Coliseu de Tempeste", LocalDate.of(2027, 01, 01), preco, "Evento legal de luta!");

            gerente.exibirEvento("Diablo", "torneio de magia");
            
        }catch(NumberFormatException e){
            System.out.println("Erro de Formato! Digite números usando ponto como separador decimal");
        }
        
        
        System.out.println("-------------------\n\n");
        
        //Realizando inscrições para o evento Torneio de Magia
        String login = "Lobao@gmail.com";
        String senha = "2026";
        
        Evento evento = new Evento();
        Participante participante = gerente.buscarParticipante(login);
        
        if(participante != null){
            participante.exibirDados();
            
            // Primeiro autentifica
            participante.autenticar(login, senha);
        
            if(participante.isLogado()){
                String nomeEvento = "torneio de magia";
                String nomeOrganizador = "Diablo";

                evento = gerente.buscarEvento(nomeOrganizador, nomeEvento);

                //Depois se inscrive
                participante.realizarInscricao(evento, Participacao.VISITANTE, "Visitar as barracas");
                
                evento.exibirInscricoes();
                System.out.println("\n\nFaturamento atual: R$"+evento.getFaturamento());
                
            }
            
        }
        
        // Organizador cancelando inscrição
        login = "noir@gmail.com";
        System.out.println("Seu login é noir@gmail.com\nDigite sua senha: ");
        senha = scan.nextLine();
       
        
        Organizador organizador = gerente.buscarOrganizador(login);
        
        if(organizador != null){
            // Primeiro autentifica (de novo)
            organizador.autenticar(login, senha);
        
            if(organizador.isLogado()){
                String emailParticipante = "Lobao@gmail.com";
                participante = gerente.buscarParticipante(emailParticipante);
                String nomeEvento2 = "torneio de magia";
                
                evento = gerente.buscarEvento(organizador.getNome(), nomeEvento2);
                
                organizador.cancelarInscricao(participante, evento);
            }
        }
        
        // Polimorfismo
        Exibivel obj1 = new Participante();
        obj1 = gerente.buscarParticipante("oni@gmail.com");
        
        Exibivel obj2 = new Evento();
        obj2 = gerente.buscarEvento("Diablo", "Torneio de Magia");
        
        System.out.println("\n-------------------------------");
        System.out.println("Exibindo o participante utilizando a interface:");
        obj1.exibirDados();
        
        System.out.println("\n-------------------------------");
        System.out.println("Exibindo o evento utilizando a interface:");
        obj2.exibirDados();        
    }
}
