package src.com.java.TankBattle;
import java.awt.*;
import javax.swing.*;

public class App extends JFrame{

    MyPanel mp;
    public App(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);


        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args){
        App app = new App();
    }
}
