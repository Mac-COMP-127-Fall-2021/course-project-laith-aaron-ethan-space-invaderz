// Authors: Laith, Ethan, Aaron.
// Class description: Class that reprsents the space shield , and extending image class.

import edu.macalester.graphics.Image;

public class SpaceShield extends Image {
    private int health = 3;

    public SpaceShield() {
        super(0, 0, "shield2.png");
        this.setScale(0.3);  // changes size of space shield
    }

    /**
     * returns space shield's current health
     * 
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * reduces shield health by 1.
     */
    public void getDamged() {
        health -= 1;
    }

}
