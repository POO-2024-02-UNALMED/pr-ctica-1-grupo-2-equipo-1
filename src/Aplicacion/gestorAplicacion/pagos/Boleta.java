package gestorAplicacion.pagos;

public class Boleta {

    // Atributos
    private String idBoleta;
    private String tipoEvento; // Concierto, partido, etc.
    private String formato; // Física o Virtual
    private double precio;
    private int transferencias; // Número de transferencias realizadas
    private String estado; // Pagada, Disponible, etc.

    // Constructor
    public Boleta(String idBoleta, String tipoEvento, String formato, double precio) {
        this.idBoleta = idBoleta;
        this.tipoEvento = tipoEvento;
        this.formato = formato;
        this.precio = precio;
        this.transferencias = 0; // Inicia en 0 por defecto
        this.estado = "Disponible"; // Estado inicial
    }

    // Getters y Setters
    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(int transferencias) {
        this.transferencias = transferencias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos

    /**
     * Genera una boleta con los detalles del evento y la asocia a un cliente.
     * tipoEvento Tipo de evento (Concierto, Partido, etc.)
     * formato Formato de la boleta (Física o Virtual)
     * precio Precio de la boleta
     * Una nueva instancia de Boleta
     */
    public static Boleta generarBoleta(String tipoEvento, String formato, double precio) {
        String idBoleta = generarIdUnico(tipoEvento);
        return new Boleta(idBoleta, tipoEvento, formato, precio);
    }

    /**
     * Transfiere la boleta a un nuevo propietario.
     * nuevoPropietario Nombre del nuevo propietario
     * return true si la transferencia es exitosa, false en caso contrario
     */
    public boolean transferirBoleta(String nuevoPropietario) {
        if (estado.equals("Pagada")) {
            transferencias++;
            System.out.println("La boleta ha sido transferida a: " + nuevoPropietario);
            return true;
        } else {
            System.out.println("La boleta no puede ser transferida. Estado actual: " + estado);
            return false;
        }
    }

    /**
     * Genera un ID único para la boleta.
     * tipoEvento Tipo de evento para el cual se genera la boleta
     * return ID único de la boleta
     */
    private static String generarIdUnico(String tipoEvento) {
        return tipoEvento.substring(0, 3).toUpperCase() + "-" + System.currentTimeMillis();
    }

    // Método para mostrar los detalles de la boleta
    @Override
    public String toString() {
        return "Boleta{" +
                "idBoleta='" + idBoleta + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", formato='" + formato + '\'' +
                ", precio=" + precio +
                ", transferencias=" + transferencias +
                ", estado='" + estado + '\'' +
                '}';
    }
}
