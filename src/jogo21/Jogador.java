package jogo21;

import java.util.LinkedList;

public class Jogador {
    private LinkedList <Carta> cartas;
    private String nome;

   public Jogador(String nome) {
        this.cartas = new LinkedList<>();
        this.nome = nome;
    }
    
    public void recebaCarta(Carta c){
        this.cartas.add(c);
    }
    
    public Carta[] peguePrimeiraCartaEOculta(){
        Carta[] c = new Carta[2];
        c[0] = this.cartas.get(0);
        c[1] = new Carta("X", "🃏", 0);
        return c;
    }
    
    public int calcularPontos(){
        int pontos = 0;
        for (Carta c : this.cartas) {
            pontos += c.getPontos();
        }
        return pontos;
    }

    public Carta[] getCartas() {
        return this.cartas.toArray(new Carta[0]);
    }

    public String getNome(){
        return this.nome;
    } 
    
}
