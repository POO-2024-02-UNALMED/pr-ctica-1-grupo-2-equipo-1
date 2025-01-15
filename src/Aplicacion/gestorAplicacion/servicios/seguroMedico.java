package gestorAplicacion.servicios;

public class SeguroMedico {
    private int idSeguro;
    private double costoPorParticipante;
    private int numeroParticipantes;
    private int duracionTorneo;

    public SeguroMedico(int idSeguro, double costoPorParticipante, int numeroParticipantes, int duracionTorneo) {
        this.idSeguro = idSeguro;
        this.costoPorParticipante = costoPorParticipante;
        this.numeroParticipantes = numeroParticipantes;
        this.duracionTorneo = duracionTorneo;
    }

    public double calcularCosto() {
        return costoPorParticipante * numeroParticipantes * duracionTorneo;
    }
}
