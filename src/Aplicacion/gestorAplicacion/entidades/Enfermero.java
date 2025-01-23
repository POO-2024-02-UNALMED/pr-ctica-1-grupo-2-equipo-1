package gestorAplicacion.entidades;

public class Enfermero extends Persona{
    private String areaAsignada;

    public Enfermero(String nombre, String apellido, int edad, String areaAsignada) {
        super(nombre, apellido, edad);
        this.areaAsignada = areaAsignada;
    }


    public String getRol() {
        return "Enfermero";
    }

    public String getAreaAsignada() {
        return areaAsignada;
    }
    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }

}