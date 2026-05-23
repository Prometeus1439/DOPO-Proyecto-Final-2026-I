package presentation;

import java.awt.*;
import javax.swing.*;

public class InstructionsPanel extends GameScreenPanel {

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
        GUIStyle.styleTitle(title);

        instructionsText = new JTextArea();
        instructionsText.setEditable(false);
        instructionsText.setFont(new Font("Verdana", Font.PLAIN, 22));
        instructionsText.setLineWrap(true);
        instructionsText.setWrapStyleWord(true);
        instructionsText.setOpaque(false);
        instructionsText.setForeground(GUIStyle.BLACK);
        instructionsText.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        backButton = new JButton("RETURN TO SELECTION MODE");
        playButton = new JButton("START GAME");
        
        GUIStyle.styleMenuButton(backButton,GUIStyle.GREEN,new Color(120, 255, 180));

        GUIStyle.styleMenuButton(playButton,GUIStyle.ORANGE,new Color(255, 220, 120));

        JPanel buttonsPanel = new GameScreenPanel(new GridLayout(1, 2, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 30, 40));

        buttonsPanel.add(backButton);
        buttonsPanel.add(playButton);

        add(title, BorderLayout.NORTH);
        add(instructionsText, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void showNormalInstructions() {
        instructionsText.setText(
            "OBJECTIVE:\n" +
            "Avoid enemies, collect all coins and reach the goal.\n\n" +
            		
            "CONTROLS:\n" +
            "WASD or Arrow Keys.\n\n" +
            
            "RULES:\n" +
            "· You control one player.\n" +
            "· If you touch an enemy, you return to the start.\n" +
            "· Collect coins before reaching the goal."
        );
    }

    public void showPvpInstructions() {
        instructionsText.setText(
            "OBJECTIVE:\n" +
            "Two players compete or cooperate to reach the goal.\n\n" +
            		
            "CONTROLS:\n" +
            "Player 1: WASD.\n" +
            "Player 2: Arrow keys.\n\n" +
            
            "RULES:\n" +
            "· Each player has their own character.\n" +
            "· Avoid enemies and obstacles.\n" +
            "· The winner is the player who reaches the goal first.\n" +
            "· If both players touch, both die and return to the last checkpoint."
        );
    }

    public void showPvmInstructions() {
        instructionsText.setText(
            "OBJECTIVE:\n" +
            "Play against a machine-controlled player.\n\n" +
            		
            "CONTROLS:\n" +
            "Human player: WASD or arrow keys.\n\n" +
            
            "Rules:\n" +
            "· The machine moves automatically.\n" +
            "· Avoid enemies and collect coins.\n" +
            "· Try to reach the goal before the machine.\n" +
            "· If both players touch, both die and return to the last checkpoint."
        );
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getPlayButton() {
        return playButton;
    }
}