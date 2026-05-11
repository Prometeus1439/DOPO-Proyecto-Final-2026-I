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

    private HGame hardestGame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    // Menï¿½
    private JMenuBar menuBarHardestGame;
    private JMenu menuHardestGame;
    private JMenuItem menuItemPause;
    private JMenuItem menuItemFinish;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemLoad;
    
    
    //Pantallas
    private WelcomePanel welcomePanel;
    private SettingsPanel settingsPanel;
    private ModeSelectionPanel selectionModePanel;
    private InstructionsPanel instructionsPanel;
    private CharacterSelectionPanel selectionCharacterPanel;
    private GamePanel gamePanel;
    
    
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
    	hardestGame = new HGame();
        prepareElements();
        prepareActions();
    }
    
    public static void main(String[] args){
        HardestGameGUI gui = new HardestGameGUI();
        HGame hardestGame= new HGame();
        gui.setVisible(true);
    }
    
    private void prepareElements(){
        setTitle("The DOPO Hardest Game");
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        //GamePanel gamePanel= new GamePanel(hardestGame.getActualLevel(), hardestGame.getPlayers());
        
        setSize(screen.width/2, screen.height/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        welcomePanel = new WelcomePanel();
        settingsPanel = new SettingsPanel();
        selectionModePanel = new ModeSelectionPanel();
        instructionsPanel = new InstructionsPanel();
        selectionCharacterPanel = new CharacterSelectionPanel();
        gamePanel = new GamePanel();
        
        mainPanel.add(welcomePanel, "WELCOME");
        mainPanel.add(settingsPanel, "SETTINGS");
        mainPanel.add(selectionModePanel, "MODE");
        mainPanel.add(instructionsPanel, "INSTRUCTIONS");
        mainPanel.add(selectionCharacterPanel, "CHARACTER");
        mainPanel.add(gamePanel, "GAME");

        getContentPane().add(mainPanel);

        cardLayout.show(mainPanel, "WELCOME");
    }
    
    private void prepareActions(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                exit();
            }
        });
        
        welcomePanel.getPlayButton().addActionListener(e -> showPanel("MODE"));
        welcomePanel.getSettingsButton().addActionListener(e -> showPanel("SETTINGS"));

        settingsPanel.getBackButton().addActionListener(e -> showPanel("WELCOME"));
        settingsPanel.getVolumeMinusButton().addActionListener(e -> settingsPanel.decreaseVolume());
        settingsPanel.getVolumePlusButton().addActionListener(e -> settingsPanel.increaseVolume());
        
        selectionModePanel.getNormalButton().addActionListener(e -> {instructionsPanel.showNormalInstructions();showPanel("INSTRUCTIONS");});
        selectionModePanel.getPvpButton().addActionListener(e -> {instructionsPanel.showPvpInstructions();showPanel("INSTRUCTIONS");});
        selectionModePanel.getPvmButton().addActionListener(e -> {instructionsPanel.showPvmInstructions();showPanel("INSTRUCTIONS");});

        instructionsPanel.getBackButton().addActionListener(e -> showPanel("MODE"));
        instructionsPanel.getPlayButton().addActionListener(e -> showPanel("CHARACTER"));

        selectionCharacterPanel.getCharacterOneButton().addActionListener(e -> showPanel("GAME"));
        selectionCharacterPanel.getCharacterTwoButton().addActionListener(e -> showPanel("GAME"));
        selectionCharacterPanel.getCharacterThreeButton().addActionListener(e -> showPanel("GAME"));
        selectionCharacterPanel.getBackButton().addActionListener(e -> showPanel("INSTRUCTIONS"));
    } 
    
    private void showPanel(String name) {
    	cardLayout.show(mainPanel, name);
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
    
}