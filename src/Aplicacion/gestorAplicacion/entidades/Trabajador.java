package gestorAplicacion.entidades;

public class Trabajador extends Persona {
    //Atributos----------------------------------------------------------

    String Rol;
    boolean ocupado = false;

    //-------------------------------------------------------------------

    //Constructores------------------------------------------------------

    //Constructor por defecto.
    public Trabajador() {}
    //Constructor Completo.
    public Trabajador(String nombre, String apellido, String rol, int edad) {
        super(nombre, apellido, edad);
        this.Rol = rol;
    }

    //-------------------------------------------------------------------

    //Métodos------------------------------------------------------------

    //Método abstracto.
    @Override
    public String getRol() {
        return this.Rol;
    }

    //Setters y Getters
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    //-------------------------------------------------------------------
}