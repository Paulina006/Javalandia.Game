package Modelo;

import java.util.List;

public class Escudero extends Habitante{

    private List<String> listaArmas;

    public Escudero(String nombre, String reinoProcedencia, int codigoRegistro, boolean indicadorHonorabilidad, List<String> listaArmas) {
        super(nombre, reinoProcedencia, codigoRegistro, indicadorHonorabilidad);
        this.listaArmas = listaArmas;
    }
}
