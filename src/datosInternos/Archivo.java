/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosInternos;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author christopher
 */
public class Archivo implements Serializable{
	
	private File file;
	private String sender;
	private String recivier;

	public Archivo(File file, String sender, String recivier) {
		this.file = file;
		this.sender = sender;
		this.recivier = recivier;
	}

	public Archivo() {
	}

	public File getFile() {
		return file;
	}

	public String getSender() {
		return sender;
	}

	public String getRecivier() {
		return recivier;
	}

	
}
