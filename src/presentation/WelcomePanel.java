package presentation;

import java.awt.*;
import javax.swing.*;

public class WelcomePanel extends JPanel {

    private JButton playButton;
    private JButton settingsButton;

    public WelcomePanel() {
        prepareElements();
    }

    private void prepareElements() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("HARDEST GAME", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 60));

        playButton = new JButton("PLAY GAME");
        settingsButton = new JButton("SETTINGS");

        JPanel buttonsPanel = new JPanel(new GridLayout(2,1,10,10));

        buttonsPanel.add(playButton);
        buttonsPanel.add(settingsButton);

        add(title, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }
    
}