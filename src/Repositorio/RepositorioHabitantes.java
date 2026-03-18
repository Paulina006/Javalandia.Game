package Repositorio;

import Excepcion.HabitanteDuplicadoException;
import Excepcion.HabitanteNoEncontradoException;
import Modelo.Habitante;
import Modelo.IHabitante;

import java.util.ArrayList;


public class RepositorioHabitantes implements IRepositorio <IHabitante, Integer>{ //limito a que la clase utilice la Interfaz Habitante.

    private ArrayList<IHabitante> habitantes;

    public RepositorioHabitantes() {
        this.habitantes = new ArrayList<>();
    }

    @Override
    public void registrar(IHabitante elemento) throws HabitanteDuplicadoException {
        for(IHabitante h : habitantes) {
            if(h.getCodigoRegistro()==elemento.getCodigoRegistro()) {
                throw new HabitanteDuplicadoException("Error. Habitante duplicado");
            }
        }
        habitantes.add(elemento);
    }

    @Override
    public boolean eliminar(Integer codigo) throws HabitanteNoEncontradoException {
   for(int i=0;i<habitantes.size();i++){
       if(habitantes.get(i).getCodigoRegistro() == codigo)
       {
           habitantes.remove(i);
           return true;
       }
   }
    throw new HabitanteNoEncontradoException("Habitante no encontrado.");
    }

    @Override
    public IHabitante buscar(Integer codigo) throws HabitanteNoEncontradoException {
        for(int i=0; i<habitantes.size();i++){
            if(habitantes.get(i).getCodigoRegistro()==codigo){
                return habitantes.get(i);
            }
        }
        throw new HabitanteNoEncontradoException("Habitante no encontrado");
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
      return habitantes.size();
    }


}
