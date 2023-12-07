/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Grafo.GraphNode;
import java.util.*;

/**
 *
 * @author Alejandro Andrade, Allan Panchi, Alex Trejo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numNodes = 100;
        int startNode = 0;
        int weightRange = 5;
        int src, dest, weight;

        Random rand = new Random();

        long t_o = System.currentTimeMillis();

        ArrayList<GraphNode> grafo = new ArrayList<>();

        for (int i = 0; i < numNodes; i++)
        {
            src = rand.nextInt((int) (((float)numNodes) * 0.1F));
            dest = rand.nextInt(numNodes);
            weight = rand.nextInt(weightRange);

            GraphNode node = new GraphNode(src, dest, weight);
            grafo.add(node);
        }

        ArrayList<GraphNode> edges = grafo;
        
        printGraph(edges);

        // Calcular distancias mínimas desde el nodo de inicio
        int[] distances1 = dijkstra(edges, startNode);
        int[] distances2 = bellmanFord(numNodes, edges, startNode);

        // Imprimir las distancias mínimas
        System.out.println("Distancias mínimas desde el nodo " + startNode + ":");
        for (int i = 0; i < numNodes; i++)
        {
            if (distances1[i] > (weightRange * numNodes))
            {
                System.out.println("D - No hay conexion de " + startNode + " al nodo " + i);
            } else
            {
                System.out.println("D - Nodo " + i + ": " + distances1[i]);

            }
        }

        System.out.println("Distancias mínimas desde el nodo " + startNode + ":");
        for (int i = 0; i < numNodes; i++)
        {
            if (distances1[i] > (weightRange * numNodes))
            {
                System.out.println("BF - No hay conexion de " + startNode + " al nodo " + i);
            } else
            {
                System.out.println("BF - Nodo " + i + ": " + distances2[i]);
            }
        }

        long t_f = System.currentTimeMillis();
        System.out.println(t_f - t_o + " milisegundos");

    }

    public static void printGraph(ArrayList<GraphNode> edges) {
        GraphNode temp = new GraphNode();

        for (int i = 0; i < edges.size(); i++)
        {
            temp = edges.get(i);
            System.out.println(temp.toString());
        }
    }

    // Implementación del algoritmo de Dijkstra
    public static int[] dijkstra(ArrayList<GraphNode> graph, int startNode) {
        int numNodes = graph.size();
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.getWeight()));
        priorityQueue.add(new GraphNode(startNode, startNode, 0));
        distances[startNode] = 0;

        while (!priorityQueue.isEmpty())
        {
            GraphNode currentNode = priorityQueue.poll();

            for (GraphNode neighbor : graph)
            {

                if (neighbor.getSource() == currentNode.getDest())
                {
                    int newDistance = distances[currentNode.getDest()] + neighbor.getWeight();

                    if (newDistance < distances[neighbor.getDest()])
                    {
                        distances[neighbor.getDest()] = newDistance;
                        priorityQueue.add(new GraphNode(startNode, neighbor.getDest(), newDistance));
                    }
                }

            }
        }

        return distances;
    }

    public static int[] bellmanFord(int numNodes, ArrayList<GraphNode> edges, int startNode) {
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

        return distances;
    }
}
