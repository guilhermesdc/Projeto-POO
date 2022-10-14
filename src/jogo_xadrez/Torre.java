/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Torre extends Peca {
    /*CONSTRUCTOR*/

    public Torre(boolean cor) {
        this.cor = cor;
        this.emJogo = false;
    }

    /*METHODS*/
    
    @Override
    public char desenho() {
        // peca preta em minusculo
        if(!cor) {
            return 't';
        }
        //peca branca em maiusculo
        return 'T';
    }
    
    @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        /* Movimento vertical ou horizontal*/
        if((linhaOrigem == linhaDestino && this.parseColuna(colunaOrigem) != this.parseColuna(colunaDestino))
          || (this.parseColuna(colunaOrigem) == this.parseColuna(colunaDestino) && linhaOrigem != linhaDestino)) {
            return true;
        }
        else {
            return false;
        }
    }
}