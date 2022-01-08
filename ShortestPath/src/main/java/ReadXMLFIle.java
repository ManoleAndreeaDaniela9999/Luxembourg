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
            upgradeArcs();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void upgradeArcs() {
        for (Arc a :
                map.getArcs().getArcs()) {
            a.setStartNode(getNodeWith(a.getFrom()));
            a.setEndNode(getNodeWith(a.getTo()));
            a.settleNeighbours();
        }
    }

    private Node getNodeWith(Integer id){
        return map.getNodes().getNodes().elementAt(id);
    }

    private void normaliseCoords() {

        Float minX = Float.MAX_VALUE;
        Float maxX = 0.0f;
        Float minY = Float.MAX_VALUE;
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

        for (Node n :
                map.getNodes().getNodes()) {
            n.X = (n.X - minX) / (maxX - minX) * Main.MAP_WIDTH * Main.SCALE_X;
            n.Y = (n.Y - minY) / (maxY - minY) * Main.MAP_HEIGHT * Main.SCALE_Y;
        }
    }

    public Vector<Node> getNodes() {
        return map.getNodes().getNodes();
    }

    public Vector<Arc> getArcs() {
        return map.getArcs().getArcs();
    }
}
