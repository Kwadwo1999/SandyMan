

package GameTest;

import city.cs.engine.*;

/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */





public class CoinObject extends DynamicBody {


    /**
     * Represents coin shape.
     */
    private static final Shape shape =  new CircleShape(0.9f);


    /**
     * Represents coin image.
     */

    private static final BodyImage image = new BodyImage("data/Coin.png",2.0f);

    /**
     *  Create Coin Object
     * @param w represents the virtual world.
     * @return CoinObject
     */

    public CoinObject(World w) {
        super(w,  shape);
        addImage(image);

    }
}
