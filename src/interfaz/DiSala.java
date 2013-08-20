/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DiSala.java
 *
 * Created on 14-ago-2013, 19:01:57
 */
package interfaz;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ui.UISalas;

/**
 *
 * @author M-01
 */
public class DiSala extends javax.swing.JDialog {
    int IDSala;
    //RaulCorp:
    int ultimoMensaje;
    private UISalas uiSala;
    private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
    /** Creates new form DiSala */
    
    public DiSala(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
	uiSala = new UISalas(this);
        ultimoMensaje = 0;
        setLocationRelativeTo(null);

    }

	public int getIDSala() {
		return IDSala;
	}

	public void setIDSala(int IDSala) {
		this.IDSala = IDSala;
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jScrollPane1 = new javax.swing.JScrollPane();
                txtChat = new javax.swing.JTextArea();
                jPanel1 = new javax.swing.JPanel();
                lblTitle = new javax.swing.JLabel();
                nuevaSala = new javax.swing.JButton();
                enviarArchivo = new javax.swing.JButton();
                txtMensaje = new javax.swing.JTextField();
                lblMensaje = new javax.swing.JLabel();
                btnEnviar = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                lstUsuarios = new javax.swing.JList();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setResizable(false);

                txtChat.setColumns(20);
                txtChat.setRows(5);
                jScrollPane1.setViewportView(txtChat);

                jPanel1.setBackground(new java.awt.Color(0, 0, 0));
                jPanel1.setForeground(new java.awt.Color(255, 255, 255));

                lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                lblTitle.setForeground(new java.awt.Color(255, 255, 255));
                lblTitle.setText("CHAT 2000");

                nuevaSala.setText("Nueva Sala");
                nuevaSala.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                nuevaSalaActionPerformed(evt);
                        }
                });

                enviarArchivo.setText("Enviar Archivo");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enviarArchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nuevaSala)
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTitle)
                                        .addComponent(nuevaSala)
                                        .addComponent(enviarArchivo))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                lblMensaje.setText("Mensaje:");

                btnEnviar.setBackground(new java.awt.Color(204, 204, 255));
                btnEnviar.setText("Enviar");
                btnEnviar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEnviarActionPerformed(evt);
                        }
                });

                lstUsuarios.setModel(new javax.swing.AbstractListModel() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                });
                jScrollPane2.setViewportView(lstUsuarios);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblMensaje)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMensaje)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMensaje)
                                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
    uiSala.enviarMensaje();
    this.txtMensaje.setText("");
    
}//GEN-LAST:event_btnEnviarActionPerformed

        private void nuevaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaSalaActionPerformed
		int id = 0;
		id =uiSala.crearSala();
		DiSala newSala= new DiSala(null,false);
		newSala.setIDSala(id);
		newSala.setVisible(true);
                // TODO add your handling code here:
		
        }//GEN-LAST:event_nuevaSalaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DiSala dialog = new DiSala(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public JList getLstUsuarios() {
        return lstUsuarios;
    }

    public JTextArea getTxtChat() {
        return txtChat;
    }

    public JTextField getTxtMensaje() {
        return txtMensaje;
    }

    public int getUltimoMensaje() {
        return ultimoMensaje;
    }
    
    
    
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEnviar;
        private javax.swing.JButton enviarArchivo;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lblMensaje;
        private javax.swing.JLabel lblTitle;
        private javax.swing.JList lstUsuarios;
        private javax.swing.JButton nuevaSala;
        private javax.swing.JTextArea txtChat;
        private javax.swing.JTextField txtMensaje;
        // End of variables declaration//GEN-END:variables

}
