package gestorAplicacion.reservas;

import java.util.ArrayList;
import java.util.Scanner;

public class Instalacion {
    private static int idCounter = 0; // Contador estático para los ID
    private int idInstalacion;
    private String deporte;
    private int precioHora;
    private int profundidad;
    private boolean toldo;
    private String nombre;
    private String descripcion;
    private int capacidad; // Capacidad de la instalación (tribunas o usuarios por hora)
    private ArrayList<Horario> horariosDisponibles; // Lista de horarios disponibles (instancias de Horario)
    private ArrayList<String> horasOcupadas; // Lista de horas ocupadas
    private String estado; // Estado de la instalación (Disponible, Reservado, Ocupado)
    private Horario horario;

    // Constructor con todos los atributos
    public Instalacion(String nombre, String deporte, int precioHora, int profundidad, String descripcion) {
        this.idInstalacion = ++idCounter; // Incrementa el contador estático
        this.nombre = nombre;
        this.deporte = deporte;
        this.descripcion = descripcion;
        this.precioHora = precioHora;
        this.profundidad = profundidad;
        this.capacidad = 0; // Inicializado en 0 por defecto
        this.horariosDisponibles = new ArrayList<>(); // Inicializar horarios vacíos
        this.estado = "Disponible"; // Estado inicial
        this.horasOcupadas = new ArrayList<>(); // Inicializar lista de horas ocupadas
    }

    // Constructor especial para piscinas, con capacidad
    public Instalacion(String nombre, String deporte, int precioHora, int profundidad, String descripcion, int capacidad) {
        this(nombre, deporte, precioHora, profundidad, descripcion);
        this.capacidad = capacidad;
        inicializarHorarios(); // Llamamos a inicializar los horarios con la capacidad
    }

    // Constructor con toldo
    public Instalacion(String nombre, String deporte, int precioHora, int profundidad, String descripcion, Toldo toldo) {
        this(nombre, deporte, precioHora, profundidad, descripcion);
        this.toldo = toldo;
    }

    // Métodos setters y getters
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
        inicializarHorarios(); // Si cambiamos la capacidad, actualizamos los horarios
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setToldo(Toldo toldo) {
        this.toldo = toldo;
    }

    public Toldo getToldo() {
        return toldo;
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setHorariosDisponibles(ArrayList<Horario> horariosDisponibles) {
        this.horariosDisponibles = horariosDisponibles;
    }

    public ArrayList<Horario> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    // Método para inicializar los horarios con la capacidad de la piscina
    private void inicializarHorarios() {
        if (!this.deporte.equalsIgnoreCase("Natacion")) {
            return; // Solo aplica para instalaciones de tipo piscina
        }


        // Lista de horas del día
        ArrayList<String> horasDelDia = new ArrayList<>();
        horasDelDia.add("08:00");
        horasDelDia.add("10:00");
        horasDelDia.add("12:00");
        horasDelDia.add("14:00");
        horasDelDia.add("16:00");
        horasDelDia.add("18:00");
        horasDelDia.add("20:00");
        horasDelDia.add("21:00");
        horasDelDia.add("22:00");
        horasDelDia.add("23:00");

        // Lista de días de la semana
        ArrayList<String> diasDeLaSemana = new ArrayList<>();
        diasDeLaSemana.add("Lunes");
        diasDeLaSemana.add("Martes");
        diasDeLaSemana.add("Miércoles");
        diasDeLaSemana.add("Jueves");
        diasDeLaSemana.add("Viernes");
        diasDeLaSemana.add("Sábado");
        diasDeLaSemana.add("Domingo");

        // Para cada día, inicializamos los horarios con los cupos según la capacidad
        for (String dia : diasDeLaSemana) {
            ArrayList<String> horasDisponibles = new ArrayList<>();
            ArrayList<Integer> cuposDisponibles = new ArrayList<>();

            // Inicializa las horas y los cupos para cada hora según la capacidad
            for (String hora : horasDelDia) {
                horasDisponibles.add(hora); // Agregar la hora
                cuposDisponibles.add(this.capacidad); // Inicializar los cupos con la capacidad
            }

            // Crear el horario para el día y agregarlo
            Horario horario = new Horario(dia, horasDisponibles, cuposDisponibles);
            this.horariosDisponibles.add(horario);
        }
    }

    @Override
    public String toString() {
        return nombre +
                "-" + descripcion +
                "-" + deporte +
                "-" + precioHora +
                "-" + capacidad;
    }

    public boolean hayCupoDisponible(String horaSeleccionada) {
        for (Horario horario : horariosDisponibles) {
            for (int i = 0; i < horario.getHorasDisponibles().size(); i++) {
                if (horario.getHorasDisponibles().get(i).equals(horaSeleccionada) && horario.getCuposDisponibles().get(i) > 0) {
                    return true; // Se encontró un cupo disponible
                }
            }
        }
        return false; // No hay cupos disponibles para esa hora
    }


    public static Instalacion seleccionarInstalacion(Scanner scanner, ArrayList<Instalacion> instalacionesDisponibles) {
        System.out.println("Instalaciones disponibles que cumplen con los criterios:");
        for (int i = 0; i < instalacionesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + instalacionesDisponibles.get(i).getNombre());
        }

        int seleccion;
        do {
            System.out.print("Seleccione una instalación por su número: ");
            seleccion = scanner.nextInt();
            scanner.nextLine();
            if (seleccion < 1 || seleccion > instalacionesDisponibles.size()) {
                System.out.println("Selección inválida. Intente nuevamente.");
            }
        } while (seleccion < 1 || seleccion > instalacionesDisponibles.size());

        return instalacionesDisponibles.get(seleccion - 1);
    }

    public static boolean esPiscinaConRestriccion(Instalacion instalacion) {
        return instalacion.getNombre().toLowerCase().contains("piscina") &&
            (instalacion.getNombre().toLowerCase().contains("olimpica") ||
                instalacion.getNombre().toLowerCase().contains("semi olimpica"));
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Horario getHorario() {
        return horario;
    }
}


