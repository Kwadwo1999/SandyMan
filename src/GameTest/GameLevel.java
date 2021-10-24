package GameTest;

import city.cs.engine.Body;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public abstract class GameLevel extends World {


    /**
     * Represents GoodCharacter
     */
    public GoodCharacter goodCharacter;
    /**
     * It Implements the CollisionDetector
     */

    CollisionDetector encounter;
    /**
     * Represents the GameSound
     */
    GameSound gameSound;
    /**
     * Represents GameSound
     */
    GameSound C;
    /**
     * Represents the GameSound c
     */
    GameSound D;
    /**
     * Represents the GameSound D
     */
    Game game;
    /**
     * Represents the game
     */
    Fire fire;

    public GameLevel(Game game) {
       // populate(game);
    }




    /**
     *  To populate the game objects
     * @param  game represents the refrences of the game object
     * @param  level represents any levels of the game.
     * @param  n represents the number of enemies
     * @return no value.
     */
    public void populate(Game game, int level, int n){
        //this.game = game;
        encounter = new CollisionDetector(this, game);
        goodCharacter = new GoodCharacter(this);

        goodCharacter.addCollisionListener(encounter);
        createEnemies(n, level);


        game.view.goodCharacter = this.getGoodCharacter();





    }

    /**
     *  To created the enemies object
     * @param  level represents any levels of the game.
     * @param  n represents the number of enemies
     * @return no value.
     */
    public void createEnemies(int n, int level) {
        if(level == 1){
            for (int j = 0; j < n; j++) {
                DevilCharacter devil = new DevilCharacter(this);
                devil.setPosition(new Vec2((j) + 2.0f, (j) + 2.0f));
                //zombie.setAlwaysOutline(true);
                devil.addCollisionListener(encounter);
                // zombie.addCollisionListener(encounter);
                //DevilCharacter.add(devil);

            }
            int y = 10;
            for (int i = 0; i < 30; i++) {
                //Coins increase the health count of a character
                Body Coin = new CoinObject(this);

                Coin.setPosition(new Vec2(i * 1, y--));
                //redBall.setAlwaysOutline(true);
                //now each Coin has a collision listener thus whenever the Coin collides with another object collision occurs
                Coin.addCollisionListener(encounter);
                //Coins.add(Coin);
            }


        }else if (level == 2){
            for (int j = 0; j < n; j++) {
                DevilCharacter2 devil = new DevilCharacter2(this);
                devil.setPosition(new Vec2((j) * 2f, (j) * 2.0f));
                // devil.setPosition(new Vec2());
                //zombie.setAlwaysOutline(true);
                devil.addCollisionListener(encounter);
                // zombie.addCollisionListener(encounter);
                //DevilCharacter.add(devil
            }
            int y = 10;
            for (int i = 0; i < 30; i++) {
                //Coins increase the health count of a character
              Body Coin = new CoinObject(this);

                Coin.setPosition(new Vec2(i * 1, y--));
                //redBall.setAlwaysOutline(true);
                //now each Coin has a collision listener thus whenever the Coin collides with another object collision occurs
                Coin.addCollisionListener(encounter);
                //Coins.add(Coin);
            }

        }else if (level == 3){

            for (int j = 0; j < n; j++) {
                DevilCharacter3 devil = new DevilCharacter3(this);
                devil.setPosition(new Vec2((j) * 2, (j) * -1));
                //zombie.setAlwaysOutline(true);
                devil.addCollisionListener(encounter);

              fire = new Fire(this);
              fire.setPosition(new Vec2(-7, -4.9f));
              fire.addCollisionListener(encounter);



            }
            int y = 10;
            for (int i = 0; i < 30; i++) {
                //Coins increase the health count of a character
                Body Coin = new CoinObject(this);

                Coin.setPosition(new Vec2(i * 1, y--));
                //redBall.setAlwaysOutline(true);
                //now each Coin has a collision listener thus whenever the Coin collides with another object collision occurs
                Coin.addCollisionListener(encounter);
                //Coins.add(Coin);
            }
            }
          }

    /**
     *  To create CoinObjects
     * @param  num represents the number of coin objects.
     * @return no value.
     */

    public void createHealthCoins(int num) {
        int y =10;
        for (int i = 0; i < 25; i++) {
            //Coins increase the health count of a character
            Body Coin = new CoinObject(this);

            Coin.setPosition(new Vec2(i * 5, y--));
            //redBall.setAlwaysOutline(true);
            //now each Coin has a collision listener thus whenever the Coin collides with another object collision occurs
            Coin.addCollisionListener(encounter);
        }
    }

    /**
     *  Set a GoodCharacter
     * @param g represents the goodcharacter object
     * @return no value.
     */

    public void setGoodCharacter(GoodCharacter g){

        goodCharacter = g;
    }

    /**
     *  Returns a GoodCharacter
     * @return  A goodCharacter Object
     */

    public GoodCharacter getGoodCharacter() {


        return goodCharacter;
    }

    /**
     *  Returns the LevelName
     * @return  A LevelName
     */

    public abstract String getLevelName();

    /**
     *  Returns if the game is complete
     * @return  isComplete.
     */


    public abstract boolean isComplete();

    /**
     *  Pause game
     * @return pause.
     */

    public void pause(){

        this.stop();
    }
}





