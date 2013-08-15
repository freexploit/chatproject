/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosInternos;

/**
 *
 * @author M-01
 */
public class Mensaje {
    String mensaje;
    String usuario;
    int IDSala;

    public Mensaje(int sala, String mensaje, String usuario){
        this.IDSala = sala;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }
    
    public int getIDSala() {
        return IDSala;
    }

    public void setIDSala(int IDSala) {
        this.IDSala = IDSala;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
