import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.awt.*;

@XmlRootElement(name = "arc")
@XmlAccessorType(XmlAccessType.NONE)
public class Arc {

    @XmlAttribute
    private String from;

    @XmlAttribute
    private String to;

    @XmlAttribute
    private int length;

    private Node startNode;
    private Node endNode;
    private Color color = Color.BLACK;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    @Override
    public String toString() {
        return "Arc{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", length='" + length + '\'' +
                '}';
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
        this.from = startNode.getId();

    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
        this.to = endNode.getId();
    }

    public void settleNeighbours() {
        if (startNode != null)
            this.startNode.addNeighbour(endNode);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
