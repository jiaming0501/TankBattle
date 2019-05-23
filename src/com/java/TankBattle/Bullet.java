package src.com.java.TankBattle;

import java.awt.*;

public class Bullet extends MovableObject implements ObjFunction, MovableFunction, Runnable {
    public Bullet(int x, int y, int color, boolean visible, int life, int size, int speed, int direction, boolean alive){
        super(x, y, color, visible, life, size, speed, direction, alive);
    }
    @Override
    public void show(Graphics g) {
        g.setColor(colorList.get(color));
        g.fillOval(x, y, size, size);
    }

    @Override
    public void move(int moveDirection, int width, int height) {
        if(moveDirection == 1 && isValid(x, y - speed, width, height)){
            setY(y - speed);
        }else if(moveDirection == 2 && isValid(x + speed, y, width, height)){
            setX(x + speed);
        }else if(moveDirection == 3 && isValid(x, y + speed, width, height)){
            setY(y + speed);
        }else if(moveDirection == 4 && isValid(x - speed, y, width, height)){
            setX(x - speed);
        }else{
            setAlive(false);
        }
    }

    @Override
    public boolean isValid(int x, int y, int width, int height) {
        if(x > 0 && x <= width - 3 && y > 0 && y <= height - 3){
            return true;
        }
        return false;
    }

    @Override
    public void destroy(Graphics g) {

    }

    @Override
    public void run() {
        while(alive){
            try{
                Thread.sleep(50);
            }catch(Exception e){
                e.printStackTrace();
            }
            move(direction, 500, 500);
        }
    }

}
