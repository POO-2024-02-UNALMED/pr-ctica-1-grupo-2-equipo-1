package baseDatos.formativo;

import gestorAplicacion.servicios.DeporteFormativo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Serializador {
    public static void serializar(ArrayList<DeporteFormativo> deporteFormativos) {
        try (FileWriter writer = new FileWriter("src\\Aplicacion\\baseDatos\\temp\\formativo.txt")) {
            for (DeporteFormativo deporteFormativo : deporteFormativos) {
                writer.write(deporteFormativo.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al serializar los deportes formativos " + e.getMessage());
        }
    }
}
