package Modelo;

import Excepcion.ArmaDuplicadaException;
import Excepcion.ArmaNoEncontradaException;
import Excepcion.DatosIncompletosException;
import Repositorio.IRepositorio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForjaReal implements IRepositorio <Arma, String>{
    private Map<String, Arma> listaArmas;

    public ForjaReal() {
        this.listaArmas = new HashMap<>();
    }

    public Map<String, Arma> getListaArmas() {
        return listaArmas;
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

    public IArma buscarNombre(String nombre)
    {
        return listaArmas.get(nombre);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for (IArma arma : listaArmas.values()) {
            jsonArray.put(arma.toJSON());
        }
        jsonObject.put("armas", jsonArray);
        return jsonObject;
    }
}
