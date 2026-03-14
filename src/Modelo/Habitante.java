package Modelo;

public abstract class Habitante implements IHabitante{  //clase abstracta que sera la clase padre del resto

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

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getReinoProcedencia() {
        return this.reinoProcedencia;
    }

    @Override
    public int getCodigoRegistro() {
        return this.codigoRegistro;
    }

    @Override
    public Boolean getIndicadorHonorabilidad() {
        return this.indicadorHonorabilidad;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    @Override
    public void setReinoProcedencia(String reinoProcedencia) {
        this.reinoProcedencia = reinoProcedencia;

    }

    @Override
    public void setCodigoRegistro(int codigoRegistro) {
        this.codigoRegistro = codigoRegistro;

    }

    @Override
    public void setIndicadorHonorabilidad(boolean indicadorHonorabilidad) {
        this.indicadorHonorabilidad = indicadorHonorabilidad;

    }
}

