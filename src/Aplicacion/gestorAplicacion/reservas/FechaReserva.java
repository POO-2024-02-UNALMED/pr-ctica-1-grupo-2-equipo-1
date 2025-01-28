package gestorAplicacion.reservas;

import java.time.LocalDateTime;

public class FechaReserva {
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
