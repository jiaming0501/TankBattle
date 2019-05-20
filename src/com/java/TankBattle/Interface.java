package src.com.java.TankBattle;
import java.awt.*;

interface ObjFunction{
    public void show(Graphics g);
    public void destroy(Graphics g);
}

interface MovableFunction{
    public void move(int moveDirection, int width, int height);
    public boolean isValid(int x, int y, int width, int height);
}

interface AttackFunction{
    public void fire();
    public boolean hasBullet();
    public boolean getHit(Bullet b);
    public void addBullet();
}
interface Interaction{
    public void talk();
    public void give();
    public void pick();
}
