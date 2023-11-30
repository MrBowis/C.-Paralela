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
        int numNodes = 7;
        int startNode = 0;

        List<GraphNode> edges = Arrays.asList(
                new GraphNode(0, 1, 2),
                new GraphNode(0, 2, 1),
                new GraphNode(1, 2, 5),
                new GraphNode(1, 3, 11),
                new GraphNode(1, 4, 3),
                new GraphNode(2, 5, 15),
                new GraphNode(3, 4, 2),
                new GraphNode(3, 6, 1),
                new GraphNode(4, 5, 4),
                new GraphNode(4, 6, 7),
                new GraphNode(5, 6, 3));

        // Calcular distancias mínimas desde el nodo de inicio
        //int[] distances = dijkstra(edges, startNode);

        int[] distances = bellmanFord(numNodes, edges, startNode);

        // Imprimir las distancias mínimas
        System.out.println("Distancias mínimas desde el nodo " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Nodo " + i + ": " + distances[i]);
        }
    }

    // Implementación del algoritmo de Dijkstra
    // public static int[] dijkstra(List<GraphNode> graph, int startNode) {
    //     int numNodes = graph.size();
    //     int[] distances = new int[numNodes];
    //     Arrays.fill(distances, Integer.MAX_VALUE);

    //     PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.getWeight()));
    //     priorityQueue.add(new GraphNode(startNode, startNode, 0));
    //     distances[startNode] = 0;

    //     while (!priorityQueue.isEmpty()) {
    //         GraphNode currentNode = priorityQueue.poll();

    //         for (GraphNode neighbor : graph) {
            
    //             if (neighbor.getSource() == currentNode.getDest()) {
    //                 int newDistance = distances[currentNode.getDest()] + neighbor.getWeight();

    //                 if (newDistance < distances[neighbor.getDest()]) {
    //                     distances[neighbor.getDest()] = newDistance;
    //                     priorityQueue.add(new GraphNode(startNode, neighbor.getDest(), newDistance));
    //                 }
    //             }

    //         }
    //     }

    //     return distances;
    // }

    public static int[] bellmanFord(int numNodes, List<GraphNode> edges, int startNode) {
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        // Relajación de aristas repetidamente
        for (int i = 1; i < numNodes; i++) {
            for (GraphNode edge : edges) {
                if (distances[edge.getSource()] != Integer.MAX_VALUE && distances[edge.getSource()] + edge.getWeight() < distances[edge.getDest()]) {
                    distances[edge.getDest()] = distances[edge.getSource()] + edge.getWeight();
                }
            }
        }

        // Detección de ciclo negativo
        for (GraphNode edge : edges) {
            if (distances[edge.getSource()] != Integer.MAX_VALUE && distances[edge.getSource()] + edge.getWeight() < distances[edge.getDest()]) {
                System.err.println("El grafo contiene un ciclo negativo accesible desde el nodo de inicio.");
                // Puedes lanzar una excepción u tomar alguna acción en este caso.
            }
        }

        return distances;
    }

    // public static int[] bellman_ford(List<List<GraphNode>> graph, int startNode) {
    //     int numNodes = graph.size();
    //     int[] distances = new int[numNodes];
    //     Arrays.fill(distances, Integer.MAX_VALUE);

    //     for (int i = 0; i <= numNodes; i++) {
    //     }

    //     distances[startNode] = 0;

    //     return distances;
    // }

}
