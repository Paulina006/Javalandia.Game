package Modelo;

public class AprendizHechicero extends Habitante{

    private String artefactoMagico;

    public AprendizHechicero(String nombre, String reinoProcedencia, int codigoRegistro, boolean indicadorHonorabilidad, String artefactoMagico) {
        super(nombre, reinoProcedencia, codigoRegistro, indicadorHonorabilidad);
        this.artefactoMagico = artefactoMagico;
    }
}
