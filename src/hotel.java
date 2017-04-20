/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class hotel extends servicios{
    private int tipo;
    private String [] tipos={"Alojamiento y desayuno","Media pension","Pension completa"};
    public static final double ALOJ=0;
    public static final double MEDIA=1;
    public static final double PENSIONC=2;
    
    public static final double TASAA=40;
    public static final double TASAM=60;
    public static final double TASAP=75;

    public hotel(int tipo, String dni, int plazas, int dias) {
        super(dni, plazas, dias);
        this.tipo = tipo;
    }

    public hotel() {
    }
    
    
    public double estancia(){
        double precio=0;
        if(tipo==0)
            precio=servicios.TASA+TASAA;
        else if(tipo==1)
            precio=servicios.TASA+TASAM;
        else if(tipo==2)
            precio=servicios.TASA+TASAP;
        
        return precio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }

    @Override
    public String toString() {
        return super.toString()+"\nTipo de hotel: " + tipos[tipo];
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print("\t\tHotel\t\t\t"+estancia());
    }
    
    
}
