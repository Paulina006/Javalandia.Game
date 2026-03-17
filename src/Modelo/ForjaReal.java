package Modelo;

import Excepcion.ArmaDuplicadaException;
import Excepcion.ArmaNoEncontradaException;
import Excepcion.DatosIncompletosException;
import Repositorio.IRepositorio;

import java.util.HashMap;
import java.util.Map;

public class ForjaReal implements IRepositorio <Arma, String>{
    private Map<String, Arma> listaArmas;

    public ForjaReal() {
        this.listaArmas = new HashMap<>();
    }

    @Override
    public void registrar(Arma elemento) throws ArmaDuplicadaException, DatosIncompletosException {
        if(elemento.getNombreArma() == null || elemento.getNombreArma().isEmpty()){
            throw new DatosIncompletosException("Nombre vacío");
        }
        if(listaArmas.containsKey(elemento.getNombreArma())){
        throw new ArmaDuplicadaException("Arma duplicada");
        }
        listaArmas.put(elemento.getNombreArma(), elemento);

    }

    @Override
    public boolean eliminar(String nombre) throws ArmaNoEncontradaException {
        if(!listaArmas.containsKey(nombre)){
            throw new ArmaNoEncontradaException("Arma no encontrada");
        }
        listaArmas.remove(nombre);
        return true;
    }

    @Override
    public Arma buscar(String nombre) throws ArmaNoEncontradaException {
        Arma arma= listaArmas.get(nombre);
        if(arma==null){
            throw new ArmaNoEncontradaException("Arma no encontrada");
        }
        return arma;
    }

    @Override
    public String listar() {
        String rta= "";
        for(Arma a :listaArmas.values()){
            rta+= a.toString();
        }
        return rta;
    }

    @Override
    public int contar() {
        return listaArmas.size();
    }
}
