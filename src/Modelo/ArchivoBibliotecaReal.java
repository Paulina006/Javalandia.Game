package Modelo;

import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ArchivoBibliotecaReal {
    JSONArray jsonArr=new JSONArray();

    //serializar
    public void objetoAjson(ForjaReal forja){
        for (IArma arma : forja.getListaArmas().values()) {
            jsonArr.put(arma.toJSON());
        }
    }
    public void escribirArchivo(String nombreArchivo) {
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(nombreArchivo + ".json"));
            escribir.write(jsonArr.toString());
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String mostrarArchivo(String nombreArchivo) {
        String rta = "";
        File lectura = new File(nombreArchivo + ".json");
        try {
            rta+= Files.readString(lectura.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rta;
    }

}
