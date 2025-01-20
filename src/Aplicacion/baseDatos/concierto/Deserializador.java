package baseDatos.concierto;

import gestorAplicacion.entidades.Evento;
import gestorAplicacion.entidades.Reserva;
import gestorAplicacion.servicios.GestorReservas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deserializador {
    public static ArrayList<Evento> deserializar() throws IOException {
        ArrayList<Evento> eventos = Evento.eventos;
        BufferedReader reader = new BufferedReader(new FileReader("out\\production\\src\\baseDatos\\temp\\concierto.txt"));

        String linea;

        while((linea = reader.readLine()) != null){
            String[] partes = linea.split("-");
            /*
            declaracion de constructores
             */
        }
        return eventos;
    }
}
