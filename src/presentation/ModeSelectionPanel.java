package presentation;

import java.awt.*;
import javax.swing.*;

public class ModeSelectionPanel extends JPanel {

    private JButton normalButton;
    private JButton pvpButton;
    private JButton pvmButton;

    public ModeSelectionPanel() {
        prepareElements();
    }

    private void prepareElements() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("SELECT GAME MODE", JLabel.CENTER);
        title.setFont(new Font("Arial Black", Font.BOLD, 32));

        normalButton = new JButton("NORMAL");
        pvpButton = new JButton("PLAYER VS PLAYER");
        pvmButton = new JButton("PLAYER VS MACHINE");

        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(120, 250, 120, 250));

        buttonsPanel.add(normalButton);
        buttonsPanel.add(pvpButton);
        buttonsPanel.add(pvmButton);

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
}