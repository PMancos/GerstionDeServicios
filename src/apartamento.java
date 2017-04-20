
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class apartamento extends servicios{
    private int tipo;
    private String [] tipos={"Estudio","Dos Habitaciones","Pension Cmpleta"};
    public static final double ESTUDIO=0;
    public static final double DOS=1;
    public static final double PENSIONC=2;
    
    public static final double TASAE=50;
    public static final double TASAD=70;
    public static final double TASAP=100;

    public apartamento(int tipo, String dni, int plazas, int dias) {
        super(dni, plazas, dias);
        this.tipo = tipo;
    }

    public apartamento() {
    }
    
    public double estancia(){
        double precio=0;
        if(tipo==0)
            precio=servicios.TASA+TASAE;
        else if(tipo==1)
            precio=servicios.TASA+TASAD;
        else if(tipo==2)
            precio=servicios.TASA+TASAP;
        
        return precio;
    }

    @Override
    public String toString() {
        return super.toString()+"\nTipo de apartamento: " + tipos[tipo];
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print("\t\tApartamento\t\t"+estancia());
    }
}
