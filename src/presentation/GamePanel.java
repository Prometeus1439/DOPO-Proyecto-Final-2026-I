package presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import domain.HGame;
import javax.swing.Timer;

public class GamePanel extends GameScreenPanel {

    private static final long serialVersionUID = 1L;
    
    private HGame hardestGame;
    private String gameMode;
    private Timer gameTimer;
    private int remainingSeconds;
    private static final int INITIAL_TIME = 600;
    private Runnable exitToMainMenuAction;

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;

    private JLabel levelLabel;
    private JLabel timeLabel;
    private JLabel deathsLabel;

    private JButton menuButton;
    private JPopupMenu gameMenu;
    
    public GamePanel(HGame hardestGame) {
    	super(new BorderLayout());
    	
    	this.hardestGame = hardestGame;
    	this.gameMode = "NORMAL";
    	
    	prepareElements();
    	prepareGameMenu();
    	prepareActions();
    	
    }

    private void prepareElements() {

        prepareTopPanel();
        prepareCenterPanel();
        prepareBottomPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    public void setExitToMainMenuAction(Runnable action) {
        this.exitToMainMenuAction = action;
    }

    private void prepareTopPanel() {

        topPanel = new JPanel(new BorderLayout());

        topPanel.setBackground(Color.BLACK);
        topPanel.setPreferredSize(new Dimension(100, 50));

        menuButton = new JButton("MENU");
        
        levelLabel = new JLabel("1/30", JLabel.CENTER);
        deathsLabel = new JLabel("DEATHS: 0", JLabel.RIGHT);
        timeLabel = new JLabel("TIME: 10:00", JLabel.CENTER);

        menuButton.setForeground(Color.WHITE);
        menuButton.setBackground(Color.BLACK);
        menuButton.setFont(new Font("Arial Black", Font.BOLD, 20));
        menuButton.setFocusPainted(false);
        menuButton.setBorderPainted(false);
        menuButton.setContentAreaFilled(true);
        
        levelLabel.setForeground(Color.WHITE);
        deathsLabel.setForeground(Color.WHITE);
        timeLabel.setForeground(Color.WHITE);

        levelLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        deathsLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        timeLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        
        JPanel centerInfoPanel = new JPanel(new GridLayout(1, 2));
        
        centerInfoPanel.setBackground(Color.BLACK);

        centerInfoPanel.add(levelLabel);
        centerInfoPanel.add(timeLabel);

        topPanel.add(menuButton, BorderLayout.WEST);
        topPanel.add(centerInfoPanel, BorderLayout.CENTER);
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
    
    public void setGameMode(String gameMode) {
    	this.gameMode = gameMode;
    }
    
    private void prepareGameMenu() {

        gameMenu = new JPopupMenu();

        JMenuItem resumeItem = new JMenuItem("Resume");
        JMenuItem saveItem = new JMenuItem("Save game");
        JMenuItem loadItem = new JMenuItem("Load game");
        JMenuItem volumeUpItem = new JMenuItem("Volume +");
        JMenuItem volumeDownItem = new JMenuItem("Volume -");
        JMenuItem exitToMenuItem = new JMenuItem("Exit to main menu");
        JMenuItem quitItem = new JMenuItem("Quit game");

        gameMenu.add(resumeItem);
        gameMenu.addSeparator();
        gameMenu.add(saveItem);
        gameMenu.add(loadItem);
        gameMenu.addSeparator();
        gameMenu.add(volumeUpItem);
        gameMenu.add(volumeDownItem);
        gameMenu.addSeparator();
        gameMenu.add(exitToMenuItem);
        gameMenu.add(quitItem);

        resumeItem.addActionListener(e -> {
        	
        	if (gameTimer != null) {
                gameTimer.start();
            }
        	
        	requestFocusInWindow();
        });
        
        exitToMenuItem.addActionListener(e -> {
            if (gameTimer != null) {
                gameTimer.stop();
            }

            if (exitToMainMenuAction != null) {
                exitToMainMenuAction.run();
            }
        });

        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Save feature in development"));

        loadItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Load feature in development"));

        volumeUpItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Volume increased"));

        volumeDownItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Volume decreased"));

        quitItem.addActionListener(e -> System.exit(0));
        
    }
    
    private void prepareActions(){
    	
    	setFocusable(true);
    	
        addKeyListener(new KeyAdapter(){
        	
        @Override
        public void keyPressed(KeyEvent e) {
        	movePlayer(e);
        	}
        });
        
        menuButton.addActionListener(e -> {
        	
        	if(gameTimer != null) {
        		gameTimer.stop();
        	}
        	
        	gameMenu.show(menuButton, 0, menuButton.getHeight());
        });
    }
    
    private void movePlayer(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if(gameMode.equals("NORMAL") || gameMode.equals("PVM")) {
    		moveSinglePlayer(key);
    	}
    	
    	else {
    		moveTwoPlayers(key);
    	}
    	
    	repaint();
    }
    
    private void moveSinglePlayer(int key) {
    	switch(key) {
    		case KeyEvent.VK_W:
    		case KeyEvent.VK_UP:
    			hardestGame.move('W', 0);
    			break;
    		
    		case KeyEvent.VK_S:
    		case KeyEvent.VK_DOWN:
    			hardestGame.move('S', 0);
    			break;
    			
    		case KeyEvent.VK_A:
    		case KeyEvent.VK_LEFT:
    			hardestGame.move('A', 0);
    			break;
    		
    		case KeyEvent.VK_D:
    		case KeyEvent.VK_RIGHT:
    			hardestGame.move('D', 0);
    			break;
    	}
    }
    
    private void moveTwoPlayers(int key) {
    	switch(key) {
    	//Jugador 1 - WASD
    	case KeyEvent.VK_W:
    		hardestGame.move('W', 0);
    		break;
    		
    	case KeyEvent.VK_S:
    		hardestGame.move('S', 0);
    		break;
    	
    	case KeyEvent.VK_A:
    		hardestGame.move('A', 0);
    		break;
    		
    	case KeyEvent.VK_D:
    		hardestGame.move('D', 0);
    		break;
    	
    	//Jugador 2 - Flechas
    	case KeyEvent.VK_UP:
    		hardestGame.move('W', 1);
    		break;
    		
    	case KeyEvent.VK_DOWN:
    		hardestGame.move('S', 1);
    		break;
    	
    	case KeyEvent.VK_LEFT:
    		hardestGame.move('A', 1);
    		break;
    		
    	case KeyEvent.VK_RIGHT:
    		hardestGame.move('D', 1);
    		break;
    	}
    }
    
    public void startGameTimer() {
    	remainingSeconds = INITIAL_TIME;
    	updateTimeLabel();
    	
    	if(gameTimer != null) {
    		gameTimer.stop();
    	}
    	
    	gameTimer = new Timer(1000, e -> {
    		remainingSeconds--;
    		updateTimeLabel();
    		
    		if(remainingSeconds <= 0) {
    			gameTimer.stop();
    			gameOverByTime();
    		}
    	});
    	
    	gameTimer.start();
    }
    
    private void updateTimeLabel() {
    	
    	int minutes = remainingSeconds / 60;
    	int seconds = remainingSeconds % 60;
    	
    	timeLabel.setText(String.format("TIME: %02d:%02d", minutes, seconds));
    }
    
    private void gameOverByTime() {
    	
    	JOptionPane.showMessageDialog(this, "Time is over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }
    
}