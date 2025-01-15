package gestorAplicacion.entidades;

import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.servicios.RegistrosEntrenamiento;

public class Joven extends Persona {
    public int experienciaJoven;
    public Acudiente acudiente;
    public String eps;
    public List<gestorAplicacion.servicios.RegistrosEntrenamiento> registrosEntrenamientos;

    // Constructor de la clase Joven
    public Joven(String nombre, String apellido, int edad, int experiencia, String eps, Acudiente acudiente) {
        super(nombre, apellido, edad);
        this.experienciaJoven = experiencia;
        this.eps = eps;
        this.acudiente = acudiente;
        this.registrosEntrenamientos = new ArrayList<>();  // Inicialización de la lista de registros
    }

    // Setters y getters
    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public List<Registro> getRegistros() {
        return registrosEntrenamientos;
    }

    public void setRegistros(List<Registro> registrosEntrenamientos) {
        this.registrosEntrenamientos = registrosEntrenamientos;
    }

    public void agregarRegistro(Registro registrosEntrenamiento) {
        registrosEntrenamientos.add(registrosEntrenamiento);
    }

    public String getRol() {
        return "Joven";
    }
}
