/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Estudiantes
 */
public class Cliente {

    //private final String HOST = "172.20.1.146"; LAB 7
    private final String HOST = "127.0.0.1";
    private final int PUERTO = 5000;
    private Object mensaje;

    public Cliente(Object mensaje) {

        try {

            // Crea un socket para establecer comunicacion con el servidor...
            System.out.println("Conectando a " + HOST + ":" + PUERTO);
            Socket cliente = new Socket(HOST, PUERTO);

            //Establece mecanismo de comunicacion con el servidor - Lectura..
            System.out.println("Estableciendo comunicacion de lectura con el server...");
            OutputStream conexionSalida = cliente.getOutputStream();
            ObjectOutputStream flujoEscritura = new ObjectOutputStream(conexionSalida);


            //Establece mecanismo de comunicacion con el servidor - Lectura..
            System.out.println("Estableciendo comunicacion de lectura con el server...");
            InputStream conexionEntrada = cliente.getInputStream();
            ObjectInputStream flujoLectura = new ObjectInputStream(conexionEntrada);

            // envio de la orden al servidor...

            flujoEscritura.writeObject(mensaje);

            //procesa la respuesta del servidor..
            System.out.println("Procesando respuesta del server");
            this.mensaje = flujoLectura.readObject();
            

            // cierra la conexion...
            System.out.println("Cerrando conexion...");
            flujoLectura.close();
            flujoEscritura.close();
            cliente.close();
            System.out.println("Fin de la conexion con el server..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getMensaje() {
        return mensaje;
    }
}
