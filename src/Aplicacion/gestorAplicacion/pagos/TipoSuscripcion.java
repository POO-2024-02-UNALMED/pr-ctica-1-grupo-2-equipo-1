package gestorAplicacion.pagos;

public enum TipoSuscripcion {
    ROOKIE(0.05,true,true,0,0),
    PROPLAYER(0.08,true,true,1,0.1),
    MVP(0.15,true,true,4,0.1);

    private double descuento;
    private boolean formativo;
    private boolean crearTorneo;
    private int reservasGratis;
    private double descBoletas;

    TipoSuscripcion(double descuento, boolean formativo, boolean crearTorneo, int reservasGratis,double descBoletas){
        this.descuento = descuento;
        this.formativo = formativo;
        this.crearTorneo = crearTorneo;
        this.reservasGratis = reservasGratis;
        this.descBoletas = descBoletas;
    }

    public double getDescuento(){
        return descuento;
    }
    public boolean isFormativo(){
        return formativo;
    }
    public boolean isCrearTorneo(){
        return crearTorneo;
    }
    public int getReservasGratis(){
        return reservasGratis;
    }
    public double getDescBoletas(){
        return descBoletas;
    }

}
