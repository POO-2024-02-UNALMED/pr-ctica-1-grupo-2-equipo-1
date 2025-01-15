package gestorAplicacion.entidades;

public class Cliente extends Persona {
    private String preferencias; 
    private boolean suscrito;

    public Cliente(String nombre, String apellido, int edad, String preferencias, boolean suscrito) {
        super(nombre, apellido, edad);
        this.preferencias = preferencias;
        this.suscrito = suscrito;
    }

    // Método que retorna el rol del cliente
    public String getRol() {
        return "Cliente";
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public boolean isSuscrito() {
        return suscrito;
    }

    public void setSuscrito(boolean suscrito) {
        this.suscrito = suscrito;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Rol: Cliente, Preferencias: " + preferencias +
                ", Suscrito: " + (suscrito ? "Sí" : "No");
    }
}