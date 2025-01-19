package gestorAplicacion.entidades;

import java.io.Serializable;

public class Reserva implements Serializable {
    private Cliente cliente;
    private Instalacion instalacion;
    private String horaReservada; // La hora reservada
    private Horario horario; // El horario asociado a la instalación
    private String estado; // Estado de la reserva (por defecto "Activa")

    public Reserva(Cliente cliente, Instalacion instalacion, String horaReservada, Horario horario) {
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.horaReservada = horaReservada;
        this.horario = horario;
        this.estado = "Activa"; // Estado por defecto
    }
    
    // Constructor con estado opcional
    public Reserva(Cliente cliente, Instalacion instalacion, String horaReservada, Horario horario, String estado) {
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.horaReservada = horaReservada;
        this.horario = horario;
        this.estado = estado;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public String getHoraReservada() {
        return horaReservada;
    }

    public Horario getHorario() {
        return horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva de " + cliente.getNombreCompleto() +
               ", Instalación: " + instalacion.getNombre() +
               ", Hora: " + horaReservada +
               ", Estado: " + estado;
    }
}