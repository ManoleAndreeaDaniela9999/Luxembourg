import java.awt.*;

public class GraphicsDrawMethods {
    public static void DrawSimpleArc(Arc arc, Graphics g) {

        Point startPos = new Point(Math.round(arc.getStartNode().X),Math.round(arc.getStartNode().Y));
        Point endPos = new Point(Math.round(arc.getEndNode().X),Math.round(arc.getEndNode().Y));

        g.setColor(arc.getColor());
        g.drawLine(startPos.x, startPos.y, endPos.x, endPos.y);

    }

    public static void DrawNode(Node node, Graphics g) {
        g.setColor(Color.black);
        g.fillOval(Math.round(node.X - node.getRadius()), Math.round(node.Y - node.getRadius()), Math.round(node.getDiam()), Math.round(node.getDiam()));
        g.drawOval(Math.round(node.X - node.getRadius()), Math.round(node.Y - node.getRadius()), Math.round(node.getDiam()), Math.round(node.getDiam()));
    }
}
