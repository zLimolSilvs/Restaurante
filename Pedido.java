import java.util.List;

public class Pedido {
    private int numero;
    private Mesa mesa;
    private List<Prato> pratos;
    private String status;

    public Pedido(int numero, Mesa mesa, List<Prato> pratos, String status) {
        this.numero = numero;
        this.mesa = mesa;
        this.pratos = pratos;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
