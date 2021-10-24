package GameTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitPage extends Game {
    private JPanel panel1;
    private JButton Restart;
    private JLabel TEXT;
    public JPanel PannelMain;

    public ExitPage() {
        Restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLevel.stop();
            }
        });
    }


    }

