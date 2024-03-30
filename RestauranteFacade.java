import java.util.List;

// Classe RestauranteFacade
class RestauranteFacade {
    private Menu menu;

    public RestauranteFacade(Menu menu) {
        this.menu = menu;
    }

    public void adicionarPratoAoMenu(Prato prato) {
        menu.adicionarPratoAoMenu(prato);
    }

    public List<Prato> verMenu() {
        return menu.verMenu();
    }
}