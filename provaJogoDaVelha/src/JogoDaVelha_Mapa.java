import java.util.Random;

public class JogoDaVelha_Mapa {
    private Random rand = new Random();
    private char[][] mapa = {{'|',' ','|',' ','|',' ','|'},
            {'|',' ','|',' ','|',' ','|'},
            {'|',' ','|',' ','|',' ','|'}};

    public int sortear(int inicio, int fim){
        return rand.nextInt(fim - inicio) + inicio;
    }

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
        char caractere = jogador;
        if(linha < 0 || linha > 2 || coluna < 0 || coluna > 2){
            System.out.println("Valor inválido");
            return false;
        }
        switch (coluna){
            case 0: coluna = 1; break;
            case 1: coluna = 3; break;
            case 2: coluna = 5; break;
        }
        if(mapa[linha][coluna] == ' '){
            mapa[linha][coluna] = caractere;
            return true;
        }
        return false;
    }

    public boolean ganhou(char jogador) {
        for (int i = 0; i < 3; i++) {
            if (mapa[i][1] == jogador && mapa[i][3] == jogador && mapa[i][5] == jogador) {
                return true;
            }
        }
        for (int j = 1; j <= 5; j += 2) {
            if (mapa[0][j] == jogador && mapa[1][j] == jogador && mapa[2][j] == jogador) {
                return true;
            }
        }
        return (mapa[0][1] == jogador && mapa[1][3] == jogador && mapa[2][5] == jogador) ||
                (mapa[0][5] == jogador && mapa[1][3] == jogador && mapa[2][1] == jogador);
    }
}
