package gestorAplicacion.entidades;

import gestorAplicacion.servicios.Formato;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Torneo {
    private int idTorneo = 0;
    public String deporte;
    private Formato formato;
    private List<Equipo> equiposParticipantes;
    private String seguroMedico;
    public float costoSeguroMedico;
    private double precioTotal;
    public boolean ventaBoletasTorneo = false;
    public ArrayList<String> partidos;

    public Torneo(String deporte,Formato formato,List<Equipo> equiposParticipantes, String seguroMedico, double precioTotal){
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
            this.precioTotal += costoSeguroMedico;
        }
    }

    public void agregarSeguro(String seguro) {
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

    public List<Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }

    public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public static void crearTorneos(){
        boolean salirTorneo = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el deporte en el cual desea realizar el torneo");
        System.out.println("1. Futbol");
        System.out.println("2. Baloncesto");
        System.out.println("3. Baloncesto");
        System.out.println("4. Voleibol");
        System.out.println("5. Salir");

        int deporteTorneo = scanner.nextInt();

        while (!salirTorneo){
            switch (deporteTorneo){
                case 1://futbol
                    System.out.println("Seleccione la cancha en la que desea realizar el torneo");

                case 2://basket
                case 3://natacion
                case 4://voleibol
                case 5://salir
                default:
                    System.out.println("Seleccione una opcion valide. Del 1 al 5");
            }
        }
    }
}