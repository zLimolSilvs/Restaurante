import java.util.List;

public class Gerente {
    private Menu menu;
    private Estoque estoque;

    public Gerente(Menu menu, Estoque estoque) {
        this.menu = menu;
        this.estoque = estoque;
    }

    public void adicionarPratoAoMenu(Prato prato) {
        menu.adicionarPratoAoMenu(prato);
    }

    public void atualizarEstoque(Prato prato, int quantidade) {
        estoque.atualizarEstoque(prato, quantidade);
    }

    public List<Pedido> visualizarPedidos(PedidoDAO pedidoDAO) {
        return pedidoDAO.lerTodos();
    }
}

