import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LuxPanel extends JPanel {

    ReadXMLFIle fileReader;
    Vector<Node> nodeList;
    Vector<Arc> arcList;


    public LuxPanel(){
        fileReader = new ReadXMLFIle(Main.XML_FILE_PATH);
        fileReader.read();
        nodeList = fileReader.getNodes();
        arcList = fileReader.getArcs();
        this.setBackground(Color.PINK);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Node node :
                nodeList) {
            GraphicsDrawMethods.DrawNode(node, g);
        }
        for (Arc arc :
                arcList) {
            GraphicsDrawMethods.DrawSimpleArc(arc, g);
        }
    }
}
