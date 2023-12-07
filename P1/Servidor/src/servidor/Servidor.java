package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Servidor {

    private int puerto;

    public Servidor(int puerto) {
        try
        {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("SERVER INICIADO - Esperando conexiones de clientes ...");
            int cont = 1;
            ArrayList<String> productos = new ArrayList<>();
            ArrayList<String> descuentos = new ArrayList<>();

            productos.add("Papel");
            productos.add("Tijeras");
            productos.add("Goma");
            productos.add("Lapiz");
            productos.add("Borrador");

            descuentos.add("Hoy tenemos un 15% de descuento");
            descuentos.add("Hoy tenemos un 25% de descuento");
            descuentos.add("Hoy tenemos un 35% de descuento");
            descuentos.add("Hoy tenemos un 45% de descuento");
            descuentos.add("Hoy tenemos un 60% de descuento");

            Random rand = new Random();
            boolean salir = false;

            for (;;)
            {
                Socket cliente = servidor.accept();
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                salida.writeUTF("Hola cliente " + cont);
                String texto = "";

                while (!texto.equals("salir") && salir == false)
                {
                    texto = entrada.readUTF();

                    switch (texto)
                    {
                        case "productos":
                        {
                            int posRespuesta = rand.nextInt(productos.size());
                            salida.writeUTF(productos.get(posRespuesta));
                            break;
                        }
                        case "descuento":
                        {
                            int posRespuesta = rand.nextInt(descuentos.size());
                            salida.writeUTF(descuentos.get(posRespuesta));
                            break;
                        }
                        case "salir":
                        {
                            salir = true;
                            break;
                        }
                        default:
                            salida.writeUTF("X_X");
                            break;
                    }
                }

                entrada.close();
                salida.close();
                cliente.close();
                cont++;
            }

        } catch (IOException e)
        {

        }
    }

    public static void main(String[] args) {
        new Servidor(10000);
    }
}
