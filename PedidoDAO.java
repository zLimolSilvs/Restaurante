import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PedidoDAO implements CRUD<Pedido> {
    private Map<Integer, Pedido> pedidos;

    public PedidoDAO() {
        this.pedidos = new HashMap<>();
    }

    @Override
    public void criar(Pedido pedido) {
        pedidos.put(pedido.getNumero(), pedido);
    }

    @Override
    public Pedido ler(int numero) {
        return pedidos.get(numero);
    }

    @Override
    public List<Pedido> lerTodos() {
        return new ArrayList<>(pedidos.values());
    }

    @Override
    public void atualizar(int numero, Pedido pedido) {
        pedidos.put(numero, pedido);
    }

    @Override
    public void deletar(int numero) {
        pedidos.remove(numero);
    }
}