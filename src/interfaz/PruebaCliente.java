/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

import cliente.Cliente;
import datosComunes.Accion;
import datosComunes.ObjComunicacion;


/**
 *
 * @author Estudiantes
 */
public class PruebaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjComunicacion peticion= new ObjComunicacion();
        peticion.setAccion(Accion.SALUDAR);
        peticion.setEntrada("Ericka");
        Cliente conexion = new Cliente(peticion);
        peticion = (ObjComunicacion) conexion.getMensaje();
        //sout+tab  : System.out.println("");
        System.out.println(peticion.getSalida());
        
    }

}
