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
        setCanvasBackground();  // sets canvas background image.
        spaceShip = new SpaceShip(canvas);
        spaceShieldManger = new SpaceShieldManger(canvas);
        alienWall = new AlienWall(canvas);
        interactionManager = new InteractionManager();
        healthMeter = new HealthMeter(CANVAS_WIDTH * 0.75, CANVAS_HEIGHT * 0.05, canvas);
    }

    /**
     * Starts game. Animates objects on the screen and scans users interaction.
     */
    public void runGame() {
        canvas.onMouseMove(event -> spaceShip.updateX(event.getPosition().getX()));  // Moves user's space ship on mouse move in X plane 
        canvas.onClick(event -> BulletManger.addShot(canvas, alienWall, spaceShip)); // shoots bullets on mouse click

        canvas.animate(() -> {
            if (aliensLeft() && !shipDestroyed() && !aliensAtShip()) {
                BulletManger.shootBullets(alienWall, interactionManager, canvas, spaceShieldManger, spaceShip);
                BulletManger.shootAlienBullets(alienWall, canvas, spaceShieldManger, spaceShip); // randomly shoots bullets from aliens with delay
                alienWall.moveY(); // slowly moves alien wall in Y direction closer to the player's spaceship.
                alienWall.moveX(); // slowly moves alien wall in X direction.
                alienWall.alienShoot();
            } else if (!aliensLeft()) {
                endGame(canvas, "The aliens are dead, You Won!");  // shows end game message when player destroys all aliens
            } else if (shipDestroyed()) {
                endGame(canvas, "Ship is destroyed, You Lose!");  // shows end game message when player's ship is destroyed
            } else if (aliensAtShip()) {
                endGame(canvas, "This Aliens are here, You Lose!");  // shows end game message when aliens reach space ship
            }

        });
    }

    /**
     * Shows end game text on top of game screen
     * 
     * @param canvas canvas used to show end screen.
     */
    public static void endGame(CanvasWindow canvas, String wonOrLossed) {
        // canvas.removeAll();
        GraphicsText endGame = new GraphicsText(wonOrLossed + " Press any key on keyboard to quit", 0, 0);
        endGame.setCenter((CANVAS_WIDTH / 2) - (endGame.getWidth() / 2) + 5, CANVAS_HEIGHT / 2);
        endGame.setFont(FontStyle.BOLD, 24);
        canvas.add(endGame);
        canvas.onKeyDown(event -> System.exit(0)); // Exits game on keyboard click after game ends
        endGame.setFillColor(Color.white);
    }

    /**
     * sets canvas background to a photo.
     */
    private void setCanvasBackground() {
        background = new Image(0, 0, "background2.png");
        canvas.add(background);
    }

    /**
     * checks to see if aliens have reach player's ship.
     * @return boolean: true if alien's reached.
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
     * @return boolean: true if there aliens left. flase is aliens are dead.
     */
    public boolean aliensLeft() {
        if (alienWall.getAliens().size() > 21) {
            return true;
        }
        return false;
    }
    /**
     * checks if ship has been destroyed
     * @return true if ship is dead. false if ship is alive.
     */
    public boolean shipDestroyed() {
        if (SpaceShip.getHealth() <= 0) {
            return true;
        }
        return false;
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
        SpaceInvaderz spaceInvaderz = new SpaceInvaderz();
        spaceInvaderz.runGame();
    }
}
