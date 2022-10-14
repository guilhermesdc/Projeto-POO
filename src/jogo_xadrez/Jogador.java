/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Jogador {

    private  final String nome;
    private  final boolean corJogador;
    public Peca[] pecas = new Peca[16];


    /*CONSTRUCTOR*/

    public Jogador(String nome, boolean cor, Peca[] array) {
         if ((nome == null || array == null) ||
             (nome.length() == 0 && array.length != 16)) {
            throw new IllegalArgumentException();
        }
        this.pecas = array;
        this.corJogador = cor;
        this.nome = nome;
    }



    /*GETTERS AND SETTERS*/

    public String getNome() {
        return nome;
    }

    public boolean isBranco() {
        return corJogador;
    }
}
