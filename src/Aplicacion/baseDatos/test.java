package baseDatos;

import baseDatos.reserva.Deserializador;
import gestorAplicacion.entidades.Reserva;

import java.io.IOException;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
       List<Reserva> reservas = Deserializador.deserializar();
    }
}
