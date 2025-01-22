package gestorAplicacion;

public abstract class Trabajador extends Persona {

    private int salarioHora;

    // Constructor con salario por defecto
    public Trabajador(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.salarioHora = 5000;
    }

    // Constructor con salario personalizado
    public Trabajador(String nombre, String apellido, int edad, int salarioHora) {
        super(nombre, apellido, edad);
        this.salarioHora = salarioHora;
    }

    public int getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(int salarioHora) {
        this.salarioHora = salarioHora;
    }

    public String getRol() {
        return "Trabajador";
    }
    public abstract String getTrabajo();
}
