package presentation;

import java.awt.*;
import javax.swing.*;

public class SettingsPanel extends GameScreenPanel {
	
	private static final long serialVersionUID = 1L;

    private JButton backButton;
    private JButton volumeMinusButton;
    private JButton volumePlusButton;
    private JLabel volumeLabel;

    private int volume;

    public SettingsPanel() {
    	super(new BorderLayout());
        volume = 100;
        prepareElements();
    }

    private void prepareElements() {
    	
        JLabel title = new JLabel("SETTINGS", JLabel.CENTER);
        GUIStyle.styleTitle(title);

        volumeLabel = new JLabel("Volume: " + volume + "%", JLabel.CENTER);
        volumeLabel.setFont(GUIStyle.BUTTON_FONT);
        volumeLabel.setForeground(GUIStyle.BLACK);

        volumeMinusButton = new JButton("-");
        volumePlusButton = new JButton("+");
        backButton = new JButton("BACK TO MENU");
        
        GUIStyle.styleMenuButton(volumeMinusButton, GUIStyle.RED, new Color(255,120,120));
        GUIStyle.styleMenuButton(volumePlusButton, GUIStyle.BLUE, new Color(120,220,255));
        GUIStyle.styleMenuButton(backButton, GUIStyle.ORANGE, new Color(255,220,120));
        
        JPanel volumePanel = new GameScreenPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        volumePanel.add(volumeMinusButton);
        volumePanel.add(volumeLabel);
        volumePanel.add(volumePlusButton);
        
        JPanel centerPanel = new GameScreenPanel(new FlowLayout(FlowLayout.CENTER, 30, 120));
        centerPanel.add(volumePanel);
        
        JPanel bottomPanel = new GameScreenPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 40, 20));
        bottomPanel.add(backButton);

        add(title, BorderLayout.NORTH);
        add(volumePanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
    
    public JButton getBackButton() {
        return backButton;
    }	

    public JButton getVolumeMinusButton() {
        return volumeMinusButton;
    }

    public JButton getVolumePlusButton() {
        return volumePlusButton;
    }

    public void increaseVolume() {
        if (volume < 100) {
            volume += 10;
            volumeLabel.setText("Volume: " + volume + "%");
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume -= 10;
            volumeLabel.setText("Volume: " + volume + "%");
        }
    }
}