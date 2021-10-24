

package GameTest;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import javax.swing.*;

/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */



public class CollisionDetector implements CollisionListener {


    /**
     * Represents the GoodCharacter.
     */
    private GoodCharacter goodCharacter;
    /**
     * Represents the GameLevel
     */
    private GameLevel gameLevel;
    /**
     * Represents the Game Object
     */
    private Game game;

    /**
     *  Creates a collision detector object
     *
     * @param  character represents GoodCharacter object.
     * @return Collision Detector Object.
     */
    public CollisionDetector(GoodCharacter character){
        goodCharacter = character;
    }

    /**
     *  Creates a collision detector object
     * @param  game represents the references of the game object
     * @param  level represents any levels of the game.
     * @return Collision Detector Object.
     */

    public CollisionDetector(GameLevel level, Game game) {
        this.gameLevel = level;
        this.game = game;

    }
    /**
     *  Handles all the collision in the game
     *
     * @param  collisionEvent represents collisionEvent
     * @return no value.
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {
        //other body represents what the Coin collided with
        GoodCharacter goodCharacter = this.gameLevel.getGoodCharacter();
        System.out.println();
        if(collisionEvent.getReportingBody() instanceof CoinObject && collisionEvent.getOtherBody() == goodCharacter){
            System.out.println("Collision between Coin and GoodCharacter");
            goodCharacter.incrementHealthCount();
            goodCharacter.incrementCoinCount();

            GameSound C = new GameSound("data/Collect Coin_NEW.wav");
            C.play();

            //reporting body represents the object which has had an object collided with it
            collisionEvent.getReportingBody().destroy();//get the ball in question and destroy it
        }else if (collisionEvent.getReportingBody() instanceof DevilCharacter && collisionEvent.getOtherBody() == goodCharacter){


            System.out.println("Collision occurs between GoodCharacter and DevilCharacter");
            goodCharacter.decrementHealthCount();
            collisionEvent.getReportingBody().destroy();

            GameSound F = new GameSound("data/HealthDecrease.wav");
            F.play();

        }else if (collisionEvent.getReportingBody() instanceof DevilCharacter2 && collisionEvent.getOtherBody() == goodCharacter) {

            System.out.println("Collision occurs between GoodCharacter and DevilCharacter");
            goodCharacter.decrementHealthCount();
            collisionEvent.getReportingBody().destroy();


            GameSound F = new GameSound("data/HealthDecrease.wav");
            F.play();

        }else if (collisionEvent.getReportingBody() instanceof DevilCharacter3 && collisionEvent.getOtherBody() == goodCharacter) {
            System.out.println("Collision occurs between GoodCharacter and DevilCharacter");

            goodCharacter.decrementHealthCount();
            collisionEvent.getReportingBody().destroy();


            GameSound F = new GameSound("data/HealthDecrease.wav");
            F.play();

        }else if (collisionEvent.getReportingBody() instanceof Fire && collisionEvent.getOtherBody() == goodCharacter) {

            System.out.println("Collision occurs between GoodCharacter and DevilCharacter");
            goodCharacter.decrementHealthCount();



        }else if (gameLevel.isComplete()){
            game.goToNextLevel();
        }

    }
}
