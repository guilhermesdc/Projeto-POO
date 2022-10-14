/*
Guilherme Camargo - 792183
Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Cavalo extends Peca {
    /*CONSTRUCTOR*/

    public Cavalo(boolean cor) {
        this.cor = cor;
        this.emJogo = false;
    }

    /*METHODS*/
    
    @Override
    public char desenho() {
        // peca preta em minusculo
        if(!cor) {
            return 'c';
        }
        //peca branca em maiusculo
        return 'C';
    }
    
    @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        /* Calcula a diferenca entre a linha de origem e a de destino*/
        int diferenca_linha = linhaOrigem - linhaDestino;
        /*Calcula a diferenca entre a coluna de origem e a de destino*/
        int diferenca_coluna = this.parseColuna(colunaOrigem) - this.parseColuna(colunaDestino);
        /*Movimento em L, caminhando uma coluna e duas linhas*/
        if((diferenca_coluna == 1 || diferenca_coluna == -1) && (diferenca_linha == 2 || diferenca_linha == -2)) {
            return true;
        }
        /*Movimento em L, caminhando duas colunas e uma linha*/
        else if((diferenca_coluna == 2 || diferenca_coluna == -2) && (diferenca_linha == 1 || diferenca_linha == -1)) {
            return true;
        }
        else {
            return false;
        }
    }
}