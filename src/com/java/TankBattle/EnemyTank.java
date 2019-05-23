package src.com.java.TankBattle;
import java.util.*;

public class EnemyTank extends Tank implements Runnable{
    Random rand;
    int cycle;
    int direct;
    public static java.util.List<GameObject> objList = new LinkedList<>();
    public EnemyTank(int x, int y, int color, boolean visible, int life, int size, int speed, int direction, boolean alive, int bulletNum){
        super(x, y, color, visible, life, size, speed, direction, alive, bulletNum);
        rand = new Random();
        cycle = 0;
        direct = 0;
    }

    public static void add0bject(GameObject obj){
        objList.add(obj);
//        System.out.println("objList size: " + objList.size());
    }
    public static void remove0bject(GameObject obj){
        objList.remove(obj);
    }

    @Override
    public void run() {
        while(alive){
            if(cycle == 0) {
                direct = rand.nextInt(4) + 1;
            }
            cycle ++;
            if(cycle % 25 == 0){
                fire();
            }
            if(cycle == 50){
                cycle = 0;
            }
            int index = objList.indexOf(this);
            if (!overlaps(objList, index, direct)) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                move(direct, 500, 500);
            }

        }
    }
}
