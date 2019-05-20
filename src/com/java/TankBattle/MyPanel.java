package src.com.java.TankBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    //declare myTank object
    int width, height;
    MyTank hero;


    public MyPanel(int width, int height){
        this.width = width;
        this.height = height;
        hero = new MyTank(200, 300, 2,true, 1, 2, 4, true);
    }

    public void paint(Graphics g){
        super.paint(g);
        setBackground(Color.black);
        hero.show(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                hero.move(1, width, height);
                break;
            case KeyEvent.VK_D:
                hero.move(2, width, height);
                break;
            case KeyEvent.VK_S:
                hero.move(3, width, height);
                break;
            case KeyEvent.VK_A:
                hero.move(4, width, height);
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
