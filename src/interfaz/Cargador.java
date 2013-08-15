/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import contenedor.Lista;
import datosComunes.Usuario;
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
    
    
    
}
