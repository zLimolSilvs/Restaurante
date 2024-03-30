import java.util.List;

// Interface CRUD
interface CRUD<T> {
    void criar(T obj);
    T ler(int id);
    List<T> lerTodos();
    void atualizar(int id, T obj);
    void deletar(int id);
}
