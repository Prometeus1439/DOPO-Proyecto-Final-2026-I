package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import domain.*;

public class HardestGameGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

    private HGame hardestGame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private String selectedMode;
    private PlayerType playerOneType;
    private PlayerType playerTwoType;
    private int selectingPlayer;
    
    //Pantallas
    private WelcomePanel welcomePanel;
    private SettingsPanel settingsPanel;
    private ModeSelectionPanel selectionModePanel;
    private InstructionsPanel instructionsPanel;
    private CharacterSelectionPanel selectionCharacterPanel;
    private GamePanel gamePanel;
    
    private HardestGameGUI(){
    	hardestGame = new HGame();
        prepareElements();
        prepareActions();
    }
    
    public static void main(String[] args){
        HardestGameGUI gui = new HardestGameGUI();
        gui.setVisible(true);
    }
    
    private void prepareElements(){
    	
    	prepareFrameStyle();
    	
    	preparePanels();
    	
    	prepareMainPanel();
    }
    
    private void prepareFrameStyle() {
    	setTitle("The DOPO Hardest Game");
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        
        setSize(screen.width/2, screen.height/2);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    private void preparePanels() {
    	welcomePanel = new WelcomePanel();
        settingsPanel = new SettingsPanel();
        selectionModePanel = new ModeSelectionPanel();
        instructionsPanel = new InstructionsPanel();
        selectionCharacterPanel = new CharacterSelectionPanel();
        gamePanel = new GamePanel(hardestGame);
    }
    
    private void prepareMainPanel() {
    	cardLayout = new CardLayout();
        
    	mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(GUIStyle.BACKGROUND);
        
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
        
        selectionModePanel.getNormalButton().addActionListener(e -> {selectedMode = "NORMAL";gamePanel.setGameMode(selectedMode); instructionsPanel.showNormalInstructions();showPanel("INSTRUCTIONS");});
        selectionModePanel.getPvpButton().addActionListener(e -> {selectedMode = "PVP";gamePanel.setGameMode(selectedMode);instructionsPanel.showPvpInstructions();showPanel("INSTRUCTIONS");});
        selectionModePanel.getPvmButton().addActionListener(e -> {selectedMode = "PVM";gamePanel.setGameMode(selectedMode);instructionsPanel.showPvmInstructions();showPanel("INSTRUCTIONS");});
        selectionModePanel.getBackButton().addActionListener(e -> showPanel("WELCOME"));

        instructionsPanel.getBackButton().addActionListener(e -> showPanel("MODE"));
        instructionsPanel.getPlayButton().addActionListener(e -> {

            selectingPlayer = 1;

            if(selectedMode.equals("NORMAL")) {
                selectionCharacterPanel.showSinglePlayerSelection();
            }
            else {
                selectionCharacterPanel.showPlayerOneSelection();
            }

            showPanel("CHARACTER");
        });

        selectionCharacterPanel.getCharacterOneButton().addActionListener(e -> selectCharacter(new RedSkin()));
        selectionCharacterPanel.getCharacterTwoButton().addActionListener(e -> selectCharacter(new GreenSkin()));
        selectionCharacterPanel.getCharacterThreeButton().addActionListener(e -> selectCharacter(new BlueSkin()));
        selectionCharacterPanel.getBackButton().addActionListener(e -> showPanel("INSTRUCTIONS"));
        
        gamePanel.setExitToMainMenuAction(() -> showPanel("WELCOME"));
    } 
    
    private void showPanel(String name) {
    	cardLayout.show(mainPanel, name);
    	
    	if (name.equals("GAME")) {
            gamePanel.startGameTimer();
            gamePanel.requestFocusInWindow();
        }
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
    
    private void selectCharacter(PlayerType type) {

        if(selectedMode.equals("PVP") || selectedMode.equals("PVM")) {

            if(selectingPlayer == 1) {
                playerOneType = type;
                selectingPlayer = 2;

                if(selectedMode.equals("PVP")) {
                    selectionCharacterPanel.showPlayerTwoSelection();
                }
                else {
                    selectionCharacterPanel.showMachineSelection();
                }

                showPanel("CHARACTER");
            }
            else {
                playerTwoType = type;
                hardestGame.startGame(selectedMode, playerOneType, playerTwoType);
                showPanel("GAME");
            }
        }
        else {
            hardestGame.startGame(selectedMode, type);
            showPanel("GAME");
        }
    }
    
}