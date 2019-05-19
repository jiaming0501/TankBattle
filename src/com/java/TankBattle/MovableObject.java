package src.com.java.TankBattle;

public class MovableObject extends GameObject{
    int speed;
    int direction;
    boolean alive;

    public MovableObject(int x, int y, int color, boolean visible, int life, int speed, int direction, boolean alive){
        super(x, y, color, visible, life);
        this.speed = speed;
        this.direction = direction;
        this.alive = alive;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
