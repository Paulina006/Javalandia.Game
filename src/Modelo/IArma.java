package Modelo;

import org.json.JSONObject;

import java.util.ArrayList;

public interface IArma {
     String getNombreArma();
     String getCategoria();
     int getCantDisponible();
     ArrayList<String> getMaterialCreacion();
     JSONObject toJSON();
    }
