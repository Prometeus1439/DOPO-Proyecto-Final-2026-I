package presentation;

import java.awt.*;
import javax.swing.*;

public class ModeSelectionPanel extends GameScreenPanel {

	private static final long serialVersionUID = 1L;
	
    private JButton normalButton;
    private JButton pvpButton;
    private JButton pvmButton;
    private JButton backButton;
    
    public ModeSelectionPanel() {
    	super(new BorderLayout());
        prepareElements();
    }

    private void prepareElements() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("SELECT GAME MODE", JLabel.CENTER);
        GUIStyle.styleTitle(title);

        normalButton = new JButton("NORMAL");
        pvpButton = new JButton("PLAYER VS PLAYER");
        pvmButton = new JButton("PLAYER VS MACHINE");
        backButton = new JButton("BACK TO MENU");
        
        
        GUIStyle.styleMenuButton(normalButton,GUIStyle.BLUE,new Color(120, 200, 255));
        GUIStyle.styleMenuButton(pvpButton,GUIStyle.PURPLE,new Color(220, 120, 255));
        GUIStyle.styleMenuButton(pvmButton,GUIStyle.GREEN,new Color(120, 255, 180));
        GUIStyle.styleMenuButton(backButton,GUIStyle.ORANGE,new Color(255, 220, 120));

        JPanel buttonsPanel = new GameScreenPanel(new GridLayout(4, 1, 10, 10));
        
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(80, 250, 80, 250));

        buttonsPanel.add(normalButton);
        buttonsPanel.add(pvpButton);
        buttonsPanel.add(pvmButton);
        buttonsPanel.add(backButton);

        add(title, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
    }
    
    public JButton getNormalButton() {
        return normalButton;
    }

    public JButton getPvpButton() {
        return pvpButton;
    }

    public JButton getPvmButton() {
        return pvmButton;
    }
    
    public JButton getBackButton() {
        return backButton;
    }
}