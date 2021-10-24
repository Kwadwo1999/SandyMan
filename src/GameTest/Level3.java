package GameTest;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class Level3 extends GameLevel{
    private static final BodyImage Ground = new BodyImage("data/floor2.png");
    private static final BodyImage platform = new BodyImage("data/floor2.png", 2f);
    private Image background;

    private JPanel pannelMain;


    public Level3(Game game) {
        super(game);
        pannelMain = new JPanel();



        gameSound = new GameSound("data/backc.wav");
        gameSound.play();

        // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -12f));
        ground.addImage(Ground);

        // UP SIDE
        Shape upside = new BoxShape(30, 0.5f);
        StaticBody up = new StaticBody(this, shape);
        up.setPosition(new Vec2(0, 13f));


        // RIGHT WALL
        Shape wall1Shape = new BoxShape(0.5f, 20f);
        StaticBody wall1 = new StaticBody(this, wall1Shape);
        wall1.setPosition(new Vec2(13, -7f));
        //wall1.addImage(platform);a

        // LEFT WALL
        Shape wall2Shape = new BoxShape(0.5f, 20f);
        StaticBody wall2 = new StaticBody(this, wall2Shape);
        wall2.setPosition(new Vec2(-13, 0f));
        //wall2.addImage(platformTexture);


        /// PLATFORM STARTING FROM DOWN TO TOP //


        // make another platform
        Shape platform1Shape = new BoxShape(10, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);

        platform1.setPosition(new Vec2(10, -7f));
        //platform1.setFillColor(Color.black);

        // make another platform
        Shape platform2Shape = new BoxShape(7, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);

        platform2.setPosition(new Vec2(-10, -7f));

        // make another platform
        Shape platform3Shape = new BoxShape(9.5f, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);


        platform3.setPosition(new Vec2(0, -2));


        //make a platform
        Shape platform4Shape = new BoxShape(3, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        //refers to an object of a class new VirtualWorld()

        platform4.setPosition(new Vec2(-13, 3));

        //make a platform
        Shape platform5Shape = new BoxShape(6, 0.5f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        //refers to an object of a class new VirtualWorld()

        platform5.setPosition(new Vec2(0, 3));

        //make a platform
        Shape platform6Shape = new BoxShape(3, 0.5f);
        StaticBody platform6 = new StaticBody(this, platform6Shape);
        //refers to an object of a class new VirtualWorld()

       platform6.setPosition(new Vec2(13, 4));



        //make a platform
        Shape platform8Shape = new BoxShape(7, 0.5f);
        StaticBody platform8 = new StaticBody(this, platform8Shape);
        //refers to an object of a class new VirtualWorld()

        platform8.setPosition(new Vec2(0, 7.9f));


    }





    public GoodCharacter getGoodCharacter(){

        return goodCharacter;
    }

    @Override
    public void populate(Game game, int level, int n){

        super.populate(game,3,30);



        goodCharacter.setPosition(new Vec2(4, -10));



    }

    protected void paintBackground(Graphics2D g){
        g.drawImage(background,0,0, (ImageObserver) this);
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }

    @Override
    public boolean isComplete() {
        if (getGoodCharacter().coinCount == 10) {
            gameSound.stop();



            return true;
        } else
            return false;
    }

    @Override
    public void pause() {

    }



}


