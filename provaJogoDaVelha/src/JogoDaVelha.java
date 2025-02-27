import java.util.Scanner;

public class JogoDaVelha {
    private JogoDaVelha_Mapa jogoMapa;
    private JogoDaVelha_PC jogoPC;
    private JogoDaVelha_Jogador jogoJogador;

    public JogoDaVelha() {
        jogoMapa = new JogoDaVelha_Mapa();
        jogoPC = new JogoDaVelha_PC(jogoMapa);
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.jogar(sc);
    }

    private void jogar(Scanner sc) {
        int sorteio;
        char repetir;
        int count = 0;
        sorteio = jogoMapa.sortear(1, 3);

        jogoMapa.desenha(count);

        while (true) {
            if (sorteio % 2 == 0) {
                jogoPC.joga();
            } else {
                jogoJogador.joga();
            }
            count++;
            sorteio++;
            jogoMapa.desenha(count);

            if (jogoMapa.ganhou('X') || jogoMapa.ganhou('O')) {
                System.out.println("Deseja jogar novamente (s/n)?");
                repetir = sc.next().toUpperCase().charAt(0);
                while (repetir != 'S' && repetir != 'N') {
                    System.out.println("Digite uma letra válida (s/n)?");
                    repetir = sc.next().toUpperCase().charAt(0);
                }
                if (repetir == 'N') {
                    System.out.println("Você saiu do jogo!");
                    break;
                }
                jogoMapa.limpaMapa();
                count = 0;
                sorteio = jogoMapa.sortear(1, 3);
                jogoMapa.desenha(count);
            }

            if (count == 9) {
                System.out.println("EMPATE");
                System.out.println("Deseja jogar novamente (s/n)?");
                repetir = sc.next().toUpperCase().charAt(0);
                while (repetir != 'S' && repetir != 'N') {
                    System.out.println("Digite uma letra válida (s/n)?");
                    repetir = sc.next().toUpperCase().charAt(0);
                }

                if (repetir == 'N') {
                    System.out.println("Você saiu do jogo!");
                    break;
                }
                jogoMapa.limpaMapa();
                count = 0;
                sorteio = jogoMapa.sortear(1, 3);
                jogoMapa.desenha(count);
            }
        }
    }
}
