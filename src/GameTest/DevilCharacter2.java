

package GameTest;

import city.cs.engine.*;

/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class DevilCharacter2 extends Walker {

    /**
     * Represents the shape of the DevilCharacter2.
     */

    private static final Shape shape =
            new PolygonShape(-0.27f,2.39f, -1.9f,1.37f, -1.92f,-1.49f, -0.81f,-2.28f, 1.54f,-2.27f, 2.11f,1.02f, 1.09f,2.0f, -0.2f,2.37f);


    /**
     * Represents the image of the DevilCharacter2.
     */
    private static final BodyImage image = new BodyImage("data/devil2.png",4.0f);


    /**
     *  Create second DevilCharacter
     * @param world represents the virtual world.
     * @return DevilCharacter2
     */

    public DevilCharacter2(World world) {

        super(world,shape);
        addImage(image);
    }
}
