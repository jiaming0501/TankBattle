package src.com.java.TankBattle;
import java.awt.*;
import javax.swing.*;

public class App extends JFrame{
    int width, height;
    MyPanel mp;
    public App(){
        width = 500;
        height = 500;

        mp = new MyPanel(width, height);
        Thread t = new Thread(mp);
        t.start();

        this.add(mp);
        this.addKeyListener(mp);


        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args){
        App app = new App();
    }
}
