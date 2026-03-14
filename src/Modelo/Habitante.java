package Modelo;

public abstract class Habitante {  //clase abstracta que sera la clase padre del resto

    private String nombre;
    private String reinoProcedencia;
    private int codigoRegistro;
    private boolean indicadorHonorabilidad;

    public Habitante(String nombre, String reinoProcedencia, int codigoRegistro, boolean indicadorHonorabilidad) {
        this.nombre = nombre;
        this.reinoProcedencia = reinoProcedencia;
        this.codigoRegistro = codigoRegistro;
        this.indicadorHonorabilidad = indicadorHonorabilidad;
    }

    @Override
    public String toString() {
        return "Habitante{" +
                "nombre='" + nombre + '\'' +
                ", reinoProcedencia='" + reinoProcedencia + '\'' +
                ", codigoRegistro=" + codigoRegistro +
                ", indicadorHonorabilidad=" + indicadorHonorabilidad +
                '}';
    }
}
