package presentation;

import java.awt.*;
import javax.swing.*;

public class CharacterSelectionPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JButton characterOneButton;
    private JButton characterTwoButton;
    private JButton characterThreeButton;
    private JButton backButton;

    public CharacterSelectionPanel() {
        prepareElements();
    }

    private void prepareElements() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("SELECT CHARACTER", JLabel.CENTER);
        title.setFont(new Font("Arial Black", Font.BOLD, 32));

        characterOneButton = new JButton("CHARACTER 1 - NORMAL");
        characterTwoButton = new JButton("CHARACTER 2 - MORE LIFE");
        characterThreeButton = new JButton("CHARACTER 3 - SMALLER AND FASTER");
        backButton = new JButton("BACK");

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(100, 250, 100, 250));

        buttonsPanel.add(characterOneButton);
        buttonsPanel.add(characterTwoButton);
        buttonsPanel.add(characterThreeButton);
        buttonsPanel.add(backButton);

        add(title, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
    }

    public JButton getCharacterOneButton() {
        return characterOneButton;
    }

    public JButton getCharacterTwoButton() {
        return characterTwoButton;
    }

    public JButton getCharacterThreeButton() {
        return characterThreeButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}