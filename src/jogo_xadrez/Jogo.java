package jogo_xadrez;

import java.util.Scanner;

public class Jogo {
    //    ATRIBUTES
    public static final boolean BRANCO = true;
    public static final boolean PRETO = false;
    private Jogador jBranco;
    private Jogador jPreto;
    private Tabuleiro tabuleiro;


//    CONTRUCTOR

    public Jogo(String nomeJ1, String nomeJ2) {
        jBranco = new Jogador(nomeJ1, BRANCO);
        jPreto = new Jogador(nomeJ2, PRETO);
        tabuleiro = new Tabuleiro();
        tabuleiro.colocarPecas();
        jogada(BRANCO);
    }


//    METHODS
    private void jogada(boolean corJogador){
        Scanner in = new Scanner(System.in);
        String casaInicial;
        String casaFinal;
        if(corJogador == BRANCO){
            System.out.println( jBranco.getNome() + " Realize sua jogada:");
        }
        else {
            System.out.println( jPreto.getNome() + " Realize sua jogada:");
        }
        System.out.print("Mover: ");
        casaInicial = in.nextLine();
        System.out.print("\nPara casa: ");
        casaFinal = in.nextLine();


        System.out.println(casaInicial);
        System.out.println(casaFinal);
        jogadaValida(casaInicial);


    }

    private void jogadaValida(String entrada){
        String[] colunas = {"A","B","C","D","E","F","G","H"};
        char coluna = entrada.charAt(0);
        //int colunaInt = colunas.indexOf(coluna);
        System.out.println(coluna);
        char linha = entrada.charAt(1);
        int linhaInt = Character.getNumericValue(linha)-1;
        if(this.tabuleiro.getPosicao(linhaInt, coluna)){
            System.out.println("Movimento invalido!");
        }
    }


//    GETTERS & SETTERS


}
