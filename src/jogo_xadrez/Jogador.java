package jogo_xadrez;

public class Jogador {
//    ATRIBUTES
    private static final boolean preto = false;
    private static final boolean branco = true;
    private final String nome;
    private final boolean cor;
    private String[] pecasDisponiveis;


//    CONTRUCTOR

    public Jogador(String nome, boolean cor) {
        this.cor = cor;
        this.nome = nome;
        //peão[] = new Peão;

    }


//    METHODS


//    GETTERS & SETTERS


    public String getNome() {
        return nome;
    }

    public boolean isCor() {
        return cor;
    }
}
