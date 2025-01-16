package gestorAplicacion.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reserva implements Serializable {
    private Cliente usuario;
    private String cancha;
    private LocalDateTime fechaHora;

    public Reserva(Cliente usuario,String cancha, LocalDateTime fechaHora) {
        this.usuario = usuario;
        this.cancha = cancha;
        this.fechaHora = fechaHora;
    }

    public Cliente getUsuario() {
        return this.usuario;
    }

    public void setNombreUsuario(Cliente usuario) {
        this.usuario = usuario;
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
                "Cliente='" + this.usuario.nombre + '\'' +
                ", cancha='" + this.cancha + '\'' +
                ", fechaHora=" + this.fechaHora +
                '}';
    }
}
