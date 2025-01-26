package gestorAplicacion.pagos;

public enum TipoSuscripcion {
    NOTIENE("Sin suscripcion",0,0,false,false,0,0),
    ROOKIE("Rookie",12000,0.05,true,true,0,0),
    PROPLAYER("Pro Player",20000,0.08,true,true,1,0.1),
    MVP("MVP",25000,0.15,true,true,4,0.1);

    private double descuento;
    private boolean formativo;
    private boolean crearTorneo;
    private int reservasGratis;
    private double descBoletas;
    private int precio;
    private String nombre;

    TipoSuscripcion(String nombre,int precio,double descuento, boolean formativo, boolean crearTorneo, int reservasGratis,double descBoletas){
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
        this.formativo = formativo;
        this.crearTorneo = crearTorneo;
        this.reservasGratis = reservasGratis;
        this.descBoletas = descBoletas;
    }

    public int getPrecio() {return precio;}
    public String getNombre() {return nombre;}
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
