import java.util.Collections;
import java.util.Vector;

public class BellmanFordAlg {


    private Integer size;
    private double[] dist;
    private Node[] prev;

    public  BellmanFordAlg(Vector<Arc> arcs, Integer nOfNodes){
        this.size = arcs.size();
        dist = new double[size];
        prev = new Node[nOfNodes];
    }

    public double[] solve(Node start ,Vector<Arc>  arcs){

        java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
        java.util.Arrays.fill(prev, null);
        dist[start.getId()] = 0;
        prev[start.getId()] = start;

        boolean relaxedAnEdge = true;

        for (int v = 0; v < size - 1 && relaxedAnEdge; v++) {
            relaxedAnEdge = false;
            for (Arc arc : arcs) {
                if (dist[arc.getFrom()] + arc.getLength() < dist[arc.getTo()]) {
                    dist[arc.getTo()] = dist[arc.getFrom()] + arc.getLength();
                    relaxedAnEdge = true;
                    prev[arc.getTo()] = arc.getStartNode();
                }
            }
        }


        relaxedAnEdge = true;
        for (int v = 0; v < size - 1 && relaxedAnEdge; v++) {
            relaxedAnEdge = false;
            for (Arc arc : arcs) {
                if (dist[arc.getFrom()] + arc.getLength() < dist[arc.getTo()]) {
                    dist[arc.getTo()] = Double.NEGATIVE_INFINITY;
                    relaxedAnEdge = true;
                }
            }
        }
        return dist;
    }

    public Vector<Node> findShortestPath(Node end) {

        Vector<Node> path = new Vector<>();
        if (dist[end.getId()] == Double.POSITIVE_INFINITY || dist[end.getId()] == Double.NEGATIVE_INFINITY) return null;
        for (Node n = end; n != prev[n.getId()]; n = prev[n.getId()]) {
            path.add(n);
        }
        Collections.reverse(path);
        return path;
    }
}
