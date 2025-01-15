package gestorAplicacion.entidades;

public class Trabajador extends Persona{

    public Trabajador(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
    
    public String getRol() {
        return "Trabajador";
    }
    
}
