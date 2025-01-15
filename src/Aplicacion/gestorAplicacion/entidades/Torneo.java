package gestorAplicacion.entidades;

import gestorAplicacion.servicios.Formato;
import gestorAplicacion.entidades.Equipo;
import gestorAplicacion.servicios.seguroMedico;

import java.util.List;

public class Torneo {
    private int idTorneo;
    public String deporte;
    private Formato formato;
    private List<Equipo> equiposParticipantes;
    private seguroMedico seguroMedico;
    private double precioTotal;

    public Torneo(int idTorneo, String deporte, Formato formato) {
        this.idTorneo = idTorneo;
        this.deporte = deporte;
        this.formato = formato;
    }

    public void asignarEquipos(List<Equipo> equipos) {
        this.equiposParticipantes = equipos;
    }

    public void generarHorarios() {
        // Lógica para generar los horarios
    }

    public void calcularPrecio() {
        this.precioTotal = equiposParticipantes.size() * 100;  // Ejemplo básico
        if (seguroMedico != null) {
            this.precioTotal += seguroMedico.getCosto();
        }
    }

    public void agregarSeguro(seguroMedico seguro) {
        this.seguroMedico = seguro;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public List<Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }

    public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public seguroMedico getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(seguroMedico seguroMedico) {
        this.seguroMedico = seguroMedico;
    }
}
