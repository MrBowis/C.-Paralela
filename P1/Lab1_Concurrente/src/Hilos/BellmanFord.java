/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alejandro Andrade
 */
public class BellmanFord extends Thread {
    
    int numNodes = 0;
    int startNode = 0;
    ArrayList<GraphNode> edges = new ArrayList<>();
    int weightRange = 0;
    
    public BellmanFord(int numNodes, ArrayList<GraphNode> edges, int startNode, int weightRange){
        super();
        this.numNodes = numNodes;
        this.edges = edges;
        this.startNode = startNode;
        this.weightRange = weightRange;
    }
    
    @Override
    public void run(){
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        // Relajación de aristas repetidamente
        for (int i = 1; i < numNodes; i++)
        {
            for (GraphNode edge : edges)
            {
                if (distances[edge.getSource()] != Integer.MAX_VALUE && distances[edge.getSource()] + edge.getWeight() < distances[edge.getDest()])
                {
                    distances[edge.getDest()] = distances[edge.getSource()] + edge.getWeight();
                }
            }
        }

        // Detección de ciclo negativo
        for (GraphNode edge : edges)
        {
            if (distances[edge.getSource()] != Integer.MAX_VALUE && distances[edge.getSource()] + edge.getWeight() < distances[edge.getDest()])
            {
                System.err.println("El grafo contiene un ciclo negativo accesible desde el nodo de inicio.");
                // Puedes lanzar una excepción u tomar alguna acción en este caso.
            }
        }
        System.out.println("Distancias mínimas desde el nodo " + startNode + ":");
        for (int i = 0; i < numNodes; i++)
        {
            if (distances[i] > (weightRange * numNodes))
            {
                System.out.println("BF - No hay conexion de " + startNode + " al nodo " + i);
            } else
            {
                System.out.println("BF - Nodo " + i + ": " + distances[i]);

            }
        }
    }
    
}
