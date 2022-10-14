/* UFSCar-Sorocaba
 *  Ciencia da Computacao
 *  Programacao Orientada a Objeto
 * Guilherme Camargo - 792183
 * Maria Anita de Moura - 790084
 */
package jogo_xadrez;

public class Tabuleiro {
    private static final int TAM = 8; //tamanho de cada linha e cada coluna
    private final Posicao[][] arrayPosicao = new Posicao[TAM][TAM];  //matriz com cada posicao do tabuleiro

    /* CONTRUCTOR */

    /*Cria as 64 pecas do tabuleiro*/
    public Tabuleiro() {
        try {
            for (int linha = 0; linha < TAM; linha++) {
                for (int coluna = 0; coluna < TAM; coluna++) {
                    /*Preto*/
                    if ((linha % 2 == 0 && coluna % 2 == 0) || (linha % 2 == 1 && coluna % 2 == 1)) {
                        arrayPosicao[linha][coluna] = new Posicao(linha + 1, parseColuna(coluna), false);
                    }
                    /*Branco*/
                    else {
                        arrayPosicao[linha][coluna] = new Posicao(linha + 1, parseColuna(coluna), true);
                    }
                }
            }
        }
        catch(IllegalArgumentException | IndexOutOfBoundsException e) {
            throw e;
        }
    }

    /* METHODS */

    public void desenho() {
        try{

            //indice das colunas
            System.out.println("         A        B        C        D        E        F        G        H       ");
            System.out.println();
            for (int i = TAM-1; i >= 0; i--) {

                /*A coluna comeca com uma casa branca*/
                if (i % 2 == 1) {
                    //coluna externa
                    System.out.println("              *********         *********         *********         *********");
                    //numeracao da linha
                    System.out.printf("%d    ", i+1);
                    //coluna interna contendo a peca ou nao
                    for (int j = 0; j < TAM; j++) {
                        int linha = arrayPosicao[i][j].getLinha();
                        int coluna = parseColuna(arrayPosicao[i][j].getColuna());
                        // casa esta vazia
                        if(!arrayPosicao[i][j].isOcupada()) {
                            // cor da casa eh preta
                            if((linha - 1) % 2  ==  coluna % 2) {
                                System.out.print("*********");                        }
                            // cor da casa eh branca
                            else {
                                System.out.print("         ");
                            }
                        }
                        //casa possui peca
                        else {
                            char simbolo = arrayPosicao[i][j].getPeca().desenho();
                            // cor da casa eh preta
                            if((linha - 1) % 2  ==  coluna % 2) {
                                System.out.print("*** "+simbolo+" ***");
                            }
                            // cor da casa eh branca
                            else {
                                System.out.print("    "+simbolo+"    ");
                            }
                        }
                    }
                    //numeracao da linha
                    System.out.printf("    %d", i+1);
                    System.out.println();
                    //coluna externa
                    System.out.println("              *********         *********         *********         *********");
                }

                /*A coluna comeca com uma casa preta*/
                else {
                    //coluna externa
                    System.out.println("     *********         *********         *********         *********         ");
                    //numeracao da linha
                    System.out.printf("%d    ", i+1);
                    //coluna interna contendo a peca ou nao
                    for (int j = 0; j < TAM; j++) {
                        int linha = arrayPosicao[i][j].getLinha();
                        int coluna = parseColuna(arrayPosicao[i][j].getColuna());

                        if(!arrayPosicao[i][j].isOcupada()) {
                            // cor da casa eh preta
                            if((linha - 1) % 2  ==  coluna % 2) {
                                System.out.print("*********");
                            }
                            // cor da casa eh branca
                            else {
                                System.out.print("         ");
                            }
                        }
                        else {
                            char simbolo = arrayPosicao[i][j].getPeca().desenho();
                            // cor da casa eh preta
                            if((linha - 1) % 2  ==  coluna % 2) {
                                System.out.print("*** "+simbolo+" ***");
                            }
                            // cor da casa eh branca
                            else {
                                System.out.print("    "+simbolo+"    ");
                            }
                        }
                    }
                    //numeracao da linha
                    System.out.printf("    %d", i+1);
                    System.out.println();
                    //coluna externa
                    System.out.println("     *********         *********         *********         *********         ");
                }
            }
            System.out.println();
            //indice das colunas
            System.out.println("         A        B        C        D        E        F        G        H       ");
        }
        catch (IndexOutOfBoundsException | NullPointerException e) {
            throw e;
        }
    }

