package gestorAplicacion.entidades;

import java.time.LocalTime;

import gestorAplicacion.entidades.Persona;

public class Evento {
    // Atributos principales
    private String idEvento;
    private String genero; // Género musical del concierto
    private String nombreConcierto;
    private Cliente organizadorConcierto; // Instancia de la clase Cliente
    private String nombreArtista;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean venderEnTaquilla;

    private Instalacion instalacionSeleccionada; // Instalación asignada al evento

    // Constructor
    public Evento(String idEvento, String genero, String nombreConcierto, Cliente organizadorConcierto, String nombreArtista,
                  LocalTime horaInicio, LocalTime horaFin, boolean venderEnTaquilla) {
        this.idEvento = idEvento;
        this.genero = genero;
        this.nombreConcierto = nombreConcierto;
        this.organizadorConcierto = organizadorConcierto;
        this.nombreArtista = nombreArtista;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.venderEnTaquilla = venderEnTaquilla;
        this.instalacionSeleccionada = null; // No asignada inicialmente
    }

    // Getters y Setters
    public String getIdEvento() {
        return idEvento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombreConcierto() {
        return nombreConcierto;
    }

    public void setNombreConcierto(String nombreConcierto) {
        this.nombreConcierto = nombreConcierto;
    }

    public Cliente getOrganizadorConcierto() {
        return organizadorConcierto;
    }

    public void setOrganizadorConcierto(Cliente organizadorConcierto) {
        this.organizadorConcierto = organizadorConcierto;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isVenderEnTaquilla() {
        return venderEnTaquilla;
    }

    public void setVenderEnTaquilla(boolean venderEnTaquilla) {
        this.venderEnTaquilla = venderEnTaquilla;
    }

    public Instalacion getInstalacionSeleccionada() {
        return instalacionSeleccionada;
    }

    public void setInstalacionSeleccionada(Instalacion instalacionSeleccionada) {
        this.instalacionSeleccionada = instalacionSeleccionada;
    }

    // Métodos de interacción

    /**
     * Método para calcular los costos base del evento.
     *
     * precioHora Costo por hora de la instalación.
     *  costosAdicionales Costos adicionales como logística y limpieza.
     * return El costo total calculado.
     */
    public double calcularCostos(double precioHora, double costosAdicionales) {
        if (horaInicio == null || horaFin == null || instalacionSeleccionada == null) {
            throw new IllegalStateException("Faltan datos para calcular los costos.");
        }

        long duracionHoras = java.time.Duration.between(horaInicio, horaFin).toHours();
        return (duracionHoras * precioHora) + costosAdicionales;
    }

    /**
     * Método para asignar una instalación al evento.
     *
     *instalacion La instalación seleccionada.
     */
    public void asignarInstalacion(Instalacion instalacion) {
        this.instalacionSeleccionada = instalacion;
        System.out.println("Instalación asignada correctamente al evento.");
    }

    /**
     * Método para mostrar los detalles del evento.
     *
     * return Una representación del evento en forma de texto.
     */
    @Override
    public String toString() {
        return "Evento{" +
                "idEvento='" + idEvento + '\'' +
                ", genero='" + genero + '\'' +
                ", nombreConcierto='" + nombreConcierto + '\'' +
                ", organizadorConcierto=" + //Persona.getNombreCompleto() + //Arreglar
                ", nombreArtista='" + nombreArtista + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", venderEnTaquilla=" + (venderEnTaquilla ? "Sí" : "No") +
                ", instalacionSeleccionada=" + (instalacionSeleccionada != null ? instalacionSeleccionada.getIdInstalacion() : "No asignada") +
                '}';
    }
}
