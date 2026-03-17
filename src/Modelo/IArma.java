package Modelo;

import java.util.ArrayList;

public interface IArma {
     String getNombreArma();
     String getCategoria();
     int getCantDisponible();
     ArrayList<String> getMaterialCreacion();
    }
