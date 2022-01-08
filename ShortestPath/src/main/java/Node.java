import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Vector;

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.NONE)
public class Node {

    @XmlAttribute
    private Integer id;

    @XmlAttribute
    private Float longitude;

    @XmlAttribute
    private Float latitude;

    public Float X; //normalized lon
    public Float Y; //normalised lat
    private Float diameter = 0.5f;

    private boolean wasVisited;
    private Vector<NodeCostPair> neighbours = new Vector<>();
   // private Vector<Arc> neighboursArcs = new Vector<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;

    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getDiam() {
        return diameter;
    }

    public Float getRadius() {
        return diameter / 2;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    public boolean wasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public Vector<NodeCostPair> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Vector<NodeCostPair> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(NodeCostPair p) {
        neighbours.add(p);
        //neighboursArcs.add(respectiveArc);
    }

    public Arc getArcTo(Node destination) {
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.elementAt(i).node == destination)
                return neighbours.elementAt(i).arc;
        }
        return  null;
    }
}
