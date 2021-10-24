package GameTest;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


/**
 * @author      Kwadwo, Badu, Kwadwo.badu@city.ac.uk
 * @version     Version 1.1
 * @since       Version 1.0
 */

public class GameSound {

    /**
     * Represents the clip
     */
    private Clip clip;


    /**
     * Create Sound Object.
     * @param  s represents the filepath of the sound
     * @return GameSound Object.
     */

    public GameSound(String s) {
        try {
            AudioInputStream ais =
                    AudioSystem.getAudioInputStream(new File(s).getAbsoluteFile());
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Plays the game sound.
     * @return no value.
     */
    public void play() {
        if(clip == null) {
            System.out.println("Clip is null");
            return;
        }

        stop();
        clip.setFramePosition(0);
        clip.start();

    }
    /**
     * Stops the game sound.
     * @return no value.
     */

    public void stop() {
        if(clip.isRunning())
            clip.stop();
    }
    /**
     * Closes the game sound.
     * @return no value.
     */

    public void close() {
        stop();
        clip.close();
    }



}
