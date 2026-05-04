package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import domain.*;

public class HardestGameGUI extends JFrame {
	// instance variables - replace the example below with your own
    private HGame hardestGame;
    
    // Menú
    private JMenuBar menuBarHardestGame;
    private JMenu menuHardestGame;
    private JMenuItem menuItemPause;
    private JMenuItem menuItemFinish;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemLoad;
    
    // Panel principal
    private JPanel mainPanel;
    
    //Múltiples elementos en el juego
    private CardLayout cardLayout;
    
    //Pantallas
    private JPanel welcomePanel;
    private JPanel leaderboardPanel;
    private JPanel instructionsPanel;
    private JPanel gamePanel;
    private JPanel boardPanel;
    private JPanel infoPanel;
    private JPanel levelMessagePanel;
    private JPanel saveScorePanel;
    
    //Etiquetas
    private JLabel titleLabel;
    private JLabel menuLabel;
    private JLabel levelLabel;
    private JLabel deathCounterLabel;
    private JLabel timeLabel;
    private JLabel messageLabel;
    
    //Campo de texto
    private JTextField nameNewScoreField;
    
    
    //Botones
    private JButton playGameButton;
    private JButton leaderBoardButton;
    private JButton mainMenuToInstructionsButton;
    private JButton instructionsToMainMenuButton;
    private JButton instructionsToPlayButton;
    private JButton leaderboardToMainMenuButton;
    private JButton saveScoreButton;
    private JButton backToPlayButton;
    private JButton menuGameButton;
    private JButton pauseResumeButton;
    private JButton finishButton;
    
    
    
    private HardestGameGUI(){
        prepareElements();
        prepareActions();
    }
    
    public static void main(String[] args){
        HardestGameGUI gui = new HardestGameGUI();
        gui.setVisible(true);
    }
    
    private void prepareElementsWelcomePanel(){
        welcomePanel = new JPanel(new BorderLayout());
        
        JPanel titlePanel = prepareAreaTitle();
        
        JPanel buttonsPanel = new JPanel(new GridLayout(2,1,10,10));
        
        playGameButton = new JButton("PLAY GAME");
        leaderBoardButton = new JButton("LEADER BOARD");
        
        buttonsPanel.add(playGameButton);
        buttonsPanel.add(leaderBoardButton);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 150, 40, 150));
        centerPanel.add(buttonsPanel, BorderLayout.CENTER);
        
        welcomePanel.add(titlePanel, BorderLayout.NORTH);
        welcomePanel.add(centerPanel, BorderLayout.CENTER);
    }
    
    private JPanel prepareAreaTitle(){
    	JPanel panel = new JPanel(new BorderLayout());
    	
    	JLabel topLabel = new JLabel("The DOPO...", JLabel.LEFT);
        JLabel centerLabel = new JLabel("Hardest Game", JLabel.CENTER);
        JLabel versionLabel = new JLabel("Version 1.0", JLabel.RIGHT);
        
        topLabel.setFont(new Font("Arial", Font.BOLD, 24));
        centerLabel.setFont(new Font("Arial Black", Font.BOLD, 60));
        versionLabel.setFont(new Font("Arial", Font.BOLD, 22));
        
        topLabel.setForeground(Color.BLACK);
        centerLabel.setForeground(Color.BLUE);
        versionLabel.setForeground(Color.BLACK);
        
        panel.add(topLabel, BorderLayout.NORTH);
        panel.add(centerLabel, BorderLayout.CENTER);
        panel.add(versionLabel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void exit(){
        int result = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de salir del programa?",
            "Salir de The DOPO Hardest Game",
            JOptionPane.YES_NO_OPTION
        );
    
        if(result == JOptionPane.YES_OPTION){
            setVisible(false);
            System.exit(0);
        }
        else{
            requestFocusInWindow();
        }
    }
    
    private void prepareActions(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                exit();
            }
        });
        
        
        playGameButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel, "INSTRUCTIONS");
        	}
        });
        
        leaderBoardButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel, "LEADERBOARD");
        	}
        });
        
        instructionsToMainMenuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(mainPanel, "WELCOME");
            }
        });

        leaderboardToMainMenuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(mainPanel, "WELCOME");
            }
        });
        
        instructionsToPlayButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(
                    HardestGameGUI.this,
                    "Game screen under construction"
                );
            }
        });
    } 
    
    
    private void prepareElementsInstructionsPanel(){

        instructionsPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("INSTRUCTIONS", JLabel.CENTER);
        title.setFont(new Font("Arial Black", Font.BOLD, 28));

        JTextArea text = new JTextArea(
            "Objective:\n" +
            "Avoid enemies, collect all coins and reach the goal.\n\n" +
            "Controls:\n" +
            "Use arrow keys or WASD.\n\n" +
            "Tips:\n" +
            "- Touching enemies returns you.\n" +
            "- Coins may change your powers.\n" +
            "- Be patient."
        );

        text.setEditable(false);
        text.setFont(new Font("Arial", Font.PLAIN, 18));
        text.setBackground(instructionsPanel.getBackground());
        
        text.setLineWrap(true);
        text.setWrapStyleWord(true);

        instructionsToMainMenuButton = new JButton("MENU");
        instructionsToPlayButton = new JButton("PLAY");

        JPanel buttons = new JPanel(new GridLayout(1,2,10,10));
        buttons.add(instructionsToMainMenuButton);
        buttons.add(instructionsToPlayButton);

        instructionsPanel.add(title, BorderLayout.NORTH);
        instructionsPanel.add(text, BorderLayout.CENTER);
        instructionsPanel.add(buttons, BorderLayout.SOUTH);
    }
    
    private void prepareElementsLeaderboardPanel(){

        leaderboardPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("LEADERBOARD", JLabel.CENTER);
        title.setFont(new Font("Arial Black", Font.BOLD, 28));

        JLabel scores = new JLabel(
            "<html><center>" +
            "1. JUAN - 2 deaths<br><br>" +
            "2. ANA - 4 deaths<br><br>" +
            "3. CARLOS - 7 deaths" +
            "</center></html>",
            JLabel.CENTER
        );

        scores.setFont(new Font("Arial", Font.PLAIN, 22));

        leaderboardToMainMenuButton = new JButton("BACK");

        leaderboardPanel.add(title, BorderLayout.NORTH);
        leaderboardPanel.add(scores, BorderLayout.CENTER);
        leaderboardPanel.add(leaderboardToMainMenuButton, BorderLayout.SOUTH);
    }
    
    private void prepareElements(){
        setTitle("The DOPO Hardest Game");
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        
        setSize(screen.width/2, screen.height/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        prepareElementsWelcomePanel();
        prepareElementsInstructionsPanel();
        prepareElementsLeaderboardPanel();
        
        mainPanel.add(welcomePanel, "WELCOME");
        mainPanel.add(instructionsPanel, "INSTRUCTIONS");
        mainPanel.add(leaderboardPanel, "LEADERBOARD");

        add(mainPanel);

        cardLayout.show(mainPanel, "WELCOME");
    }
    
}