/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import Grafo.GraphNode;
import java.util.*;


/**
 *
 * @author Alejandro Andrade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numNodes = 7;
        int startNode = 0;

        List<List<GraphNode>> graph = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Agregar aristas al GraphNode (aquí, es un GraphNode dirigido)
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 4);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 3, 7);
        addEdge(graph, 2, 4, 3);
        addEdge(graph, 3, 4, 1);
        addEdge(graph, 3, 5, 1);
        addEdge(graph, 4, 6, 2);

        // Calcular distancias mínimas desde el nodo de inicio
        int[] distances = dijkstra(graph, startNode);

        // Imprimir las distancias mínimas
        System.out.println("Distancias mínimas desde el nodo " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Nodo " + i + ": " + distances[i]);
        }
    }

    public static void addEdge(List<List<GraphNode>> graph, int src, int dest, int weight) {
        graph.get(src).add(new GraphNode(dest, weight));
    }

    // Implementación del algoritmo de Dijkstra
    public static int[] dijkstra(List<List<GraphNode>> graph, int startNode) {
        int numNodes = graph.size();
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.getWeight()));
        priorityQueue.add(new GraphNode(startNode, 0));
        distances[startNode] = 0;

        while (!priorityQueue.isEmpty()) {
            GraphNode currentNode = priorityQueue.poll();

            for (GraphNode neighbor : graph.get(currentNode.getVertex())) {
                int newDistance = distances[currentNode.getVertex()] + neighbor.getWeight();

                if (newDistance < distances[neighbor.getVertex()]) {
                    distances[neighbor.getVertex()] = newDistance;
                    priorityQueue.add(new GraphNode(neighbor.getVertex(), newDistance));
                }
            }
        }

        return distances;
    }
    
}
