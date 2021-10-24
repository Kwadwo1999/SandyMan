/* package GameTest;
import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Level4 extends GameLevel{

    private static final BodyImage Ground = new BodyImage("data/floor2.png");
    private static final BodyImage platform = new BodyImage("data/floor2.png", 2f);



    public Level4(Game game){
        super(game);


        // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -12f));
        ground.addImage(Ground);

        // RIGHT WALL
        Shape wall1Shape = new BoxShape(0.5f, 20f);
        StaticBody wall1 = new StaticBody(this, wall1Shape);
        wall1.setPosition(new Vec2(13, 0f));
        //wall1.addImage(platform);

        // LEFT WALL
        Shape wall2Shape = new BoxShape(0.5f, 20f);
        StaticBody wall2 = new StaticBody(this, wall2Shape);
        wall2.setPosition(new Vec2(-13, 0f));
        //wall2.addImage(platformTexture);


        createHealthCoins(30);


    }

    @Override
    public boolean isComplete() {
        if (getGoodCharacter().coinCount == 5) {

            System.out.println("Well Done!, EXIT NOW");

            System.exit(2);
            //gameSound.stop();


            return true;
        } else
            return false;
    }

    @Override
    public void pause() {

    }
}
*/