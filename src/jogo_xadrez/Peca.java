/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public abstract class Peca {
    protected boolean cor;
    protected boolean emJogo;
    
    /*METHODS*/

    public abstract boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino);
    
    public abstract char desenho();
    
    /*GETTERS AND SETTERS*/

    public boolean getEmJogo() {
        return emJogo;
    }

    public void setEmJogo(boolean estadoAtual) {
        this.emJogo = estadoAtual;
    }
    
    public boolean getColor() {
        return cor;
    }
    
    protected int parseColuna(char idx) {
        idx = Character.toLowerCase(idx);
        int coluna = (int) idx;
        return coluna - 97;
    }
}
