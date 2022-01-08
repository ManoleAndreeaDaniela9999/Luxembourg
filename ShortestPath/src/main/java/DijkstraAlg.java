import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class DijkstraAlg {

    private int[] distances;
    private Node[] prev;
    private Integer size;

    //takes only sorted nodes vector
    public DijkstraAlg(Integer nodesSize) {

        distances = new int[nodesSize];
        prev = new Node[nodesSize];
        size = nodesSize;
    }

    public void solve(Node start) {
        for (int i = 0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
            prev[i] = null;
        }

        distances[start.getId()] = 0;
        PriorityQueue<NodeCostPair> pq = new PriorityQueue<NodeCostPair>((p1, p2) -> Integer.compare(p1.cost, p2.cost));

        pq.add(new NodeCostPair(start, 0));

        while (!pq.isEmpty()) {
            NodeCostPair p = pq.poll();
            Node currentNode = p.node;
            Integer minCost = p.cost;

            currentNode.setWasVisited(true);
            int index = currentNode.getId();
            if (distances[index] < minCost) continue;

            for (NodeCostPair pn : currentNode.getNeighbours()) {
                if (pn.node.wasVisited()) continue;
                int newDist = distances[index] + pn.cost;
                int neighbourIndex = pn.node.getId();
                if (newDist < distances[neighbourIndex]) {
                    prev[neighbourIndex] = currentNode;
                    distances[neighbourIndex] = newDist;
                    pq.add(new NodeCostPair(pn.node, newDist));
                }
            }
        }
    }

    public Vector<Node> findShortestPath(Node end) {

        Vector<Node> path = new Vector<>();
        if (distances[end.getId()] == Integer.MAX_VALUE) return null;
        for (Node n = end; n != null; n = prev[n.getId()]) {
            path.add(n);//TODO: SOLVE ERROR HEAP SPACE OUT OF MEMORY
        }
        Collections.reverse(path);
        return path;
    }

}
