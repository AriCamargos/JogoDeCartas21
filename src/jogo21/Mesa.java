package jogo21;
public class Mesa {
    private final Croupier croupier;
    private final Interface umaI;
    private final Jogador jogador, virtual;
    
    public Mesa(){
        this.umaI = new Interface();
        this.croupier = new Croupier();
        this.jogador = new Jogador("Ariana");
        this.virtual = new Jogador("Virtual");
    }
    
    public void iniciarRodada(){
        
        this.umaI.apresentarJogo(); //apresento jogo
        this.croupier.embaralharCartas();
        Carta[] cartas = this.croupier.retornarTodasCartas();
        this.umaI.mostrarCartas(cartas);
        this.distribuirCartasIniciais();
        
       while(true){
            Acao a = this.umaI.pedeAcaoUsuario();
            switch(a){
                case VER_PROPRIAS_CARTAS -> this.umaI.mostrarCartasJogador(this.jogador.getNome(), this.jogador.getCartas());
                case VER_CARTAS_MESA -> this.umaI.mostrarCartasJogador(this.virtual.getNome(), this.virtual.peguePrimeiraCartaEOculta());
                case PEDIR_CARTA -> {
                    this.darCartaJogador();
                    this.umaI.mostrarCartasJogador(this.jogador.getNome(), this.jogador.getCartas());
                    StatusJogo s = this.determinarSeJogadorGanhou();
                    if(s == StatusJogo.EM_ANDAMENTO){
                        break;
                    }
                    this.finalizarJogo();
                    return;
                }
                case BATER -> {
                    this.finalizarJogo();
                    return;
                }
                case SAIR -> {
                    return;
                }
            }
        }
    }
       
    private void finalizarJogo(){
        StatusJogo status = this.determinarVencedor();
        this.umaI.apresentarFimDeJogo();
        this.umaI.mostrarCartasJogador(this.virtual.getNome(), this.virtual.getCartas());
        this.umaI.mostrarCartasJogador(this.jogador.getNome(),this.jogador.getCartas());
        if(StatusJogo.JOGADOR_GANHOU == status){
            this.umaI.mostrarJogadorVenceu(this.jogador.getNome(),this.jogador.calcularPontos(),this.virtual.calcularPontos());
            return;
        }
        this.umaI.mostrarVirtualVenceu(this.jogador.getNome(),this.jogador.calcularPontos(),this.virtual.calcularPontos());
    }
    
    private StatusJogo determinarSeJogadorGanhou(){
        int pontos = this.jogador.calcularPontos();
        if(pontos == 21){
            return StatusJogo.JOGADOR_GANHOU;
        }
        if(pontos>21){
          return  StatusJogo.MESA_GANHOU;
        }
        return StatusJogo.EM_ANDAMENTO;
    }
    
    private StatusJogo determinarVencedor(){
        int pontosJogador = this.jogador.calcularPontos();
        int pontosVirtual = this.virtual.calcularPontos();
        if(pontosJogador>21 || pontosVirtual>pontosJogador){
            return StatusJogo.MESA_GANHOU;
        }
        return StatusJogo.JOGADOR_GANHOU;
    }
    
    private void darCartaJogador(){
        Carta c = this.croupier.darCarta();
        this.jogador.recebaCarta(c);
    }
    
    private void distribuirCartasIniciais(){
        Carta c = this.croupier.darCarta();
        
        this.jogador.recebaCarta(c);
        c = this.croupier.darCarta();
        this.virtual.recebaCarta(c);
        c = this.croupier.darCarta();
        this.jogador.recebaCarta(c);
        c = this.croupier.darCarta();
        this.virtual.recebaCarta(c);
    }
}
