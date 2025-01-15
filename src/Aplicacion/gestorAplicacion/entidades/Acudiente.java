package gestorAplicacion.entidades;

public class Acudiente extends Persona {
    public Joven protegido;
    public Long telefono;

    //Constructor de la clase Acudiente
    public Acudiente(String nombre, String apellido, int edad, Joven protegido, Long telefono) {
        super(nombre, apellido, edad);
        this.protegido = protegido;
        this.telefono = telefono;
    }

    //Setters y getters
    public String getRol() {
        return "Acudiente";
    }
    public Joven getProtegido() {
        return protegido;
    }
    public Long getTelefono() {
        return telefono;
    }
    public void setProtegido(Joven protegido) {
        this.protegido = protegido;
    }
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
}