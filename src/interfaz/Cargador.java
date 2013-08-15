/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import contenedor.Lista;
import datosComunes.Usuario;
import datosInternos.Mensaje;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author LuisBrenes
 */
public class Cargador {
    
    public static DefaultListModel cargarlistaUsuarios(Lista usuarios){
        DefaultListModel modelLista = new DefaultListModel();
        
        for(int i = 0; i < usuarios.getCantidad() ;i++){
            modelLista.add(i, ((Usuario)usuarios.getLista().get(i)).getLoginUsr());
        }
        
        return modelLista;
    }

    public static String cargarMensajes(Lista tempMensajes) {
        String mensajes = "";
        for(int i = 0; i < tempMensajes.getCantidad() ;i++){
            String usuario = ((Mensaje)tempMensajes.getLista().get(i)).getUsuario();
            String mensaje = ((Mensaje)tempMensajes.getLista().get(i)).getMensaje();       
            mensajes += usuario +": "+mensaje+"\n\n";
        }
        return mensajes;
    }
    
    
    
}