    /*Coloca todas as pecas nas posicoes iniciais do jogo*/
    public void colocarPecas(Peca[] arrayBranco, Peca[] arrayPreto) {
        try {
            //peoes e casa vazias
            for (int linha = 0; linha < TAM; linha++) {
                for (char coluna = 0; coluna < TAM; coluna++) {
                    if(linha == 1) {
                        //para a linha 1 do tabuleiro colocar os peoes brancos
                        arrayPosicao[linha][coluna].setPeca(arrayBranco[coluna]);
                    }
                    else if(linha == 6) {
                        //para a linha 6 do tabuleiro colocar os peaos pretos
                        arrayPosicao[linha][coluna].setPeca(arrayPreto[coluna]);
                    }
                    //para as demais linhas, peca recebe null
                    else {
                        arrayPosicao[linha][coluna].setPeca(null);
                    }
                }
            }
            
            //BRANCOS  -- linha 1(0 na matrix do tabuleiro)
            //torre
            arrayPosicao[0][parseColuna('A')].setPeca(arrayBranco[12]);
            arrayPosicao[0][parseColuna('H')].setPeca(arrayBranco[13]);

            //cavalo
            arrayPosicao[0][parseColuna('B')].setPeca(arrayBranco[14]);
            arrayPosicao[0][parseColuna('G')].setPeca(arrayBranco[15]);

            //bispo
            arrayPosicao[0][parseColuna('C')].setPeca(arrayBranco[10]);
            arrayPosicao[0][parseColuna('F')].setPeca(arrayBranco[11]);

            //rainha
            arrayPosicao[0][parseColuna('D')].setPeca(arrayBranco[9]);

            //rei
            arrayPosicao[0][parseColuna('E')].setPeca(arrayBranco[8]);

            //PRETOS

            //torre
            arrayPosicao[7][parseColuna('A')].setPeca(arrayPreto[12]);
            arrayPosicao[7][parseColuna('H')].setPeca(arrayPreto[13]);

            //cavalo
            arrayPosicao[7][parseColuna('B')].setPeca(arrayPreto[14]);
            arrayPosicao[7][parseColuna('G')].setPeca(arrayPreto[15]);

            //bispo
            arrayPosicao[7][parseColuna('C')].setPeca(arrayPreto[10]);
            arrayPosicao[7][parseColuna('F')].setPeca(arrayPreto[11]);

            //rainha
            arrayPosicao[7][parseColuna('D')].setPeca(arrayPreto[9]);

            //rei
            arrayPosicao[7][parseColuna('E')].setPeca(arrayPreto[8]);
        }
        catch (IndexOutOfBoundsException | NullPointerException | IllegalArgumentException e) {
            throw e;
        }
    }

    /*Metodos para a verificacao de Movimento*/

    //recebe duas Strings como entrada -- uso na classe Jogo
    public boolean movimentoValido(String origem, String destino, boolean corJogador, StringBuilder msgErro)
    {
        try {
            //recebe a string e verifica se a casa esta dentro dos limites do tabuleiro
            Posicao pOrigem = converteCasa(origem);
            Posicao pDestino = converteCasa(destino);

            //Posicao de origem possui uma peca do jogador
            if(!pecaValida(pOrigem, corJogador)) {
                msgErro.append("Você nao possui uma peca nessa posicao.");
                return false;
            }
            //Posicao de destino nao possui uma peca do proprio jogador
            if(!destinoValido(pDestino, corJogador)) {
                msgErro.append("Posicao de destino já se encontra ocupada por uma peca sua.");
                return false;
            }

            if(pOrigem.getPeca().getClass().getSimpleName().equals("Peao")) {
                if(pDestino.isOcupada()) {
                    ((Peao)pOrigem.getPeca()).setCasaDestinoOcupada(true);
                }
                else {
                    ((Peao)pOrigem.getPeca()).setCasaDestinoOcupada(false);
                }
            }
            //verifica se a peca pode realizar este movimento
            if(!pOrigem.getPeca().checaMovimento(pOrigem.getLinha(), pOrigem.getColuna() , pDestino.getLinha(), pDestino.getColuna())) {
               msgErro.append(pOrigem.getPeca().getClass().getSimpleName() + " " +
                       "nao pode realizar esse movimento");
                return false;
            }
            //rever essa parte
            else {
                if(pOrigem.getPeca().getClass().getSimpleName().equals("Peao")) {
                    ((Peao)pOrigem.getPeca()).moveu();
                }
                return true;
            }
        }
        catch (NullPointerException | IndexOutOfBoundsException | IllegalArgumentException e) {
            msgErro.append("Posicao inexistente");
           return false;
        }
    }

