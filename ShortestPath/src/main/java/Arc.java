import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.awt.*;

@XmlRootElement(name = "arc")
@XmlAccessorType(XmlAccessType.NONE)
public class Arc {

    @XmlAttribute
    private Integer from;

    @XmlAttribute
    private Integer to;

    @XmlAttribute
    private int length;

    private Node startNode;
    private Node endNode;
    private Color color = Color.BLACK;

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
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
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public void settleNeighbours() {
        if (startNode != null)
            this.startNode.addNeighbour(new NodeCostPair(endNode, this));
    }

    public Color getColor() {
        return color;
    }

    public boolean setColor(Color color) {
        this.color = color;
        return true;
    }
}
