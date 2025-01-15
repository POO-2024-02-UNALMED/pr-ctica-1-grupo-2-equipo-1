package gestorAplicacion.entidades;
import java.util.ArrayList;
import java.util.List;
public class Acudiente extends Persona {
    public List<Joven> protegidos;
    public String telefono;

    //Constructor de la clase Acudiente
    public Acudiente(String nombre, String apellido, int edad, String telefono) {
        super(nombre, apellido, edad);
        this.telefono = telefono;
        this.protegidos = new ArrayList<>();
    }

    //Setters y getters
    public String getRol() {
        return "Acudiente";
    }
    public List<Joven> getProtegidos() {
        return protegidos;
    }
    public int getNumeroDeProtegidos() {
        return protegidos.size();
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //Suma y sustracción de protegidos
    public void agregarProtegido(Joven joven) {
        protegidos.add(joven);
    }
    public void eliminarProtegido(Joven joven) {
        protegidos.remove(joven);
    }
}