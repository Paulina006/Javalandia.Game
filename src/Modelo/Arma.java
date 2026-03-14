package Modelo;

import java.util.ArrayList;

public class Arma {
    private String nombreArma;
    private String categoria;
    private int cantDisponible;
    private ArrayList<String> materialCreacion;

    public Arma(String nombreArma, String categoria, int cantDisponible) {
        this.nombreArma = nombreArma;
        this.categoria = categoria;
        this.cantDisponible = cantDisponible;
        this.materialCreacion = new ArrayList<>();
    }
}
