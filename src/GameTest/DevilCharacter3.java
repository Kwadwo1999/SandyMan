package GameTest;

import city.cs.engine.*;

/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class DevilCharacter3 extends Walker {

    /**
     * Represents the shape of the DevilCharacter3.
     */

    private static final Shape shape =
            new PolygonShape(-0.04f,1.81f, -0.97f,1.67f, -1.33f,0.08f, -0.1f,-1.68f, 1.28f,-0.05f, 1.27f,1.19f, 0.84f,1.69f, 0.07f,1.8f
            );

    /**
     * Represents the image of the DevilCharacter3.
     */
    private static final BodyImage image = new BodyImage("data/devil33.png",5);

    /**
     *  Create the third DevilCharacter
     * @param world represents the virtual world.
     * @return DevilCharacter3
     */


    public DevilCharacter3(World world) {

        super(world,shape);
        addImage(image);
    }
}
