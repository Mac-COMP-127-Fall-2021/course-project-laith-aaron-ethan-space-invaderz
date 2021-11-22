import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;

public class BulletManger {
    
    static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); 
    public BulletManger(){

    }

    public static void addShot(CanvasWindow canvas){
        bullets.add(new Bullet(canvas));
    }

    public static void shootBullets(){
        for (Bullet bullet : bullets) {
            bullet.shoot();
        }
    }

    public static ArrayList<Bullet> getBullets() {
        if (bullets.isEmpty()){
            return null;
        } else {
        return bullets;
        }
    }
    
}
