package baseDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Reserva;

public class Deserializador {
    public static List<Reserva> deserializarReservas(String rutaArchivo) {
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\Aplicacion\\baseDatos\\temp\\reserva.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.replace("Reserva{", "").replace("}", "").split(", ");
                String nombreUsuario = partes[0].split("=")[1];
                String cancha = partes[1].split("=")[1];
                LocalDateTime fechaHora = LocalDateTime.parse(partes[2].split("=")[1]);
                reservas.add(new Reserva(new Cliente(nombreUsuario, "", 0, "cancha", false),cancha, fechaHora));
            }
            System.out.println("Reservas deserializadas correctamente");
        } catch (IOException e) {
            System.err.println("Error al deserializar las reservas: " + e.getMessage());
        }
        return reservas;
    }
}
