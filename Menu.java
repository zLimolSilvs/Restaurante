import java.util.ArrayList;
import java.util.List;

// Classe Menu
class Menu {
    private List<Prato> pratos;

    public Menu() {
        this.pratos = new ArrayList<>();
    }

    public void adicionarPratoAoMenu(Prato prato) {
        pratos.add(prato);
    }

    public List<Prato> verMenu() {
        return pratos;
    }
}

