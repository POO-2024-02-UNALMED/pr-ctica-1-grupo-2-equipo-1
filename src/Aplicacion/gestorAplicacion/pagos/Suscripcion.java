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

    public boolean verificacionVencimiento(){
        if(this.finSuscripcion.isBefore(LocalDate.now())){
            return false;
        }
        else{
            return true;
        }
    }

    public LocalDate getFinSuscripcion() {
        return finSuscripcion;
    }
    public LocalDate getInicioSuscripcion() {
        return inicioSuscripcion;
    }
    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }
}