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
        return !this.finSuscripcion.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Informacion de suscripcion \n" +
                "Tipo de suscripcion: " + tipoSuscripcion + "\n" +
                "Inicio suscripcion: " + inicioSuscripcion + "\n" +
                "Fin suscripcion: " + finSuscripcion;
    }

    public LocalDate getFinSuscripcion() {
        return finSuscripcion;
    }
    public void setFinSuscripcion(LocalDate finSuscripcion){
        this.finSuscripcion = finSuscripcion;
    }
    public void setTipoSuscripcion(TipoSuscripcion tipoSuscripcion){
        this.tipoSuscripcion = tipoSuscripcion;
    }
    public LocalDate getInicioSuscripcion() {
        return inicioSuscripcion;
    }
    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }
}