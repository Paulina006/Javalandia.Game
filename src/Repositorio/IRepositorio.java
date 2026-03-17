package Repositorio;

import Excepcion.HabitanteDuplicadoException;

public interface IRepositorio <T, K> {
    // esta interfaz define QUE se puede hacer pero NO COMO se hace.

    void registrar(T elemento) throws Exception;

    boolean eliminar(K codigo) throws Exception;

    T buscar(K codigo) throws Exception;

    String listar();
    int contar();
}
