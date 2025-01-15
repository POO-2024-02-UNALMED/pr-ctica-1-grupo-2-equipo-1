package gestorAplicacion.servicios;

import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Horario;
import gestorAplicacion.entidades.Instalacion;

public class Reserva {
    private Cliente cliente;
    private Instalacion instalacion;
    private Horario horario;
    private int duracionHoras;
    private String estado;
    private double montoTotal;

    public Reserva(Cliente cliente, Instalacion instalacion, Horario horario, int duracionHoras) {
        this.cliente = cliente;
        this.instalacion = instalacion;
        this.horario = horario;
        this.duracionHoras = duracionHoras;
        this.estado = "pendiente";
    }

   
    





    
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

    public int getDuracionHoras() {
        return duracionHoras;
    }
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
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
    public void setMontoTotal(double montoTotal){
        this.montoTotal = montoTotal;
    }

}