package gestorAplicacion.pagos;

import gestorAplicacion.entidades.Persona;

import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Persona {
    public static ArrayList<Cliente> listaClientes;
    private Suscripcion suscripcion;
    private int ID;

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        Random idGen = new Random();
        this.ID = idGen.nextInt(100000);
        listaClientes.add(this);
    }
    public Cliente(String nombre,String apellido,int edad,Suscripcion suscripcion){
        super(nombre,apellido,edad);
        Random idGen = new Random();
        this.ID = idGen.nextInt(100000);
        this.suscripcion = suscripcion;
        listaClientes.add(this);
    }

    public String getRol(){
        return "Cliente";
    }


}