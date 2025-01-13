package gestorAplicacion.gestionCanchas;

public enum Horario {
    LUNES_8_10("Lunes", "08:00 AM - 10:00 AM"),
    LUNES_10_12("Lunes", "10:00 AM - 12:00 PM"),
    LUNES_12_2("Lunes", "12:00 PM - 02:00 PM"),
    LUNES_2_4("Lunes", "02:00 PM - 04:00 PM"),
    LUNES_4_6("Lunes", "04:00 PM - 06:00 PM"),
    LUNES_6_8("Lunes", "06:00 PM - 08:00 PM"),

    MARTES_8_10("Martes", "08:00 AM - 10:00 AM"),
    MARTES_10_12("Martes", "10:00 AM - 12:00 PM"),
    MARTES_12_2("Martes", "12:00 PM - 02:00 PM"),
    MARTES_2_4("Martes", "02:00 PM - 04:00 PM"),
    MARTES_4_6("Martes", "04:00 PM - 06:00 PM"),
    MARTES_6_8("Martes", "06:00 PM - 08:00 PM"),

    MIERCOLES_8_10("Miércoles", "08:00 AM - 10:00 AM"),
    MIERCOLES_10_12("Miércoles", "10:00 AM - 12:00 PM"),
    MIERCOLES_12_2("Miércoles", "12:00 PM - 02:00 PM"),
    MIERCOLES_2_4("Miércoles", "02:00 PM - 04:00 PM"),
    MIERCOLES_4_6("Miércoles", "04:00 PM - 06:00 PM"),
    MIERCOLES_6_8("Miércoles", "06:00 PM - 08:00 PM"),

    JUEVES_8_10("Jueves", "08:00 AM - 10:00 AM"),
    JUEVES_10_12("Jueves", "10:00 AM - 12:00 PM"),
    JUEVES_12_2("Jueves", "12:00 PM - 02:00 PM"),
    JUEVES_2_4("Jueves", "02:00 PM - 04:00 PM"),
    JUEVES_4_6("Jueves", "04:00 PM - 06:00 PM"),
    JUEVES_6_8("Jueves", "06:00 PM - 08:00 PM"),

    VIERNES_8_10("Viernes", "08:00 AM - 10:00 AM"),
    VIERNES_10_12("Viernes", "10:00 AM - 12:00 PM"),
    VIERNES_12_2("Viernes", "12:00 PM - 02:00 PM"),
    VIERNES_2_4("Viernes", "02:00 PM - 04:00 PM"),
    VIERNES_4_6("Viernes", "04:00 PM - 06:00 PM"),
    VIERNES_6_8("Viernes", "06:00 PM - 08:00 PM"),

    SABADO_8_10("Sábado", "08:00 AM - 10:00 AM"),
    SABADO_10_12("Sábado", "10:00 AM - 12:00 PM"),
    SABADO_12_2("Sábado", "12:00 PM - 02:00 PM"),
    SABADO_2_4("Sábado", "02:00 PM - 04:00 PM"),
    SABADO_4_6("Sábado", "04:00 PM - 06:00 PM"),
    SABADO_6_8("Sábado", "06:00 PM - 08:00 PM");

    private final String dia;
    private final String rangoHorario;

    Horario(String dia, String rangoHorario) {
        this.dia = dia;
        this.rangoHorario = rangoHorario;
    }

    public String getDia() {
        return dia;
    }

    public String getRangoHorario() {
        return rangoHorario;
    }

    @Override
    public String toString() {
        return dia + ": " + rangoHorario;
    }
}