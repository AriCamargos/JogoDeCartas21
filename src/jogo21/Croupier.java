package jogo21;
public class Croupier {
    private final Baralho baralho; //null (apenas declarei)

    public Croupier() {
        this.baralho = new Baralho();
    }
    
    public void embaralharCartas(){
        this.baralho.embaralharCartas();
    }
    
    public Carta darCarta(){
       Carta c = this.baralho.mandarCartaMesa();
       return c; 
    }
    
    public Carta[] retornarTodasCartas(){
     
        return this.baralho.getCartas();
    }
    
    public void determinarVencedor(){
        
    }
}
