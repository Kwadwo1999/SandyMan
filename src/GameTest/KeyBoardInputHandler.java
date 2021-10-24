package GameTest;

import city.cs.engine.Walker;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyBoardInputHandler extends KeyAdapter {

   private Game game;


    private static final float JUMPING_VALUE = 14;
    private static final float WALKING_SPEED_VALUE = 4;
    //we want this body to refer to the cowboy
    private Walker body;

    public KeyBoardInputHandler(Walker body, Game game) {
        this.body = body;
        this.game = game;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(Character.toLowerCase(e.getKeyChar()) == 'w'){
            body.jump(JUMPING_VALUE);
        }else if(Character.toLowerCase(e.getKeyChar()) == 'a'){
            body.startWalking(-WALKING_SPEED_VALUE);
        }else if(Character.toLowerCase(e.getKeyChar()) == 'd') {
            body.startWalking(WALKING_SPEED_VALUE);
        }else if (Character.toLowerCase(e.getKeyChar()) == 's') {
            try {
                //Game g = new Game()
                GameSaverLoader.save(game.getGameLevel(), "Save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if(Character.toLowerCase(e.getKeyChar()) == 'b') {
            FireBomb b = new FireBomb(game.getLevel().getGoodCharacter().getWorld(), game.getLevel().getGoodCharacter().getPosition().add(new Vec2(2, 0)),3000);
        }else if(Character.toLowerCase(e.getKeyChar()) == 'v') {
            FireBomb b = new FireBomb(game.getLevel().getGoodCharacter().getWorld(), game.getLevel().getGoodCharacter().getPosition().add(new Vec2(-2, 0)), 3000);
        }

        else if (Character.toLowerCase(e.getKeyChar())== 'l') {
            try {
                GameLevel level = GameSaverLoader.load(game, "Save.txt");
                game.setLevel(level);
                game.inputHandler.updateGoodCharacter(game.gameLevel.getGoodCharacter());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }else{
            System.out.println("not a valid key to move a character");
        }


        }


    @Override
    public void keyReleased(KeyEvent e) {

        if(Character.toLowerCase(e.getKeyChar()) == 'a'|| Character.toLowerCase(e.getKeyChar()) == 'd'){
            body.stopWalking();
        }else{
            //nothing happens
        }

    }
    public void updateGoodCharacter(GoodCharacter goodCharacter){
        this.body = goodCharacter;
    }
}
