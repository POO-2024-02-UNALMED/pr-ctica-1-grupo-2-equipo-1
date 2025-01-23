package gestorAplicacion.entidades;

import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.inscripcion.Trabajador;

public class Entrenador extends Trabajador {

    private String deporte;
    private Instalacion instalacionAsignada;

    // Constructor de la clase Entrenador
    public Entrenador(String nombre, String apellido, int edad, int salarioHora, String deporte, Instalacion instalacionAsignada) {
        super(nombre, apellido, edad, salarioHora); // Llamada al constructor de Trabajador
        this.deporte = deporte;
        this.instalacionAsignada = instalacionAsignada;
    }

    // Getters y Setters
    public String getDeporte() {
        return deporte;
    }
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    public Instalacion getInstalacionAsignada() {
        return instalacionAsignada;
    }
    public void setInstalacionAsignada(Instalacion instalacionAsignada) {
        this.instalacionAsignada = instalacionAsignada;
    }

    @Override
    public String getTrabajo() {
        return "Entrenador";
    }
}
