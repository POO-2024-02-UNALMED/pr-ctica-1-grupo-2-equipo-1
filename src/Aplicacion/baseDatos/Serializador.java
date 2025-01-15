package baseDatos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import gestorAplicacion.entidades.Reserva;

public class Serializador {
    public static void serializarReservas(List<Reserva> reservas, String rutaArchivo) {
        try (FileWriter writer = new FileWriter("src\\Aplicacion\\baseDatos\\temp\\reserva.txt")) {
            for (Reserva reserva : reservas) {
                writer.write(reserva.toString() + "\n");
            }
            System.out.println("Reservas serializadas correctamente en " + "src\\Aplicacion\\baseDatos\\temp\\reserva.txt");
        } catch (IOException e) {
            System.err.println("Error al serializar las reservas: " + e.getMessage());
        }
    }
}