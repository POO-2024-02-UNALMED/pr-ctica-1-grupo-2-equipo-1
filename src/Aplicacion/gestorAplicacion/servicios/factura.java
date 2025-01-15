package gestorAplicacion.servicios;

public class factura {
    public int idFactura;
    public int valorFactura;
    public boolean estadoFactura;
    public String descripcionFactura;

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
