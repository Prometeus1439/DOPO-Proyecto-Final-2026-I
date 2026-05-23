package presentation;

import java.awt.*;
import javax.swing.*;

public class WelcomePanel extends GameScreenPanel {

	private static final long serialVersionUID = 1L;
	
    private JButton playButton;
    private JButton settingsButton;

    public WelcomePanel() {
        super(new BorderLayout());
    	prepareElements();
    }

    private void prepareElements() {
        //Panel del título
        JPanel titlePanel = new GameScreenPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel,BoxLayout.Y_AXIS));
        GUIStyle.applyBackground(titlePanel);
        
        //Parte superior THE DOPO'S
        JLabel topLabel = new JLabel("THE DOPO'S...");
        topLabel.setFont(GUIStyle.SMALL_FONT);
        topLabel.setForeground(GUIStyle.BLACK);
        
        JPanel upperPanel = new GameScreenPanel(new FlowLayout(FlowLayout.LEFT));
        
        upperPanel.add(topLabel);
        titlePanel.add(upperPanel);
        
        //Parte centrada HARDEST GAME
        JLabel mainTitle = new JLabel("HARDEST GAME");
        
        mainTitle.setFont(GUIStyle.MAIN_TITLE_FONT);
        mainTitle.setForeground(GUIStyle.BLUE);
        
        JPanel centerTitlePanel = new GameScreenPanel(new FlowLayout(FlowLayout.CENTER));
        
        centerTitlePanel.add(mainTitle);
        titlePanel.add(centerTitlePanel);
        
        //Parte inferior VERSION 1.X
        JLabel versionLabel = new JLabel("VERSION 1.0");
        
        versionLabel.setFont(GUIStyle.SMALL_FONT);
        versionLabel.setForeground(GUIStyle.BLACK);
        
        JPanel versionPanel = new GameScreenPanel(new FlowLayout(FlowLayout.RIGHT));
        
        versionPanel.add(versionLabel);
        titlePanel.add(versionPanel);
        
        //Botones
        playButton = new JButton("<html><center>PLAY<br>GAME</center></html>");
        settingsButton = new JButton("SETTINGS");
        
        GUIStyle.styleMenuButton(playButton, GUIStyle.RED, new Color(255, 120, 120));
        GUIStyle.styleMenuButton(settingsButton, GUIStyle.YELLOW, new Color(255, 255, 120));
        
        JPanel buttonsPanel = new GameScreenPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));

        buttonsPanel.add(playButton);
        buttonsPanel.add(settingsButton);
        
        JPanel centerPanel = new GameScreenPanel(new BorderLayout());

        centerPanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

        centerPanel.add(buttonsPanel, BorderLayout.NORTH);
        
        //Texto inferior
        JLabel footerLabel = new JLabel("PREPARE TO DIE",JLabel.CENTER);
        
        footerLabel.setFont(GUIStyle.SMALL_FONT);
        footerLabel.setForeground(GUIStyle.BLACK);

        JPanel footerPanel = new GameScreenPanel(new BorderLayout());

        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 25, 10));

        footerPanel.add(footerLabel, BorderLayout.CENTER);
        
        //Agregar
        add(titlePanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }
    
    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }
    
}