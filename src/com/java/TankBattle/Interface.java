package src.com.java.TankBattle;
import java.awt.*;

interface ObjFunction{
    public void show(int x, int y, int direct, int color, Graphics g);
}

interface MovableFunction{
    public void move(int x, int y, int direct, int speed);
    public boolean isValid(int x, int y);
}

interface AttackFunction{
    public void fire();
    public boolean hasBullet();
    public void addBullet();
}
interface Interaction{
    public void talk();
    public void give();
    public void pick();
}
