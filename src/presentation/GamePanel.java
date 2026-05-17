package presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import domain.*;
import javax.swing.Timer;
import java.util.*;

public class GamePanel extends GameScreenPanel {

    private static final long serialVersionUID = 1L;

    private HGame hardestGame;
    private String gameMode;
    private Timer gameTimer;
    private Timer movementTimer;
    private Set<Integer> pressedKeys = new HashSet<>();
    private boolean gameOver = false;
    private int remainingSeconds;
    private static final int INITIAL_TIME = 600;
    private static final int MOVEMENT_DELAY = 16;
    private Runnable exitToMainMenuAction;

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;

    private JLabel levelLabel;
    private JLabel timeLabel;
    private JLabel statsLabel;

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
        statsLabel = new JLabel("P1 D: 0 | C: 0", JLabel.RIGHT);
        timeLabel = new JLabel("TIME: 10:00", JLabel.CENTER);

        menuButton.setForeground(Color.WHITE);
        menuButton.setBackground(Color.BLACK);
        menuButton.setFont(new Font("Arial Black", Font.BOLD, 20));
        menuButton.setFocusPainted(false);
        menuButton.setBorderPainted(false);
        menuButton.setContentAreaFilled(true);
        
        levelLabel.setForeground(Color.WHITE);
        statsLabel.setForeground(Color.WHITE);
        timeLabel.setForeground(Color.WHITE);

        levelLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        statsLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        timeLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        
        JPanel centerInfoPanel = new JPanel(new GridLayout(1, 2));
        
        centerInfoPanel.setBackground(Color.BLACK);

        centerInfoPanel.add(levelLabel);
        centerInfoPanel.add(timeLabel);

