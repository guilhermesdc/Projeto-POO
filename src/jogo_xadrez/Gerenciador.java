/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

import java.io.IOException;
import java.util.Scanner;

public class Gerenciador {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            try {
                String nomeJogador1;
                String nomeJogador2;


                System.out.println("Bem-vindo Jogadores!\n");
                System.out.println("Jogador das pecas brancas, digite seu nome: ");
                nomeJogador1 = in.nextLine();
                while(nomeJogador1.length() == 0) {
                    System.out.println("Jogador das pecas brancas, favor Inserir um nome Valido");
                    nomeJogador1 = in.nextLine();
                }

                System.out.print("\nJogador das pecas pretas, digite seu nome: ");
                nomeJogador2 = in.nextLine();
                while(nomeJogador2.length() == 0) {
                    System.out.println("Jogador das pecas pretas, favor Inserir um nome Valido");
                    nomeJogador2 = in.nextLine();
                }

                Jogo jogo = new Jogo(nomeJogador1, nomeJogador2);
                jogo.iniciarJogo();
            }
            catch (IllegalArgumentException | IndexOutOfBoundsException e){
                System.out.println("Digite qualquer coisa para tentar novamente ou 'sair' para finalizar o programa\n");
                if (in.nextLine().equals("sair")) {
                    break;
                }
            }
        }
    }
}
