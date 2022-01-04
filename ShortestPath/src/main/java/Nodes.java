import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Vector;

@XmlRootElement(name = "nodes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Nodes implements Serializable {

    @XmlElement(name = "node")
    private Vector<Node> nodes = null;

    public Vector<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Vector<Node> nodes) {
        this.nodes = nodes;
    }
}