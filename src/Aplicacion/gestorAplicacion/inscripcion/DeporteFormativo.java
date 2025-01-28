package gestorAplicacion.inscripcion;

import java.io.Serial;
import java.io.Serializable;

public class DeporteFormativo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    private String eps;
    private String acudiente;
    private String deporteDeseado;
    private int experienciaMeses;
    private String categoriaEquipo;
    private String categoriaEntrenador;
    private String horario;

    public DeporteFormativo() {
    }

    // Setters para cargar datos desde Main (en lugar de Scanner)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public void setDeporteDeseado(String deporteDeseado) {
        this.deporteDeseado = deporteDeseado;
    }

    public void setExperienciaMeses(int experienciaMeses) {
        this.experienciaMeses = experienciaMeses;
    }

    // Lógica interna para clasificar según experiencia y asignar horario
    public void clasificarYAsignar() {
        if (experienciaMeses < 6) {
            this.categoriaEquipo = "Categoría 1";
            this.categoriaEntrenador = "Entrenador Categoría 1";
        } else if (experienciaMeses <= 12) {
            this.categoriaEquipo = "Categoría 2";
            this.categoriaEntrenador = "Entrenador Categoría 2";
        } else {
            this.categoriaEquipo = "Categoría 3";
            this.categoriaEntrenador = "Entrenador Categoría 3";
        }

        if (edad <= 12) {
            this.horario = "Mañana: 6 AM - 12 M";
        } else {
            this.horario = "Tarde: 1 PM - 8 PM";
        }
    }

    // Getters para que Main pueda leer los resultados
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEps() {
        return eps;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public String getDeporteDeseado() {
        return deporteDeseado;
    }

    public int getExperienciaMeses() {
        return experienciaMeses;
    }

    public String getCategoriaEquipo() {
        return categoriaEquipo;
    }

    public String getCategoriaEntrenador() {
        return categoriaEntrenador;
    }

    public String getHorario() {
        return horario;
    }
}
