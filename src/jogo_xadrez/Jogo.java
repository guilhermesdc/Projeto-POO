package jogo_xadrez;

import java.util.Scanner;

public class Jogo {
    //    ATRIBUTES
    public static final boolean BRANCO = true;
    public static final boolean PRETO = false;
    private final Jogador jBranco;
    private final Jogador jPreto;
    //trocar de public para private
    public final Tabuleiro tabuleiro;
    private boolean xeque = false;


//    CONTRUCTOR

    public Jogo(String nomeJ1, String nomeJ2) {
        jBranco = new Jogador(nomeJ1, BRANCO);
        jPreto = new Jogador(nomeJ2, PRETO);
        tabuleiro = new Tabuleiro();
        tabuleiro.colocarPecas();

//        ta no contrutor soh para fica mais facil por enquanto
//        recursivo
        jogada(jBranco);//jogador branco eh quem comeca o jogo
    }




//    METHODS
    private void jogada(Jogador j){
        //recursivo//

        if (xeque){ //so para a ide parar de enxer o saco com recursao infinita
            return;
        }

        Scanner in = new Scanner(System.in);
        Posição casaInicial;
        Posição casaFinal;

        System.out.println( j.getNome() + " Realize sua jogada:");

        System.out.print("Mover: ");
        casaInicial = converteCasa(in.nextLine());
        System.out.print("\nPara casa: ");
        casaFinal = converteCasa(in.nextLine());

        if(j.isCor() == BRANCO){
            jogada(jPreto);
        }
        else{
            jogada(jBranco);
        }

    }

    //converte a String de entrada do jogador em um objeto do tipo Posicao e verifica se a entrada eh valida
    private Posição converteCasa(String entrada){

        String colunas = "ABCDEFGH";
        int coluna = colunas.indexOf(entrada.charAt(0));
        //coluna = -1 se nn estiver em colunas
        System.out.println(coluna);
        int linha = Character.getNumericValue(entrada.charAt(1))-1;
//        if(linha>=8 || linha<0 || coluna<0){
//            return;
//        }
        return tabuleiro.getPosicao(linha, coluna);

    }

    //Verifica se a casa inicial eh valida
    private boolean pecaValida(Posição casa, boolean corJogador){
        if(!casa.isOcupada() || casa.isCorPeca() != corJogador){
            return false;
        }
        return true;
    }

    //Verifica se a casa destino eh valida
    private boolean destinoValido(Posição casa, boolean corJogador){
        if(casa.isOcupada() && casa.isCorPeca() == corJogador){
            return false;
        }
        return true;
    }



//    GETTERS & SETTERS


}
