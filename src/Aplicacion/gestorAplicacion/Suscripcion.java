package gestorAplicacion;

public class Suscripcion {
    private String plan;
    private double descuentoMensualidad;
    private double descuentoTienda;

    public Suscripcion(String plan) {
        this.plan = plan;
        switch (plan) {
            case "Nivel 1":
                this.descuentoMensualidad = 0.05;
                this.descuentoTienda = 0.0;
                break;
            case "Nivel 2":
                this.descuentoMensualidad = 0.10;
                this.descuentoTienda = 0.15;
                break;
            case "Nivel 3":
                this.descuentoMensualidad = 0.20;
                this.descuentoTienda = 0.30;
                break;
            default:
                this.descuentoMensualidad = 0.0;
                this.descuentoTienda = 0.0;
        }
    }

    public String getPlan() {
        return plan;
    }

    public double getDescuentoMensualidad() {
        return descuentoMensualidad;
    }

    public double getDescuentoTienda() {
        return descuentoTienda;
    }

    public String toString() {
        return plan + ": " + 
               "\n- Descuento en mensualidad: " + (descuentoMensualidad * 100) + "%" + 
               "\n- Descuento en tienda: " + (descuentoTienda * 100) + "%";
    }
    
}