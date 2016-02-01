/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Borja
 */
public class Servidor {

    int ans;
    InputStream is;
    OutputStream os;
    Socket newSocket;
    ServerSocket serverSocket;
    
    public Servidor() {
    }

    public Servidor(int ans) {
        this.ans = ans;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    
      public void conexion() throws IOException{
          System.out.println("Creando socket servidor");

        serverSocket = new ServerSocket();

        System.out.println("Realizando el bind");

        InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
        serverSocket.bind(addr);

        
      }
    public void receptor() throws IOException {

        
System.out.println("Aceptando conexiones");

        newSocket = serverSocket.accept();

        System.out.println("Conexi�n recibida");

       is = newSocket.getInputStream();
        os = newSocket.getOutputStream();
        byte[] mensaje = new byte[25];
        int parametro1 = (is.read());
        int parametro2 = (is.read());
        int operacion = (is.read());

        if (operacion == 0) {
            ans = parametro1 + parametro2;
        } else if (operacion == 1) {
            ans = parametro1 - parametro2;

        } else if (operacion == 2) {
            ans = parametro1 * parametro2;

        } else if (operacion == 3) {
            ans = parametro1 / parametro2;

        }

        newSocket.close();

        System.out.println("Cerrando el socket servidor");

        serverSocket.close();

        System.out.println("Terminado");
    }
}
