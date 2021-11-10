package jogo21;
public class Carta {
    private final String nome;
    private final String naipe;
    private final int pontos;

    public Carta(String nome, String naipe, int pontos) {
        this.nome = nome;
        this.naipe = naipe;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public String getNaipe() {
        return naipe;
    }
    
    public int getPontos(){
        return pontos;
    }

}
