package gestorAplicacion.servicios;

public class Factura {
    public int idFactura;
    public int valorFactura;
    public boolean estadoFactura;
    public String descripcionFactura;

    //Constructor con estado de factura
    public Factura(int idFactura, int valorFactura, boolean estadoFactura, String descripcionFactura) {
        this.idFactura = idFactura;
        this.valorFactura = valorFactura;
        this.estadoFactura = estadoFactura;
        this.descripcionFactura = descripcionFactura;
    }

    //Constructor sin estado de factura
    public Factura(int idFactura, int valorFactura, String descripcionFactura){
        this.idFactura = idFactura;
        this.valorFactura = valorFactura;
        this.descripcionFactura = descripcionFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    public void setValorFactura(int valorFactura) {
        this.valorFactura = valorFactura;
    }
    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
    }
    public void setDescripcionFactura(String descripcionFactura) {
        this.descripcionFactura = descripcionFactura;
    }
    public int getIdFactura() {
        return idFactura;
    }
    public int getValorFactura() {
        return valorFactura;
    }
    public boolean getEstadoFactura() {
        return estadoFactura;
    }
    public String getDescripcionFactura() {
        return descripcionFactura;
    }
}