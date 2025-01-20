package gestorAplicacion.entidades;

import java.util.Scanner;

public class Cliente {
    private String id;//NUMERO DE IDENTIFICACION DNI T.I C.C  
    private String nombre;
    private String apellido;
    private int edad;
    private String instalacionPreferida;
    private String deporte;
    private double precioMinimo;
    private double precioMaximo;
    private boolean suscrito;
    private String nombreCompleto; 

  
    public Cliente(String id, String nombre, String apellido, int edad, String instalacionPreferida, String deporte, double precioMinimo, double precioMaximo, boolean suscrito) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.instalacionPreferida = instalacionPreferida;
        this.deporte = deporte;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
        this.suscrito = suscrito;
        this.nombreCompleto = nombre + " " + apellido;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInstalacionPreferida() {
        return instalacionPreferida;
    }

    public void setInstalacionPreferida(String instalacionPreferida) {
        this.instalacionPreferida = instalacionPreferida;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public double getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public double getPrecioMaximo() {
        return precioMaximo;
    }

    public void setPrecioMaximo(double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    public boolean isSuscrito() {
        return suscrito;
    }

    public void setSuscrito(boolean suscrito) {
        this.suscrito = suscrito;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    @Override
    public String toString() {
        return  id +
                "," + nombre +
                "," + apellido +
                "," + edad +
                "," + instalacionPreferida +
                "," + deporte +
                "," + precioMinimo +
                "," + precioMaximo +
                "," + suscrito;
    }

    public static Cliente solicitarDatosCliente(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente (Numero de Identificacion): ");
        String idCliente = scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellidoCliente = scanner.nextLine();
        System.out.print("Ingrese la edad del cliente: ");
        int edadCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Desea ingresar sus preferencias? (si/no): ");
        String deseaPreferencias = scanner.nextLine().toLowerCase();
        String instalacionPreferida = "";
        String deporte = "";
        double precioMinimo = 0.0;
        double precioMaximo = 0.0;

        if (deseaPreferencias.equals("si")) {
            System.out.print("Ingrese la instalación preferida: ");
            instalacionPreferida = scanner.nextLine();
            System.out.print("Ingrese el deporte preferido: ");
            deporte = scanner.nextLine();
            System.out.print("Ingrese el precio mínimo: ");
            precioMinimo = scanner.nextDouble();
            System.out.print("Ingrese el precio máximo: ");
            precioMaximo = scanner.nextDouble();
            scanner.nextLine();
        }

        System.out.print("¿El cliente está suscrito? (si/no): ");
        String respuestaSuscripcion = scanner.nextLine().toLowerCase();
        boolean suscrito = respuestaSuscripcion.equals("si");

        return new Cliente(idCliente, nombreCliente, apellidoCliente, edadCliente, instalacionPreferida, deporte, precioMinimo, precioMaximo, suscrito);
    }

}