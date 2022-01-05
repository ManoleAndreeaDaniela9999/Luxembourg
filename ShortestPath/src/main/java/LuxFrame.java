import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LuxFrame extends JFrame implements ActionListener {

    enum Option{
        DIJKSTRA,
        BELLMAN
    }

    LuxMouseListener ms;
    JMenuItem option1;
    JMenuItem option2;
    JMenuBar menu;
    private LuxPanel luxPanel;
    static public Option activeOption = Option.DIJKSTRA;

    public LuxFrame(){
        this.setTitle("Graf menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Main.MAP_WIDTH, Main.MAP_HEIGHT);
        luxPanel = new LuxPanel();
        this.add(luxPanel);
        this.setResizable(false);

        menu = new JMenuBar();

        option1 = new JMenuItem("DIJKSTRA");
        option1.addActionListener(this);
        option2 = new JMenuItem("BELLMAN-FORD");
        option2.addActionListener(this);

        JMenu options = new JMenu("Chose search alg.");
        options.add(option1);
        options.add(option2);
        menu.add(options);
        this.setJMenuBar(menu);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == option1){
            activeOption = Option.DIJKSTRA;
            System.out.println("You changed search alg. to DIJKSTRA");
            ms.reset();
            repaint();
        }

        if (e.getSource() == option2){
            activeOption = Option.BELLMAN;
            System.out.println("You changed search alg. to BELLMAN-FORD");
            ms.reset();
            repaint();
        }
    }
}
