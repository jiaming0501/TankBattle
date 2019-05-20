package src.com.java.TankBattle;

import java.awt.*;
import java.util.*;
public class GameObject {
    int x, y;
    int color;
    java.util.List<Color> colorList = new ArrayList<>();
    Boolean visible;
    int life;
    public GameObject(int x, int y, int color, boolean visible, int life){
        this.x = x;
        this.y = y;
        this.color = color;
        this.visible = visible;
        this.life = life;
        colorList.add(Color.BLUE);
        colorList.add(Color.RED);
        colorList.add(Color.YELLOW);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.GRAY);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
