package presentation;

import java.awt.*;
import javax.swing.*;

public class InstructionsPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextArea instructionsText;
    private JButton backButton;
    private JButton playButton;

    public InstructionsPanel() {
        prepareElements();
    }

    private void prepareElements() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("INSTRUCTIONS", JLabel.CENTER);
        title.setFont(new Font("Arial Black", Font.BOLD, 32));

        instructionsText = new JTextArea();
        instructionsText.setEditable(false);
        instructionsText.setFont(new Font("Arial", Font.PLAIN, 18));
        instructionsText.setLineWrap(true);
        instructionsText.setWrapStyleWord(true);
        instructionsText.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        backButton = new JButton("MENU GAME");
        playButton = new JButton("BACK TO PLAY");

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonsPanel.add(backButton);
        buttonsPanel.add(playButton);

        add(title, BorderLayout.NORTH);
        add(instructionsText, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void showNormalInstructions() {
        instructionsText.setText(
            "Objective:\n" +
            "Avoid enemies, collect all coins and reach the goal.\n\n" +
            "Controls:\n" +
            "Use arrow keys or WASD.\n\n" +
            "Rules:\n" +
            "- You control one player.\n" +
            "- If you touch an enemy, you return to the start.\n" +
            "- Collect coins before reaching the goal."
        );
    }

    public void showPvpInstructions() {
        instructionsText.setText(
            "Objective:\n" +
            "Two players compete or cooperate to reach the goal.\n\n" +
            "Controls:\n" +
            "Player 1: WASD.\n" +
            "Player 2: Arrow keys.\n\n" +
            "Rules:\n" +
            "- Each player has their own character.\n" +
            "- Avoid enemies and obstacles.\n" +
            "- The winner is the player who reaches the goal first."
        );
    }

    public void showPvmInstructions() {
        instructionsText.setText(
            "Objective:\n" +
            "Play against a machine-controlled player.\n\n" +
            "Controls:\n" +
            "Human player: WASD or arrow keys.\n\n" +
            "Rules:\n" +
            "- The machine moves automatically.\n" +
            "- Avoid enemies and collect coins.\n" +
            "- Try to reach the goal before the machine."
        );
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getPlayButton() {
        return playButton;
    }
}