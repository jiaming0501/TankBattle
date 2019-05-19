package src.com.java.TankBattle;

public class MovableObject extends GameObject{
    int speed;
    int direction;
    boolean alive;

    public MovableObject(int x, int y, boolean visible, int life, int speed, int direction, boolean alive){
        super(x, y, visible, life);
        this.speed = speed;
        this.direction = direction;
        this.alive = alive;
    }

}
