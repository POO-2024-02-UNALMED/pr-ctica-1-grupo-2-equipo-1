package gestorAplicacion.reservas;

import java.util.ArrayList;
import java.util.Scanner;

public class Instalacion {
    private static ArrayList<Instalacion> listaInstalaciones = new ArrayList<Instalacion>();
    private final int ID;
    private String deporte;
    private int precioHora;
    private String nombre;
    private ArrayList<Horario> horarios;
    private ArrayList<Reserva> reservas;

    // Constructor con todos los atributos
    public Instalacion(String nombre, String deporte, int precioHora) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.precioHora = precioHora;
        this.ID = listaInstalaciones.size() + 1;
        this.horarios = new ArrayList<Horario>();
        this.reservas = new ArrayList<Reserva>();
    }

    public Instalacion(String nombre,String deporte, int precioHora,ArrayList<Horario> horarios,ArrayList<Reserva> reservas){
        this(nombre,deporte,precioHora);
        this.horarios = horarios;
        this.reservas = reservas;
    }
    public static String deporteViaNumero(int opcion){
        return switch (opcion) {
            case 1 -> "Futbol";
            case 2 -> "Baloncesto";
            case 3 -> "Natacion";
            case 4 -> "Voleibol";
            default -> null;
        };
    }

    public static void crearInstalaciones(){
        listaInstalaciones.add(new Instalacion("Cancha F11 1","Futbol",3000));
        listaInstalaciones.add(new Instalacion("Cancha F11 2","Futbol",3000));
        listaInstalaciones.add(new Instalacion("Cancha F9","Futbol",2000));
        listaInstalaciones.add(new Instalacion("Cancha F7","Futbol",1000));

        listaInstalaciones.add(new Instalacion("Coliseo","Baloncesto",4000));
        listaInstalaciones.add(new Instalacion("Cancha techada 1","Baloncesto",1000));
        listaInstalaciones.add(new Instalacion("Cancha techada 2","Baloncesto",1000));

        listaInstalaciones.add(new Instalacion("Piscina olimpica","Natacion",6000));
        listaInstalaciones.add(new Instalacion("Piscina semiolimpica","Natacion",4000));
        listaInstalaciones.add(new Instalacion("Piscina infantil","Natacion",2000));

        listaInstalaciones.add(new Instalacion("Cancha de cemento","Voleibol",3000));
        listaInstalaciones.add(new Instalacion("Cancha de arena","Voleibol",2000));
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getDeporte(){
        return this.deporte;
    }

    public int getID(){
        return this.ID;
    }

    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }

    public static ArrayList<Instalacion> getListaInstalaciones(){
        return listaInstalaciones;
    }

    public static Instalacion obtenerInstalacion(int id){
        if(listaInstalaciones != null){
            for (Instalacion instalacion: listaInstalaciones){
                if(instalacion.getID() == id){
                    return instalacion;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Instalacion Informacion: \n" +
                "ID: " + this.ID + "\n " +
                "Nombre: " + this.nombre + "\n " +
                "Deporte" + this.deporte + "\n " +
                "Precio por hora" + this.precioHora;
    }
}


