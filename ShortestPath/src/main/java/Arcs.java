import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Vector;

@XmlRootElement(name = "arcs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Arcs {

    @XmlElement(name = "arc")
    private Vector<Arc> arcs = null;

    public Vector<Arc> getArcs() {
        return arcs;
    }

    public void setArcs(Vector<Arc> arcs) {
        this.arcs = arcs;
    }
}
