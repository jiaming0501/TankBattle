package src.com.java.TankBattle;
import java.util.*;
import java.awt.*;

public class Tank extends MovableObject implements ObjFunction, MovableFunction, AttackFunction{
//    java.util.List<Bullet> Bullets = new LinkedList<Bullet>();
    public Tank(int x, int y, boolean visible, int life, int speed, int direction, boolean alive){
        super(x, y, visible, life, speed, direction, alive);
    }
    @Override
    public void show(int x, int y, int direct, int color, Graphics g) {

    }

    @Override
    public void move(int x, int y, int direct, int speed) {

    }

    @Override
    public boolean isValid(int x, int y) {
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
