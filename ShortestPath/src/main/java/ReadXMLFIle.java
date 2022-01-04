import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.Vector;

public class ReadXMLFIle {

    Map map;
    String filePath;

    public ReadXMLFIle(String filePath) {
        this.filePath = filePath;
    }

    public void read() {

        jakarta.xml.bind.JAXBContext jaxbContext = null;
        try {

            jaxbContext = JAXBContext.newInstance(Map.class);

            File file = new File("src/main/resources/map2.xml");

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            map = (Map) jaxbUnmarshaller.unmarshal(file);

            normaliseCoords();
            int i = 0;
            for (Arc a :
                 map.getArcs().getArcs()) {
                i+=1;
                a.setStartNode(findNode(a.getFrom()));
                a.setEndNode(findNode(a.getTo()));
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private Node findNode(String id) {
        for (Node n:
             map.getNodes().getNodes()) {
            if(n.getId().equals(id))
                return n;
        }
        return null;
    }

    private void normaliseCoords() {

        Float minX = 100000000.0f;
        Float maxX = 0.0f;
        Float minY = 100000000.0f;
        Float maxY = 0.0f;
        for (Node n :
                map.getNodes().getNodes()) {
            n.X = n.getLongitude();
            n.Y = n.getLatitude();
            minX = Math.min(minX, n.getLongitude());
            maxX = Math.max(minX, n.getLongitude());
            minY = Math.min(minY, n.getLatitude());
            maxY = Math.max(minY, n.getLatitude());
        }
        Float scaleX = 0.23f;
        Float scaleY = 0.5f;
        for (Node n :
                map.getNodes().getNodes()) {
            n.X = (n.X - minX) / (maxX - minX) * Main.MAP_WIDTH * scaleX;
            n.Y = (n.Y - minY) / (maxY - minY) * Main.MAP_HEIGHT * scaleY;
        }
    }

    public Vector<Node> getNodes() {
        return map.getNodes().getNodes();
    }

    public Vector<Arc> getArcs() {
        return map.getArcs().getArcs();
    }
}
