package gestorAplicacion.reservas;

public enum Horario {
    LUNES_08_10("Lunes", "08:00 - 10:00"),
    LUNES_10_12("Lunes", "10:00 - 12:00"),
    LUNES_12_14("Lunes", "12:00 - 14:00"),
    LUNES_14_16("Lunes", "14:00 - 16:00"),
    LUNES_16_18("Lunes", "16:00 - 18:00"),
    LUNES_18_20("Lunes", "18:00 - 20:00"),
    MARTES_08_10("Martes", "08:00 - 10:00"),
    MARTES_10_12("Martes", "10:00 - 12:00"),
    MARTES_12_14("Martes", "12:00 - 14:00"),
    MARTES_14_16("Martes", "14:00 - 16:00"),
    MARTES_16_18("Martes", "16:00 - 18:00"),
    MARTES_18_20("Martes", "18:00 - 20:00"),
    MIERCOLES_08_10("Miércoles", "08:00 - 10:00"),
    MIERCOLES_10_12("Miércoles", "10:00 - 12:00"),
    MIERCOLES_12_14("Miércoles", "12:00 - 14:00"),
    MIERCOLES_14_16("Miércoles", "14:00 - 16:00"),
    MIERCOLES_16_18("Miércoles", "16:00 - 18:00"),
    MIERCOLES_18_20("Miércoles", "18:00 - 20:00"),
    JUEVES_08_10("Jueves", "08:00 - 10:00"),
    JUEVES_10_12("Jueves", "10:00 - 12:00"),
    JUEVES_12_14("Jueves", "12:00 - 14:00"),
    JUEVES_14_16("Jueves", "14:00 - 16:00"),
    JUEVES_16_18("Jueves", "16:00 - 18:00"),
    JUEVES_18_20("Jueves", "18:00 - 20:00"),
    VIERNES_08_10("Viernes", "08:00 - 10:00"),
    VIERNES_10_12("Viernes", "10:00 - 12:00"),
    VIERNES_12_14("Viernes", "12:00 - 14:00"),
    VIERNES_14_16("Viernes", "14:00 - 16:00"),
    VIERNES_16_18("Viernes", "16:00 - 18:00"),
    VIERNES_18_20("Viernes", "18:00 - 20:00"),
    SABADO_08_10("Sábado", "08:00 - 10:00"),
    SABADO_10_12("Sábado", "10:00 - 12:00"),
    SABADO_12_14("Sábado", "12:00 - 14:00"),
    SABADO_14_16("Sábado", "14:00 - 16:00"),
    SABADO_16_18("Sábado", "16:00 - 18:00"),
    SABADO_18_20("Sábado", "18:00 - 20:00");

    private final String dia;
    private final String franjaHoraria;

    // Constructor
    Horario(String dia, String franjaHoraria) {
        this.dia = dia;
        this.franjaHoraria = franjaHoraria;
    }

    public String getDia() {
        return dia;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }

    public String getDiaYFranja() {
        return dia + " - " + franjaHoraria;
    }
}
