import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JogoDaVelha_Mapa jogoDaVelha = new JogoDaVelha_Mapa();
        JogoDaVelha_PC jogoDaVelha_PC = new JogoDaVelha_PC(jogoDaVelha);
        JogoDaVelha_Jogador Jogador = new JogoDaVelha_Jogador(jogoDaVelha);

        boolean jogarNovamente = true;
        int linha;
        int coluna;
        int sorteio;
        char repetir;

        int count = 0;
        sorteio = jogoDaVelha.sortear();

        jogoDaVelha.desenha(count);

        while (jogarNovamente) {

            if(sorteio % 2 == 0) {
                jogoDaVelha_PC.joga();
                count++;
                sorteio ++;

            }

            else{
                Jogador.joga();
                count++;
                sorteio ++;
            }

            jogoDaVelha.desenha(count);


            if (jogoDaVelha.ganhou('X') || jogoDaVelha.ganhou('O')) {
                jogoDaVelha.ganhou((char) 0);
                System.out.println("Digite N para sair, e qualquer outra letra para continuar");
                repetir = sc.next().toUpperCase().charAt(0);
                if(repetir == 'N'){
                    System.out.println("Você saiu do jogo!");
                    break;
                }
                jogoDaVelha.limpaMapa();
                count = 0;
                sorteio = jogoDaVelha.sortear();


            }
        }
    }
}
