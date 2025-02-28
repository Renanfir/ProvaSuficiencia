import java.util.Random;

public class JogoDaVelha_PC {
    private Random rand = new Random();
    private JogoDaVelha_Mapa mapa;
    private char letra = 'O';

    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean joga() {
        int linha, coluna;
        do {
            linha = rand.nextInt(3);
            coluna = rand.nextInt(3);
        } while (!mapa.jogar(linha, coluna, letra));

        System.out.println("PC [" + linha + "," + coluna + "]");
        if(mapa.ganhou('O')){
            System.out.println("...PC GANHOU!");
            return false;
        }
        return  false;
    }
}