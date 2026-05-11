package presentation;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;

    private JLabel menuLabel;
    private JLabel levelLabel;
    private JLabel deathsLabel;

    public GamePanel() {
        prepareElements();
    }

    private void prepareElements() {

        setLayout(new BorderLayout());

        prepareTopPanel();
        prepareCenterPanel();
        prepareBottomPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void prepareTopPanel() {

        topPanel = new JPanel(new BorderLayout());

        topPanel.setBackground(Color.BLACK);
        topPanel.setPreferredSize(new Dimension(100, 50));

        menuLabel = new JLabel("MENU");
        levelLabel = new JLabel("1/30", JLabel.CENTER);
        deathsLabel = new JLabel("DEATHS: 0", JLabel.RIGHT);

        menuLabel.setForeground(Color.WHITE);
        levelLabel.setForeground(Color.WHITE);
        deathsLabel.setForeground(Color.WHITE);

        menuLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        levelLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        deathsLabel.setFont(new Font("Arial Black", Font.BOLD, 20));

        topPanel.add(menuLabel, BorderLayout.WEST);
        topPanel.add(levelLabel, BorderLayout.CENTER);
        topPanel.add(deathsLabel, BorderLayout.EAST);
    }

    private void prepareCenterPanel() {

        centerPanel = new JPanel();

        centerPanel.setBackground(
            new Color(210, 210, 255)
        );
    }

    private void prepareBottomPanel() {

        bottomPanel = new JPanel();

        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setPreferredSize(new Dimension(100, 50));
    }
}