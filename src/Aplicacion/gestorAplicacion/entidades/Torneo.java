package gestorAplicacion.entidades;

import gestorAplicacion.servicios.Formato;
import gestorAplicacion.entidades.Equipo;
import gestorAplicacion.servicios.SeguroMedico;
import java.util.Scanner;

import java.util.List;

public class Torneo {
    private int idTorneo;
    public String deporte;
    private Formato formato;
    private List<Equipo> equiposParticipantes;
    private SeguroMedico seguroMedico;
    private double precioTotal;

    Scanner scanner = new Scanner(System.in);

    public Torneo(String deporte,Formato formato,List<Equipo> equiposParticipantes, SeguroMedico seguroMedico, double precioTotal){
        this.deporte = deporte;
        this.formato = formato;
        this.equiposParticipantes = equiposParticipantes;
        this.seguroMedico = seguroMedico;
        this.precioTotal = precioTotal;
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

    public void agregarSeguro(SeguroMedico seguro) {
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
        System.out.println("Ingrese el deporte para el torneo");
        this.deporte = scanner.nextLine();
    }

    public List<Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }

    public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public SeguroMedico getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(SeguroMedico seguroMedico) {
        this.seguroMedico = seguroMedico;
    }
}
