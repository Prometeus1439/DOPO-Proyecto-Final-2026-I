package presentation;

import java.awt.LayoutManager;
import javax.swing.JPanel;

public class GameScreenPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public GameScreenPanel() {
        super();
        GUIStyle.applyBackground(this);
    }

    public GameScreenPanel(LayoutManager layout) {
        super(layout);
        GUIStyle.applyBackground(this);
    }
}