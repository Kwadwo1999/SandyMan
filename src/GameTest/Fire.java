package GameTest;

import city.cs.engine.*;

/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class Fire extends StaticBody {

    /**
     * Represents the shape of the FireObject.
     */

    private static final Shape shape =
            new PolygonShape(0.15f,2.25f, -1.23f,0.83f, -1.41f,-1.12f, -1.3f,-2.13f, 0.02f,-2.33f, 1.32f,-1.26f, 1.21f,1.88f, 0.25f,2.26f
            );

    /**
     * Represents the image of the the FireObject.
     */
    private static final BodyImage image = new BodyImage("data/Fire.png",4.0f);


    /**
     *  Create the FireObject
     * @param world represents the virtual world.
     * @return Fire
     */
    public Fire(World world) {

        super(world,shape);
        addImage(image);
    }
}