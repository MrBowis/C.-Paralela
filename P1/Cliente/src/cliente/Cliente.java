package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private int puerto;
    private String ip;

    public Cliente(String ip, int puerto) throws InterruptedException {
        this.ip = ip;
        this.puerto = puerto;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        try
        {
            Socket cliente = new Socket(ip, puerto);
            DataInputStream entrada = new DataInputStream(
                    cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(
                    cliente.getOutputStream());
            System.out.println(entrada.readUTF());

            while (!salir)
            {
                System.out.println("Ingresa algo: ");
                String texto = sc.next();
                salida.writeUTF(texto);
                if (texto.equals("salir"))
                {
                    salir = true;
                    break;
                }
                System.out.println(entrada.readUTF());
            }

            System.out.println("Hasta la proxima ...");

            salida.close();
            entrada.close();
            cliente.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Cliente cliente = new Cliente("10.40.18.156", 10000);
    }
}
