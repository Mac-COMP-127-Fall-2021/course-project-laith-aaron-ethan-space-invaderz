import edu.macalester.graphics.CanvasWindow;
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

        canvas.animate(() ->{
            BulletManger.shootBullets(alienWall, interactionManager, canvas, spaceShieldManger, spaceShip);
            BulletManger.shootAlienBullets(alienWall, interactionManager, canvas, spaceShieldManger, spaceShip);
            alienWall.moveY();
            alienWall.moveX();
            alienWall.alienShoot();
        });

        canvas.animate(() -> {
        if (alienWall.getAliens().size() == 21) {
            endGame(canvas);
        }
    });

    }

    /**
     * removes everything from canvas and Shows end game screen
     * @param canvas canvas used to show end screen.
     */
    private static void endGame(CanvasWindow canvas) {
        canvas.removeAll();
        canvas.add(new GraphicsText("END GAME!"), CANVAS_WIDTH * 0.40, CANVAS_HEIGHT / 2);
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

}
