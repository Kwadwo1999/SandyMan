package GameTest;


import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Level2 extends GameLevel {
    private static final BodyImage Ground = new BodyImage("data/floor2.png");
    private static final BodyImage platform = new BodyImage("data/floor2.png", 2f);
    private Image background;



    public Level2(Game game) {
        super(game);



        gameSound = new GameSound("data/backb.wav");
        gameSound.play();


        // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -12f));
        ground.addImage(Ground);

        //UP SIDE
        Shape upside = new BoxShape(30, 0.5f);
        StaticBody up = new StaticBody(this, shape);
        up.setPosition(new Vec2(0, 13f));



        // RIGHT WALL
        Shape wall1Shape = new BoxShape(0.5f, 20f);
        StaticBody wall1 = new StaticBody(this, wall1Shape);
        wall1.setPosition(new Vec2(13, -7f));
        //wall1.addImage(platform);

        // LEFT WALL
        Shape wall2Shape = new BoxShape(0.5f, 20f);
        StaticBody wall2 = new StaticBody(this, wall2Shape);
        wall2.setPosition(new Vec2(-13, 0f));
        //wall2.addImage(platformTexture);



        // make another platform
        Shape platform2Shape = new BoxShape(17.5f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);

        platform2.setPosition(new Vec2(-8, -7f));
        platform2.setFillColor(Color.darkGray);

        // make another platform
        Shape platform3Shape = new BoxShape(12, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);


        platform3.setPosition(new Vec2(2.5f, -2));
        platform3.setFillColor(Color.darkGray);


        //make a platform
        Shape platform4Shape = new BoxShape(3, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        //refers to an object of a class new VirtualWorld()

        platform4.setPosition(new Vec2(-11, 3));
        platform4.setFillColor(Color.darkGray);

        //make a platform
        Shape platform5Shape = new BoxShape(9.5f, 0.5f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        //refers to an object of a class new VirtualWorld()

        platform5.setPosition(new Vec2(5, 3));
        platform5.setFillColor(Color.darkGray);

        //make a platform
        Shape platform6Shape = new BoxShape(8, 0.5f);
        StaticBody platform6 = new StaticBody(this, platform6Shape);
        //refers to an object of a class new VirtualWorld()

        platform6.setPosition(new Vec2(8, 8f));
        platform6.setFillColor(Color.darkGray);



        //make a platform
        Shape platform7Shape = new BoxShape(6, 0.5f);
        StaticBody platform7 = new StaticBody(this, platform7Shape);
        //refers to an object of a class new VirtualWorld()

        platform7.setPosition(new Vec2(-10, 8f));
        platform7.setFillColor(Color.darkGray);


    }


    @Override
    public void populate(Game game, int level, int n){

        super.populate(game,2,30);
        goodCharacter.setPosition(new Vec2(-11, -10));

    }

    protected void paintBackground(Graphics2D g){
        g.drawImage(background,0,0, (ImageObserver) this);
    }



    @Override
    public boolean isComplete() {
        if (getGoodCharacter().coinCount == 9) {

            gameSound.stop();
            getGoodCharacter().coinCount = 0;

            return true;
        } else
            return false;
    }

    @Override
    public void pause() {

    }



    @Override
    public String getLevelName() {
        return "Level2";
    }


}
