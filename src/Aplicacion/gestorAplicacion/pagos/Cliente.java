package gestorAplicacion.pagos;

import gestorAplicacion.entidades.Persona;

public class Cliente extends Persona {
    private Suscripcion suscripcion;

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public String getRol(){
        return "Cliente";
    }


}