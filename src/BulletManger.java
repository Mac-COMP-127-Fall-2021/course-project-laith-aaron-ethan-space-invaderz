import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;

public class BulletManger {
    
    static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); 
    public BulletManger(){

    }

    public static void addShot(CanvasWindow canvas, AlienWall alienWall){
        bullets.add(new Bullet(canvas, alienWall));
    }

    public static void shootBullets(AlienWall alienWall, InteractionManager interactionManager, CanvasWindow canvas){
        for (Bullet bullet : bullets) {
            bullet.shoot();
            bullet.checkIntersection(alienWall, canvas);
        }
    }

    public static ArrayList<Bullet> getBullets() {
        if (bullets.isEmpty()){
            return null;
        } 
        else {
            return bullets;
        }
    }
    
}
