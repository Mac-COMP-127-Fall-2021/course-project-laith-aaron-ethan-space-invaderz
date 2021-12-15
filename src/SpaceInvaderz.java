// Authors: Laith, Aaron, and Ethan
// Class Description: Main class that runs the Space Invaders game.
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

public class SpaceInvaderz {

    private static final int CANVAS_WIDTH = 900;
    private static final int CANVAS_HEIGHT = 600;
    private static CanvasWindow canvas = new CanvasWindow("Space Invaderz!!!", CANVAS_WIDTH, CANVAS_HEIGHT);;
    private static AlienWall alienWall;
    private static InteractionManager interactionManager;
    private static SpaceShieldManger spaceShieldManger;
    private static HealthMeter healthMeter;
    private static SpaceShip spaceShip;
    private static Image background;

    /**
    * initializes all of the objects on the canvas.
    */
    public SpaceInvaderz() {
        setCanvasBackground();
        spaceShip = new SpaceShip(canvas);
        spaceShieldManger = new SpaceShieldManger(canvas);
        alienWall = new AlienWall(canvas);
        interactionManager = new InteractionManager();
        healthMeter = new HealthMeter(CANVAS_WIDTH * 0.75, CANVAS_HEIGHT * 0.05, canvas);
    }

    /**
     * takes user input and animates the objects
     */
    public void runGame() {
        canvas.onMouseMove(event -> spaceShip.updateX(event.getPosition().getX()));
        canvas.onClick(event -> BulletManger.addShot(canvas, alienWall, spaceShip));

        canvas.animate(() -> {
            if (aliensLeft() && !shipDestroyed() && !aliensAtShip()) {
                BulletManger.shootBullets(alienWall, interactionManager, canvas, spaceShieldManger, spaceShip);
                BulletManger.shootAlienBullets(alienWall, interactionManager, canvas, spaceShieldManger, spaceShip);
                alienWall.moveY();
                alienWall.moveX();
                alienWall.alienShoot();
            } else if (!aliensLeft()) {
                endGame(canvas, "The aliens are dead, You Won!");
            } else if (shipDestroyed()) {
                endGame(canvas, "Ship is destroyed, You Lose!");
            } else if (aliensAtShip()) {
                endGame(canvas, "This Aliens are here, You Lose!");
            }

        });
    }

    /**
     * removes everything from canvas and Shows end game screen
     * 
     * @param canvas canvas used to show end screen.
     */
    public static void endGame(CanvasWindow canvas, String wonOrLossed) {
        // canvas.removeAll();
        GraphicsText endGame = new GraphicsText(wonOrLossed + " Press any key on keyboard to quit", 0, 0);
        endGame.setCenter((CANVAS_WIDTH / 2) - (endGame.getWidth() / 2) + 5, CANVAS_HEIGHT / 2);
        endGame.setFont(FontStyle.BOLD, 24);
        canvas.add(endGame);
        canvas.onKeyDown(event -> System.exit(0));
        endGame.setFillColor(Color.white);
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
        SpaceInvaderz sp = new SpaceInvaderz();
        sp.runGame();
    }
    /**
     * checks to see if aliens have reach bottom of screen.
     * @return
     */
    public boolean aliensAtShip() {
        for (Alien a : alienWall.getAliens()) {
            if (a.getY() + alienWall.getY() > 300) {
                return true;
            }
            return false;
        }
        return false;
    }
    /**
     * checks if any aliens are left
     * @return
     */
    public boolean aliensLeft() {
        if (alienWall.getAliens().size() > 21) {
            return true;
        }
        return false;
    }
    /**
     * checks if ship has been destroyed
     * @return
     */
    public boolean shipDestroyed() {
        if (SpaceShip.getHealth() <= 0) {
            return true;
        }
        return false;
    }

}
