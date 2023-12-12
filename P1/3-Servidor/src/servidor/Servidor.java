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
            System.out.println("SERVER INICIADO - Esperando conexiones de clientes ...");
            ServerSocket servidor = new ServerSocket(puerto);
            int cont = 1;

            for (;;)
            {
                Socket cliente = servidor.accept();
                new Thread(new ManejadorCliente(cliente, cont)).start();
                cont++;
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public class ManejadorCliente implements Runnable {

        private Socket cliente;
        private int cont;
        private ArrayList<String> productos;
        private ArrayList<String> descuentos;
        private Random rand;

        public ManejadorCliente(Socket cliente, int cont) {
            this.cliente = cliente;
            this.cont = cont;
            this.rand = new Random();
            this.productos = new ArrayList<>();
            this.descuentos = new ArrayList<>();

            this.productos.add("Papel");
            this.productos.add("Tijeras");
            this.productos.add("Goma");
            this.productos.add("Lapiz");
            this.productos.add("Borrador");

            this.descuentos.add("Hoy tenemos un 15% de descuento");
            this.descuentos.add("Hoy tenemos un 25% de descuento");
            this.descuentos.add("Hoy tenemos un 35% de descuento");
            this.descuentos.add("Hoy tenemos un 45% de descuento");
            this.descuentos.add("Hoy tenemos un 60% de descuento");
        }

        @Override
        public void run() {
            try
            {
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                salida.writeUTF("Hola cliente " + cont);
                System.out.println("Ha ingresado el cliente " + cont);
                String texto = "";

                while (!texto.equals("salir"))
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
                            entrada.close();
                            salida.close();
                            cliente.close();
                            break;
                        }
                        default:
                            salida.writeUTF("X_X");
                            break;
                    }
                    this.cont++;
                }

            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new Servidor(10000);
    }
}
