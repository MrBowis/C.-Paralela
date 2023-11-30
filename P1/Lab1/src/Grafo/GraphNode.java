package Grafo;

public class GraphNode {
    int dest;
    int weight;
    int source;

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    public int getSource() {
        return source;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public GraphNode(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}