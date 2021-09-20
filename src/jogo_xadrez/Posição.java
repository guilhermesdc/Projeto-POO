package jogo_xadrez;

public class Posição {
//    ATRIBUTES

    private static final boolean branco = true;
    private static final boolean preto = false;
    public enum Pecas {
        REI,DAMA,CAVALO,BISPO,TORRE,PEAO;
    }
    public enum Coluna{
        A,B,C,D,E,F,G,H;
    }

    private boolean cor;
    private boolean ocupada;
    private boolean corPeca;
    private int peca;
    private final int linha;
    private final int coluna;

//    CONTRUCTOR
    //padrao para
    public Posição(boolean ocupada, boolean cor, int linha, int coluna) {
        this.cor = cor;
        this.ocupada = ocupada;
        this.linha = linha;
        this.coluna = coluna;
    }


//    METHODS
public void imprimir(){
    System.out.println("Ocupada: " + isOcupada());
    System.out.println("Cor: " + isCor());
    System.out.println("Linha: " + getLinha());
    System.out.println("Coluna: " + getColuna());
    System.out.println("Peca: " + getPeca());
    System.out.println("Cor Peca:" + isCorPeca());
}

//    GETTERS & SETTERS


    public boolean isCor() {
        return cor;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public boolean isCorPeca() {
        return corPeca;
    }

    public int getPeca() {
        return peca;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setCorPeca(boolean corPeca) {
        this.corPeca = corPeca;
    }

    public void setPeca(int peca) {
        this.peca = peca;
    }
}
