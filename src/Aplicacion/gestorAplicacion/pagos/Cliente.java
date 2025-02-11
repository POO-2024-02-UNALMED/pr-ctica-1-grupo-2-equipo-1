package gestorAplicacion.pagos;

import gestorAplicacion.entidades.Persona;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private Suscripcion suscripcion;
    private final int ID;

    public Cliente(String nombre, String apellido, int edad, int id){//No borrar, necesario para torneo
        super(nombre, apellido, edad);
        this.ID = id;
    }

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.suscripcion = new Suscripcion(TipoSuscripcion.NOTIENE);
        this.ID = listaClientes.size() + 1;
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

    public static ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public String getRol(){
        return "Cliente";
    }

    public static void setListaClientes(ArrayList<Cliente> lista){
        listaClientes = lista;
    }

    @Override
    public String toString() {
        return "Informacion Cliente \n" +
                "Suscripcion:" + suscripcion.getTipoSuscripcion() + "\n" +
                "ID: " + ID + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Edad: " + getEdad();
    }
}