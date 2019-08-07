package src.com.java.TankBattle;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.*;
import java.io.*;

public class Tank extends MovableObject implements ObjFunction, MovableFunction, AttackFunction{

    int bulletNum;
    java.util.List<Bullet> Bullets = new LinkedList<Bullet>();
    public static java.util.List<GameObject> objList = new LinkedList<>();
    Image img1, img2, img3;
    public Tank(int x, int y, int color, boolean visible, int life, int size, int speed, int direction, boolean alive, int bulletNum){
        super(x, y, color, visible, life, size, speed, direction, alive);
        this.bulletNum = bulletNum;

        try{
            img1 = ImageIO.read(new File("E:/CS/MyJava/TankBattle/img/bomb_1.gif"));
            img2 = ImageIO.read(new File("E:/CS/MyJava/TankBattle/img/bomb_2.gif"));
            img3 = ImageIO.read(new File("E:/CS/MyJava/TankBattle/img/bomb_3.gif"));
        }   catch(Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void show(Graphics g) {
        g.setColor(colorList.get(color));
        if(alive) {
            switch (direction) {
                case 1:
                    g.fill3DRect(x, y, 7, size, false); //left rect
                    g.fill3DRect(x + 26, y, 7, size, false); //right rect
                    g.fill3DRect(x + 7, y + 5, 19, 21, false); //center rect
                    g.fill3DRect(x + 15, y, 3, 16, false);
                    break;
                case 2:
                    g.fill3DRect(x, y, size, 7, false); //left rect
                    g.fill3DRect(x, y + 26, size, 7, false); //right rect
                    g.fill3DRect(x + 5, y + 7, 21, 19, false); //center rect
                    g.fill3DRect(x + 15, y + 15, 16, 3, false);
                    break;
                case 3:
                    g.fill3DRect(x, y, 7, 31, false); //left rect
                    g.fill3DRect(x + 26, y, 7, 31, false); //right rect
                    g.fill3DRect(x + 7, y + 5, 19, 21, false); //center rect
                    g.fill3DRect(x + 15, y + 15, 3, 16, false); // gun
                    break;
                case 4:
                    g.fill3DRect(x, y, size, 7, false); //left rect
                    g.fill3DRect(x, y + 26, size, 7, false); //right rect
                    g.fill3DRect(x + 5, y + 7, 21, 19, false); //center rect
                    g.fill3DRect(x, y + 15, 16, 3, false);
                    break;
            }
        }
    }

    @Override
    public void move(int moveDirection, int width, int height) {
//        System.out.println("x= " + x + " y= " + y);
        if(direction != moveDirection){
            setDirection(moveDirection);
        }else {
            if (moveDirection == 1 && isValid(x, y - speed, width, height)) {
                setY(y - speed);
            } else if (moveDirection == 2 && isValid(x + speed, y, width, height)) {
                setX(x + speed);
            } else if (moveDirection == 3 && isValid(x, y + speed, width, height)) {
                setY(y + speed);
            } else if (moveDirection == 4 && isValid(x - speed, y, width, height)) {
                setX(x - speed);
            }
        }
    }

    @Override
    public boolean isValid(int x, int y, int width, int height) {
        if(x > 0 && x <= width - size && y > 0 && y <= height - size){
            return true;
        }
        return false;
    }


    public boolean overlaps (int index, int direction) {
        for(int i = 0; i < objList.size(); i++){
            if(i != index) {
                GameObject emt = objList.get(i);
                if(direction == 1) {
                    if (x <= emt.x + emt.size && x + size >= emt.x && y - speed <= emt.y + emt.size && y + size - speed >= emt.y) {
                        return true;
                    }
                }else if(direction == 2){
                    if (x + speed <= emt.x + emt.size && x + size + speed >= emt.x && y <= emt.y + emt.size && y + size >= emt.y) {
                        return true;
                    }
                }else if(direction == 3){
                    if (x <= emt.x + emt.size && x + size >= emt.x && y + speed <= emt.y + emt.size && y + size + speed >= emt.y) {
                        return true;
                    }
                }else{
                    if (x - speed <= emt.x + emt.size && x + size - speed >= emt.x && y <= emt.y + emt.size && y + size >= emt.y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void fire() {
//        System.out.println("EnemyTank tries to fire");
        if(hasBullet()){
//            System.out.println("fire");
            Bullet b = null;
            switch(direction){
                case 1:
                    b = new Bullet(x+15, y-3, 3, true, 1, 3,4, direction, true);
                    break;
                case 2:
                    b = new Bullet(x+31, y+15, 3, true, 1, 3, 4, direction, true);
                    break;
                case 3:
                    b = new Bullet(x+15, y+31, 3, true, 1, 3, 4, direction, true);
                    break;
                case 4:
                    b = new Bullet(x-3, y+15, 3, true, 1, 3, 4, direction, true);
                    break;
            }
            Bullets.add(b);
            Thread t = new Thread(b);
            t.start();
        }
    }

    @Override
    public void destroy(Graphics g) {
        int i = 9;
        while(i > 0){
            if(i > 6){
                 g.drawImage(img1, x, y, 33,33, null);
            }else if(i > 3){
                g.drawImage(img2, x, y, 33, 33, null);
            }else{
                g.drawImage(img3, x, y, 33, 33, null);
            }
            i --;
        }
    }

    @Override
    public boolean getHit(Bullet b) {
        if(b.getX() > getX() - 3 && b.getX() < getX() + size && b.getY() > getY() - 3 && b.getY() < getY() + size){
            setAlive(false);
            b.setAlive(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean hasBullet() {

        if(Bullets.size() < bulletNum){
            return true;
        }
        return false;
    }

    @Override
    public void addBullet() {

    }
    public static void add0bject(GameObject obj){
        objList.add(obj);
//        System.out.println("objList size: " + objList.size());
    }
    public static void remove0bject(GameObject obj){
        objList.remove(obj);
    }
}
