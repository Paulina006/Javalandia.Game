package Modelo;

public interface IHabitante  {

     String getNombre();
     String getReinoProcedencia();
     int getCodigoRegistro();
     Boolean getIndicadorHonorabilidad();

    void setNombre(String nombre);
    void setReinoProcedencia(String reinoProcedencia);
    void setCodigoRegistro(int codigoRegistro);
    void setIndicadorHonorabilidad(boolean indicadorHonorabilidad);
}
