import java.util.Scanner;

public class QuadradoMagico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        System.out.println("Preencha a matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor para [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        if (verificarQuadradoMagico(matriz)) {
            System.out.println("A matriz é um quadrado mágico!");
        } else {
            System.out.println("A matriz NÃO é um quadrado mágico.");
        }

        scanner.close();
    }

    public static boolean verificarQuadradoMagico(int[][] matriz) {
        int somaReferencia = 0;

        for (int j = 0; j < 3; j++) {
            somaReferencia += matriz[0][j];
        }

        for (int i = 1; i < 3; i++) {
            int somaLinha = 0;
            for (int j = 0; j < 3; j++) {
                somaLinha += matriz[i][j];
            }
            if (somaLinha != somaReferencia) {
                return false;
            }
        }

        for (int j = 0; j < 3; j++) {
            int somaColuna = 0;
            for (int i = 0; i < 3; i++) {
                somaColuna += matriz[i][j];
            }
            if (somaColuna != somaReferencia) {
                return false;
            }
        }

        int somaDiagonalPrincipal = 0;
        for (int i = 0; i < 3; i++) {
            somaDiagonalPrincipal += matriz[i][i];
        }
        if (somaDiagonalPrincipal != somaReferencia) {
            return false;
        }

        int somaDiagonalSecundaria = 0;
        for (int i = 0; i < 3; i++) {
            somaDiagonalSecundaria += matriz[i][2 - i];
        }
        if (somaDiagonalSecundaria != somaReferencia) {
            return false;
        }

        return true;
    }
}