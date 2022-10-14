/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Posicao {

    private Peca peca;
    private final int linha;
    private final char coluna;
    private final boolean cor;

    /*CONSTRUCTOR*/

    public Posicao(int linha, char coluna, boolean cor) {
        if((linha < 1 || linha > 8) ||
                (coluna < 'A' || coluna > 'H')){
            throw new IllegalArgumentException();
        }
        this.linha = linha;
        this.coluna = coluna;
        this.cor = cor;
    }


    /*GETTERS AND SETTERS*/

    public boolean isOcupada() {
        return peca != null;
    }

    public Peca getPeca() {
        return peca;
    }

    public int getLinha() {
        return linha;
    }

    public char getColuna() {
        return coluna;
    }

    public void setPeca(Peca peca) {
        //nao eh possivel passar uma peca nao nula que esteja fora do jogo
        if(peca != null && peca.getEmJogo() == false) {
            throw new IllegalArgumentException();
        }
        this.peca = peca;
    }

    public boolean isBranca() {
        return this.cor;
    }

}
