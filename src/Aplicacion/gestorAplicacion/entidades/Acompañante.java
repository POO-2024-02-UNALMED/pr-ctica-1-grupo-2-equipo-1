package gestorAplicacion.entidades;

public class Acompañante extends Persona{
    

    public Acompañante(String nombre, String apellido, int edad, boolean habilitadoParaAsistir) {
        super(nombre, apellido, edad);
    }

    public String getRol() {
        return "Acompañante";
    }

}