package gestorAplicacion.inscripcion;

import gestorAplicacion.entidades.Persona;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Joven extends Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static ArrayList<Joven> listaJovenes = new ArrayList<Joven>();
    private int experienciaJoven;
    private String eps;
    private String nombreAcudiente;
    private String telefonoAcudiente;
    private String cedulaAcudiente;
    private ArrayList<Integer> registrosEntrenamiento;

    public Joven() {}
    public Joven(String nombre, String apellido, int id, int edad, int experienciaJoven, String eps, String nombreAcudiente,
                 String telefonoAcudiente, String cedulaAcudiente) {
        super(nombre, apellido, edad, id);
        this.experienciaJoven = experienciaJoven;
        this.eps = eps;
        this.nombreAcudiente = nombreAcudiente;
        this.telefonoAcudiente = telefonoAcudiente;
        this.cedulaAcudiente = cedulaAcudiente;
        this.registrosEntrenamiento = new ArrayList<>();
    }

    @Override
    public String getRol() {
        return "Joven";
    }

    public ArrayList<Joven> getListaJovenes() {
        return listaJovenes;
    }
    public void setListaJovenes(ArrayList<Joven> listaJovenes) {
        this.listaJovenes = listaJovenes;
    }

    public int getExperienciaJoven() {
        return experienciaJoven;
    }

    public void setExperienciaJoven(int experienciaJoven) {
        this.experienciaJoven = experienciaJoven;
    }

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

    public int darCategoria(int exp){
        if (exp < 6){
            return 1;
        } else if (exp < 12){
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public String toString() {
        return "Joven{nombre='" + nombre + "', apellido='" + apellido
                + "', edad=" + edad + ", experiencia=" + experienciaJoven
                + ", eps='" + eps + "', acudiente='" + nombreAcudiente
                + "', telAcudiente='" + telefonoAcudiente
                + "', cedulaAcudiente='" + cedulaAcudiente + "'}";
    }
}
