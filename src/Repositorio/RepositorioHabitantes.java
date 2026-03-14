package Repositorio;

import Modelo.Habitante;

import java.util.HashMap;
import java.util.Map;

public class RepositorioHabitantes <T extends Habitante> implements IRepositorio<T>{

    private Map<String, T> habitantes;

    public RepositorioHabitantes() {
        habitantes = new HashMap<>();
    }
}
