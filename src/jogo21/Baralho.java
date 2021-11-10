package jogo21;
public class Baralho {
   private int quantidade = 52;
   private int contProximaCarta = 0;
   private Carta[] cartas = new Carta [quantidade];
   
   public Baralho(){
       String nomes[] = {"K", "Q", "J", "A", "2", "3","4", "5", "6", "7", "8", "9", "10"};
       int pontos [] = {10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       String naipes[] = {"♥", "♦", "♣", "♠"};
       int cont = 0;
       
       for (String naipe : naipes) {
           for (int i = 0; i < nomes.length; i++) {
            cartas[cont] = new Carta(nomes[i], naipe, pontos[i]);
            cont++;  
           }
       }
    }
  
   public void embaralharCartas(){
        for(int i = 0; i < this.quantidade; i++){
            Carta aux = cartas[i];
            int prox = (int) (Math.random()*quantidade);
            cartas[i] = cartas[prox];
            cartas[prox] = aux;
            
        } 
        this.contProximaCarta=0; 
    }    
   
   public void qntCartas(){
       if(quantidade>=0){
           System.out.println("Tem " + quantidade + " cartas");
        }
    }
   
   public Carta mandarCartaMesa(){
       Carta c = this.cartas[this.contProximaCarta];
       this.contProximaCarta++;
       return c;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public int getContProximaCarta() {
        return contProximaCarta;
    }

    public Carta[] getCartas() {
        return cartas;
    }

}
