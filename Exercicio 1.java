import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] agenda = new String[31][24]; // Matriz para armazenar os compromissos do mês

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Adicionar compromisso");
            System.out.println("2. Consultar compromisso");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarCompromisso(scanner, agenda);
                    break;
                case 2:
                    consultarCompromisso(scanner, agenda);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    public static void adicionarCompromisso(Scanner scanner, String[][] agenda) {
        System.out.print("Digite o dia do mês (1 a 31): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a hora (0 a 23): ");
        int hora = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o compromisso: ");
        String compromisso = scanner.nextLine();

        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            agenda[dia - 1][hora] = compromisso;
            System.out.println("Compromisso adicionado com sucesso!");
        } else {
            System.out.println("Dia ou hora inválidos. O dia deve ser entre 1 e 31, e a hora entre 0 e 23.");
        }
    }

    public static void consultarCompromisso(Scanner scanner, String[][] agenda) {
        System.out.print("Digite o dia do mês (1 a 31): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a hora (0 a 23): ");
        int hora = scanner.nextInt();

        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            String compromisso = agenda[dia - 1][hora];
            if (compromisso != null) {
                System.out.println("Compromisso encontrado: " + compromisso);
            } else {
                System.out.println("Nenhum compromisso encontrado para esta hora.");
            }
        } else {
            System.out.println("Dia ou hora inválidos. O dia deve ser entre 1 e 31, e a hora entre 0 e 23.");
        }
    }
}