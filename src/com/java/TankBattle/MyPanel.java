package src.com.java.TankBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class MyPanel extends JPanel implements KeyListener, Runnable{
    //declare myTank object
    int width, height;
    int EnemyNum = 5;
    MyTank hero;
    java.util.List<EnemyTank> EnemyList = new LinkedList<>();

    public MyPanel(int width, int height){
        this.width = width;
        this.height = height;
        hero = new MyTank(200, 300, 2,true, 1, 2, 1, true, 5);

        for(int i = 0; i < EnemyNum; i++){
            try{
                Thread.sleep(i*200);
            }catch(Exception e){
                e.printStackTrace();
            }
            EnemyTank t = new EnemyTank((i+1)*50, 10, 4, true, 1, 2, 3, true,  3);
            EnemyList.add(t);
            Thread thread = new Thread(t);
            thread.start();
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        setBackground(Color.black);
        // show myTank
        hero.show(g);
        // show myTank's bullets
        for(int i = 0; i < hero.Bullets.size(); i++){
            Bullet b = hero.Bullets.get(i);
            if(b.alive == true) {
                b.show(g);
            }else{
                hero.Bullets.remove(b);
            }
        }

        // show EnemyTank
        for(int i = 0; i < EnemyList.size(); i++){
            EnemyTank t1 = EnemyList.get(i);
            if(t1.alive) {
                t1.show(g);
                for(int j = 0; j < t1.Bullets.size(); j++){
                    Bullet bt = t1.Bullets.get(j);
                    if(bt.alive){
                        bt.show(g);
                    }else{
                        t1.Bullets.remove(bt);
                    }
                }
            }else {
                EnemyList.remove(t1);
            }
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.move(1, width, height);
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.move(2, width, height);
        }else if(e.getKeyCode() == KeyEvent.VK_S) {
            hero.move(3, width, height);
        }else if(e.getKeyCode() == KeyEvent.VK_A) {
            hero.move(4, width, height);
        }
        if(e.getKeyCode() == KeyEvent.VK_J){
            hero.fire();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
