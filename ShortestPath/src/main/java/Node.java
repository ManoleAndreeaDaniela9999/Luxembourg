import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

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
    private Float diameter = 2.0f;

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
}
