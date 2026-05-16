package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIStyle {

    public static final Color BACKGROUND = new Color(210, 210, 255);
    public static final Color BLUE = new Color(0, 102, 255);
    public static final Color RED = new Color(220, 0, 0);
    public static final Color YELLOW = new Color(255, 200, 0);
    public static final Color GREEN = new Color(0, 180, 80);
    public static final Color PURPLE = new Color(160, 0, 220);
    public static final Color ORANGE = new Color(255, 150, 0);
    public static final Color BLACK = Color.BLACK;
    public static final Color WHITE = Color.WHITE;

    public static final Font MAIN_TITLE_FONT = new Font("Verdana", Font.BOLD, 72);
    public static final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 38);
    public static final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 28);
    public static final Font SMALL_FONT = new Font("Verdana", Font.BOLD, 18);

    public static void styleTitle(JLabel label) {
        label.setFont(TITLE_FONT);
        label.setForeground(BLUE);
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void styleMenuButton(JButton button, Color normalColor, Color hoverColor) {
        button.setFont(BUTTON_FONT);
        button.setForeground(normalColor);
        button.setPreferredSize(new Dimension(300, 80));

        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setBackground(GUIStyle.BACKGROUND);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(normalColor, 4));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(hoverColor);
                button.setBorder(BorderFactory.createLineBorder(hoverColor, 4));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(normalColor);
                button.setBorder(BorderFactory.createLineBorder(normalColor, 4));
            }
        });
    }

    public static void applyBackground(JPanel panel) {
        panel.setBackground(BACKGROUND);
    }
}