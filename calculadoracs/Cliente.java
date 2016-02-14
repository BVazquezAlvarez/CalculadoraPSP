/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import static java.lang.System.out;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author Borja
 */
public class Cliente {

    int parametro1;
    int parametro2;
    int operando;
    OutputStream os;
    Socket clienteSocket = new Socket();

    public Cliente() {
    }

    public Cliente(int parametro1, int parametro2, int operando) {
        this.parametro1 = parametro1;
        this.parametro2 = parametro2;
        this.operando = operando;
    }

    //Crea el socket y los outputs para enviar
    public void conexion() throws IOException {

        System.out.println("Estableciendo la conexion");
        InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
        clienteSocket.connect(addr);

        os = clienteSocket.getOutputStream();
    }

    public void enviar() throws IOException {

        //Envia los parametros que se hayan escrito en la interfaz
        os.write(parametro1);
        os.write(parametro2);
        os.write(operando);
    }
}
