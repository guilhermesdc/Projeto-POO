package jogo_xadrez;

public class Bispo extends Peca {
    /*CONSTRUCTOR*/

    public Bispo(boolean cor) {
        this.cor = cor;
        this.emJogo = false;
    }

    /*METHODS*/
    
    @Override
    public char desenho() {
        // peca preta em minusculo
        if(!cor) {
            return 'b';
        }
        //peca branca em maiusculo
        return 'B';
    }
    
    @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {

        /* Calcula a diferenca entre a linha de origem e a de destino*/
        int diferenca_linha =  linhaOrigem - linhaDestino;
        /*Calcula a diferenca entre a coluna de origem e a de destino*/
        int diferenca_coluna = this.parseColuna(colunaOrigem) - this.parseColuna(colunaDestino);
        /*Movimento em diagonal*/
        if(diferenca_linha == diferenca_coluna || diferenca_linha == diferenca_coluna * -1) {
            return true;
        }
        else {
            return false;
        }
    }
}