package gestorAplicacion.entidades;

public class Reserva {
    private Cliente cliente; 
    private Instalacion instalacion;
    private Horario horario; 
    private String horaReservada; 
    private String estado; 
    private double montoTotal; 

    // Constructor
    public Reserva(Cliente cliente, Instalacion instalacion, Horario horario, String horaReservada, String estado, double montoTotal) {
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.horario = horario;
        this.horaReservada = horaReservada;
        this.estado = estado;
        this.montoTotal = montoTotal;
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getHoraReservada() {
        return horaReservada;
    }

    public void setHoraReservada(String horaReservada) {
        this.horaReservada = horaReservada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    // Mostrar información de la reserva
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", instalacion=" + instalacion +
                ", horario=" + horario.getDia() +
                ", horaReservada='" + horaReservada + '\'' +
                ", estado='" + estado + '\'' +
                ", montoTotal=" + montoTotal +
                '}';
    }
}