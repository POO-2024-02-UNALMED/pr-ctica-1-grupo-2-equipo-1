package gestorAplicacion.inscripcion;

import gestorAplicacion.entidades.Persona;

public class Entrenador extends Persona {
    private String deporte;

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
