package gestorAplicacion.servicios;

import java.util.Date;
import gestorAplicacion.entidades.Entrenador;
import gestorAplicacion.entidades.Joven;

public class RegistrosEntrenamiento {

    public Date fecha;
    public String anotaciones;
    public double nota;
    public Entrenador entrenador;
    public Joven joven;

    // Constructor
    public RegistrosEntrenamiento(Date fecha, String anotaciones, double nota, Entrenador entrenador, Joven joven) {
        this.fecha = fecha;
        this.anotaciones = anotaciones;
        this.nota = nota;
        this.entrenador = entrenador;
        this.joven = joven;
    }

    // Getters y Setters
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getAnotaciones() {
        return anotaciones;
    }
    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public Entrenador getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    public Joven getJoven() {
        return joven;
    }
    public void setJoven(Joven joven) {
        this.joven = joven;
    }
}