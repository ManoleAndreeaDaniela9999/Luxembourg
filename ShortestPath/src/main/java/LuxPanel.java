import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Vector;

public class LuxPanel extends JPanel {

    ReadXMLFIle fileReader;
    Vector<Node> nodeList;
    Vector<Arc> arcList;
    LuxMouseListener mouseListener;

    public LuxPanel(){
        fileReader = new ReadXMLFIle(Main.XML_FILE_PATH);
        fileReader.read();
        nodeList = fileReader.getNodes();
        arcList = fileReader.getArcs();
        mouseListener = new LuxMouseListener(nodeList,arcList);
        this.addMouseListener(mouseListener);
        this.setBackground(Color.PINK);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Arc arc :
                arcList) {
            GraphicsDrawMethods.DrawSimpleArc(arc, g);
        }
        for (Node node :
                nodeList) {
            GraphicsDrawMethods.DrawNode(node, g);
        }
    }
}
