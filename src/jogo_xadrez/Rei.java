/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Rei extends Peca {
    /*CONSTRUCTOR*/

    public Rei(boolean cor) {
        this.cor = cor;
        this.emJogo = false;
    }

    /*METHODS*/
    
    @Override
    public char desenho() {
        // peca preta em minusculo
        if(!cor) {
            return 'r';
        }
        //peca branca em maiusculo
        return 'R';
    }

    @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        /*Calcula a diferenca entre a linha de origem e a de destino*/
        int diferenca_linha = linhaOrigem - linhaDestino;

        /* Calcula a diferenca entre a coluna de origem e a de destino*/
        int diferenca_coluna = this.parseColuna(colunaOrigem) - this.parseColuna(colunaDestino);

        if((linhaOrigem == linhaDestino && (diferenca_coluna == -1 || diferenca_coluna == 1))  /* Movimento horizontal caminhando uma posicao*/
            || this.parseColuna(colunaOrigem) == this.parseColuna(colunaDestino) && (diferenca_linha == -1 || diferenca_linha == 1)) { /* Movimento vertical caminhando uma posicao*/
            return true;
        }

        else if((diferenca_linha == 1 || diferenca_linha == -1) &&
                (diferenca_linha == diferenca_coluna || diferenca_linha == diferenca_coluna * -1)) { // Movimento em diagonal caminhando uma posicao
            return true;
        }
        else {
            return false;
        }
    }
}
