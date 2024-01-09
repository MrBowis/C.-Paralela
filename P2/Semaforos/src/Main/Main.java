/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import Hilos.Usuario;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Alejandro Andrade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numImpresoras = 1;
        Semaphore semaforoImpresoras = new Semaphore(numImpresoras);
        
        for (int i = 1; i <= 5; i++)
        {
            Thread hiloUsuario = new Thread(new Usuario(semaforoImpresoras, "Usuario " + i));
            hiloUsuario.start();
        }
        
    }
    
}