    //recebe 2 Posicoes como entrada -- uso na classe Tabuleiro
    private boolean movimentoValido(Posicao pOrigem, Posicao pDestino, boolean corJogador) {
        try {
            //Posicao de origem possui uma peca do jogador
            if(!pecaValida(pOrigem, corJogador)) {
                return false;
            }
            //Posicao de destino nao possui uma peca do proprio jogador
            if(!destinoValido(pDestino, corJogador)) {
                return false;
            }

            if(pOrigem.getPeca().getClass().getSimpleName().equals("Peao")) {
                if(pDestino.isOcupada()) {
                    ((Peao)pOrigem.getPeca()).setCasaDestinoOcupada(true);
                }
                else {
                    ((Peao)pOrigem.getPeca()).setCasaDestinoOcupada(false);
                }
            }
            //verifica se a peca pode realizar este movimento
            if(!pOrigem.getPeca().checaMovimento(pOrigem.getLinha(), pOrigem.getColuna() , pDestino.getLinha(), pDestino.getColuna())) {
                return false;
            }
            //rever essa parte
            else {
                if(pOrigem.getPeca().getClass().getSimpleName().equals("Peao")) {
                    ((Peao)pOrigem.getPeca()).moveu();
                }
                return true;
            }
        }
        catch (NullPointerException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public void moverPeca(String origem, String destino) {
        try{
            Posicao pOrigem = converteCasa(origem);
            Posicao pDestino = converteCasa(destino);

            Peca p = pOrigem.getPeca();
            //antiga posicao fica vazia
            pOrigem.setPeca(null);
            if(pDestino.isOcupada()) {
                //se havia uma peca na posicoa destino, seu estado atual esta fora do jogo
                pDestino.getPeca().setEmJogo(false);
            }
            //colocamos a peca de origem em sua nova posicao
            pDestino.setPeca(p);
        }
        catch (NullPointerException | IndexOutOfBoundsException e) {
            throw e;
        }
    }

    /*Converte Entrada do jogador em um objeto Posicao retorna nulo de a entrada for invalida*/
    private Posicao converteCasa(String entrada) {
       try {
           if(entrada.length() != 2) {
               throw new IllegalArgumentException();
           }
            char coluna = entrada.charAt(0);
            coluna = Character.toUpperCase(coluna);

            int linha = Character.getNumericValue(entrada.charAt(1));

            if((coluna < 'A' || coluna > 'H') || (linha < 1 || linha > 8)) {
                throw new IllegalArgumentException();
            }
            return this.obterPosicao(linha, parseColuna(coluna));
       }
       catch (IndexOutOfBoundsException | IllegalArgumentException | NullPointerException e) {
            throw e;
       }
    }

    /*Verifica se a casa inicial é valida*/
    private boolean pecaValida(Posicao casa, boolean corJogador) {
        /*Jogador tentar mover uma peca que nao existe, ou a peca do outro jogador*/
        try {
            if(!casa.isOcupada() || casa.getPeca().getColor() != corJogador) {
                return false;
            }
            return true;
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    /*Verifica se a casa destino é valida*/
    private boolean destinoValido(Posicao casa, boolean corJogador) {
        /*Jogador tentar mover sua peca para uma casa que ja possua uma peca sua*/
        //Jogador tenta mover sua peca para a sua propria peca
        try {
            if(casa.isOcupada() && casa.getPeca().getColor() == corJogador) {
               return false;
            }
            return true;
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    /* recebe string como parametro */
    public boolean caminhoValido(String pOrigem, String pDestino) {
        try {
            Posicao origem = converteCasa(pOrigem);
            Posicao destino = converteCasa(pDestino);

            char desenhoPeca = origem.getPeca().desenho();
            //cavalo pode pular pecas e peao e rei so andam uma casa
            if(origem.getPeca().getClass().getSimpleName().equals("Cavalo") ||
                    origem.getPeca().getClass().getSimpleName().equals("Rei")) {
                return true;
            }

            //movimento horizontal
            if(destino.getLinha() == origem.getLinha()) {
                //quando o destino eh maior do que a origem
                if (destino.getColuna() > origem.getColuna()) {
                    for (int i = origem.getColuna() + 1; i < destino.getColuna(); i++) {
                        if (obterPosicao(origem.getLinha(), parseColuna((char)i) ).isOcupada()) {
                            return false;
                        }
                    }
                }
                //quando a origem for maior do que o destino
                else {
                    for (int i = origem.getColuna() - 1; i > destino.getColuna(); i--) {
                        if (obterPosicao(origem.getLinha(), parseColuna((char) i) ).isOcupada()) {
                            return false;
                        }
                    }
                }
            }

            //movimento vertical
            else if(destino.getColuna() == origem.getColuna()) {
                //quando o destino eé maior do que a origem
                if(destino.getLinha() > origem.getLinha()) {
                    for (int i = origem.getLinha() + 1; i < destino.getLinha(); i++) {
                        if (obterPosicao(i, parseColuna(origem.getColuna()) ).isOcupada()) {
                            return false;
                        }
                    }
                }
                else{
                    //quando a origem for maior do que o destino
                    for (int i = origem.getLinha()-1; i > destino.getLinha(); i--) {
                        if(obterPosicao(i, parseColuna(origem.getColuna()) ).isOcupada()) {
                            return false;
                        }
                    }
                }
            }

            //movimento diagonal
            else{
                //diferenca entre a linha de destino e a de origem
                int diferenca = Math.abs(destino.getLinha() - origem.getLinha());

                //se a linha e coluna destino forem maiores do que a de origem
                if(destino.getLinha() > origem.getLinha() && destino.getColuna() > origem.getColuna()) {
                    //percorre-se a mesma distancia da vertical e na horizonta a partir da casa inicial
                    for(int i = 1; i < diferenca; i++) {
                        int indiceColuna = parseColuna(origem.getColuna()) + i;
                        if(obterPosicao(origem.getLinha() + i , indiceColuna).isOcupada()) {
                            return false;
                        }
                    }
                }
                //se a linha de destino for maior e a coluna menor
                else if(destino.getLinha() > origem.getLinha() && destino.getColuna() < origem.getColuna()) {
                    //percorre-se a mesma distancia da vertical e na horizonta a partir da casa inicial
                    for(int i = 1; i < diferenca; i++) {
                        int indiceColuna = parseColuna(origem.getColuna()) - i;
                        if(obterPosicao(origem.getLinha() + i , indiceColuna).isOcupada()) {
                            return false;
                        }
                    }

                }
                //se a linha de destino for menor e a coluna maior
                else if(destino.getLinha() < origem.getLinha() && destino.getColuna() > origem.getColuna()) {
                    //percorre-se a mesma distancia da vertical e na horizonta a partir da casa inicial
                    for(int i = 1; i < diferenca; i++) {
                        int indiceColuna = parseColuna(origem.getColuna()) + i;
                        if(obterPosicao(origem.getLinha() - i , indiceColuna).isOcupada()) {
                            return false;
                        }
                    }
                }
                //se a linha de destino for menor e a coluna menor
                else {
                    for(int i = 1; i < diferenca; i++) {
                        //percorre-se a mesma distancia da vertical e na horizonta a partir da casa inicial
                        int indiceColuna = parseColuna(origem.getColuna()) - i;
                        if(obterPosicao(origem.getLinha() - i , indiceColuna).isOcupada()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        catch (IllegalArgumentException | IndexOutOfBoundsException  | NullPointerException e){
            return false;
        }
    }

    //recebe Posicao como parametro
    private boolean caminhoValido(Posicao origem, Posicao destino) {
        try {
            char desenhoPeca = origem.getPeca().desenho();
            //cavalo pode pular pecas e peao e  rei so andam uma casa
            if(desenhoPeca == 'c' || desenhoPeca == 'r' || desenhoPeca == 'C'|| desenhoPeca == 'R') {
                return true;
            }

            //movimento horizontal
            if(destino.getLinha() == origem.getLinha()) {
                //quando o destino eh maior do que a origem
                if (destino.getColuna() > origem.getColuna()) {
                    for (int i = origem.getColuna() + 1; i < destino.getColuna(); i++) {
                        if (obterPosicao(origem.getLinha(), parseColuna((char)i) ).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
                //quando a origem for maior do que o destino
                else {
                    for (int i = origem.getColuna() - 1; i > destino.getColuna(); i--) {
                        if (obterPosicao(origem.getLinha(), parseColuna((char)i) ).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            //movimento vertical
            else if(destino.getColuna() == origem.getColuna()) {
                //quando o destino eh maior do que a origem
                if(destino.getLinha() > origem.getLinha()) {
                    for (int i = origem.getLinha() + 1; i < destino.getLinha(); i++) {
                        if (obterPosicao(i, parseColuna(origem.getColuna()) ).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
                else{
                    //quando a origem for maior do que o destino
                    for (int i = origem.getLinha()-1; i > destino.getLinha(); i--) {
                        if(obterPosicao(i, parseColuna(origem.getColuna()) ).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            //movimento diagonal
            //a distancia entre a o destino e a origem devem ser as mesmas tanto para linha quanto para cluna
            else if(Math.abs(destino.getLinha() - origem.getLinha()) == Math.abs(destino.getColuna() - origem.getColuna())){

                //diferenca entre a linha de destino e a de origem
                int diferenca = Math.abs(destino.getLinha() - origem.getLinha());

                //se a linha e coluna destino forem maiores do que a de origem
                if(destino.getLinha() > origem.getLinha() && destino.getColuna() > origem.getColuna()) {
                    //percorre-se a mesma distancia da vertical e na horizonta a partir da casa inicial
                    for(int i = 1; i < diferenca; i++) {
                        int indiceColuna = parseColuna(origem.getColuna()) + i;
                        if(obterPosicao(origem.getLinha() + i, indiceColuna).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
                //se a linha de destino for maior e a coluna menor
                else if(destino.getLinha() > origem.getLinha() && destino.getColuna() < origem.getColuna()) {
                    //percorre-se a mesma distancia da vertical e na horizontal a partir da casa inicial
                    for(int i = 1; i < diferenca; i++) {
                        int indiceColuna = parseColuna(origem.getColuna()) - i;
                        if(obterPosicao(origem.getLinha() + i , indiceColuna ).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
                //se a linha de destino for menor e a coluna maior
                else if(destino.getLinha() < origem.getLinha() && destino.getColuna() > origem.getColuna()) {
                    //percorre-se a mesma distancia da vertical e na horizontal a partir da casa inicial
                    for(int i = 1; i < diferenca; i++) {
                        int indiceColuna = parseColuna(origem.getColuna()) + i;
                        if(obterPosicao(origem.getLinha() - i , indiceColuna ).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
                //se a linha de destino for menor e a coluna menor
                else {
                    for(int i = 1; i < diferenca; i++) {
                        //percorre-se a mesma distancia da vertical e na horizontal a partir da casa inicial
                        int indiceColuna = parseColuna(origem.getColuna()) - i;
                        if(obterPosicao(origem.getLinha() - i , indiceColuna ).isOcupada()) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            else {
                return false;
            }
        }
        catch (IllegalArgumentException | IndexOutOfBoundsException  | NullPointerException e){
            return false;
        }

    }

    /* Metodos para fazer a  cheacagem de Xeque e Xeque Mate*/

    public boolean verificaXeque(boolean corRei) {

        try {
            /*Obtemos a posicao do rei de uma cor*/
            Posicao posicaoRei = obterPosicaoRei(corRei);

            /*verifica-se  se alguma peca possui movimento valido para capturar o rei inimigo*/
            /* Caso possua o movimento valido, o rei encontra-se em xeque*/
            return posicaoPodeSerOcupada(posicaoRei, corRei);
        }
        catch (IndexOutOfBoundsException | NullPointerException e) {
            return false;
        }


    }

    public boolean verificaXequeMate(boolean corRei){
        try {
            /*Adquirimos a posicao atual do rei*/
            Posicao posicaoRei = obterPosicaoRei(corRei);

            Posicao pecaAtacante = null;

            /*verifica-se quantas pecas possui movimento livre para capturar o rei inimigo*/
            int qtdPecasAgressivas = qtdPecasAtacantes(posicaoRei, corRei);

            /*Se mais de 1 peca pode capturar o rei, isso significa que a unica forma dele escapar eh de movendo*/
            /*Pois outra pecas nao pode interpor dois caminho ou comer duas pecas*/
            if(qtdPecasAgressivas > 1) {
                /*Verificamos se o rei pode se mover para um posicao segura*/
                /*se o rei pode escapar se movendo, ele nao esta em xeque-mate*/
                return !escapeRei(posicaoRei, corRei);
            }

            /*se apenas uma peca estiver ameacando o rei ele pode sair de xeque de 3 formas:*/
            //1 comendo a peca
            //2 alguma outra peca entrando na frente
            //3 movendo o rei

            else if(qtdPecasAgressivas == 1) {
                /*Obtemos a posicao da peca que ameaca o rei*/
                pecaAtacante = obterPosicaoPecaAtacante(posicaoRei);
                /*1: se alguma peca pode capturar a peca atacante, tirando a de jogo*/
                if(posicaoPodeSerOcupada(pecaAtacante, !corRei)) {
                    /*Se a peca pode ser capturada o rei nao esta em xeque*/
                    return false;
                }

                /*2: se alguma peca pode se interpor no caminho da peca atacante ao rei, impedindo que esta chegue ao rei*/
                /*Verifica-se cada uma das pecas da cor do rei, se alguma delas pode se interpor no caminho*/
                if(pecaPodeInterpor(pecaAtacante)) {
                    /*de alguma peca pode se interpor, o rei nao esta em xeque-mate*/
                    return false;
                }

                /*3: O rei pode se movimentar para escapar da captura*/
                /*Vericamos se o rei pode fazer algum movimento valido  para o tirar de xeque*/
                if(escapeRei(posicaoRei, corRei)) {
                    /*Se o rei pode sair da posicao, ele nao esta em xeque*/
                    return false;
                }
            }
            /*Caso o rei nao consiga sair do xeque, ele esta em xeque mate*/
            return true;
        }
        catch (NullPointerException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    /*Adquirimos a posicao em que o rei se encontra*/
    private Posicao obterPosicaoRei(boolean corRei) {
        try {
            //adquire a posicao do rei percorrendo o tabuleiro
            Posicao pAtual;
            for (int linha = 1; linha <= TAM; linha++) {
                for (int coluna = 0; coluna < TAM; coluna++) {
                    // pAtual recebe a posicao atual
                    pAtual = obterPosicao(linha, coluna);
                    //verifica-se se possui uma peca nessa posicao, e se essa peca eh um rei da cor selecionada
                    if(pAtual.isOcupada() && pAtual.getPeca().getColor() == corRei
                        && pAtual.getPeca().getClass().getSimpleName().equals("Rei")) {
                        //retorna posicao do rei
                        return pAtual;
                    }
                }
            }
            return null;
        }
        catch (IndexOutOfBoundsException | NullPointerException e) {
            throw e;
        }
    }

    //Verificamos se uma posicao pode ser ocupada
    private boolean posicaoPodeSerOcupada(Posicao posicaoVerificada, boolean corAtacante){
        try {
            Posicao pAtual;
            for (int linha = 1; linha <= TAM; linha++) {
                for (int coluna = 0; coluna < TAM; coluna++) {
                    //posicao atual no tabuleiro
                    pAtual = obterPosicao(linha, coluna);

                    //verifica-se se há uma peca
                    if(pAtual.isOcupada()) {
                        //verificamos se a peca é inimiga da peca atacante
                        if(pAtual.getPeca().getColor() != corAtacante  ) {
                            //verificamos se a peca nao é o rei, pois ele nao pode interpor o proprio caminho
                            if(!pAtual.getPeca().getClass().getSimpleName().equals("Rei")) {
                                if(movimentoValido(pAtual, posicaoVerificada, !corAtacante )
                                        && caminhoValido(pAtual, posicaoVerificada)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        catch(NullPointerException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    /*Calculamos quantas pecas podem capturar uma peca ou posicao */
    private int qtdPecasAtacantes(Posicao pecaACapturar, boolean corPecaACapturar) {
        try {
            /*Iniciamos a quantidade de pecas que podem capturar o rei com 0*/
            int qtdPecasAgressivas = 0;
            /*cor da peca a ser capturada*/
            boolean corCapturada = pecaACapturar.getPeca().getColor();
            Posicao pAtual;
            /*Percorremos todo o tabuleiro em busca de pecas que podem capturar o rei*/
            for (int linha = 1; linha <= TAM; linha++) {
                for (int coluna = 0; coluna < TAM; coluna++) {
                    //posicao atual no tabuleiro
                    pAtual = obterPosicao(linha, coluna);

                    /*verifica-se se ha uma peca na posicao*/
                    if(pAtual.isOcupada()) {
                        /*a cor da peca na posicao deve ser oposta a cor que queremos capturar*/
                        if(pAtual.getPeca().getColor() != corCapturada) {
                            /*Verifica-se se a peca inimica pode capturar a peca em questao*/
                            if(movimentoValido(pAtual, pecaACapturar, !corCapturada)
                                    && caminhoValido(pAtual, pecaACapturar)) {
                                /*imcrementamos a quantidade de pecas que podem capturar a peca em questao e 1*/
                                qtdPecasAgressivas++;
                            }
                        }
                    }
                }
            }
            /*Retornamos a quantidade de pecas que podem capturar um peca*/
            return qtdPecasAgressivas;
        }
        catch (NullPointerException | IndexOutOfBoundsException e) {
            throw e;
        }

    }

    /*Obtemos a posicao da peca que ameaca uma determinada posicao*/
    private Posicao obterPosicaoPecaAtacante(Posicao pecaACapturar) {
        try {
            /*cor da peca que queremos capturar*/
            boolean corPecaACapturar = pecaACapturar.getPeca().getColor();
            /*Percorremos o tabuleiro em busca da posicao da peca que coloca o rei em xeque*/
            Posicao pAtual;
            for (int linha = 1; linha <= 8; linha++) {
                for (int coluna = 0; coluna < 8; coluna++) {
                    //posicao atual no tabuleiro
                    pAtual = obterPosicao(linha, coluna);

                    /*verifica-se se ha uma peca na posicao*/
                    if(pAtual.isOcupada()) {
                        /*a cor da peca na posicao deve ser oposta a cor que queremos capturar*/
                        if(pAtual.getPeca().getColor() != corPecaACapturar) {
                            /*verifica-se se a peca tem movimento valido ate o peca ameacada*/
                            if(movimentoValido(pAtual, pecaACapturar, !corPecaACapturar) && caminhoValido(pAtual, pecaACapturar)) {
                                /*se possui movimento valido, retorna-se su posicao*/
                                return pAtual;
                            }
                        }
                    }
                }
            }
            return null;
        }
        catch (NullPointerException | IndexOutOfBoundsException e) {
            throw e;
        }

    }

    /*Verifica-se se uma peca pode entrar no caminho de uma outra peca*/
    private boolean pecaPodeInterpor(Posicao atacante) {
        try {
            /*O Cavalo pode pular pecas, o rei e o peao, andam apenas uma casa para capturar uma peca*/
            /*Assim essas 3 pecas nao tem como ter o caminho interpostos*/
            if(atacante.getPeca().getClass().getSimpleName().equals("Cavalo") ||      //verificamos se a peca eh um cavalo
                    atacante.getPeca().getClass().getSimpleName().equals("Rei") ||   //verificamos se a peca eh um rei
                    atacante.getPeca().getClass().getSimpleName().equals("Peao")) { //verificamos se a peca eh um rei
                return false;
            }

            boolean corACapturar = atacante.getPeca().getColor(); //obtemos as cor da peca que pode capturar o xei

            // Obtemos a posicao do Rei da cor oposta a peca a ser interposta
            Posicao pRei = obterPosicaoRei(!corACapturar);

            /* A diferenca entre a linha do atacante e a do defensor*/
            int difLinha = Math.abs(atacante.getLinha() - pRei.getLinha());
            /* A diferenca entre a coluna do atacante e a do defensor*/
            int difCol = Math.abs(atacante.getColuna() - pRei.getColuna());

            // A direcao do movimento (esse valor sera utilizado para no incremento da posicao)
            //verificamos sentido do movimento horizontal
            int direcaoLinha = pRei.getLinha() - atacante.getLinha() > 0 ? 1 : -1;
            direcaoLinha = pRei.getLinha() -  atacante.getLinha() == 0 ? 0 : direcaoLinha; // se as duas pecas se encontrarem na mesma linha

            //verificamos sentido do movimento vertical
            int direcaoCol = pRei.getColuna() - atacante.getColuna() > 0 ? 1 : -1;
            direcaoCol = pRei.getColuna() - atacante.getColuna() == 0 ? 0 : direcaoCol; // se as duas pecas se encontrarem na mesma coluna

            // Verifica se eh um dos caminhos validos (horizontal, vertical ou diagonal)
            if(difLinha == 0 || difCol == 0 || difLinha == difCol) {
                int i = 0, linha = atacante.getLinha();
                int j = 0, coluna = parseColuna(atacante.getColuna());

                Posicao posCaminho = obterPosicao(linha, coluna);
                // Percorrer o caminho verificando se nenhuma outra peca pode ir naquelas casas interpor
                while(posCaminho != pRei) { // linha/coluna != posRei
                    // Enquando a linha ou coluna nao chegar a posicao do rei, incrementamos o I ou J
                    i = i < difLinha ? i + 1 : i;
                    j = j < difCol ? j + 1 : j;

                    // Aplica o movimento adequado
                    linha = atacante.getLinha() + (i * direcaoLinha);
                    coluna = parseColuna(atacante.getColuna()) + (j * direcaoCol);

                    //posicao no caminho recebe a nova posicao
                    posCaminho = obterPosicao(linha, coluna);

                    //verificamos se alguma peca pode entrar no caminho entrea peca atacante e o rei
                    if (posicaoPodeSerOcupada(posCaminho, corACapturar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        catch (IndexOutOfBoundsException | NullPointerException e){
            throw e;
        }
    }

    private boolean escapeRei(Posicao pRei, boolean corRei) {
        try {
            int valorColuna = parseColuna(pRei.getColuna());
            // movimento horizontal do rei:
            // Para a direita
            valorColuna++;
            Posicao direitaRei = obterPosicao(pRei.getLinha(), valorColuna);
            //rei em xeque possui movimento valido para a direita
            if(movimentoValido(pRei, direitaRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(direitaRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }

            // Para a esquerda
            valorColuna -= 2;
            Posicao esquerdaRei =  obterPosicao(pRei.getLinha(), valorColuna);
            //rei em xeque possui movimento valido para a esquerda
            if(movimentoValido(pRei, esquerdaRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(esquerdaRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }

            valorColuna++;//voltando ao valor original

            //movimento vertical do rei:
            //para cima
            Posicao cimaRei = obterPosicao(pRei.getLinha()+1, parseColuna(pRei.getColuna()));
            //rei em xeque possui movimento valido para cima
            if(movimentoValido(pRei, cimaRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(cimaRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }

            //para baixo
            Posicao baixoRei = obterPosicao(pRei.getLinha()+1, parseColuna(pRei.getColuna()));
            //rei em xeque possui movimento valido para baixo
            if(movimentoValido(pRei, baixoRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(baixoRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }

            //movimento diagonal do rei:

            //diagonal superior direita
            valorColuna++;
            Posicao cimaDireitaRei = obterPosicao(pRei.getLinha()+1, valorColuna);
            if(movimentoValido(pRei, cimaDireitaRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(cimaDireitaRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }
            valorColuna--; //voltando ao valor original

            //diagonal superior esquerda
            valorColuna--;
            Posicao cimaEsquerdaRei = obterPosicao(pRei.getLinha()+1, valorColuna);
            if(movimentoValido(pRei, cimaEsquerdaRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(cimaEsquerdaRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }

            //diagonal inferior esquerda
            Posicao baixoEsquerdaRei =  obterPosicao(pRei.getLinha()-1, valorColuna);
            if(movimentoValido(pRei, baixoEsquerdaRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(baixoEsquerdaRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }

            valorColuna--; //voltando ao valor original

            //diagonal inferior
            valorColuna++;
            Posicao baixoDireitaRei = obterPosicao(pRei.getLinha()-1, valorColuna);
            if(movimentoValido(pRei, baixoDireitaRei, corRei)){
                Peca rei = pRei.getPeca();
                pRei.setPeca(null);
                //se o rei nao pode ser capturado na nova posicao
                if(!posicaoPodeSerOcupada(baixoDireitaRei, corRei)) {
                    pRei.setPeca(rei);
                    return true;
                }
                pRei.setPeca(rei);
            }
            return false;
        }
        //rei tentou se mover para fora do tabuleiro
        catch (IndexOutOfBoundsException | NullPointerException e) {
            return false;
        }
    }

    /* GETTERS & SETTERS */
    //retorna uma posicao do tabuleiro
    private Posicao obterPosicao(int linha, int coluna) {
        try {
            return arrayPosicao[linha-1][coluna];
        }
        catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    //transforma o index da colna em char
    private char parseColuna(int idx) {
        idx += 97;
        char coluna = (char) idx;
        coluna = Character.toUpperCase(coluna);
        return coluna;
    }

    //transforma o char da coluna em um index
    private int parseColuna(char idx) {
        idx = Character.toLowerCase(idx);
        int coluna = (int) idx;
        return coluna - 97;
    }
}
