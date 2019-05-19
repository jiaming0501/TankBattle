package src.com.java.TankBattle;

import java.awt.*;

public class GameObject {
    int x, y;
    String color;
    Boolean visible;
    int life;
    public GameObject(int x, int y, boolean visible, int life){
        this.x = x;
        this.y = y;
        this.visible = visible;
        this.life = life;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
