package jogo_xadrez;

public class Tabuleiro {
      //      ATRIBUTES
      private static final char[] colunas = {'a','b','c','d','e','f','g','h'};
      private int[][] tabuleiro = new int[8][8];


//      CONTRUCTOR


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


//      GETTERS & SETTERS


}
