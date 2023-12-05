/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import java.util.*;
import Hilos.*;

/**
 *
 * @author Alejandro Andrade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numNodes = 1000;
        int startNode = 0;
        int weightRange = 5;
        int src, dest, weight;

        Random rand = new Random();

        long t_o = System.currentTimeMillis();

        ArrayList<GraphNode> grafo = new ArrayList<>();

        for (int i = 0; i < numNodes; i++)
        {
            src = rand.nextInt((int) (((float)numNodes) * 0.001F));
            dest = rand.nextInt(numNodes);
            weight = rand.nextInt(weightRange);

            GraphNode node = new GraphNode(src, dest, weight);
            grafo.add(node);
        }

        ArrayList<GraphNode> edges = grafo;
        
        printGraph(edges);
        
        new BellmanFord(numNodes, edges, startNode, weightRange).start();
        new Dijkstra(edges, startNode, weightRange).start();
    
        long t_f = System.currentTimeMillis();
        System.out.println("\n" + (t_f - t_o) + " milisegundos" + "\n");
    }
    
    public static void printGraph(ArrayList<GraphNode> edges) {
        GraphNode temp = new GraphNode();

        for (int i = 0; i < edges.size(); i++)
        {
            temp = edges.get(i);
            System.out.println(temp.toString());
        }
    }

}
