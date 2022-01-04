import javax.swing.*;

public class LuxFrame extends JFrame {

    LuxPanel luxPanel;

    public LuxFrame(){
        this.setTitle("Graf menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(Main.MAP_WIDTH, Main.MAP_HEIGHT);
        luxPanel = new LuxPanel();
        this.add(luxPanel);
        this.setResizable(false);
        this.setVisible(true);
    }
}
