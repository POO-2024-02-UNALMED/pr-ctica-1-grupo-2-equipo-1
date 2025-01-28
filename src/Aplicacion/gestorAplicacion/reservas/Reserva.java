package gestorAplicacion.reservas;

import java.util.ArrayList;
import gestorAplicacion.inscripcion.GrupoFormativo;

import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.torneo.Equipo;

public class Reserva{
    private static ArrayList<Reserva> listaReservas;
    private int ID;
    private Cliente cliente;
    private Instalacion instalacion;
    private boolean pagada;
    private FechaReserva fechaReserva;
    private Equipo equipo1;
    private Equipo equipo2;
    private GrupoFormativo grupoFormativo;

    public Reserva() {}
    public Reserva(Cliente cliente, Instalacion instalacion, String horaReservada) {
        this.ID = listaReservas.size() + 1;
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.pagada = false;
    }

    public Reserva(Cliente cliente, Instalacion instalacion, FechaReserva fechaReserva) {
        this.ID = listaReservas.size() + 1;
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.fechaReserva = fechaReserva;
        this.pagada = false;
    }

    //Constructor para Torneos
    public Reserva(Instalacion instalacion, String horaReservada, Equipo equipo1, Equipo equipo2) {
        this.ID = listaReservas.size() + 1;
        this.instalacion = instalacion;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    //Constructor para fomrativo
    public Reserva(Instalacion instalacion, String horaReservada, GrupoFormativo grupoFormativo) {
        this.instalacion = instalacion;
        this.ID = listaReservas.size() + 1;
        this.grupoFormativo = grupoFormativo;
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

    @Override
    public String toString() {
        return "Reserva Informacion" +
                "ID: " + ID + "\n" +
                "Cliente nombre: " + cliente.getNombre()+ " " + cliente.getApellido() + "\n" +
                "Instalacion: " + instalacion.getNombre() + "\n" +
                "Pagada: " + pagada;
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

    public boolean getPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }


}