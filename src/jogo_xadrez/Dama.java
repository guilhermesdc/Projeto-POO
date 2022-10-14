/*
Guilherme Camargo - 792183
Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Dama extends Peca {

    /*CONSTRUCTOR*/

    public Dama(boolean cor) {
        this.cor = cor;
        this.emJogo = false;
    }

    /*METHODS*/
    
    @Override
    public char desenho() {
        // peca preta em minusculo
        if(!cor) {
            return 'd';
        }
        //peca branca em maiusculo
        return 'D';
    }
    
    @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        /*Calcula a diferenca entre a linha de origem e a de destino*/
        int diferenca_linha = linhaOrigem - linhaDestino;
        /*Calcula a diferenca entre a coluna de origem e a de destino*/
        int diferenca_coluna = this.parseColuna(colunaOrigem) - this.parseColuna(colunaDestino);
        /*Movimento vertical ou horizontal*/
        if(linhaOrigem == linhaDestino
            || this.parseColuna(colunaOrigem) == this.parseColuna(colunaDestino)) {
            return true;
        }
        /*Movimento em diagonal*/
        else if(diferenca_linha == diferenca_coluna || diferenca_linha == diferenca_coluna * -1) {
            return true;
        }
        else {
            return false;
        }
    }
}