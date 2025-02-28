import java.util.Scanner;

public class JogoDaVelha_Jogador {
    private Scanner sc = new Scanner(System.in);
    private JogoDaVelha_Mapa mapa;
    private char letra = 'X';

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean joga() {
        int linha, coluna;
        do {
            System.out.print("Digite a sua linha: ");
            linha = sc.nextInt();
            System.out.print("Digite a sua coluna: ");
            coluna = sc.nextInt();
        } while (!mapa.jogar(linha, coluna, letra));
        System.out.println("Jogador ..");
        System.out.println("Linha: ");
        System.out.println(linha);
        System.out.println("Coluna: ");
        System.out.println(coluna);

        if(mapa.ganhou('X')){
            System.out.println("...jogador GANHOU!");
            return false;
        }
        return  false;

    }

}
