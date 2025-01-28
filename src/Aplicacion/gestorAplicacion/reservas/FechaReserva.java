package gestorAplicacion.reservas;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class FechaReserva implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private LocalDateTime inicioReserva;
    private LocalDateTime finReserva;

    public FechaReserva(LocalDateTime inicioReserva, LocalDateTime finReserva){
        this.inicioReserva = inicioReserva;
        this.finReserva = finReserva;
    }

    public LocalDateTime getInicioReserva(){
        return this.inicioReserva;
    }

    public LocalDateTime getFinReserva(){
        return this.finReserva;
    }
}
