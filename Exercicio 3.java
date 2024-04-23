import java.util.Scanner;

public class JogoDaVelha {
    private char[] tabuleiro;
    private char turno;

    public JogoDaVelha() {
        tabuleiro = new char[9];
        for (int i = 0; i < 9; i++) {
            tabuleiro[i] = ' ';
        }
        turno = 'X';
    }

    public void imprimirTabuleiro() {
        System.out.println(" 0 | 1 | 2 ");
        System.out.println("-----------");
        System.out.println(" 3 | 4 | 5 ");
        System.out.println("-----------");
        System.out.println(" 6 | 7 | 8 ");
        System.out.println("\nTabuleiro:");
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tabuleiro[i*3] + " | " + tabuleiro[i*3+1] + " | " + tabuleiro[i*3+2] + " ");
            if (i < 2) {
                System.out.println("-----------");
            }
        }
    }

    public boolean fazerJogada(int posicao) {
        if (tabuleiro[posicao] == ' ') {
            tabuleiro[posicao] = turno;
            if (verificarVitoria()) {
                imprimirTabuleiro();
                System.out.println("Parabéns! O jogador " + turno + " venceu!");
                return true;
            }
            turno = (turno == 'X') ? 'O' : 'X';
            return false;
        } else {
            System.out.println("Posição inválida! Tente novamente.");
            return false;
        }
    }

    private boolean verificarVitoria() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i*3] != ' ' && tabuleiro[i*3] == tabuleiro[i*3+1] && tabuleiro[i*3] == tabuleiro[i*3+2]) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i] != ' ' && tabuleiro[i] == tabuleiro[i+3] && tabuleiro[i] == tabuleiro[i+6]) {
                return true;
            }
        }
        if (tabuleiro[0] != ' ' && tabuleiro[0] == tabuleiro[4] && tabuleiro[0] == tabuleiro[8]) {
            return true;
        }
        if (tabuleiro[2] != ' ' && tabuleiro[2] == tabuleiro[4] && tabuleiro[2] == tabuleiro[6]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            jogo.imprimirTabuleiro();
            System.out.println("Jogador " + jogo.turno + ", informe a posição onde deseja jogar (0-8):");
            int posicao = scanner.nextInt();
            if (posicao >= 0 && posicao < 9) {
                if (jogo.fazerJogada(posicao)) {
                    break;
                }
            } else {
                System.out.println("Posição inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}