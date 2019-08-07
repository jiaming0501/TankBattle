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
        hero = new MyTank(200, 300, 2,true, 1, 31, 2, 1, true, 5);
        EnemyTank.add0bject(hero);
        for(int i = 0; i < EnemyNum; i++){
            try{
                Thread.sleep(i*200);
            }catch(Exception e){
                e.printStackTrace();
            }
            EnemyTank t = new EnemyTank((i+1)*80, 10, 4, true, 1, 31, 2, 3, true,  3);
            EnemyTank.add0bject(t);
            EnemyList.add(t);
            Thread thread = new Thread(t);
            thread.start();
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        setBackground(Color.black);
        // show myTank
        showMyTank(hero, g);
        showEnemy(EnemyList, g);
        //
        boom(g);
    }

    public void showMyTank(MyTank hero, Graphics g){
        if(hero.alive) {
            hero.show(g);
        }
        // show myTank's bullets
        for(int i = 0; i < hero.Bullets.size(); i++){
            Bullet b = hero.Bullets.get(i);
            if(b.alive) {
                b.show(g);
            }else{
                hero.Bullets.remove(b);
            }
        }
    }

    public void showEnemy(java.util.List<EnemyTank> EnemyList, Graphics g){
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
                EnemyTank.remove0bject(t1);
            }
        }
    }
    public void boom(Graphics g){
//        check myTank hit enemyTank
        for(int i = 0; i < EnemyList.size(); i++){
            EnemyTank emt = EnemyList.get(i);
            for(int j = 0; j < hero.Bullets.size(); j++){
                Bullet b = hero.Bullets.get(j);
                if(emt.getHit(b)){
                    emt.destroy(g);
                }
            }
        }
//         check EnemyTank hit me
        for(int i = 0; i < EnemyList.size(); i++){
            EnemyTank emt = EnemyList.get(i);
            for(int j = 0; j < emt.Bullets.size(); j++){
                Bullet b = emt.Bullets.get(j);
                if(hero.getHit(b)){
                    hero.destroy(g);
                }
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W && !hero.overlaps(0, 1)){
            hero.move(1, width, height);
        }else if(e.getKeyCode() == KeyEvent.VK_D && !hero.overlaps(0, 2)){
            hero.move(2, width, height);
        }else if(e.getKeyCode() == KeyEvent.VK_S && !hero.overlaps(0, 3)) {
            hero.move(3, width, height);
        }else if(e.getKeyCode() == KeyEvent.VK_A && !hero.overlaps(0, 4)) {
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
