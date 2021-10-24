package GameTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.awt.SystemColor.window;

public class Settings extends Game {
    private JButton Pause;
    private JPanel panel;
    private JButton Exit;
    private JButton Start;
    public JButton Mute;
    private JButton UnMute;
    private JLabel VersionName;
    private JButton Restart;


    public Settings() {


        Pause.setText("Pause");
        Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               gameLevel.stop();


            }


        });
        Exit.setText("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });
        UnMute.setText("Unmute");
        UnMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gameLevel.gameSound.play();

            }

        });
        Start.setText("Start");
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gameLevel.start();



            }
        });
        Mute.setText("Mute");
        Mute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLevel.gameSound.stop();

            }
        });


        Restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Control Panel");
        frame.setContentPane(new Settings().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(200,300);
        frame.setVisible(true);


    }
}
