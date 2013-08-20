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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christopher
 */
public final class UISalas implements Runnable {
    private DiSala ventana;

	public UISalas(DiSala ventana) {
		this.ventana = ventana;
		refrescarVentana();
	}


    private void refrescarVentana(){
	//Refrescar lista usuarios
	ObjComunicacion peticion = new ObjComunicacion();
	peticion.setAccion(Accion.LISTAR_CONECTADOS);
	peticion.setEntrada(ventana.getIDSala());
	Cliente conexion = new Cliente (peticion);
	peticion = (ObjComunicacion) conexion.getMensaje();
	Lista tempLista = (Lista)peticion.getSalida();
	ventana.getLstUsuarios().setModel(Cargador.cargarlistaUsuarios(tempLista));
	//Refrescar lista mensajes
	peticion = new ObjComunicacion(Accion.ENVIAR_MENSAJE, new Mensaje(ventana.getIDSala(), "",""));
	conexion = new Cliente(peticion);
	peticion = (ObjComunicacion) conexion.getMensaje();
	Lista tempMensajes = (Lista)peticion.getSalida();
	ventana.getTxtChat().setText(Cargador.cargarMensajes(tempMensajes));
	
    }

    public void enviarMensaje() {
	String mensaje = ventana.getTxtMensaje().getText().trim();
	Mensaje paquete = new Mensaje(ventana.getIDSala(), mensaje, ventana.getLogin());
	ObjComunicacion peticion = new ObjComunicacion();
	peticion.setAccion(Accion.ENVIAR_MENSAJE);
	peticion.setEntrada(paquete);
	Cliente conexion = new Cliente(peticion);
	refrescarVentana();
	
	
    }
    public int crearSala(){
    	Usuario u = new Usuario(null,ventana.getLogin(),null);
	ObjComunicacion peticion = new ObjComunicacion();
	peticion.setAccion(Accion.CREAR_SALA);
	peticion.setEntrada(u);
	Cliente conexion = new Cliente(peticion);
	peticion = (ObjComunicacion) conexion.getMensaje();
	Integer id = (Integer) peticion.getSalida();
	int iD=id.intValue();
	return iD;
    
    }

	public void run() {
		refrescarVentana();
	    try {
		    Thread.sleep(1000);
	    } catch (InterruptedException ex) {
		    Logger.getLogger(UISalas.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}
	
}
