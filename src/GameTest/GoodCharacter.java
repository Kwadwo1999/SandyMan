package GameTest;

import city.cs.engine.*;

import javax.swing.*;

/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class GoodCharacter extends Walker {

    /**
     * Represents health reduction amount.
     */
    private static final int REDUCTION_AMOUNT = 2;

    /**
     * Represents the cointCount
     */
    int coinCount;

    /**
     * Represents the healthCount
     */
    private int healthCount;


    /**
     * Represents the shape of the GoodCharacter.
     */

    private static final Shape pShape =
            new PolygonShape(-0.5f, 1.97f, -1.22f, 1.6f, -1.44f, 0.91f, -0.48f, -1.79f, 0.94f, -1.86f, 1.42f, 0.46f, 0.69f, 1.62f
            );

    /**
     * Represents the image of the GoodCharacter.
     */

    private static final BodyImage image = new BodyImage("data/Man.png", 4.0f);

    /**
     *  Create the GoodCharacter Object.
     * @param world represents the virtual world.
     * @return GoodCharacter
     */

    public GoodCharacter(World world) {
        super(world, pShape);
        addImage(image);
        healthCount = 10;
        coinCount = 0;
    }

    /**
     *  Shows the incrementHealthCount.
     * @return incrementHealthCount
     */


    public void incrementHealthCount() {
        if(healthCount == 10) {
            System.out.println("Maximum Health");
        }else{
            healthCount++;
            System.out.println("Health Increased By 1");

        }

    }


    /**
     *  Gets the Health Count
     * @return getHealthCount
     */

    public int getHealthCount(){
        return healthCount;
    }



    /**
     *  Gets the Coin Count
     * @return getCoinCount
     */


    public int getCoinCount() {
        return coinCount;
    }

    /**
     *  decrement players health
     * @return no value.
     */


    public void decrementHealthCount() {
        if(healthCount == 0){
           // System.exit(0);
        }else{
        healthCount = healthCount - REDUCTION_AMOUNT;
        }
      //  System.out.println("Health Level Reduced By 1");
        System.out.println("health level remaining: " +healthCount);

    }

    /**
     *  increment players coin count
     * @return no value.
     */


    public void incrementCoinCount (){
        if(coinCount == 10){
          //  incrementHealthCount();
            coinCount = 0;
        }else {
            coinCount++;
            System.out.println("Coin Picked Up By GoodCharacter");
        }


        /**
         *  Sets the CoinCount
         * @param CoinCount represents the coin count
         * @return no value
         */

    }public void setCoinCount(int CointCount){

        this.coinCount = coinCount;

    }


}

