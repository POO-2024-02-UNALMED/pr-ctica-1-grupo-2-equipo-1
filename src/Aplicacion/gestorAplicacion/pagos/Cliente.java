package gestorAplicacion.pagos;

import gestorAplicacion.entidades.Persona;

import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Persona {
    public static ArrayList<Cliente> listaClientes;
    private Suscripcion suscripcion;
    private int ID;

    public Cliente(String nombre, String apellido, int edad, int id){//No borrar, necesario para torneo
        super(nombre, apellido, edad);
        this.ID = id;
    }

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        Random idGen = new Random();
        this.suscripcion = new Suscripcion(TipoSuscripcion.NONE);
        this.ID = idGen.nextInt(100000);
        listaClientes.add(this);
    }
    public Cliente(String nombre,String apellido,int edad,Suscripcion suscripcion){
        super(nombre,apellido,edad);
        Random idGen = new Random();
        this.ID = idGen.nextInt(1000);
        this.suscripcion = suscripcion;
        listaClientes.add(this);
    }

    public static Cliente obtenerCliente(int ID){
        if(listaClientes != null){
            for(Cliente cliente : listaClientes){
                if(cliente.ID == ID){
                    return cliente;
                }
            }
        }
        return null;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public String getRol(){
        return "Cliente";
    }

    @Override
    public String toString() {
        return "Cliente Encontrado \n" +
                "Suscripcion:" + suscripcion + "\n" +
                "ID: " + ID + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "ID: " + id + "\n" +
                "Edad: " + edad;
    }
}