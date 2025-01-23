package gestorAplicacion.pagos;

public class Pago {

    // Atributos
    private String metodoPago; // Efectivo, Transferencia, Tarjeta de crédito/débito
    private double monto; // Monto total del pago
    private int cuotas; // Número de cuotas (solo para tarjeta de crédito)
    private boolean estadoPago; // true si el pago fue exitoso, false de lo contrario

    // Constructor
    public Pago(String metodoPago, double monto) {
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.cuotas = 0; // Por defecto, sin cuotas
        this.estadoPago = false; // Estado inicial del pago
    }

    // Getters y Setters
    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    /**
     * Valida manualmente si el pago se completó exitosamente.
     * return true si la validación es exitosa, false de lo contrario.
     */
    public boolean validarPago() {
        System.out.println("Validando el pago...");
        return true; // Por defecto, se asume exitoso
    }

    @Override
    public String toString() {
        return "Pago{" +
                "metodoPago='" + metodoPago + '\'' +
                ", monto=" + monto +
                ", cuotas=" + cuotas +
                ", estadoPago=" + (estadoPago ? "Exitoso" : "Fallido") +
                '}';
    }
}
