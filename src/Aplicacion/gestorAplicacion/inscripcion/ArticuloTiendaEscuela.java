package gestorAplicacion.inscripcion;

public class ArticuloTiendaEscuela {
    // Atributos
    private int idArticulo;
    private String nombreArticulo;
    private int stockArticulo;
    public double precio;
    public String tipoArticulo;

    // Constructor
    public ArticuloTiendaEscuela(int idArticulo, String nombreArticulo, int stockArticulo, double precio, String tipoArticulo) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.stockArticulo = stockArticulo;
        this.precio = precio;
        this.tipoArticulo = tipoArticulo;
    }

    // Getters y Setters
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getStockArticulo() {
        return stockArticulo;
    }

    public void setStockArticulo(int stockArticulo) {
        this.stockArticulo = stockArticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }
}