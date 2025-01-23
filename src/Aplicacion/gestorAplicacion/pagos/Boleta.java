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
