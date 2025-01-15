package gestorAplicacion.entidades;

import java.util.List;

public class Torneo {
    private int idTorneo;
    private String deporte;
    private String formato;
    private String reglas;
    private List<Instalacion> instalacionesUsadas;
    private List<Equipo> equiposParticipantes;
    private List<Trabajador> arbitrosAsignados;
    private List<Trabajador> paramedicosAsignados;
    private double precioTotal;
    private boolean seguroMedico;

    public Torneo(int idTorneo, String deporte, String formato, String reglas, List<Instalacion> instalacionesUsadas, List<Equipo> equiposParticipantes) {
        this.idTorneo = idTorneo;
        this.deporte = deporte;
        this.formato = formato;
        this.reglas = reglas;
        this.instalacionesUsadas = instalacionesUsadas;
        this.equiposParticipantes = equiposParticipantes;
    }

    public void calcularPrecio() {
        // Lógica para calcular el precio total del torneo
    }

    public void asignarInstalaciones(List<Instalacion> instalacionesDisponibles) {
        // Lógica para asignar instalaciones
    }

    public void generarHorarios(List<Equipo> partidos, String modoAsignacion) {
        // Lógica para generar los horarios de los partidos
    }
}