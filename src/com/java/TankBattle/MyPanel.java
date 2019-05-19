package src.com.java.TankBattle;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public void paint(Graphics g){
        super.paint(g);
        g.drawOval(50, 50, 20, 20);
    }

}
