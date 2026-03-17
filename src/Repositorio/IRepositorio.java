package Repositorio;

import Excepcion.HabitanteDuplicadoException;

public interface IRepositorio <T> {
    // esta interfaz define QUE se puede hacer pero NO COMO se hace.

    void registrar(T elemento) throws HabitanteDuplicadoException;

    boolean eliminar(int codigo) throws HabitanteDuplicadoException;

    T buscar(int codigo) throws HabitanteDuplicadoException;

    String listar();
    int contar();
}
