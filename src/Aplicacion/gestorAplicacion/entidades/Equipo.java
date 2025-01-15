package gestorAplicacion.entidades;

import java.util.List;

public class Equipo {
    private int idEquipo;
    private String nombreEquipo;
    private List<String> jugadores;
    private int puntaje;

    public Equipo(int idEquipo, String nombreEquipo, List<String> jugadores) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.jugadores = jugadores;
        this.puntaje = 0;
    }

    public void actualizarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public List<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<String> jugadores) {
        this.jugadores = jugadores;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}
