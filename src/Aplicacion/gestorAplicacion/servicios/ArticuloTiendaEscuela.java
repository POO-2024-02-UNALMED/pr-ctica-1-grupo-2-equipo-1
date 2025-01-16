package gestorAplicacion.servicios;

import gestorAplicacion.entidades.Objeto;

public class ArticuloTiendaEscuela extends Objeto {
    private double precioUnitarioArticuloTiendaEscuela;
    private String tipoArticulo;

    // Constructor
    public ArticuloTiendaEscuela(int idObjeto, String nombreObjeto, int stockObjeto, double precioUnitario, String tipoArticulo) {
        super(idObjeto, nombreObjeto, stockObjeto);
        this.precioUnitarioArticuloTiendaEscuela = precioUnitario;
        this.tipoArticulo = tipoArticulo;
    }

    // Getters y Setters
    public double getPrecioUnitarioArticuloTiendaEscuela() {
        return precioUnitarioArticuloTiendaEscuela;
    }

    public void setPrecioUnitarioArticuloTiendaEscuela(double precioUnitarioArticuloTiendaEscuela) {
        this.precioUnitarioArticuloTiendaEscuela = precioUnitarioArticuloTiendaEscuela;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }
}