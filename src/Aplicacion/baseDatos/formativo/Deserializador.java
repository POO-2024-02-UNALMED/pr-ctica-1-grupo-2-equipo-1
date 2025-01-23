package baseDatos.formativo;

import gestorAplicacion.inscripcion.DeporteFormativo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deserializador {
    public static ArrayList<DeporteFormativo> deserializar() throws IOException {
        ArrayList<DeporteFormativo> deportesFormativos = DeporteFormativo.deportesFormativos;
        BufferedReader reader = new BufferedReader(new FileReader("out\\production\\src\\baseDatos\\temp\\formativo.txt"));

        String linea;

        while((linea = reader.readLine()) != null){
            String[] partes = linea.split("-");
            /*
            declaracion de constructores
             */
        }
        return deportesFormativos;
    }
}
