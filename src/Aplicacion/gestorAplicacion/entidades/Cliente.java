package gestorAplicacion.entidades;

public class Cliente {
    private String id;  
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
        return "Cliente{" +
                "ID='" + id + '\'' +  // Mostrar el ID en el toString
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", instalacionPreferida='" + instalacionPreferida + '\'' +
                ", deporte='" + deporte + '\'' +
                ", precioMinimo=" + precioMinimo +
                ", precioMaximo=" + precioMaximo +
                ", suscrito=" + suscrito +
                '}';
    }
}