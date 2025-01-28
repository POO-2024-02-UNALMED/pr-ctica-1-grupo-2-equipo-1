package gestorAplicacion.pagos;

import java.util.ArrayList;
import java.util.Random;

public class Boleta {

    private static ArrayList<Boleta> listaBoletas;
    private int ID;
    private String tipoEvento;
    private int precio;
    private Cliente cliente;
    private boolean pagada;

    public Boleta(){}
    // Constructor
    public Boleta( String tipoEvento,int precio,Cliente cliente) {
        Random idGen = new Random();
        this.ID = idGen.nextInt(1000);
        this.tipoEvento = tipoEvento;
        this.precio = precio;
        this.cliente = cliente;
        this.pagada = false;
        listaBoletas.add(this);
    }

    public static Boleta buscarBoleta(int ID){
        if(listaBoletas != null){
            for (Boleta boleta: listaBoletas){
                if(boleta.ID == ID){
                    return boleta;
                }
            }
        }
        return null;
    }

    public int getPrecio(){
        return this.precio;
    }
    public boolean isPagada(){
        return this.pagada;
    }
    public void setPagada(boolean pagada){
        this.pagada = pagada;
    }

    @Override
    public String toString() {
        return  "ID: " + ID + "\n" +
                "En nombre de" + cliente.getNombre() + " " + cliente.getApellido() + "\n" +
                "Tipo de evento: " + tipoEvento + "\n" +
                "Total a pagar: " + precio;
    }

    public int getID(){
        return this.ID;
    }

}
