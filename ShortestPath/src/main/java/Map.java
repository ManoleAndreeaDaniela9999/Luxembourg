import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nodes", "arcs"})
public class Map {

    @XmlAttribute
    private String description;

    @XmlElement(name = "nodes")
    private Nodes nodes;

    @XmlElement(name = "arcs")
    private Arcs arcs;

    public Nodes getNodes() {
        return this.nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public Arcs getArcs() {
        return this.arcs;
    }

    public void setArcs(Arcs arcs) {
        this.arcs = arcs;
    }
}
