package gestorAplicacion.reservas;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

import baseDatos.Deserializador;
import gestorAplicacion.entidades.Trabajador;
import gestorAplicacion.inscripcion.GrupoFormativo;

import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.torneo.Equipo;

public class Reserva implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
    private int ID;
    private Cliente cliente;
    private Instalacion instalacion;
    private boolean pagada;
    private FechaReserva fechaReserva;
    private int aPagar;
    private Equipo equipo1;
    private Equipo equipo2;
    private GrupoFormativo grupoFormativo;
    private Trabajador arbitro;

    public Reserva() throws IOException, ClassNotFoundException {
        Deserializador.deserializar();
    }

    public Reserva(Cliente cliente, Instalacion instalacion, FechaReserva fechaReserva,int aPagar) {
        this.ID = listaReservas.size() + 1;
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.fechaReserva = fechaReserva;
        this.aPagar = aPagar;
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
        return "Reserva Informacion" + "\n" +
                "ID: " + this.ID + "\n" +
                "Cliente nombre: " + cliente.getNombre()+ " " + cliente.getApellido() + "\n" +
                "Instalacion: " + instalacion.getNombre() + "\n" +
                "Total basico: " + this.aPagar + "\n" +
                "Total a pagar con descuento de suscripcion: " + (this.aPagar - this.aPagar * cliente.getSuscripcion().getTipoSuscripcion().getDescuento()) + "\n" +
                "Pagada: " + this.pagada;
    }

    public String toString(String x){
        return "Reserva Informacion" +
                "ID: " + ID + "\n" +
                "Pagada: " + pagada + x;
    }

    public int getID(){
        return this.ID;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public int getaPagar() {return this.aPagar;}

    public void setPagada(){
        this.pagada = true;
    }

    public static ArrayList<Reserva> getListaReservas(){
        return listaReservas;
    }

    public static void setListaReservas(ArrayList<Reserva> lista){
        listaReservas = lista;
    }



}