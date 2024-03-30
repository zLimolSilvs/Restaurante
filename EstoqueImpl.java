import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EstoqueImpl implements Estoque {
    private Map<Prato, Integer> estoque;

    public EstoqueImpl() {
        this.estoque = new HashMap<>();
    }

    @Override
    public boolean verificarDisponibilidade(Prato prato) {
        Integer quantidade = estoque.get(prato);
        return quantidade != null && quantidade > 0;
    }

    // Implementação do método verificarDisponibilidade(Prato, int)
    @Override
    public boolean verificarDisponibilidade(Prato prato, int quantidadePratos) {
        Integer quantidade = estoque.get(prato);
        return quantidade != null && quantidade >= quantidadePratos;
    }

    @Override
    public void atualizarEstoque(Prato prato, int quantidade) {
        estoque.put(prato, quantidade);
    }

    @Override
    public List<Prato> getPratosDisponiveis() {
        return new ArrayList<>(estoque.keySet());
    }

    @Override
    public Prato getPratoPorNumero(int numeroPrato) {
        List<Prato> pratos = new ArrayList<>(estoque.keySet());
        if (numeroPrato >= 1 && numeroPrato <= pratos.size()) {
            return pratos.get(numeroPrato - 1);
        }
        return null;
    }

    @Override
    public int getQuantidade(Prato prato) {
        return estoque.getOrDefault(prato, 0);
    }
}
