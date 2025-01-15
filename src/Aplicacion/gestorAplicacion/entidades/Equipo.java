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

    public static void ordenarEquiposPorPuntaje(List<Equipo> equipos) {
        // Lógica para ordenar los equipos según puntaje
    }
}
