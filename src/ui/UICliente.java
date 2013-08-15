/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import cliente.Cliente;
import datosComunes.Accion;
import datosComunes.ObjComunicacion;
import datosComunes.Usuario;
import datosInternos.Mensaje;
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
        if ( (Boolean) peticion.getSalida()){
            JOptionPane.showMessageDialog(null, "debe recuperar la lista de conectados");
            peticion = new ObjComunicacion();
            peticion.setAccion(Accion.CREAR_SALA);
            peticion.setAccion(Accion.LISTAR_CONECTADOS);
            conexion = new Cliente (peticion);
            peticion = (ObjComunicacion) conexion.getMensaje();
            // en el dato de salida de la nueva peticion viene la lista de conectados..
            DiSala salita = new DiSala(null, false, this);
            salita.setVisible(true);
            if(salita != null){
                ventana.dispose();
                JOptionPane.showMessageDialog(null, peticion.getSalida());
            }else{
                JOptionPane.showMessageDialog(null, "Error al crear ventana.");    
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario no válido");
        }
    }

    public void enviarMensaje(DiSala salita) {
        IDSala = 0;
        String mensaje = salita.getTxtMensaje().getText();
        Mensaje paquete = new Mensaje(IDSala, mensaje, login);
        ObjComunicacion peticion = new ObjComunicacion(Accion.ENVIAR_MENSAJE, paquete);
        Cliente  conexion = new Cliente(peticion);
        
    }
    
    
    
    
}
