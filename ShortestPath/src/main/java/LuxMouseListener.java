import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class LuxMouseListener implements MouseListener {


    private int mouseClickCount = 0;
    Node startN = null;
    Node endN = null;
    Vector<Node> nodes;
    Vector<Arc> arcs;

    public LuxMouseListener(Vector<Node> nodes, Vector<Arc> arcs) {
        this.nodes = nodes;
        this.arcs = arcs;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Node n = CalculateEuclidianDistance(e.getPoint().x, e.getPoint().y);
        if (mouseClickCount == 0) {
            startN = n;
        }
        if (mouseClickCount == 1) {
            endN = n;
        }
        if (mouseClickCount == 2) {
            reset();
        }
        mouseClickCount = (mouseClickCount + 1) % 3;
    }

    private Node CalculateEuclidianDistance(int x, int y) {
        Double minDistance = Double.MAX_VALUE;
        Node result = null;
        for (Node n :
                nodes) {
            Double dist;
            dist = Point.distance(x,y,n.X,n.Y);
            if(dist < minDistance){
                minDistance  = dist;
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
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You pressed at " + e.getPoint());
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
