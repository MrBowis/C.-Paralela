/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Alex Trejo
 */
public class Servidor {
    
    private int puerto;
    
    public Servidor(int puerto) {
    
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("SERVER INICIADO - Esperando conexiones de clientes ...");
            int cont=1;
            for (;;) {
                    Socket cliente = servidor.accept();
                    System.out.println("Se conecto el cliente " + cont);
                    DataOutputStream salida = new
                    DataOutputStream(cliente.getOutputStream());
                    salida.writeUTF("Bienvenido cliente " + cont);
                    salida.close();
                    cliente.close();
                    cont++;
            }
            
            /*servidor.close();
            System.out.println("SERVER TERMINADO");*/
        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    }    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Servidor(5353);
    }
    
}
