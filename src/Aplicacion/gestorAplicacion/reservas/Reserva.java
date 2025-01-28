package gestorAplicacion.reservas;

import java.util.ArrayList;

import gestorAplicacion.entidades.Trabajador;
import gestorAplicacion.inscripcion.GrupoFormativo;

import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.torneo.Equipo;

public class Reserva{
    private static ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
    private int ID;
    private Cliente cliente;
    private Instalacion instalacion;
    private boolean pagada;
    private FechaReserva fechaReserva;
    private Equipo equipo1;
    private Equipo equipo2;
    private GrupoFormativo grupoFormativo;
    private Trabajador arbitro;

    public Reserva() {}
    public Reserva(Cliente cliente, Instalacion instalacion, String horaReservada) {
        this.ID = listaReservas.size() + 1;
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.pagada = false;
        listaReservas.add(this);
    }

    public Reserva(Cliente cliente, Instalacion instalacion, FechaReserva fechaReserva) {
        this.ID = listaReservas.size() + 1;
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.fechaReserva = fechaReserva;
        this.pagada = false;
        listaReservas.add(this);
    }

    //Constructor para torneos de Natacion
    public Reserva(Instalacion instalacion, FechaReserva fechaReserva) {
        this.ID = listaReservas.size() + 1;
    }

    //Constructor para Torneos
    public Reserva(Instalacion instalacion, FechaReserva fechaReserva, Equipo equipo1, Equipo equipo2, Trabajador arbitro) {
        this.ID = listaReservas.size() + 1;
        this.instalacion = instalacion;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.arbitro= arbitro;
        this.fechaReserva = fechaReserva;
        listaReservas.add(this);
    }

    //Constructor para fomrativo
    public Reserva(Instalacion instalacion, String horaReservada, GrupoFormativo grupoFormativo) {
        this.instalacion = instalacion;
        this.ID = listaReservas.size() + 1;
        this.grupoFormativo = grupoFormativo;
        listaReservas.add(this);
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

    public String toStringReserva(){
        return "Reserva Informacion" +
                "ID: " + ID + "\n" +
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