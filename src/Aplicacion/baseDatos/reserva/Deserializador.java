package baseDatos.reserva;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Reserva;
import gestorAplicacion.servicios.GestorReservas;

public class Deserializador {
    public static List<Reserva> deserializar() throws IOException {
        List<Reserva> reservas = GestorReservas.reservas;
        BufferedReader reader = new BufferedReader(new FileReader("Aplicacion\\baseDatos\\temp\\reserva.txt"));

        String linea;

        while((linea = reader.readLine()) != null){
            System.out.println(linea);
        }
        return reservas;
    }
}
