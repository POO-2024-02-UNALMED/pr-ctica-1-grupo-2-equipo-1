package gestorAplicacion.entidades;

public class Acompanante extends Persona{
    

    public Acompanante(String nombre, String apellido, int edad, boolean habilitadoParaAsistir) {
        super(nombre, apellido, edad);
    }

    public String getRol() {
        return "Acompañante";
    }

}