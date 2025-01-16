package gestorAplicacion.servicios;

public class SeguroMedico {
    private double costo;

    public SeguroMedico(int numeroParticipantes, int duracionTorneo) {
        this.costo = calcularCosto(numeroParticipantes, duracionTorneo);
    }

    public double calcularCosto(int numeroParticipantes, int duracionTorneo) {
        return numeroParticipantes * duracionTorneo * 10;  // Ejemplo simple
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
