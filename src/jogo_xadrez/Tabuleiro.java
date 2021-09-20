package jogo_xadrez;

public class Tabuleiro {
      //      ATRIBUTES
      private static final boolean BRANCO = true;
      private static final boolean PRETO = false;
    private static final int TAM = 8;

    public enum Pecas {
        REI,DAMA,CAVALO,BISPO,TORRE,PEAO;
    }
    public enum coluna{
        A,B,C,D,E,F,G,H;
    }
      private Posição[][] tabuleiro;


//      CONTRUCTOR


    public Tabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if((i%2 == 0 && j%2 == 0) || (i%2 == 1 && j%2 == 1)){
                    tabuleiro[i][j] = new Posição(false, BRANCO, i, j);
                }
                else{
                    tabuleiro[i][j] = new Posição(false, PRETO, i, j);
                }
            }
        }
    }

    //      METHODS
      public static void desenho(){
          for (int i = 0; i < 8; i++) {
              if(i%2 == 0){
                  System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|");
                  System.out.println("|       |#######|       |#######|       |#######|       |#######|");
                  System.out.println("|       |#######|       |#######|       |#######|       |#######|");
              }
              else{
                  System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|");
                  System.out.println("|#######|       |#######|       |#######|       |#######|       |");
                  System.out.println("|#######|       |#######|       |#######|       |#######|       |");
              }

          }
              System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|");


      }

      public void colocarPecas(){
        //pretas
          for (int i = 6; i < 8; i++) {
              for (int j = 0; j < 8; j++) {
                  tabuleiro[i][j].setOcupada(true);
                  tabuleiro[i][j].setCorPeca(PRETO);
                  if(i==6){
                      tabuleiro[i][j].setPeca(Pecas.PEAO.ordinal());
                  }
              }
          }
          //brancas
          for (int i = 0; i < 2; i++) {
              for (int j = 0; j < 8; j++) {

              }
          }
      }

//      GETTERS & SETTERS


}
