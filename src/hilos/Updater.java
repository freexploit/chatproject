/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import interfaz.DiSala;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.UICliente;


	



	
/**
 *
 * @author christopher
 */
public class Updater implements Runnable{
	private UICliente ui;
	private DiSala sala;
	
	public Updater(DiSala sala){
		this.sala=sala;
	}
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

