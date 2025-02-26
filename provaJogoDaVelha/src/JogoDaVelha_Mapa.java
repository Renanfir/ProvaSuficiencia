import java.util.Random;

public class JogoDaVelha_Mapa {
    Random rand = new Random();

    public int sortear(){
        return rand.nextInt(2) + 1;
    }

//                    00    01   02   03   04   05   06
    char[][] mapa = {{'|', ' ', '|', ' ', '|', ' ', '|'},
//                    10   11   12   13   14   15   16
                    {'|', ' ', '|', ' ', '|', ' ', '|'},
//                    20    21   22   23   24   25   26
                    {'|', ' ', '|', ' ', '|', ' ', '|'}};


    public void limpaMapa(){
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[i].length; j++){
                if (j % 2 != 0){
                    mapa[i][j] = ' ';
                }
            }
        }
    }

    public void desenha(int jogada){
        System.out.println("-----------------------------" + " .. Jogada: "+jogada);

        for (int i = 0; i < mapa.length; i++) {
            System.out.println(mapa[i]);
        }
        System.out.println("-----------------------------");

    }

    public boolean jogar(int linha, int coluna, char jogador){
        char caractere = 'X';
        switch (coluna){
            case 0: coluna = 1; break;
            case 1: coluna = 3; break;
            case 2: coluna = 5; break;
        }

        if (jogador == 'O'){
            caractere = 'O';
        }
        if(mapa[linha][coluna] == ' '){
            mapa[linha][coluna] = caractere;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean ganhou(char jogador) {
        char c = jogador;


        for (int i = 0; i < 3; i++) {
            if (mapa[i][1] == c && mapa[i][3] == c && mapa[i][5] == c) {
                return true;
            }
        }

        for (int j = 1; j <= 5; j += 2) {
            if (mapa[0][j] == c && mapa[1][j] == c && mapa[2][j] == c) {
                return true;
            }
        }

        if ((mapa[0][1] == c && mapa[1][3] == c && mapa[2][5] == c) ||
                (mapa[0][5] == c && mapa[1][3] == c && mapa[2][1] == c)) {
            return true;
        }

        boolean empate = true;
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == ' ') {
                    empate = false;
                    break;
                }
            }
            if (empate) {
                System.out.println("Empate");
                return true;
            }
        }
        return false;

    }
}

