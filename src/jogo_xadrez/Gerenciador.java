package jogo_xadrez;

import java.util.Scanner;


public class Gerenciador {

    public static void main(String[] args) {
        String nomeJogador1;
        String corJogador1;
        String nomeJogador2;

        Scanner in = new Scanner(System.in);
        System.out.println("Bem-vindo Jogadores!");
        System.out.print("Digite o nome do Jogador 1: ");
        nomeJogador1 = in.nextLine();
        System.out.print("\n "+ nomeJogador1+" digite B para escolher as pecas brancas, ou P para as pretas: ");
        corJogador1 = in.nextLine();
        System.out.print("\nDigite o nome do Jogador 2: ");
        nomeJogador2 = in.nextLine();

        if(corJogador1.equals("B")){
            Jogo jogo = new Jogo(nomeJogador1, nomeJogador2);
        }else{
            Jogo jogo = new Jogo(nomeJogador2, nomeJogador1);
        }


//        System.out.println(j1.nome);
//        System.out.println(j1.cor);
//        System.out.println(j2.nome);
//        System.out.println(j2.cor);
    }
}
