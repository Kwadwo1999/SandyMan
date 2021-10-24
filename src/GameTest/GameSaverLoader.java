package GameTest;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class GameSaverLoader

{
    /**
     * Represents the CollisionDetector
     */
    CollisionDetector encounter;



    /**
     * Saves the game file
     * @param  level represents any levels of the game.
     * @param  filename represents the file in which the game is being saved
     * @return no value.
     */

    public static void save(GameLevel level, String filename)


            throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, append);
            writer.write(level.getLevelName() + "\n");

            for(StaticBody body : level.getStaticBodies()){
                //Don't need anything to be saved//

                if(body instanceof Fire){

                    writer.write("Fire," + body.getPosition().x + "," + body.getPosition().y + "," + "\n");
                }

            }

            for(DynamicBody body : level.getDynamicBodies()){
                if(body instanceof GoodCharacter){
                    writer.write("GoodCharacter," + body.getPosition().x + "," + body.getPosition().y + "," + ((GoodCharacter) body).getCoinCount() + "\n");

                }
                else if (body instanceof CoinObject){
                    writer.write("CoinObject," + body.getPosition().x + "," + body.getPosition().y + "\n");


                }else if (body instanceof DevilCharacter){
                    writer.write("DevilCharacter,"+ body.getPosition().x + "," + body.getPosition().y + "\n");

                } else if (body instanceof DevilCharacter2) {
                    writer.write("DevilCharacter2,"+ body.getPosition().x + "," + body.getPosition().y + "\n");

                } else if (body instanceof DevilCharacter3){
                    writer.write("DevilCharacter3,"+ body.getPosition().x + "," + body.getPosition().y + "\n");

                }

            }


        } finally {
            if (writer != null) {
                writer.close();
            }

        }
    }
    /**
     *  Loads the game file
     * @param  game represents the refrences of the game object
     * @param  filename represents the file in which the game is being saved
     * @return GameLevel.
     */

    public static GameLevel load(Game game, String filename)



    throws IOException
    {

            FileReader fr = null;
            BufferedReader reader = null;
            try {
                System.out.println("Reading " + filename + " ...");
                fr = new FileReader(filename);
                reader = new BufferedReader(fr);
                String line = reader.readLine();

                GameLevel level = null;
                if (line.equals("Level1"))
                    level = new Level1(game);
                else if(line.equals("Level2"))
                    level = new Level2(game);
                else if(line.equals("Level3"))
                    level = new Level3(game);

                level.encounter = new CollisionDetector(level, game);

                line = reader.readLine();;
                while (line !=null){


                    String[] tokens = line.split(",");

                    if(tokens[0].equals("GoodCharacter")){

                        GoodCharacter g = new GoodCharacter(level);
                        float x = Float.parseFloat(tokens[1]);
                        float y = Float.parseFloat(tokens[2]);
                        g.setPosition(new Vec2(x,y));
                        int bc = Integer.parseInt(tokens[3]);
                        g.setCoinCount(bc);

                        level.setGoodCharacter(g);
                        g.addCollisionListener(level.encounter);




                    }
                    else if (tokens[0].equals("CoinObject")){
                        CoinObject c = new CoinObject(level);
                        float x = Float.parseFloat(tokens[1]);
                        float y = Float.parseFloat(tokens[2]);
                        c.setPosition(new Vec2(x,y));

                        c.addCollisionListener(level.encounter);


                    }
                    else if (tokens[0].equals("DevilCharacter2")){
                        DevilCharacter2 d = new DevilCharacter2(level);

                        float x = Float.parseFloat(tokens[1]);
                        float y = Float.parseFloat(tokens[2]);
                        d.setPosition(new Vec2(x,y));

                        d.addCollisionListener(level.encounter);

                    }
                    else if (tokens[0].equals("DevilCharacter3")){
                        DevilCharacter3 dc = new DevilCharacter3(level);
                        float x = Float.parseFloat(tokens[1]);
                        float y = Float.parseFloat(tokens[2]);
                        dc.setPosition(new Vec2(x,y));

                        dc.addCollisionListener(level.encounter);


                    }   else if (tokens[0].equals("Fire")){
                        Fire f = new Fire(level);
                        float x = Float.parseFloat(tokens[1]);
                        float y = Float.parseFloat(tokens[2]);
                        f.setPosition(new Vec2(x,y));

                        f.addCollisionListener(level.encounter);


                    }

                    line = reader.readLine();

                }

                return level;


            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }

        }
}
