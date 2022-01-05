import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Vector;

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.NONE)
public class Node {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private Float longitude;

    @XmlAttribute
    private Float latitude;

    public Float X; //normalized lon
    public Float Y; //normalised lat
    private Float diameter = 1.0f;

    private boolean wasVisited;
    private Vector<Node> neighbours = new Vector<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public Vector<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Vector<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Node n) {
        neighbours.add(n);
    }
}
