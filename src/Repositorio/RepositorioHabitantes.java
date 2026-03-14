package Repositorio;

import Modelo.Habitante;
import Modelo.IHabitante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepositorioHabitantes implements IRepositorio <IHabitante>{ //limito a que la clase utilice la Interfaz Habitante.

    private ArrayList<IHabitante> habitantes;

    @Override
    public void registrar(IHabitante elemento) {
        habitantes.add(elemento);
    }

    @Override
    public boolean eliminar(IHabitante codigo) {
        boolean flag=false;
        for(int i=0; i<habitantes.size();i++){
            if(habitantes.get(i).getCodigoRegistro()==codigo.getCodigoRegistro()){
                habitantes.remove(i);
                flag=true;
            }
        }
        return flag;

    }

    @Override
    public IHabitante buscar(int codigo) {
        for(int i=0; i<habitantes.size();i++){
            if(habitantes.get(i).getCodigoRegistro()==codigo){
                return habitantes.get(i);
            }
        }
        return null;
    }

    @Override
    public String listar() {
        String rta="";
        for(IHabitante i:habitantes)
        {
            rta+=i.toString();
        }
        return rta;
    }

    @Override
    public int contar() {
        int contador=0;
        for(IHabitante i:habitantes)
        {
            contador++;
        }
        return contador;
    }
}
