package Modelo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Arma implements IArma {
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

    public void cargarMaterialCreacion(String material)
    {
        materialCreacion.add(material);
    }

    @Override
    public String getNombreArma() {
        return this.nombreArma;
    }

    @Override
    public String getCategoria() {
        return this.categoria;
    }

    @Override
    public int getCantDisponible() {
        return this.cantDisponible;
    }

    @Override
    public ArrayList<String> getMaterialCreacion() {
        return this.materialCreacion;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombreArma='" + nombreArma + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cantDisponible=" + cantDisponible +
                ", materialCreacion=" + materialCreacion +
                '}';
    }

    @Override
        public JSONObject toJSON() {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre", this.nombreArma);
            jsonObject.put("categoria", this.categoria);
            jsonObject.put("cantidadDisponible", this.cantDisponible);

            JSONArray materiales = new JSONArray();
            for (String mat : this.materialCreacion) {
                materiales.put(mat);
            }

            jsonObject.put("materialCreacion", materiales);
            return jsonObject;
        }
}
