package jogo_xadrez;

public class Jogo {
    //    ATRIBUTES
    public static final boolean branco = true;
    public static final boolean preto = false;
    private Jogador jBranco;
    private Jogador jPreto;
    private Tabuleiro tabuleiro;


//    CONTRUCTOR

    public Jogo(String nomeJ1, String nomeJ2) {
        jBranco = new Jogador(nomeJ1, branco);
        jPreto = new Jogador(nomeJ2, preto);
        tabuleiro = new Tabuleiro();
    }


//    METHODS


//    GETTERS & SETTERS


}
