
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class contrataciones implements Comparator<servicios>{
static Scanner teclado=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //Creamos un nuevo archivo y un objeto lista vacia
            File f = new File("servicios.dat");
            ArrayList<servicios> listaServicios = null;
            
            if (!f.exists()) { //si no existe el fichero crear la lista vacía
                listaServicios = new ArrayList<servicios>();
            } else {
                //Si existe creamos una entrada de archivo y se la pasamos a una nueva entrada de objeto (Leemos)
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                listaServicios = (ArrayList<servicios>) ois.readObject();

                ois.close();
                fis.close();
            }
    
        
        int opcion=0;
        boolean modificado=false;//si se ha producido alguna modificación se grabará en el fichero, sino no
            do{
                opcion=menu();
                switch(opcion){
                    case 1:
                        contratarVacaciones(listaServicios);
                        modificado=true;
                        break;
                    case 2:
                        Collections.sort(listaServicios);
                        mostrarDatos(listaServicios);
                        modificado=true;
                        break;
                    case 3:
                        Collections.sort(listaServicios, new contrataciones());
                        mostrarDatos(listaServicios);
                        modificado=true;
                        break;
                    case 4:
                        if(modificado){ //guardar la lista en el fichero si ha habido modificaciones
                FileOutputStream fos=new  FileOutputStream(f);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                    System.out.println("Se han guardado los cambios");
                oos.writeObject(listaServicios);
                oos.close();
                }
            }
            }while(opcion!=4);
        

        }catch(NotSerializableException ex){
            
        
        } catch (FileNotFoundException ex) {
        Logger.getLogger(contrataciones.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
        Logger.getLogger(contrataciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(contrataciones.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
          public static int pedirNumeroEntero() {
        int n = 0;
        try {
            n = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error no has introducido un entero");
            teclado.nextLine();
        }
        return n;
    }

    public static int menu() {

        System.out.println("\n1. Contratar vacaciones"
                + "\n2. Listado de contratos ordenado por numero de dias contratados"
                + "\n3. Listado de contratos ordenado por DNI"
                + "\n4. Salir\n");

        int opcion;
        do {
            System.out.print("Introduce una opcion (1/4): ");
            opcion = pedirNumeroEntero();
        } while (opcion < 1 || opcion > 4);
        teclado.nextLine();
        return opcion;
    }
    
    public static void contratarVacaciones(ArrayList<servicios>lista){
        String dni;
        int dias, plazas, opcion, tipoH=0, tipoA=0;
        System.out.println("");
        System.out.print("Introduzca el DNI: ");
            dni=teclado.nextLine();
        System.out.print("Introduzca el numero de dias que se va a alojar: ");
            dias=pedirNumeroEntero();
        System.out.print("Introduzca el numero de personas que se van a alojar: ");
            plazas=pedirNumeroEntero();
        
        System.out.println("Que tipo de estancia desea");
        System.out.println("1.Hotel\n2. Apartamento");
            opcion=pedirNumeroEntero();
           
        if(opcion==1){
            System.out.println("Introduzca el tipo de hotel a reservar");
            System.out.println("0.Alojamiento y desayuno\n1.Media Pension\n2.Pension Completa");
                tipoH=pedirNumeroEntero();
            lista.add(new hotel(tipoA, dni, plazas, dias));
            
            System.out.println("Nueva reserva de hotel realizada");
        }    
        
        if(opcion==2){
            System.out.println("Introduzca el tipo de apartamento a reservar");
            System.out.println("0.Estudio\n1.Dos Habitaciones\n2.Pension Completa");
                tipoA=pedirNumeroEntero();
            lista.add(new apartamento(tipoA, dni, plazas, dias));
            
            System.out.println("Nueva reserva de apartamento realizada");
        }  
            
    }
    
    public static void mostrarDatos(ArrayList<servicios>lista){
          System.out.println("\nDNI\t\tNºDias\tNºPersonas\tTipo Alojamiento\tPrecio"
                + "\n_________\t______\t__________\t___________\t\t____");
          
          for(int i=0;i<lista.size();i++){
              lista.get(i).mostrar();
              System.out.println("");
          }
    }

    @Override
    public int compare(servicios o1, servicios o2) {
        return o1.getDni().compareToIgnoreCase(o2.getDni());
    }

}
    

