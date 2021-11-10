package jogo21;

import java.util.Arrays;
import java.util.Scanner;

public class Interface {
    
    public void apresentarJogo(){
        System.out.println("== Bem vindo ao Jogo 21 == ");
        System.out.println("Regras: Quem fizer 21 pontos primeiro ganha a rodada!");
        System.out.println("Cartas embaralhadas pelo coupier: ");
    }
    
    public void mostrarCartasJogador(String nome, Carta[] cartas){
        System.out.println("Jogador " + nome );
        this.mostrarCartas(cartas);
    }
    
    public void mostrarCartas(Carta[] cartas){
       for(int i = 0; i < cartas.length; i++){
          System.out.print(cartas[i].getNome()+ "" );
          System.out.print(cartas[i].getNaipe()+ " " );
          System.out.print(cartas[i].getPontos() + "pts ");
          if(i%13==12){
              System.out.println("  ");
              System.out.println(" == ");
          }
       }
        System.out.println(" ");
    }
    
    public Acao pedeAcaoUsuario(){
        
        System.out.println("\nQual seu próximo movimento?");
        System.out.println(" == MENU == ");
        System.out.println("Digite a - Ver suas próprias cartas");
        System.out.println("Digite b - Ver as cartas da mesa");
        System.out.println("Digite c - Para pedir carta");
        System.out.println("Digite d - Para bater");
        System.out.println("Digite e - Sair do jogo");
        
        Scanner input = new Scanner(System.in);
        String leia = input.nextLine();
        
        switch(leia){
            case "a" -> { 
                return Acao.VER_PROPRIAS_CARTAS;
            }
            case "b" ->{
                return Acao.VER_CARTAS_MESA;
            }
            case "c" ->{
                return Acao.PEDIR_CARTA;
            }
            case "d" ->{
                return Acao.BATER;
            }
            default ->{
                return Acao.SAIR;
            }
        }
    }

    void mostrarTodasAsCartasVirtual(Carta[] mesaCartas) {
        System.out.println("Essas eram todas as cartas do Jogador Virtual " + Arrays.toString(mesaCartas));
    }
    
    void determinarVencedor(StatusJogo status) {
        System.out.println("Você venceu o jogo " + StatusJogo.JOGADOR_GANHOU);
        System.out.println("O jogador virtual ganhou o jogo " + StatusJogo.MESA_GANHOU);
    }

    void apresentarFimDeJogo() {
        System.out.println(" == FIM DE JOGO == ");
    }

    public void mostrarJogadorVenceu(String nome, int pontosJogador, int pontosMesa) {
        System.out.println("Parabéns Jogador(a) " + nome + " você venceu com " + pontosJogador + " pontos X " + pontosMesa + " pontos da Mesa");
    }

    public void mostrarVirtualVenceu(String nome, int pontosJogador, int pontosMesa) {
        System.out.println("Que pena Jogador(a) " + nome + " você perdeu com " + pontosJogador + " pontos X " + pontosMesa + " pontos da Mesa");
    }
}
