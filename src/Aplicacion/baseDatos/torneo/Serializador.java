package baseDatos.torneo;

import gestorAplicacion.entidades.Torneo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Serializador {
    public static void serializar(List<Torneo> torneos) {
        try (FileWriter writer = new FileWriter("src\\Aplicacion\\baseDatos\\temp\\torneo.txt")) {
            for (Torneo torneo : torneos) {
                writer.write(torneo.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al serializar las torneos: " + e.getMessage());
        }
    }
}
