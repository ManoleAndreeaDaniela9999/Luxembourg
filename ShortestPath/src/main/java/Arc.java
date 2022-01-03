import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "arc")
@XmlAccessorType(XmlAccessType.NONE)
public class Arc {

    @XmlAttribute
    private long from;

    @XmlAttribute
    private long to;

    @XmlAttribute
    private int length;

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
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
}
