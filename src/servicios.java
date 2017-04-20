
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class servicios implements Serializable,Comparable<servicios>{
    private String dni;
    private int plazas;
    private int dias;
    public static final double TASA=2.5;

    public servicios(String dni, int plazas, int dias) {
        this.dni = dni;
        this.plazas = plazas;
        this.dias = dias;
    }

    public servicios() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "\nPlazas: " + plazas + "\nDias: " + dias;
    }
    
    public void mostrar(){
        System.out.print(dni+"\t"+dias+"\t"+plazas);
    }

   
    @Override
    public int compareTo(servicios o) {
        return this.getDias()-o.dias;
    }
    
}