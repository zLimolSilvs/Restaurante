import java.util.List;
import java.util.Scanner;

public class RestauranteApp {
    private static double totalAPagar = 0; // Variável global para armazenar o total a pagar

    public static void main(String[] args) {
        Estoque estoque = new EstoqueImpl(); // Usando a implementação do estoque

        // Inicialização do estoque (usando um mapa para simplificar)
        Prato fileParmegiana = new Prato("File à Parmegiana", 32);
        Prato lasanhaQuatroQueijos = new Prato("Lasanha Quatro Queijos", 39);
        estoque.atualizarEstoque(fileParmegiana, 10);
        estoque.atualizarEstoque(lasanhaQuatroQueijos, 5);

        // Interface de console interativa
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Por favor, escolha uma mesa (digite um número): ");
            int numeroMesa = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            System.out.println("Você escolheu a mesa número " + numeroMesa + ".\n");

            int opcao;
            do {
                System.out.println("\nSelecione uma opção:");
                System.out.println("1. Verificar Menu");
                System.out.println("2. Fazer Pedido");
                System.out.println("3. Fechar Conta");
                System.out.println("4. Sair");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        exibirMenu(estoque);
                        break;
                    case 2:
                        fazerPedido(estoque, scanner);
                        break;
                    case 3:
                        fecharConta();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 4);
        }
    }


    private static void exibirMenu(Estoque estoque) {
        System.out.println("\nMenu:");
        for (Prato prato : estoque.getPratosDisponiveis()) {
            System.out.println(prato.getNome() + " - R$" + prato.getPreco());
        }
    }

    private static void fazerPedido(Estoque estoque, Scanner scanner) {
        System.out.println("Escolha um prato:");
        List<Prato> pratos = estoque.getPratosDisponiveis();
        for (int i = 0; i < pratos.size(); i++) {
            System.out.println((i + 1) + ". " + pratos.get(i).getNome() + " - R$" + pratos.get(i).getPreco());
        }
        System.out.print("Digite o número do prato desejado: ");
        if (scanner.hasNextInt()) {
            int numeroPrato = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
    
            Prato pratoEscolhido = estoque.getPratoPorNumero(numeroPrato);
            if (pratoEscolhido != null) {
                System.out.print("Quantos pratos você gostaria de pedir? ");
                if (scanner.hasNextInt()) {
                    int quantidadePratos = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
    
                    if (estoque.verificarDisponibilidade(pratoEscolhido, quantidadePratos)) {
                        estoque.atualizarEstoque(pratoEscolhido, -quantidadePratos); // Reduzir estoque pela quantidade de pratos pedidos
                        totalAPagar += pratoEscolhido.getPreco() * quantidadePratos; // Adicionar o preço dos pratos ao total a pagar
                        System.out.println("Pedido realizado: " + quantidadePratos + " " + pratoEscolhido.getNome());
                    } else {
                        System.out.println("Estoque insuficiente para o pedido.");
                    }
                } else {
                    System.out.println("Entrada inválida. Digite um número válido.");
                }
            } else {
                System.out.println("Opção inválida. Digite 1 ou 2.");
            }
        } else {
            System.out.println("Entrada inválida. Digite um número válido.");
        }
    }

    private static void fecharConta() {
        System.out.println("Total a pagar: R$" + totalAPagar);
        totalAPagar = 0; // Zerar a conta após fechá-la
    }
}