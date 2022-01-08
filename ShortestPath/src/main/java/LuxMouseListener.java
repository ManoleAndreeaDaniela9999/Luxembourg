import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class LuxMouseListener implements MouseListener {


    private int mouseClickCount;
    private Node startN = null;
    private Node endN = null;
    private Vector<Node> nodes;
    private Vector<Arc> arcs;
    private DijkstraAlg d;

    public LuxMouseListener(Vector<Node> nodes, Vector<Arc> arcs) {
        this.nodes = nodes;
        this.arcs = arcs;
        mouseClickCount = 0;
        d = new DijkstraAlg(nodes.size());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at " + e.getPoint());
        Node n = CalculateEuclidianDistance(e.getPoint().x, e.getPoint().y);
        if (mouseClickCount == 0) {
            startN = n;
        }
        if (mouseClickCount == 1) {
            int count = 0;
            endN = n;
            if (LuxFrame.activeOption == LuxFrame.Option.DIJKSTRA) {
                d.solve(startN);
                Vector<Node> solution = d.findShortestPath(endN);
                for (int i = 0; i < solution.size() - 1; i++) {
                    Arc a = solution.elementAt(i).getArcTo(solution.elementAt(i + 1));
                    a.setColor(Color.green);
                    a.setWidth(3);
                    a = solution.elementAt(i + 1).getArcTo(solution.elementAt(i));
                    a.setColor(Color.green);
                    a.setWidth(3);
                }

            }
            if (LuxFrame.activeOption == LuxFrame.Option.BELLMAN) {
                BellmanFordAlg b = new BellmanFordAlg(nodes, arcs);
                b.solve();
            }
        }
        if (mouseClickCount == 2) {
            reset();
            System.out.println("reset");
        }
        LuxFrame.luxPanel.repaint();
        mouseClickCount = (mouseClickCount + 1) % 3;
    }

    private Node CalculateEuclidianDistance(int x, int y) {
        Double minDistance = Double.MAX_VALUE;
        Node result = null;
        for (Node n :
                nodes) {
            Double dist;
            dist = Point.distance(x, y, n.X, n.Y);
            if (dist < minDistance) {
                minDistance = dist;
                result = n;
            }
        }
        return result;
    }

    public void reset() {
        startN = null;
        endN = null;
        for (Arc a :
                arcs) {
            a.setColor(Color.black);
            a.setWidth(1);
        }
        for (Node node :
                nodes) {
            node.setWasVisited(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("You pressed at " + e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
