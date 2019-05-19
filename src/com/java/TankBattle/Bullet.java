package src.com.java.TankBattle;

import java.awt.*;

public class Bullet extends MovableObject implements ObjFunction, MovableFunction {
    public Bullet(int x, int y, boolean visible, int life, int speed, int direction, boolean alive){
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
}
