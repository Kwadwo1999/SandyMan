package GameTest;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HighScore {
    private JPanel pnlScores;
    private JPanel pnlControls;
    private JLabel lblPlayerName;
    private JTextField txtName;
    private JLabel lblScoreTitle;
    private JLabel lblScore;
    private JButton btnSave;
    private JButton btnCancel;
    private JScrollPane scrollPaneScores;
    private JList<String> lstScores;

    private Game game;
    private HighScoreWriter highscorewriter;
    private HighScoreReader highscorereader;
    private final String fileName = "HighScoreFile.txt";

    public HighScore(Game game) {
        this.game = game;

        lblScore.setText(game.getPlayer().getCoinCount() + "");
        JFrame frame = new JFrame("High Score");



        File scores = new File(fileName);
        try{
            scores.createNewFile();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        highscorewriter = new HighScoreWriter(fileName);
        highscorereader = new HighScoreReader(fileName);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    highscorewriter.writeHighScore(
                            txtName.getText(),
                            game.getPlayer().getCoinCount()
                    );
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }

        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            model.addAll(highscorereader.readScores());
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        lstScores.setModel(model);
    }

    public JPanel getPnlScores(){
        return pnlScores;
    }

}
