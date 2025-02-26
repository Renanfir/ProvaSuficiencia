import java.util.Random;

public class JogoDaVelha_PC {
    Random rand = new Random();
    JogoDaVelha_Mapa mapa = new JogoDaVelha_Mapa();

    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
    }

    public int[] joga() {
        int linha, coluna;
        do {
            linha = rand.nextInt(3);
            coluna = rand.nextInt(3);
        } while (!mapa.jogar(linha, coluna, 'O'));

        System.out.println("PC ["+linha+","+coluna+"]");

        if (mapa.ganhou('O')) {
            System.out.println("PC GANHOU!");
        }

        return new int[]{linha, coluna};
    }

}
