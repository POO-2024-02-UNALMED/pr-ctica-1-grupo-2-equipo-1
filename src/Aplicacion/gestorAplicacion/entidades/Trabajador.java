package gestorAplicacion.entidades;

public class Trabajador extends Persona {
    String Rol;
    boolean ocupado = false;

    public Trabajador(String nombre, String apellido, String rol, int edad) {
        super(nombre, apellido, edad);
        this.Rol = rol;
    }

    @Override
    public String getRol() {
        return this.Rol;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }


}
