package gestorAplicacion.inscripcion;

import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.reservas.Reserva;

import java.io.Serializable;
import java.util.ArrayList;

public class GrupoFormativo implements Serializable {
    private static ArrayList<GrupoFormativo> grupoFormativos = new ArrayList<GrupoFormativo>();
    private Instalacion instalacion;
    private ArrayList<Joven> jovenes;
    private String deporte;
    private Reserva reserva;
    private Entrenador entrenador;

    public GrupoFormativo() {
        this.jovenes = new ArrayList<>();
    }

    public GrupoFormativo(String deporte, Instalacion instalacion, Entrenador entrenador) {
        this.deporte = deporte;
        this.instalacion = instalacion;
        this.entrenador = entrenador;
        this.jovenes = new ArrayList<>();
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public ArrayList<Joven> getJovenes() {
        return jovenes;
    }

    public void addJoven(Joven joven) {
        jovenes.add(joven);
    }

    public void deleteJoven(Joven joven) {
        jovenes.remove(joven);
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void resetJovenes() {
        jovenes = new ArrayList<>();
    }
}
