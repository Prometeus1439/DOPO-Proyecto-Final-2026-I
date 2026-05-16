package presentation;

import java.awt.*;
import javax.swing.*;

public class CharacterSelectionPanel extends GameScreenPanel {

    private static final long serialVersionUID = 1L;

    private JButton characterOneButton;
    private JButton characterTwoButton;
    private JButton characterThreeButton;
    private JButton backButton;

    public CharacterSelectionPanel() {
    	super(new BorderLayout());
        prepareElements();
    }

    private void prepareElements() {
        JLabel title = new JLabel("SELECT CHARACTER", JLabel.CENTER);
        GUIStyle.styleTitle(title);

        characterOneButton = new JButton("<html><center>RED<br>NORMAL</center></html>");
        characterTwoButton = new JButton("<html><center>GREEN<br>EXTRA LIFE</center></html>");
        characterThreeButton = new JButton("<html><center>BLUE<br>FAST & SMALL</center></html>");
        
        backButton = new JButton("BACK");

        GUIStyle.styleMenuButton(characterOneButton,GUIStyle.RED,new Color(255, 120, 120));
        GUIStyle.styleMenuButton(characterTwoButton,GUIStyle.GREEN,new Color(120, 255, 180));
        GUIStyle.styleMenuButton(characterThreeButton,GUIStyle.BLUE,new Color(120, 200, 255));
        GUIStyle.styleMenuButton(backButton,GUIStyle.ORANGE,new Color(255, 220, 120));
        
        JPanel buttonsPanel = new GameScreenPanel(new GridLayout(4, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(80, 250, 80, 250));

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