package gestorAplicacion.entidades;

public class Objeto {
    private int idObjeto;
    private String nombreObjeto;
    private int stockObjeto;

    // Constructor
    public Objeto(int idObjeto, String nombreObjeto, int stockObjeto) {
        this.idObjeto = idObjeto;
        this.nombreObjeto = nombreObjeto;
        this.stockObjeto = stockObjeto;
    }

    // Getters y Setters
    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public int getStockObjeto() {
        return stockObjeto;
    }

    public void setStockObjeto(int stockObjeto) {
        this.stockObjeto = stockObjeto;
    }
}