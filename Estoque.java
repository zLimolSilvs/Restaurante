// Interface Estoque
import java.util.List;

interface Estoque {
    boolean verificarDisponibilidade(Prato prato);
    void atualizarEstoque(Prato prato, int quantidade);
    List<Prato> getPratosDisponiveis();
    Prato getPratoPorNumero(int numeroPrato);
    int getQuantidade(Prato prato);
    boolean verificarDisponibilidade(Prato pratoEscolhido, int quantidadePratos);
}
