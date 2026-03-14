package Modelo;

public class Noble extends Habitante{

    private String privilegioReal;

    public Noble(String nombre, String reinoProcedencia, int codigoRegistro, boolean indicadorHonorabilidad, String privilegioReal) {
        super(nombre, reinoProcedencia, codigoRegistro, indicadorHonorabilidad);
        this.privilegioReal = privilegioReal;
    }
}
