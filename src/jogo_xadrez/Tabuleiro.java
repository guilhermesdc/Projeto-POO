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
    public Tabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    posicao[i][j] = new Posição(false, BRANCO, i, j);
                } else {
                    posicao[i][j] = new Posição(false, PRETO, i, j);
                }
            }
        }
    }

    /* METHODS */
    public static void desenho() {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|");
                System.out.println("|       |#######|       |#######|       |#######|       |#######|");
                System.out.println("|       |#######|       |#######|       |#######|       |#######|");
            } else {
                System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|");
                System.out.println("|#######|       |#######|       |#######|       |#######|       |");
                System.out.println("|#######|       |#######|       |#######|       |#######|       |");
            }
        }
        System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|");
    }

    public void colocarPecas() {
        // Pretas

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                posicao[i][j].setOcupada(true);
                if(i>4){
                    posicao[i][j].setCorPeca(PRETO);
                }
                else{
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

    public boolean getPosicao(int coluna, int linha) {
        return posicao[linha][coluna].isOcupada();
    }
}
