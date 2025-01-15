package gestorAplicacion.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reserva implements Serializable {
    private Cliente nombreUsuario;
    private String cancha;
    private LocalDateTime fechaHora;

    public Reserva(Cliente nombreUsuario, String cancha, LocalDateTime fechaHora) {
        this.nombreUsuario = nombreUsuario;
        this.cancha = cancha;
        this.fechaHora = fechaHora;
    }

    public Cliente getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Cliente nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCancha() {
        return cancha;
    }

    public void setCancha(String cancha) {
        this.cancha = cancha;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Cliente='" + nombreUsuario + '\'' +
                ", cancha='" + cancha + '\'' +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
