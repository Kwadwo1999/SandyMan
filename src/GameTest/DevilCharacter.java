

package GameTest;

import city.cs.engine.*;
/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class DevilCharacter extends Walker {


    /**
     * Represents the shape of the DevilCharacter.
     */

    private static final Shape shape =
            new PolygonShape(-0.14f,1.73f, -1.27f,1.42f, -1.95f,0.0f, -1.92f,-0.17f, -0.73f,-1.86f, 1.85f,-1.19f, 1.89f,1.2f, 1.24f,1.95f
            );

    /**
     * Represents the image of the DevilCharacter.
     */
    private static final BodyImage image = new BodyImage("data/Devil.png",4.0f);



    /**
     *  Create DevilCharacter
     * @param world represents the virtual world.
     * @return DevilCharacter
     */

    public DevilCharacter(World world) {

        super(world,shape);
        addImage(image);
    }
}
