package presentation;

import java.awt.*;
import javax.swing.*;

public class SettingsPanel extends JPanel {

    private JButton backButton;
    private JButton volumeMinusButton;
    private JButton volumePlusButton;
    private JLabel volumeLabel;

    private int volume;

    public SettingsPanel() {
        volume = 100;
        prepareElements();
    }

    private void prepareElements() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("SETTINGS", JLabel.CENTER);
        title.setFont(new Font("Arial Black", Font.BOLD, 32));

        volumeLabel = new JLabel("Volume: " + volume + "%", JLabel.CENTER);
        volumeLabel.setFont(new Font("Arial", Font.BOLD, 22));

        volumeMinusButton = new JButton("-");
        volumePlusButton = new JButton("+");
        backButton = new JButton("VOLVER AL MENU");

        JPanel volumePanel = new JPanel(new GridLayout(1, 3, 10, 10));
        volumePanel.setBorder(BorderFactory.createEmptyBorder(120, 250, 120, 250));
        volumePanel.add(volumeMinusButton);
        volumePanel.add(volumeLabel);
        volumePanel.add(volumePlusButton);

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