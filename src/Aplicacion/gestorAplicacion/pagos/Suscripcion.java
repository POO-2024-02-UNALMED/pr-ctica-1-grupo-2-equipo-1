package gestorAplicacion.pagos;

import java.time.LocalDate;

public class Suscripcion {
    private TipoSuscripcion tipoSuscripcion;
    private LocalDate inicioSuscripcion;
    private LocalDate finSuscripcion;

    public Suscripcion(TipoSuscripcion tipoSuscripcion){
        this.tipoSuscripcion = tipoSuscripcion;
        this.inicioSuscripcion = LocalDate.now();
        this.finSuscripcion = LocalDate.now().plusMonths(1);
    }

}