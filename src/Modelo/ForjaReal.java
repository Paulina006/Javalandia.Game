package Modelo;

import Repositorio.IRepositorio;

import java.util.HashMap;
import java.util.Map;

public class ForjaReal implements IRepositorio {
    private Map<String, Arma> listaArmas;

    public ForjaReal() {
        this.listaArmas = new HashMap<>();
    }

    @Override
    public void registrar(Object elemento) {
    }

    @Override
    public boolean eliminar(int codigo) {
        return false;
    }

    @Override
    public Object buscar(int codigo) {
        return null;
    }

    @Override
    public String listar() {
        return "";
    }

    @Override
    public int contar() {
        return 0;
    }
}
