package Grafo;
import java.util.*;

public class GraphNode {
    int vertex;
    int weight;

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public GraphNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}