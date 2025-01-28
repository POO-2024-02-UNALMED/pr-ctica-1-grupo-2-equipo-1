package gestorAplicacion.torneo;

import gestorAplicacion.pagos.Boleta;
import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.entidades.Trabajador;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Torneo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public static ArrayList<Torneo> torneos;
    private int idTorneo = 0;
    private String deporte;
    private ArrayList<Equipo> equiposParticipantes;
    private String seguroMedico;
    public float costoSeguroMedico;
    private double precioTotal;
    private Instalacion instalacion;
    public ArrayList<String> reglas;
    private ArrayList<Trabajador> arbitros = new ArrayList<>();
    public ArrayList<Reserva> reservas = new ArrayList<>();
    public ArrayList<Boleta> boletas = new ArrayList<>();


    public Torneo(String deporte, ArrayList<Equipo> equiposParticipantes, String seguroMedico, double precioTotal) {
        this.deporte = deporte;
        this.equiposParticipantes = equiposParticipantes;
        this.seguroMedico = seguroMedico;
        this.precioTotal = precioTotal;
    }

    public Torneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Torneo() {
    }

    public void setSeguroMedico(String seguro) {
        this.seguroMedico = seguro;
    }

    public void agregarSeguro(String seguro, double costo) {
        this.seguroMedico = seguro;
        this.precioTotal += costo;
    }

    public String getSeguroMedico() {
        return this.seguroMedico;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setDeporte(int num) {
        if (num == 1) {
            this.deporte = "Futbol";
        } else if (num == 2) {
            this.deporte = "Baloncesto";
        } else if (num == 3) {
            this.deporte = "Natacion";
        } else if (num == 4) {
            this.deporte = "Voleibol";
        } else {
            this.deporte = "Indefinido";
        }
    }

    public String getDeporte() {
        return this.deporte;
    }

    public ArrayList<Instalacion> getInstalaciones(int num, ArrayList<Instalacion> inst) {
        ArrayList<Instalacion> instalaciones = new ArrayList<>();
        if (num == 1) {
            instalaciones.add(inst.get(0));
            instalaciones.add(inst.get(1));
            instalaciones.add(inst.get(2));
            instalaciones.add(inst.get(3));
        } else if (num == 2) {
            instalaciones.add(inst.get(4));
            instalaciones.add(inst.get(5));
            instalaciones.add(inst.get(6));
        } else if (num == 3) {
            instalaciones.add(inst.get(7));
            instalaciones.add(inst.get(8));
            instalaciones.add(inst.get(9));
        } else if (num == 4) {
            instalaciones.add(inst.get(10));
            instalaciones.add(inst.get(11));
        }
        return instalaciones;
    }

    public void setInstalacion(int instalacion, ArrayList<Instalacion> inst) {
         //ArrayList<Instalacion> inst = inst;
        if (this.deporte.equals("Futbol")) {
            if (instalacion == 1) {
                this.instalacion = inst.get(0);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(1);
            } else if (instalacion == 3) {
                this.instalacion = inst.get(2);
            } else if (instalacion == 4) {
                this.instalacion = inst.get(3);
            }
        } else if (this.deporte.equals("Baloncesto")) {
            if (instalacion == 1) {
                this.instalacion = inst.get(4);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(5);
            } else if (instalacion == 3) {
                this.instalacion = inst.get(6);
            }
        } else if (this.deporte.equals("Natacion")) {
            if (instalacion == 1) {
                this.instalacion = inst.get(7);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(8);
            } else if (instalacion == 3) {
                this.instalacion = inst.get(9);
            }
        } else if (this.deporte.equals("Voleibol")) {
            if (instalacion == 1) {
                this.instalacion = inst.get(10);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(11);
            }
        }
    }

    public Instalacion getInstalacion() {
        return this.instalacion;
    }

    public void setReglas(ArrayList<String> reglas) {
        this.reglas = reglas;
    }

    public ArrayList<String> getReglas() {
        return this.reglas;
    }

    public void setEquiposParticipantes(ArrayList<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public static void setTorneos(ArrayList<Torneo> listaTorneos){
        torneos = listaTorneos;
    }
    public static ArrayList<Torneo> getTorneos(){return torneos;}

    public ArrayList<Equipo> getEquiposParticipantes() {
        return this.equiposParticipantes;
    }

    public List<Trabajador> getArbitros() {
        return this.arbitros;
    }

    public void setArbitros(List<Trabajador> arbitros) {
        this.arbitros = new ArrayList<>(arbitros);
    }

    public void agregarArbitro(Trabajador arbitro) {
        this.arbitros.add(arbitro);
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public void calcularPrecio() {
        if (equiposParticipantes != null) {
            this.precioTotal = equiposParticipantes.size() * 100;
        }
        if (seguroMedico != null && !seguroMedico.isEmpty()) {
            this.precioTotal += this.costoSeguroMedico;
        }
    }
}
