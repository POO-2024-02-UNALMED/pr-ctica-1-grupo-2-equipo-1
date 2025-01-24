package gestorAplicacion.reservas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.torneo.Equipo;

public class Reserva implements Serializable {
    private static ArrayList<Reserva> listaReservas;
    private int ID;
    private Cliente cliente;
    private Instalacion instalacion;
    private String horaReservada; // La hora reservada
    private Horario horario; // El horario asociado a la instalación
    private EstadoReserva estado;
    private Equipo equipo1;
    private Equipo equipo2;

    public Reserva(Cliente cliente, Instalacion instalacion, String horaReservada, Horario horario) {
        Random idGen = new Random();
        this.ID = idGen.nextInt(1000);
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.horaReservada = horaReservada;
        this.horario = horario;
        this.estado = EstadoReserva.PENDIENTE;
    }
    
    // Constructor con estado opcional
    public Reserva(Cliente cliente, Instalacion instalacion, String horaReservada, Horario horario, EstadoReserva estado) {
        Random idGen = new Random();
        this.ID = idGen.nextInt(1000);
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.horaReservada = horaReservada;
        this.horario = horario;
        this.estado = estado;
    }

    //Constructor para Torneos
    public Reserva(Instalacion instalacion, Horario horario, String horaReservada, Equipo equipo1, Equipo equipo2) {
        Random idGen = new Random();
        this.ID = idGen.nextInt(1000);
        this.instalacion = instalacion;
        this.horario = horario;
        this.horaReservada = horaReservada;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public static Reserva buscarReserva(int ID){
        if(listaReservas != null){
            for (Reserva reserva: listaReservas){
                if(reserva.ID == ID){
                    return reserva;
                }
            }
        }
        return null;
    }

    public int getID(){
        return this.ID;
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

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return cliente.toString() +
               "-" + instalacion.getNombre() +
               "-" + horaReservada +
               "-" + estado;
    }
}