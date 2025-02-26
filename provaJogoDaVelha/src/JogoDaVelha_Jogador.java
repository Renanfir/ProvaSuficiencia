import java.util.Scanner;

public class JogoDaVelha_Jogador {
    Scanner sc = new Scanner(System.in);
    JogoDaVelha_Mapa mapa = new JogoDaVelha_Mapa();

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
    }

    public int[] joga() {
        int linha, coluna;
        do {
            System.out.print("Digite a sua linha: ");
            linha = sc.nextInt();

            System.out.print("Digite a sua coluna: ");
            coluna = sc.nextInt();

        } while (!mapa.jogar(linha, coluna, 'X'));

        System.out.println("Jogador ..");
        System.out.println("Linha: ");
        System.out.println(linha);
        System.out.println("Coluna: ");
        System.out.println(coluna);

        if (mapa.ganhou('X')) {
            System.out.println("JOGADOR ganhou!");

        }

        return new int[]{linha, coluna};
    }
}
