package baseDatos.torneo;

import gestorAplicacion.entidades.Torneo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deserializador {
    public static ArrayList<Torneo> deserializar() throws IOException {
        ArrayList<Torneo> torneos = Torneo.torneos;
        BufferedReader reader = new BufferedReader(new FileReader("out\\production\\src\\baseDatos\\temp\\torneo.txt"));

        String linea;

        while((linea = reader.readLine()) != null){
            String[] partes = linea.split("-");
            /*
            declaracion de constructores
             */
        }
        return torneos;
    }
}
