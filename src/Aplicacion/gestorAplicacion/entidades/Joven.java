package gestorAplicacion.entidades;

import java.util.ArrayList;

public class Joven extends Persona {
    public int experienciaJoven;
    public String eps;
    public String nombreAcudiente;
    public String telefonoAcudiente;
    public String cedulaAcudiente;
    public ArrayList<Integer> registrosEntrenamiento;

    // Constructor de la clase Joven
    public Joven(String nombre, String apellido, int edad, int experiencia, String eps, String nombreAcudiente, String telefonoAcudiente, String cedulaAcudiente) {
        super(nombre, apellido, edad);
        this.experienciaJoven = experiencia;
        this.eps = eps;
        this.nombreAcudiente = nombreAcudiente;
        this.telefonoAcudiente = telefonoAcudiente;
        this.cedulaAcudiente = cedulaAcudiente;
        this.registrosEntrenamiento = new ArrayList<>(); // Inicialización del ArrayList
    }

    // Getters y Setters
    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(String telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public String getCedulaAcudiente() {
        return cedulaAcudiente;
    }

    public void setCedulaAcudiente(String cedulaAcudiente) {
        this.cedulaAcudiente = cedulaAcudiente;
    }

    public ArrayList<Integer> getRegistrosEntrenamiento() {
        return registrosEntrenamiento;
    }

    public void setRegistrosEntrenamiento(ArrayList<Integer> registrosEntrenamiento) {
        this.registrosEntrenamiento = registrosEntrenamiento;
    }

    public void agregarRegistroEntrenamiento(Integer registro) {
        this.registrosEntrenamiento.add(registro);
    }

    public String getRol() {
        return "Joven";
    }
}