        topPanel.add(menuButton, BorderLayout.WEST);
        topPanel.add(centerInfoPanel, BorderLayout.CENTER);
        topPanel.add(statsLabel, BorderLayout.EAST);
    }

    private void prepareCenterPanel() {

        centerPanel = new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           
           if(hardestGame.getActualLevel() == null) {
               return;
           }
           
           drawZones(g);
           drawThings(g);
           drawWalls(g);
           drawPlayer(g);
          }
        };
        
        centerPanel.setBackground(new Color(210, 210, 255));
    }
    
    private void drawZones(Graphics g) {
        ArrayList<Zone> zones = hardestGame.getActualLevel().getZones();

        int panelW = centerPanel.getWidth();
        int panelH = centerPanel.getHeight();

        int levelW = hardestGame.getActualLevel().getWidth();
        int levelH = hardestGame.getActualLevel().getHeight();

        for (Zone zone : zones) {
            int width  = zone.getHitbox().width;
            int height = zone.getHitbox().height;
            int x = zone.getX() + (int)(panelW/2) - (int)(levelW/2);
            int y = zone.getY() + (int)(panelH/2) - (int)(levelH/2);

            if (zone instanceof Start) {
                g.setColor(new Color(100, 200, 100));
            } else if (zone instanceof Goal) {
                g.setColor(new Color(255, 215, 0));
            }

            g.fillRect(x, y, width, height);
        }
    }

    private void drawThings(Graphics g) {
        ArrayList<Thing> things = hardestGame.getActualLevel().getThings();

        int panelW = centerPanel.getWidth();
        int panelH = centerPanel.getHeight();

        int levelW = hardestGame.getActualLevel().getWidth();
        int levelH = hardestGame.getActualLevel().getHeight();

        for (Thing thing : things) {
            if (thing.isCollected()) continue;
            int width  = thing.getHitbox().width;
            int height = thing.getHitbox().height;
            int x = thing.getX() + (int)(panelW/2) - (int)(levelW/2);
            int y = thing.getY() + (int)(panelH/2) - (int)(levelH/2);
            g.setColor(thing.getColor());
            g.fillOval(x, y, width, height);
        }
    }

    private void drawWalls(Graphics g) {
     ArrayList<Wall> walls = hardestGame.getActualLevel().getWalls();
     g.setColor(Color.BLACK);
     
     int panelW = centerPanel.getWidth();
     int panelH = centerPanel.getHeight();
     
     int levelW = hardestGame.getActualLevel().getWidth();
     int levelH = hardestGame.getActualLevel().getHeight();
     
     for(Wall wall : walls) {
      int height = wall.getHitbox().height;
      int width = wall.getHitbox().width;
      int x = wall.getX() + (int)(panelW/2) - (int)(levelW/2);
      int y = wall.getY() + (int)(panelH/2) - (int)(levelH/2);
      g.fillRect(x, y, width, height);
     }
    }
    
    private void drawPlayer(Graphics g) {
     ArrayList<Player> players = hardestGame.getPlayers();
     
     int panelW = centerPanel.getWidth();
     int panelH = centerPanel.getHeight();
     
     int levelW = hardestGame.getActualLevel().getWidth();
     int levelH = hardestGame.getActualLevel().getHeight();
     
     for(Player player : players) {
      int height =  player.getHeight();
      int width = player.getWidth();
      int x = player.getX() + (int)(panelW/2) - (int)(levelW/2);
      int y = player.getY() + (int)(panelH/2) - (int)(levelH/2);
      g.setColor(player.getCurrentType().getColor());
      g.fillRect(x, y, width, height);
      g.setColor(Color.BLACK);
      g.drawRect(x, y, width, height);
     }
    }

    private void updateStatsLabel() {

        int playerCount = hardestGame.getPlayers().size();

        if(playerCount == 0) {
            statsLabel.setText("DEATHS: 0 | COINS: 0");
            return;
        }

        if(playerCount == 1) {
            statsLabel.setText(
                "DEATHS: " + hardestGame.getPlayerDeaths(0) +
                " | COINS: " + hardestGame.getPlayerScore(0)
            );
        }
        else {
            statsLabel.setText(
                "P1 D: " + hardestGame.getPlayerDeaths(0) +
                " | C: " + hardestGame.getPlayerScore(0) +
                "     P2 D: " + hardestGame.getPlayerDeaths(1) +
                " | C: " + hardestGame.getPlayerScore(1)
            );
        }
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
            if (gameTimer != null) gameTimer.start();
            if (movementTimer != null) movementTimer.start();
            requestFocusInWindow();
        });
        
        exitToMenuItem.addActionListener(e -> {
            if (gameTimer != null) gameTimer.stop();
            if (movementTimer != null) movementTimer.stop();
            if (exitToMainMenuAction != null) exitToMainMenuAction.run();
        });

        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Save feature in development"));
        loadItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Load feature in development"));
        volumeUpItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Volume increased"));
        volumeDownItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Volume decreased"));
        quitItem.addActionListener(e -> System.exit(0));
        
    }
    
    private void prepareActions(){

        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
            }
        });

        movementTimer = new Timer(MOVEMENT_DELAY, e -> {
            if (!pressedKeys.isEmpty()) {
                processMovement();
            }
            hardestGame.tictac();
            checkGameState();
            repaint();
        });
        movementTimer.start();

        menuButton.addActionListener(e -> {
            if (gameTimer != null) gameTimer.stop();
            if (movementTimer != null) movementTimer.stop();
            pressedKeys.clear();
            gameMenu.show(menuButton, 0, menuButton.getHeight());
        });
    }

    private void processMovement() {
        if (gameMode.equals("NORMAL") || gameMode.equals("PVM")) {
            moveSinglePlayer();
        } else {
            moveTwoPlayers();
        }
    }

    private void moveSinglePlayer() {
        if (pressedKeys.contains(KeyEvent.VK_W) || pressedKeys.contains(KeyEvent.VK_UP))
            hardestGame.move('W', 0);
        if (pressedKeys.contains(KeyEvent.VK_S) || pressedKeys.contains(KeyEvent.VK_DOWN))
            hardestGame.move('S', 0);
        if (pressedKeys.contains(KeyEvent.VK_A) || pressedKeys.contains(KeyEvent.VK_LEFT))
            hardestGame.move('A', 0);
        if (pressedKeys.contains(KeyEvent.VK_D) || pressedKeys.contains(KeyEvent.VK_RIGHT))
            hardestGame.move('D', 0);
    }

    private void moveTwoPlayers() {
        // Jugador 1 - WASD
        if (pressedKeys.contains(KeyEvent.VK_W)) hardestGame.move('W', 0);
        if (pressedKeys.contains(KeyEvent.VK_S)) hardestGame.move('S', 0);
        if (pressedKeys.contains(KeyEvent.VK_A)) hardestGame.move('A', 0);
        if (pressedKeys.contains(KeyEvent.VK_D)) hardestGame.move('D', 0);
        // Jugador 2 - Flechas
        if (pressedKeys.contains(KeyEvent.VK_UP))    hardestGame.move('W', 1);
        if (pressedKeys.contains(KeyEvent.VK_DOWN))  hardestGame.move('S', 1);
        if (pressedKeys.contains(KeyEvent.VK_LEFT))  hardestGame.move('A', 1);
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) hardestGame.move('D', 1);
    }
    
    private void checkGameState() {

        if(gameOver) return;

        if(hardestGame.getPlayers().isEmpty()) return;

        updateStatsLabel();

        for(Player player : hardestGame.getPlayers()) {
            if(player.isFinished()) {
                gameOver = true;

                if(gameTimer != null) gameTimer.stop();
                if(movementTimer != null) movementTimer.stop();

                JOptionPane.showMessageDialog(
                    this,
                    "¡Nivel completado!",
                    "Victoria",
                    JOptionPane.INFORMATION_MESSAGE
                );

                if(exitToMainMenuAction != null) {
                    exitToMainMenuAction.run();
                }

                return;
            }
        }
    }

    public void startGameTimer() {
     gameOver = false;
     pressedKeys.clear();
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
     if (movementTimer != null && !movementTimer.isRunning()) movementTimer.start();
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