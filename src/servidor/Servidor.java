/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import contenedor.Lista;
import datosComunes.ObjComunicacion;
import datosComunes.Usuario;
import datosInternos.Mensaje;
import datosInternos.Sala;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiantes
 */
public class Servidor {

	private final int PUERTO = 5000;

	/*se definen dos listas : la general y la de conectados*/
	private Lista general = new Lista();
	private Lista conectados = new Lista();
	private Lista salas = new Lista();

	public Servidor() {
		try {
			// se crea el servidor..
			File f = new File("usuarios");
			//verifica si existe el archivo usuarios y lo carga
			if (f.exists()) {
				general = general.cargar("usuarios");
			}
			System.out.println("Levantando servidor...");
			ServerSocket server = new ServerSocket(PUERTO);
			// se entra a un proceso infinto de atencion...
			while (true) {
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
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	private ObjComunicacion procesePeticion(ObjComunicacion peticion) {
		switch (peticion.getAccion()) {
			case REGISTRAR:
				Usuario u = (Usuario) peticion.getEntrada();
				if (general.consultar(u) == null) {
					general.agregar(u);
					//persistencia de usuarios
					try {
						general.grabar("usuarios");
					} catch (FileNotFoundException ex) {
						Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
					} catch (IOException ex) {
						Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
					}

					peticion.setSalida("Usuario registrado...");
				} else {
					peticion.setSalida("Usuario NO registrado (login duplicado)...");
				}
				break;
			case INGRESAR: {
				u = (Usuario) peticion.getEntrada();
				Usuario usrLista = (Usuario) general.consultar(u);
				if (usrLista != null && u.getPassUsr().equals(usrLista.getPassUsr())) {
					conectados.agregar(usrLista);
					peticion.setSalida(0);
					if (salas.getCantidad() == 0) {
						Lista tempUsers = new Lista();
						tempUsers.agregar(u);
						crearSala(tempUsers);
					} else {
						((Sala)salas.getLista().get(0)).getUsuarios().agregar(u);
					}
				} else {
					peticion.setSalida(-1);
				}
			}

			break;

			case ENVIAR_MENSAJE:
				Mensaje m = (Mensaje) peticion.getEntrada();
                                //este mensaje vacío es el que manda el cargador para que solo le devuelvan la lista de mensajes,sin agregar ningun mensaje nuevo
                                if( (m.getMensaje().equals("") && m.getUsuario().equals("")) == false ){
                                    ((Sala) salas.getLista().get(m.getIDSala())).getMensajes().agregar(m);
                                }
                                peticion.setSalida(((Sala) salas.getLista().get(m.getIDSala())).getMensajes());
				break;
			case LISTAR_CONECTADOS:
				int IDSala = (Integer) peticion.getEntrada();
				peticion.setSalida(((Sala) salas.getLista().get(IDSala)).getUsuarios());
				break;

			case SALUDAR:
				peticion.setSalida("Saludos " + peticion.getEntrada() + "!!");
				break;
			case CREAR_SALA:
				Usuario usuario = (Usuario) peticion.getEntrada();
                                System.out.println("**************SERVER: CREAR SALA POR usuario:" + usuario.getLoginUsr() +" --\n ");
				Usuario realone = (Usuario) conectados.consultar(usuario);
                                System.out.println("**************SERVER:CREAR SALA POR realone (CONFIRMADO):" + usuario.getLoginUsr() +" --\n ");
				Lista l = new Lista();
				l.agregar(realone);
				peticion.setSalida(crearSala(l));
				break;
				
					
		}
		return peticion;


	}

	private String marcadeTiempo() {
		java.util.Date date = new java.util.Date();
		return (new Timestamp(date.getTime())).toString();
	}

	//Crea sala y añade al usuario que la solicita
	private int crearSala(Lista usuarios) {
            Lista tempMensajes = new Lista();
            int indiceSala = this.salas.getCantidad();
            tempMensajes.agregar(new Mensaje(indiceSala, "Sala Creada - Numero: " + indiceSala + " - " + marcadeTiempo(), "SERVIDOR"));
            salas.agregar(new Sala(indiceSala, usuarios, tempMensajes));
            if (indiceSala == 0) {
                    ((Sala) salas.getLista().get(0)).setNombreSala("LOBBY : Bienvenido!");
            }
            return indiceSala;
    }
}
