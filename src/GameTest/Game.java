package GameTest;

import city.cs.engine.DebugViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class Game {


    public GameLevel getGameLevel(){
        return gameLevel;
    }
    public GameLevel gameLevel;


    /**
     * used to handle the control of the character.
     */
    public KeyBoardInputHandler inputHandler;

    /**
     * Description of the variable here.
     */
    private final JFrame frame;


    /**
     * The World in which the bodies move and interact.
     */
    private VirtualWorld world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    public GameView view;

    /**
     * Initialise a new Game.
     */


    JButton playButton;
    JButton pauseButton;
    JButton quitButton;
    JButton muteButton;
   // JFrame frame;

    public Game() {





        gameLevel = new Level1(this);
        view = new GameView(gameLevel,gameLevel.getGoodCharacter(),500, 500);

        gameLevel.populate(this, 1, 3);



        inputHandler = new KeyBoardInputHandler(gameLevel.getGoodCharacter(),this);


        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        //view.addMouseListener(new MouseHandler(view));

        // add the view to a frame (Java top level window)
        frame = new JFrame("Sandy Man");
        //addMenuItems();
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.addKeyListener(inputHandler);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(gameLevel, 500, 500);

        // start our game world simulation!
        //gameLevel.start();

    }

    /**
     *  Returns a good character object

     * @return GoodCharacter.
     */

    public GoodCharacter getPlayer(){

        return gameLevel.getGoodCharacter();
    }




    /**
     *  Update the level of the game to a particular level
     *
     * @param  level represents any levels of the game.
     * @return no return value.
     */


    public void setLevel(GameLevel level) {
        //stop the current level
        this.gameLevel.stop();
        //create the new (appropriate) level
        //level now refers to new level
        gameLevel.gameSound.stop();
        this.gameLevel = level;
        //change the view to look into new level
        view.setWorld(this.gameLevel);
        //change the controller to control the
        if(gameLevel instanceof Level1) {
            view.ub("data/bGround_2.png");
          //  view.paintForeground(f);
         //gameLevel.gameSound.stop();
        // gameLevel.gameSound.play();
        }else if (gameLevel instanceof Level2){
            view.ub("data/dark_1.png");
          //  gameLevel.gameSound.stop();
        }else if (gameLevel instanceof Level3){
            view.ub("data/level_3.png");
        }

        //cowboy in the new world
        //start the simulation in the new level
        gameLevel.start();
    }

    /**
     *  Moves the game to the next level.
     * @return no return value.
     */

    public void goToNextLevel(){

        if (gameLevel instanceof Level1) {

            // START GAME LEVEL 1
            //stop the current level
            //gameLevel.stop();
            //create the new (appropriate) level
            //level now refers to new level
            gameLevel = new Level2(this);
            gameLevel.populate(this, 2, 3);
            //change the view to look into new level
            view.setWorld(gameLevel);
            //view.updateCharacter();
            //change the controller to control the
            //student in the new world

            inputHandler.updateGoodCharacter(gameLevel.getGoodCharacter());
            //start the simulation in the new level
            view.ub("data/dark_1.png");
            gameLevel.start();


        }else if(gameLevel instanceof Level2){

            //START GAME LEVEL 2

            //stop the current level
            gameLevel.stop();
            //create the new (appropriate) level
            //level now refers to new level
            gameLevel = new Level3(this);
            gameLevel.populate(this, 3,3);
            //change the view to look into new level
            view.setWorld(gameLevel);
            //change the controller to control the
            //student in the new world

            inputHandler.updateGoodCharacter(gameLevel.getGoodCharacter());
            //start the simulation in the new level
            view.ub("data/level_3.png");
            gameLevel.start();




        }else {

            System.out.println("Game Complete!");
            JDialog diaScore = new JDialog(frame, true);
            HighScore highScore = new HighScore(this);
            diaScore.getContentPane().add(highScore.getPnlScores());
            diaScore.pack();
            diaScore.setVisible(true);

        }

        }

    /**
     *  Returns the current game level
     * @return GameLevel.
     */

    public GameLevel getLevel() {
        return gameLevel;
    }
}




