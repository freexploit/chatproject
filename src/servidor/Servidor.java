/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import contenedor.Lista;
import datosComunes.ObjComunicacion;
import datosComunes.Usuario;
import datosInternos.Mensaje;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Estudiantes
 */
public class Servidor {
    
    private final int PUERTO= 5000;

    /*se definen dos listas : la general y la de conectados*/
    private Lista general = new Lista();
    private Lista conectados = new Lista();
    private Lista salas = new Lista();
    
    public Servidor() {
        try {
            // se crea el servidor..
            System.out.println("Levantando servidor...");
            ServerSocket server = new ServerSocket(PUERTO);
            // se entra a un proceso infinto de atencion...
            while (true){
                System.out.println("Esperando conexion de un cliente...");
                // se espera la peticion del cliente
                Socket cliente = server.accept();
                System.out.println("Estableciendo canal de escritura...");
                // se establece el canal de comunicacion-Escritura-Lectura

                OutputStream conexionSalida = cliente.getOutputStream();
                ObjectOutputStream flujoSalida = new ObjectOutputStream(conexionSalida);
                
                InputStream conexionEntrada = cliente.getInputStream();
                ObjectInputStream flujoEntrada = new ObjectInputStream(conexionEntrada);
               
                ObjComunicacion peticion = (ObjComunicacion) flujoEntrada.readObject();
                peticion = procesePeticion(peticion);
                // decifra lo que le envian y procede a ejecutar la accion
                
                System.out.println("Enviando respuesta al cliente ");
                flujoSalida.writeObject(peticion);
                flujoSalida.flush();
                // se cierra la conexion con el cliente...
                System.out.println("Cerrando conexion ...");
                flujoSalida.close();
                flujoEntrada.close();
                cliente.close();
            }  // while
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }

    private ObjComunicacion procesePeticion(ObjComunicacion peticion) {
      switch(peticion.getAccion())  {
          case REGISTRAR : 
               Usuario u = (Usuario) peticion.getEntrada();
               if (general.consultar(u) == null){
                   general.agregar(u);
                   
                   peticion.setSalida("Usuario registrado...");
               }
               else{
                   peticion.setSalida("Usuario NO registrado (login duplicado)...");
               }
               break;
          case INGRESAR : {
               u = (Usuario) peticion.getEntrada();
               Usuario usrLista = (Usuario) general.consultar(u) ;
               if (usrLista != null && 
                   u.getPassUsr().equals(usrLista.getPassUsr())){
                   conectados.agregar(usrLista);
                   peticion.setSalida(true);
               }
               else{
                   peticion.setSalida(false);
               }
          }
              
              break;

          case ENVIAR_MENSAJE:
              Mensaje m = (Mensaje) peticion.getEntrada();
              break;
          case LISTAR_CONECTADOS: 
               peticion.setSalida(conectados);
               break;

          case SALUDAR: 
              peticion.setSalida("Saludos " + peticion.getEntrada()+"!!");
              break;
      }
      return peticion;
        
        
    }











}
