/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import cliente.Cliente;
import contenedor.Lista;
import datosComunes.Accion;
import datosComunes.ObjComunicacion;
import datosComunes.Usuario;
import datosInternos.Mensaje;
import interfaz.Cargador;
import interfaz.DiSala;
import interfaz.FRCliente;
import javax.swing.JOptionPane;


/**
 *
 * @author M-01
 */
public class UICliente {
    
    private int IDSala;
    private String login;
    
    public void registrar(FRCliente ventana){
        String nombre= ventana.getTxtNombre().getText();
        login= ventana.getTxtLogin().getText();
        String pass= ventana.getTxtPassw().getText();
        
        Usuario datoEntrada = new Usuario(nombre, login, pass);
        ObjComunicacion peticion = new ObjComunicacion(Accion.REGISTRAR, datoEntrada);
        Cliente  conexion = new Cliente(peticion);
        peticion = (ObjComunicacion) conexion.getMensaje();
        JOptionPane.showMessageDialog(null, peticion.getSalida());
        
    }

    public void ingresar(FRCliente ventana) {
        String login= ventana.getTxtUsrIng().getText();
        String pass= ventana.getTxtPwdIng().getText();
        
        Usuario usrIngreso = new Usuario("", login, pass);
        ObjComunicacion peticion = new ObjComunicacion(Accion.INGRESAR, usrIngreso);
        Cliente  conexion = new Cliente(peticion);
        peticion = (ObjComunicacion) conexion.getMensaje();
        IDSala = (Integer) peticion.getSalida();
        if ( IDSala != -1){
            //JOptionPane.showMessageDialog(null, "debe recuperar la lista de conectados");
            peticion = new ObjComunicacion();
            //peticion.setAccion(Accion.CREAR_SALA);
            peticion.setAccion(Accion.LISTAR_CONECTADOS);
            peticion.setEntrada(IDSala);
            conexion = new Cliente (peticion);
            peticion = (ObjComunicacion) conexion.getMensaje();
            // en el dato de salida de la nueva peticion viene la lista de conectados..
            DiSala salita = new DiSala(null, false);
	    salita.setIDSala(IDSala);
	    salita.setLogin(login);
            salita.setVisible(true);
	    
            if(salita != null){
                //ventana.dispose();
                //JOptionPane.showMessageDialog(null, peticion.getSalida());
            }else{
                JOptionPane.showMessageDialog(null, "Error al crear ventana.");    
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario no válido");
        }
    }
    
    
    
    
    
}
