package src.com.java.TankBattle;
import java.util.*;

public class EnemyTank extends Tank implements Runnable{
    Random rand;
    public EnemyTank(int x, int y, int color, boolean visible, int life, int speed, int direction, boolean alive, int bulletSize){
        super(x, y, color, visible, life, speed, direction, alive, bulletSize);
        rand = new Random();
    }

    @Override
    public void run() {
        while(alive){
            int direct = rand.nextInt(4) + 1;
            for(int i = 0; i < 20; i++){
                try{
                    Thread.sleep(50);
                }catch(Exception e){
                    e.printStackTrace();
                }
                move(direct, 500, 500);
            }
            try{
                Thread.sleep(50);
                fire();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
