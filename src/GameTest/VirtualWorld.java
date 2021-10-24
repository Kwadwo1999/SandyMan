package GameTest;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class VirtualWorld extends World {
    private GoodCharacter goodCharacter;
    private DevilCharacter badCharacter;

    public VirtualWorld() {

        //characters = new ArrayList<Character>();
        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape); //refers to an object of a class new VirtualWorld()

        platform1.setPosition(new Vec2(-9, 5.5f));

        // make another platform
        Shape platform2Shape = new BoxShape(4, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform1Shape); //refers to an object of a class new VirtualWorld()

        platform2.setPosition(new Vec2(5,-2.5f));

        // make a good character
        goodCharacter = new GoodCharacter(this);
        goodCharacter.setPosition(new Vec2(8, -9.1f));
        //goodCharacter.setAlwaysOutline(true);

        //make bad character
        badCharacter = new DevilCharacter(this);
        badCharacter.setPosition(new Vec2(1, -9.1f));
        //badCharacter.setAlwaysOutline(true);
        badCharacter.addCollisionListener(new CollisionDetector(goodCharacter));


        //createCoins
        createCoins();
    }

    private void createCoins() {
        for (int i = 0; i < 10; i++) {
            Body coin = new CoinObject(this);
            coin.setPosition(new Vec2(i*2-10,10));
            coin.addCollisionListener(new CollisionDetector(goodCharacter));
        }
    }

    public GoodCharacter getPlayer(){
            return goodCharacter;
        }

}
