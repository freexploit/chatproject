/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosInternos;

import contenedor.Lista;

/**
 *
 * @author M-01
 */
public class Sala {
    int id;
    String nombreSala;
    Lista usuarios;
    Lista mensajes;

    public int getId() {
        return id;
    }

    public Lista getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Lista usuarios) {
        this.usuarios = usuarios;
    }

    public Lista getMensajes() {
        return mensajes;
    }

    public void setMensajes(Lista mensajes) {
        this.mensajes = mensajes;
    }

    public Sala(int id) {
        this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Sala(int id, Lista usuarios, Lista mensajes) {
        this.id = id;
        this.usuarios = usuarios;
        this.mensajes = mensajes;
        System.out.println("**************SALA: SALA # " + this.id + " CANT. USUARIOS: " + this.usuarios.getCantidad() +" --\n ");
    }
    
    
}
