package jogo_xadrez;

public class Tabuleiro {
    /* ATRIBUTES */
    private static final boolean BRANCO = true;
    private static final boolean PRETO = false;
    private static final int TAM = 8;

    public enum Pecas {
        REI, DAMA, CAVALO, BISPO, TORRE, PEAO;
    }

    public enum Coluna {
        A, B, C, D, E, F, G, H;
    }

    private Posição[][] posicao = new Posição[TAM][TAM];

    /* CONTRUCTOR */
    //cria as 64 pecas do tabuleiro
    public Tabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    posicao[i][j] = new Posição(false, PRETO, i, j);
                } else {
                    posicao[i][j] = new Posição(false, BRANCO, i, j);
                }
            }
        }
    }

    /* METHODS */
    //somente um rascunho
    public void desenho() {
        for (int i = TAM-1; i >= 0; i--) {

            //branco
            if (i % 2 == 1) {
                System.out.println("         *********         *********         *********         *********");
                for (int j = 0; j < TAM; j++) {
                    posicao[i][j].desenho();
                }
                System.out.println();
                System.out.println("         *********         *********         *********         *********");
            }

            //preto
            else {
                System.out.println("*********         *********         *********         *********         ");
                for (int j = 0; j < TAM; j++) {
                    posicao[i][j].desenho();
                }
                System.out.println();
                System.out.println("*********         *********         *********         *********         ");
            }
        }

    }

    //coloca todas as pecas nas posicoes iniciais do jogo
    public void colocarPecas() {
        // Pretas

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {


                if(i>=6){
                    posicao[i][j].setOcupada(true);
                    posicao[i][j].setCorPeca(PRETO);
                }
                else if(i<=1){
                    posicao[i][j].setOcupada(true);
                    posicao[i][j].setCorPeca(BRANCO);

                }
                if (i==6 || i==1){
                    posicao[i][j].setPeca(Pecas.PEAO.ordinal());
                }
                else if(i==0 || i==7){
                    if(j == Coluna.A.ordinal() || j == Coluna.H.ordinal()){
                        posicao[i][j].setPeca(Pecas.TORRE.ordinal());
                    }
                    else if(j == Coluna.B.ordinal() || j == Coluna.G.ordinal()){
                        posicao[i][j].setPeca(Pecas.CAVALO.ordinal());
                    }
                    else if(j == Coluna.C.ordinal() || j == Coluna.F.ordinal()){
                        posicao[i][j].setPeca(Pecas.BISPO.ordinal());
                    }
                    else if(j == Coluna.D.ordinal()){
                        posicao[i][j].setPeca(Pecas.DAMA.ordinal());
                    }
                    else if(j == Coluna.E.ordinal()){
                        posicao[i][j].setPeca(Pecas.REI.ordinal());
                    }
                }
            }
        }

    }

    /* GETTERS & SETTERS */

    public boolean estaOcupada(int coluna, int linha) {
        return posicao[linha][coluna].isOcupada();
    }
    public boolean corPeca(int coluna, int linha) {
        return posicao[linha][coluna].isCorPeca();
    }

    public Posição getPosicao(int linha, int coluna){
        return posicao[linha][coluna];
    }
}
