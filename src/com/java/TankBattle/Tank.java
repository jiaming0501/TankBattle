package src.com.java.TankBattle;
import java.util.*;
import java.awt.*;

public class Tank extends MovableObject implements ObjFunction, MovableFunction, AttackFunction{
//    java.util.List<Bullet> Bullets = new LinkedList<Bullet>();
    public Tank(int x, int y, int color, boolean visible, int life, int speed, int direction, boolean alive){
        super(x, y, color, visible, life, speed, direction, alive);
    }
    @Override
    public void show(Graphics g) {
        g.setColor(colorList.get(color));
        switch(direction){
            case 1:
                g.fill3DRect(x, y, 7, 31, false); //left rect
                g.fill3DRect(x+26, y, 7, 31, false); //right rect
                g.fill3DRect(x+7, y+5, 19, 21, false); //center rect
                g.fill3DRect(x+15, y, 3, 16, false);
                break;
            case 2:
                g.fill3DRect(x, y, 31, 7, false); //left rect
                g.fill3DRect(x, y+26, 31, 7, false); //right rect
                g.fill3DRect(x+5, y+7, 21, 19, false); //center rect
                g.fill3DRect(x+15, y+15, 16, 3, false);
                break;
            case 3:
                g.fill3DRect(x, y, 7, 31, false); //left rect
                g.fill3DRect(x+26, y, 7, 31, false); //right rect
                g.fill3DRect(x+7, y+5, 19, 21, false); //center rect
                g.fill3DRect(x+15, y+15, 3, 16, false); // gun
                break;
            case 4:
                g.fill3DRect(x, y, 31, 7, false); //left rect
                g.fill3DRect(x, y+26, 31, 7, false); //right rect
                g.fill3DRect(x+5, y+7, 21, 19, false); //center rect
                g.fill3DRect(x, y+15, 16, 3, false);
                break;
        }
    }

    @Override
    public void move(int moveDirection, int width, int height) {
        System.out.println("x= " + x + " y= " + y);
        if(direction != moveDirection){
            setDirection(moveDirection);
        }
        if(moveDirection == 1 && isValid(x, y - speed, width, height)){
            setY(y - speed);
        }else if(moveDirection == 2 && isValid(x + speed, y, width, height)){
            setX(x + speed);
        }else if(moveDirection == 3 && isValid(x, y + speed, width, height)){
            setY(y + speed);
        }else if(moveDirection == 4 && isValid(x - speed, y, width, height)){
            setX(x - speed);
        }
    }

    @Override
    public boolean isValid(int x, int y, int width, int height) {
        if(x > 0 && x <= width - 31 && y > 0 && y <= height - 31){
            return true;
        }
        return false;
    }

    @Override
    public void fire() {

    }

    @Override
    public boolean hasBullet() {
        return false;
    }

    @Override
    public void addBullet() {

    }

}
