package gestorAplicacion.inscripcion;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.Persona;

public class Joven extends Persona {
    public int experienciaJoven;
    public String eps;
    public String nombreAcudiente;
    public String telefonoAcudiente;
    public String cedulaAcudiente;
    public ArrayList<Integer> registrosEntrenamiento;

    // Constructor de la clase Joven
    public Joven(String nombre, String apellido, int edad, int experiencia, String eps, String nombreAcudiente, String telefonoAcudiente, String cedulaAcudiente) {
        super(nombre, apellido, edad);
        this.experienciaJoven = experiencia;
        this.eps = eps;
        this.nombreAcudiente = nombreAcudiente;
        this.telefonoAcudiente = telefonoAcudiente;
        this.cedulaAcudiente = cedulaAcudiente;
        this.registrosEntrenamiento = new ArrayList<>(); // Inicialización del ArrayList
    }

    // Getters y Setters
    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(String telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public String getCedulaAcudiente() {
        return cedulaAcudiente;
    }

    public void setCedulaAcudiente(String cedulaAcudiente) {
        this.cedulaAcudiente = cedulaAcudiente;
    }

    public ArrayList<Integer> getRegistrosEntrenamiento() {
        return registrosEntrenamiento;
    }

    public void setRegistrosEntrenamiento(ArrayList<Integer> registrosEntrenamiento) {
        this.registrosEntrenamiento = registrosEntrenamiento;
    }

    public void agregarRegistroEntrenamiento(Integer registro) {
        this.registrosEntrenamiento.add(registro);
    }

    public String getRol() {
        return "Joven";
    }
    public String toString() {
        return "Joven{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", experiencia=" + experienciaJoven +
                ", eps='" + eps + '\'' +
                ", nombreAcudiente='" + nombreAcudiente + '\'' +
                ", telefonoAcudiente='" + telefonoAcudiente + '\'' +
                ", cedulaAcudiente='" + cedulaAcudiente + '\'' +
                '}';
    }
    public static Joven RegistrarJoven(Scanner scanner) { // Recibimos el objeto Scanner como parámetro
        System.out.println("Ingrese el nombre del joven:");
        String nombreJoven = scanner.nextLine();

        System.out.println("Ingrese el apellido del joven:");
        String apellidoJoven = scanner.nextLine();

        System.out.println("Ingrese la edad del joven:");
        int edadJoven = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la experiencia del joven (en meses):");
        int experienciaJoven = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la EPS del joven:");
        String eps = scanner.nextLine();

        System.out.println("Ingrese el nombre del acudiente:");
        String nombreAcudiente = scanner.nextLine();

        System.out.println("Ingrese el teléfono del acudiente:");
        String telefonoAcudiente = scanner.nextLine();

        System.out.println("Ingrese la cédula del acudiente:");
        String cedulaAcudiente = scanner.nextLine();

        Joven jovenRegistrado = new Joven(
                nombreJoven,
                apellidoJoven,
                edadJoven,
                experienciaJoven,
                eps,
                nombreAcudiente,
                telefonoAcudiente,
                cedulaAcudiente
        );

        System.out.println("Joven registrado con éxito");
        return jovenRegistrado;
    }
}