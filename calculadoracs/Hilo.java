/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja
 */
public class Hilo extends Thread{
    
    private final int nhilo;

    public Hilo(int nhilo) {
        this.nhilo = nhilo;
    }

    @Override
    public void run() {
        //Instancia el Servidor
        Servidor serv = new Servidor();
        try {
            
            //Abre la conexion del servidor y le da permiso al cliente para enviarle
            serv.conexion();
            serv.receptor();
            //Imprime el resultado
            JOptionPane.showMessageDialog(null, "El resultado es "+serv.getAns(), null, nhilo);
            
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
