/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

    private Tabuleiro tabuleiro;

    private Jogador jogadorBranco;
    private Jogador jogadorPreto;
    private Jogador jogadorAtual;

    private final Peca[] pecasBrancas = new Peca[16];
    private final Peca[] pecasPretas = new Peca[16];

    /* ESTADOS */
    private boolean inicioJogo;
    private boolean xeque;
    private boolean xequeMate;

    ArrayList<String> entradasDoUsuario = new ArrayList();

    /*CONSTRUCTOR*/
    public Jogo(String nomeJ1, String nomeJ2) {
        try {
            if(nomeJ1.length() == 0 || nomeJ2.length() == 0) {
                throw new IllegalArgumentException();
            }
            
            iniciarPecas();

            tabuleiro = new Tabuleiro();

            // Jogador no primeiro argumento do construtor recebe a cor branca
            jogadorBranco = new Jogador(nomeJ1, true, pecasBrancas);
            jogadorPreto = new Jogador(nomeJ2, false, pecasPretas);
            jogadorAtual = jogadorBranco;

            // Jogador branco eh quem comeca o jogo
        }
        catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Ocorreu um erro ao iniciar jogo");
            throw e;
        }
    }

    /*METHODS*/

    private void jogada(Jogador j) {

        this.tabuleiro.desenho();

        //verificamos o estado do jogo no inicio da partida
        //verficamos em qual estado de jogo estamos (inicioJogo, xeque, xequeMate)
        gerenciaEstadoDoJogo();


        // Le a jogada
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                System.out.println( j.getNome() + ", realize sua jogada:");
                System.out.println("Mover peca na casa:");

                ///SALVAR JOGO
                String origem = in.nextLine();
                if(origem.equals("salvar")) {
                    salvarJogo();
                }

                while (!entradaValida(origem)) {
                    System.out.println("Formato da entrada invalido, favor inserir novamente.\n");
                    origem = in.nextLine();
                }

                // Entrada da casa que deseja mover sua peca
                System.out.println("Para a casa:");
                String destino = in.nextLine();
                while (!entradaValida(origem)) {
                    System.out.println("Formato da entrada invalido, favor inserir novamente.\n");
                    origem = in.nextLine();
                }
                StringBuilder msgErro = new StringBuilder("");
                // Verificao do movimento valido
                if(tabuleiro.movimentoValido(origem, destino, j.isBranco(), msgErro)) {
                    // Verifica se o caminho da peca esta livre ()
                    if(tabuleiro.caminhoValido(origem, destino)) {
                        // Mover a peca
                        tabuleiro.moverPeca(origem, destino);

                        //salva as entradas do usuario
                        entradasDoUsuario.add(origem);
                        entradasDoUsuario.add(destino);

                        break;
                    }
                    else {
                        System.out.println("Caminho para o movimento da peca encontra-se obstruido");
                        System.out.println("Favor inserir inserir o movimento novamente.\n");
                    }
                }
                else {
                    System.out.println(msgErro);
                    System.out.println("Favor inserir o movimento novamente.\n");
                }

            }
            catch (NullPointerException | IndexOutOfBoundsException e) {
                System.out.println("Ocorreu um erro na execucao.");
            }
        }

        /* se no comeco da rodada o jogador encontrava-se em xeque, e no final ele continuar em xeque
        /* significa que na proxima rodada seu rei sera capturado
        /* entao considera-se xeque-mate */
        if(xeque) {
            xeque = false;
            xequeMate = true;
            if(xeque(true) && j.isBranco()) {
                System.out.println("XEQUE-MATE NO REI BRANCO");
                System.exit(0);
            }
            else if(xeque(false) && !j.isBranco()) {
                System.out.println("XEQUE-MATE NO REI PRETO");
                System.exit(0);
            }
        }

        /* se o jogador se colocou em xeque
        /* na proxima rodada seu rei sera capturado
        /* entao considera-se xeque mate */
        if(inicioJogo)  {
            if(xeque(true) && j.isBranco()) {
                System.out.println(j.getNome() + ", colocou-se em xeque.");
                System.out.println("XEQUE-MATE NO REI BRANCO");
                System.exit(0);
            }
            if(xeque(false) && !j.isBranco()) {
                System.out.println(j.getNome() + ", colocou-se em xeque.");
                System.out.println("XEQUE-MATE NO REI PRETO");
                System.exit(0);
            }
        }

        // Se o jogador atual for o Branco, proxima jogada eh do preto
        if(j.isBranco()) {
            jogadorAtual = jogadorPreto;
            jogada(jogadorPreto);
        }
        // Se o jogador atual for o preto proxima jogada eh do branco
        else {
            jogadorAtual = jogadorBranco;
            jogada(jogadorBranco);
        }
    }

    private boolean xeque(boolean corRei)  {
        /*Verificamos se o rei da cor passada como parametro encontra-se em xeque*/
        if(tabuleiro.verificaXeque(corRei)){
            //atualizamos o estado dejogo
            inicioJogo = false;
            xeque = true;
            return true;
        }
        return false;
    }

    private void xequeMate(boolean corRei){
        /*Verificamos se o rei da cor passada como parametro encontra-se em xeque-mate*/
        if(tabuleiro.verificaXequeMate(corRei)){
            //atualizamos os estados
            xeque = false;
            xequeMate = true;
            //xeque-mate no rei branco
            if(corRei){
                System.out.println("XEQUE-MATE NO REI BRANCO");
            }
            //xeque-mate no rei preto
            else {
                System.out.println("XEQUE-MATE NO REI PRETO");
            }
            System.exit(0);
        }
    }

    private void iniciarPecas() {
        try {
            // Posicao do vetor de 0 a 7 sao peoes
            for (int i = 0; i < 8; i++) {
                //peoes brancos
                pecasBrancas[i] = new Peao(true);
                //peoes pretos
                pecasPretas[i] = new Peao(false);
            }
            //posicao do rei no vetor: 8
            //rei branco
            pecasBrancas[8] = new Rei(true);
            //rei preto
            pecasPretas[8] = new Rei(false);

            //posicao da dama no vetor: 9
            //dama branca
            pecasBrancas[9] = new Dama(true);
            //dama preta
            pecasPretas[9] = new Dama(false);

            //posicao dos bisbos no vetor: 10/11
            //bispos branco
            pecasBrancas[10] = new Bispo(true);
            pecasBrancas[11] = new Bispo(true);
            //bispos pretos
            pecasPretas[10] = new Bispo(false);
            pecasPretas[11] = new Bispo(false);

            //posicao das torres no vetor: 12/13
            //torres brancas
            pecasBrancas[12] = new Torre(true);
            pecasBrancas[13] = new Torre(true);
            //torres pretas
            pecasPretas[12] = new Torre(false);
            pecasPretas[13] = new Torre(false);

            //posicao dos cavalos no vetor: 14/15
            //cavalos brancos
            pecasBrancas[14] = new Cavalo(true);
            pecasBrancas[15] = new Cavalo(true);
            //cavalos pretos
            pecasPretas[14] = new Cavalo(false);
            pecasPretas[15] = new Cavalo(false);
        }
        catch (IndexOutOfBoundsException | NullPointerException e) {
            throw e;
        }

    }

    private boolean entradaValida(String entrada) {
        try {
            // Verifica-se a entrada tem tamanho 2 (coluna e linha)
            if(entrada.length() != 2) {
                return false;
            }

            // Tenta transformar a entrada em um char e um int respectivamente
            char coluna = entrada.charAt(0);
            //transforma a letra em maiuscula
            coluna = Character.toUpperCase(coluna);

            //verifica se a coluna eh uma letra
            if(coluna < 'A' || coluna > 'Z') {
                return false;
            }

            int linha = Character.getNumericValue(entrada.charAt(1));
            //verifica se a linha eh um numero
            if(linha < 0 || linha > 9) {
                return false;
            }
            return true;
        }
        catch (StringIndexOutOfBoundsException | NullPointerException e) {
            return false;
        }
    }

    public void iniciarJogo() {
        try {
            inicioJogo = true;
            xeque = false;
            xequeMate = false;

            //colocamos as pecas em jogo
            for (int i = 0; i < 16; i++) {
                pecasBrancas[i].setEmJogo(true);
                pecasPretas[i].setEmJogo(true);
            }
            tabuleiro.colocarPecas(pecasBrancas, pecasPretas);

            System.out.println("\nDeseja carregar um jogo em andamento?");
            System.out.println("Digite 's' para confirmar, e qualquer outra tecla para criar um novo jogo.");
            Scanner in = new Scanner(System.in);

            //carregamos um jogo salvo, e o rodamos
            if(in.nextLine().equals("s")){
                boolean carregado = carregarJogo();
                boolean jogoValido = jogadaCarregada(jogadorAtual, 0);
                //se nao for possivel carrega-lo iniciamos o jogo novamente
                if(!carregado || !jogoValido) {
                    //limpanos a entrada do arquivo invalido
                    entradasDoUsuario.clear();
                    jogadorAtual = jogadorBranco; //jogador inicial volta a ser o branco
                    iniciarJogo();
                    return;
                }

            }
            System.out.println("Para salvar o jogo a qualquer momento digite 'salvar' em sua jogada.");
            jogada(jogadorAtual);
        }
        catch(IndexOutOfBoundsException | NullPointerException | IllegalArgumentException e) {
            System.out.println("Nao foi possivel inicializar o jogo!");
            throw e;
        }
    }

    private void gerenciaEstadoDoJogo() {
        //vericamos o xeque no rei branco
        if(xeque(true)) {
           //se o rei branco esta em xeque, verifica-se se esta em xeque mate
            xequeMate(true);
            System.out.println("REI BRANCO EM XEQUE");
        }

        //vericamos o xeque no rei preto
        if(xeque(false)) {
            //se o rei preto esta em xeque, verifica-se se esta em xeque mate
            xequeMate(false);
            System.out.println("REI PRETO EM XEQUE");
        }

        //se nenhum rei esta em xeque, estamos no estado de jogo Inicio de jogo
        if(!xeque(true) && !xeque(false)) {
            inicioJogo = true;
            xeque = false;
        }
    }

    private void salvarJogo() {
        try {

            //recebemos o nome do arquivo no qual o jogador deseja salvar o jogo
            Scanner in = new Scanner(System.in);
            System.out.println("Digite o nome do arquivo.txt em que deseja salvar");
            System.out.println("Um arquivo ja existente sera sobrescrito");
            String nomeArquivo = in.nextLine();

            //verificamos se eh um arquivo do tipo txt
            if(!nomeArquivo.contains(".txt")) {
                if(nomeArquivo.contains(".")) {//se o qrquivo eh de outra extencao
                    throw new IllegalArgumentException();
                }
                nomeArquivo = nomeArquivo + ".txt"; // caso o jogador nao tenha adcionado a extencao, adcionamos para ele
            }

            //cramos ao arquivo
            File arquivo = new File(nomeArquivo);
            //se o arquivo nao existe criamos um novo arquivo
            if (!arquivo.exists()) { //arquivo nao existe
                arquivo.createNewFile(); //cria-se um arquivo com o nome passados, neste diretorio
                System.out.println(arquivo.getName() + " criado.");
            }
            //caso o arquivo ja exista o sobreescrevemos
            FileWriter file = new FileWriter(arquivo.getName());

            //copiamos as entradas dos usuarios no arquivo
            for (String entradas : entradasDoUsuario) {
                file.write(entradas.toString()+"\n");
            }
            //fechamos o arquivo
            file.close();

            System.out.println("Arquivo:" + arquivo.getName() + " gravado com Sucesso");
            //encerramos o jogo
            System.exit(0);

        }
        catch (IOException | IllegalArgumentException e){
            System.out.println("Nao foi possivel salvar o jogo!");
        }
    }

    private boolean carregarJogo(){
        try {
            //recebemos o nome do arquivo que iremos carregar
            Scanner in = new Scanner(System.in);
            System.out.println("Digite o nome do arquivo de texto que deseja carregar:");
            String nomeArquivo = in.nextLine();

            //verificamos a extensao do arquivo
            if(!nomeArquivo.contains(".txt")) {
                if(nomeArquivo.contains(".")) {
                    throw new IllegalArgumentException("Formato de arquivo Invalido");
                }
                nomeArquivo = nomeArquivo + ".txt"; // se o jogador nao colocou a extenso .txt, fazemos por ele
            }

            //abrimos o arquivo para leitura
            FileReader arquivo = new FileReader(nomeArquivo);

            BufferedReader leitor = new BufferedReader(arquivo);
            String linha = leitor.readLine();
            //lemos as linhas do arquivo e salvamos na arraylista de entradas do usuario
            while(linha != null) {
                entradasDoUsuario.add(linha);
                linha = leitor.readLine();
            }
            //fechamos o arquivo
            arquivo.close();
            leitor.close();
            return true;

        }
        catch (IOException e) {
            System.out.println("Arquivo nao encontrado!");
            return false;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean jogadaCarregada(Jogador j, int idxEntrada) {
        //caso base da recursao - todas as jogadas ja foram lidas
        if(idxEntrada >= entradasDoUsuario.size()) {
            return true;
        }
        //verificamos o estado do jogo no inicio da partida
        //verficamos em qual estado de jogo estamos (inicioJogo, xeque, xequeMate)
        gerenciaEstadoDoJogo();


        // Le a jogada
        while(true) {
            try {
                //recebemos a linha de entrada na array lista com as jogadas salvas
                String origem = entradasDoUsuario.get(idxEntrada);
                String destino = entradasDoUsuario.get(idxEntrada+1);

                //verificamos se as linhas de entrada sao validas
                if (!entradaValida(origem) || !entradaValida(origem)) {
                    throw new IllegalArgumentException();
                }

                StringBuilder msgErro = new StringBuilder("");
                // Verificao do movimento valido
                if(tabuleiro.movimentoValido(origem, destino, j.isBranco(), msgErro)) {
                    // Verifica se o caminho da peca esta livre ()
                    if(tabuleiro.caminhoValido(origem, destino)) {
                        // Mover a peca
                        tabuleiro.moverPeca(origem, destino);
                        break;
                    }
                    else{
                        //movimento invalido
                        throw new IllegalArgumentException();
                    }
                }
                else {
                    //movimento invalido
                    throw new IllegalArgumentException();
                }
            }
            catch (NullPointerException | IndexOutOfBoundsException | IllegalArgumentException e) {

                System.out.println("Arquivo corrompido, impossivel fazer a leitura.");
                return false;
            }

        }

        // Se o jogador atual for o Branco, proxima jogada eh do preto
        if(j.isBranco()) {
            jogadorAtual = jogadorPreto;
            return jogadaCarregada(jogadorPreto, idxEntrada+2);
        }
        // Se o jogador atual for o preto proxima jogada eh do branco
        else {
            jogadorAtual = jogadorBranco;
            return jogadaCarregada(jogadorBranco, idxEntrada+2);
        }

    }

}
