/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cl;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Alex Trejo
 */
public class Cl {

    /**
     * @param args the command line arguments
     */
    
    private int puerto;
    private String ip;
    
    public Cl(String ip, int puerto) {
    this.ip = ip;
    this.puerto = puerto;
    try {
        Socket cliente = new Socket(ip, puerto);
        DataInputStream entrada = new
        DataInputStream(cliente.getInputStream());
        System.out.println(entrada.readUTF());
        entrada.close();
        cliente.close();
        
    }catch(IOException e){
        e.printStackTrace();
    }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Cl("10.40.18.2", 5353);
    }
}