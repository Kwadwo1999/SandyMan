package GameTest;

import city.cs.engine.*;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class FireBomb implements ActionListener {

    /**
     * Represents the body of the bomb
     */

    private DynamicBody bomb;

    /**
     * Represents the body of the explosion
     */


    private DynamicBody explosion;


    /**
     * Represents the number of the timercount
     */
    private int timerCount;

    /**
     *  (Description)
     * <p>
     * Detailed description.
     *
     * @param  world represents the virtual world.
     * @param  pos represents the position of the FireBomb
     * @param  time repersents the time at which the FireBomb will start
     * @return FireBomb.
     */

    public FireBomb(World world, Vec2 pos, int time) {
        bomb = new DynamicBody(world, new CircleShape(2f));
        bomb.addImage(new BodyImage("data/firedrop.gif", 5));
        bomb.setPosition(pos);

        Timer t = new Timer(time, this);
        t.start();
        t.setRepeats(false);

        timerCount = 0;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        timerCount++;


        if (timerCount == 1) {
            bomb.destroy();

            explosion = new DynamicBody(bomb.getWorld(), new CircleShape(3f));
            explosion.addImage(new BodyImage("data/fireExplotion.gif", 9));
            explosion.setPosition(bomb.getPosition());

            Timer t = new Timer(500, this);
            t.setRepeats(false);
            t.start();


            explosion.addCollisionListener(new CollisionListener() {

                @Override
                public void collide(CollisionEvent collisionEvent) {

                    if (collisionEvent.getOtherBody() instanceof DevilCharacter)
                        collisionEvent.getOtherBody().destroy();
                   // GameSound D = new GameSound("data/Destroy_NEW.wav");
                    //D.play();
                    else if (collisionEvent.getOtherBody() instanceof DevilCharacter2)
                        collisionEvent.getOtherBody().destroy();

                    else if (collisionEvent.getOtherBody() instanceof DevilCharacter3)
                        collisionEvent.getOtherBody().destroy();
                    else if(collisionEvent.getOtherBody() instanceof GoodCharacter)
                        ((GoodCharacter) collisionEvent.getOtherBody()).decrementHealthCount();
                    GameSound F = new GameSound("data/Destroy_NEW.wav");
                    F.play();



                }

           });
        }

            if (timerCount == 2) {
                explosion.destroy();
            }
        }
    }