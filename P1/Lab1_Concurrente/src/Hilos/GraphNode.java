package Hilos;

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
    
    public GraphNode() {
        this.source = 0;
        this.dest = 0;
        this.weight = 0;
    }

    public GraphNode(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "GraphNode{" + "source=" + source + ", dest=" + dest + ", weight=" + weight + '}';
    }
    
    
}