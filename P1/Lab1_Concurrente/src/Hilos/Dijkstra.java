/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Alejandro Andrade
 */
public class Dijkstra extends Thread {

    ArrayList<GraphNode> graph = new ArrayList<>();
    int startNode = 0;
    int weightRange = 0;

    public Dijkstra(ArrayList<GraphNode> graph, int startNode, int weightRange) {
        super();
        this.startNode = startNode;
        this.graph = graph;
        this.weightRange = weightRange;
    }

    @Override
    public void run() {
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
        
        System.out.println("Distancias mínimas desde el nodo " + startNode + ":");
        for (int i = 0; i < numNodes; i++)
        {
            if (distances[i] > (weightRange * numNodes))
            {
                System.out.println("D - No hay conexion de " + startNode + " al nodo " + i);
            } else
            {
                System.out.println("D - Nodo " + i + ": " + distances[i]);
            }
        }
    }
}

