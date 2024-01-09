/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Alejandro Andrade
 */
public class Usuario extends Thread {
    private final Semaphore semaforoImpresora;
    private final String nombreUsuario;
    
    public Usuario(Semaphore semaforoImpresora, String nombreUsuario){
        this.semaforoImpresora = semaforoImpresora;
        this.nombreUsuario = nombreUsuario;
    }
    
    @Override
    public void run(){
        try{
            System.out.println(nombreUsuario + " esta esperando para usar una impresora");
            
            semaforoImpresora.acquire();
            System.out.println(nombreUsuario + " esta usando una impresora");
            
            Thread.sleep(2000);
            System.out.println(nombreUsuario + " ha terminado de usar una impresora");
            
            semaforoImpresora.release();
            
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
