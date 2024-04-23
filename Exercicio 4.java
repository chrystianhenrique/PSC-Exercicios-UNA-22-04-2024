import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os valores da matriz 4x4:");

        double[][] matriz = new double[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        MatrizOperacoes matrizOperacoes = new MatrizOperacoes(matriz);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Exibir os valores da diagonal principal");
            System.out.println("2. Exibir os valores da diagonal secundária");
            System.out.println("3. Exibir a matriz transposta");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    matrizOperacoes.exibirDiagonalPrincipal();
                    break;
                case 2:
                    matrizOperacoes.exibirDiagonalSecundaria();
                    break;
                case 3:
                    matrizOperacoes.exibirMatrizTransposta();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}

class MatrizOperacoes {
    private double[][] matriz;

    public MatrizOperacoes(double[][] matriz) {
        this.matriz = matriz;
    }

    public void exibirDiagonalPrincipal() {
        System.out.println("\nValores da diagonal principal:");
        for (int i = 0; i < 4; i++) {
            System.out.println(matriz[i][i]);
        }
    }

    public void exibirDiagonalSecundaria() {
        System.out.println("\nValores da diagonal secundária:");
        for (int i = 0; i < 4; i++) {
            System.out.println(matriz[i][3 - i]);
        }
    }

    public void exibirMatrizTransposta() {
        System.out.println("\nMatriz transposta:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();
        }
    }
}