package GameTest;

import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;


/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class GameView extends city.cs.engine.UserView {

    /**
     * Represents the background
     */
    private Image background;
    /**
     * Represents the the GoodCharacter
     */

    GoodCharacter goodCharacter;

    /**
     * Create the game view.
     * @param  w represents the virtual world.
     * @param goodCharacter represents the GoodCharacter object.
     * @param width represents the number width used to create the Game View
     * @param height represents the number height used to create the Game View
     * @return GameView Object
     */
    public GameView(World w, GoodCharacter goodCharacter, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/bGround_2.png").getImage();
        this.goodCharacter = goodCharacter;


    }

    @Override
    protected void paintForeground(Graphics2D g){
        g.setFont(new Font("Arial",Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString("Score: " + goodCharacter.getCoinCount(),10,60);
        g.drawString("Health: " + goodCharacter.getHealthCount(),60,60);
      //System.out.println(goodCharacter.getCoinCount());

    }



    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);

    }

    /**
     * Create the game view.
     * @param  imagePath represents the the filepath of the image.
     * @return no value.
     */
    public void ub(String imagePath) {

        background = new ImageIcon(imagePath).getImage();

    }

}

