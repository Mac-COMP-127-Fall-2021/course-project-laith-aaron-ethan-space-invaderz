import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

public class SpaceInvaderz {

    private static final int CANVAS_WIDTH = 900;
    private static final int CANVAS_HEIGHT = 600;
    private static CanvasWindow canvas = new CanvasWindow("Space Invaderz!!!", CANVAS_WIDTH, CANVAS_HEIGHT);;
    private static AlienWall alienWall;
    private InteractionManager interactionManager;
    private SpaceShieldManger spaceShieldManger;
    private HealthMeter healthMeter;
    private SpaceShip spaceShip;

    private static Image background;

    public SpaceInvaderz(){
        setCanvasBackground();
        spaceShip = new SpaceShip(canvas);
        spaceShieldManger = new SpaceShieldManger(canvas);
        alienWall = new AlienWall(canvas);

        interactionManager = new InteractionManager();
        healthMeter = new HealthMeter(CANVAS_WIDTH * 0.75, CANVAS_HEIGHT * 0.05, canvas);
    
        canvas.onMouseMove(event -> spaceShip.updateX(event.getPosition().getX()));
        canvas.onClick(event -> BulletManger.addShot(canvas, alienWall, spaceShip));

        canvas.animate(() -> {
            if (aliensLeft() && aliensAboveShip() && !shipDestroyed())  {
                BulletManger.shootBullets(alienWall, interactionManager, canvas, spaceShieldManger, spaceShip);
                BulletManger.shootAlienBullets(alienWall, interactionManager, canvas, spaceShieldManger, spaceShip);
                alienWall.moveY();
                alienWall.moveX();
                alienWall.alienShoot();
            }
            else if (!aliensLeft()) {
                endGame(canvas);
            }
            else if (!aliensAboveShip()) {
                endGame(canvas);
            }
            else if (shipDestroyed()) {
                endGame(canvas);
            }

        });
    }

       
        

    /**
     * removes everything from canvas and Shows end game screen
     * @param canvas canvas used to show end screen.
     */
    public static void endGame(CanvasWindow canvas) {
        //canvas.removeAll();
        GraphicsText endGame = new GraphicsText("END GAME!", CANVAS_WIDTH * 0.425, CANVAS_HEIGHT / 2);
        endGame.setFont(FontStyle.BOLD, 30);
        canvas.add(endGame);
    }
    

    /**
     * sets canvas background to a photo.
     */
    private void setCanvasBackground() {
        background = new Image(0, 0, "background2.png");
        canvas.add(background);
    }

    public static int getCanvasWidth() {
        return CANVAS_WIDTH;
    }

    public static int getCanvasHeight() {
        return CANVAS_HEIGHT;
    }

    public static CanvasWindow getCanvas() {
        return canvas;
    }

    public static void main(String[] args) {
        new SpaceInvaderz();
    }

    public boolean aliensAboveShip() {
        for (Alien alien : alienWall.getAliens()) {
            if ((alien.getY() - alien.getHeight()/2) < spaceShip.getCenterY()) {
                return true;
            }
        }
        return false;
    }

    public boolean aliensLeft() {
        if (alienWall.getAliens().size() > 21) {
            return true;
        }
        return false;
    }

    public boolean shipDestroyed() {
        if (SpaceShip.getHealth() - 20 <= 0)  {
            return true;
        }
        return false;
    }

}
