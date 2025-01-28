package gestorAplicacion.inscripcion;

import gestorAplicacion.entidades.Persona;

import java.io.Serial;
import java.io.Serializable;

public class Entrenador extends Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String deporte;

    public Entrenador() {}
    public Entrenador(String nombre, String apellido, int edad, String deporte) {
        super(nombre, apellido, edad);
        this.deporte = deporte;
    }

    @Override
    public String getRol() {
        return "Entrenador";
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
