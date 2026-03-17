package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Escudero extends Habitante{

    private ArrayList<IArma> listaArmas;

    public Escudero(String nombre, String reinoProcedencia, int codigoRegistro, boolean indicadorHonorabilidad) {
        super(nombre, reinoProcedencia, codigoRegistro, indicadorHonorabilidad);
        this.listaArmas = new ArrayList<>();
    }

    public void cargarListaArmas(IArma arma)
    {
        listaArmas.add(arma);
    }
}
