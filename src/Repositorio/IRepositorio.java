package Repositorio;

public interface IRepositorio <T> {
    // esta interfaz define QUE se puede hacer pero NO COMO se hace.

    void registrar(T elemento);

    boolean eliminar(T codigo);

    T buscar(int codigo);

    String listar();
    int contar();
}
