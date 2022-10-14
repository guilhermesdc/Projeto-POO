/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Peao extends Peca {
    private boolean casaDestinoOcupada;
    private boolean pecaMovimentada;
    
    /*CONSTRUCTOR*/

    public Peao(boolean cor) {
        this.cor = cor;
        this.emJogo = false;
        this.pecaMovimentada = false;
    }

    /*METHODS*/
    
    @Override
    public char desenho() {
        // peca preta em minusculo
        if(!cor) {
            return 'p';
        }
        //peca branca em maiusculo
        return 'P';

    }

    @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        /*Movimento normal, caminhando na mesma coluna*/
        if(this.parseColuna(colunaDestino) == this.parseColuna(colunaOrigem)) {
            return checaMovimentoVertical(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
        }
        /*Movimento para comer uma peca, caminhando na diagonal*/
        else {
            return checaMovimentoDiagonal(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
        }
    }
    
    private boolean checaMovimentoVertical(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        /*Branco*/
        if(this.cor){
            /*Saída inicial, validando caminhar duas casas*/
            if(!this.pecaMovimentada && linhaOrigem == 2 && linhaDestino - linhaOrigem == 2 && !this.casaDestinoOcupada) {
                return true;
            }
            /*Caminhando uma casa*/
            else if(linhaDestino - linhaOrigem == 1 && !this.casaDestinoOcupada) {
                return true;
            }
            else {
                return false;
            }
        } 
        /*Preto*/
        else {
            /* Saída inicial, validando caminhar duas casas*/
            if(!this.pecaMovimentada && linhaOrigem == 7 && linhaDestino - linhaOrigem == -2 && !this.casaDestinoOcupada) {
                return true;
            }
            /* Caminhando uma casa*/
            else if(linhaDestino - linhaOrigem == -1 && !this.casaDestinoOcupada) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    private boolean checaMovimentoDiagonal(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        /*Branco*/
        if(this.cor) {
            int diferenca_coluna = this.parseColuna(colunaOrigem) - this.parseColuna(colunaDestino);
            /*Movimento Valido*/
            if(linhaDestino - linhaOrigem == 1 && (diferenca_coluna == -1 || diferenca_coluna == 1) && this.casaDestinoOcupada) {
                return true;
            }
            else {
                return false;
            }
        }
        /*Preto*/
        else {
            int diferenca_coluna = this.parseColuna(colunaOrigem) - this.parseColuna(colunaDestino);
            /*Movimento Valido*/
            if(linhaDestino - linhaOrigem == -1 && (diferenca_coluna == -1 || diferenca_coluna == 1) && this.casaDestinoOcupada) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public void moveu() {
        this.pecaMovimentada = true;
    }
    
    /*GETTERS AND SETTERS*/ 


    public void setCasaDestinoOcupada(boolean casaDestinoOcupada) {
        this.casaDestinoOcupada = casaDestinoOcupada;
    }
}