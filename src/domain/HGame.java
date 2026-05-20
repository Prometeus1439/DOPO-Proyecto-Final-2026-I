package domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HGame implements Serializable {

 private static final long serialVersionUID = 1L; 

 private ArrayList<Player> players;
 private ArrayList<Level> levels;
 private Level actualLevel;
 
 private String mode;
 private int deaths;

 public HGame() {
  players = new ArrayList<>();
  levels = new ArrayList<>();
 }

 public int getDeaths() {	
  return deaths;
 }
 
 public void startGame(String mode, PlayerType playerType) {
	 this.mode = mode;
	 
	 players.clear();
	 levels.clear();
	  
	 createPlayer("human", 1, playerType);
	  
	 level1();
} 
 
 public void startGame(String mode, PlayerType playerOneType, PlayerType playerTwoType) {
	 	this.mode = mode;
	 
	    players.clear();
	    levels.clear();
	    deaths = 0;

	    createPlayer("human", 1, playerOneType);

	    if(mode.equals("PVP")) {
	        createPlayer("human", 2, playerTwoType);
	    }
	    else if(mode.equals("PVM")) {
	        createPlayer("machine", 2, playerTwoType);
	    }

	    level1();
	}
 
 public void move(char direction, int player) {
  int dx = 0;
  int dy = 0;
  Player p= players.get(player);
  
  double speed = p.getSpeed();
  
  switch(direction) {
   case 'W':
   dy = (int) -speed;
   break;

   case 'S':
   dy = (int) speed;
   break;

   case 'A':
   dx = (int) -speed;
   break;
   
   case 'D':
   dx = (int) speed;
   break;
   }
     
  Rectangle future = new Rectangle(p.getX()+ dx, p.getY() + dy, p.getWidth(), p.getHeight());
  
  if(actualLevel.isWall(future)) {
   p.move(future);
  }
  
 }
 
 public void createPlayer(String controlType, int player, PlayerType pType) {
  Player p = null;
  
  if(controlType.equals("human")) {
   p = new HumanPlayer(pType,1,1,20,20);
  }
  
  else if (controlType.equals("machine")) {
   p= new MachinePlayer(pType,1,1,20,20);
  }
  
  if(p != null) {
   p.setPlayerNumber(player);
   players.add(p);
  }
  
 }
 
 public void tictac() {
  if (actualLevel == null) return;
  actualLevel.moveThings();
  for(Player p: players) {
   actualLevel.checkZone(p);
   actualLevel.checkThing(p);
   actualLevel.checkScenarioItems(p);
   if(p.getLife()==0) {
    deaths++;
    p.addDeath();
    
    p.setLife(1);
    p.setX(p.getRespawnX());
    p.setY(p.getRespawnY());
    
    p.setScore(0);
    
    actualLevel.resetCoins();
    }
   }
}
 
 public int getPlayerDeaths(int index) {
	 return players.get(index).getDeaths();
}

public int getPlayerScore(int index) {
	return players.get(index).getScore();
}
 
public void level1() {

    ArrayList<Wall> walls = new ArrayList<>();
    ArrayList<Zone> zones = new ArrayList<>();
    ArrayList<Thing> things = new ArrayList<>();

    int size = 700;
    int thickness = 10;

    walls.add(new Wall(0,0,size,thickness));
    walls.add(new Wall(0,0,thickness,size));
    walls.add(new Wall(0,size-thickness,size,thickness));
    walls.add(new Wall(size-thickness,0,thickness,size));
    walls.add(new Wall(125,0,thickness,size-190));
    walls.add(new Wall(590,200,thickness,size));
    walls.add(new Wall(0,50,1000,100));
    walls.add(new Wall(0,550,1000,100));

    Start start = new Start(20,0,100,500);
    Goal goal = new Goal(600,200,100,500);

    zones.add(start);
    zones.add(goal);
    things.add(new Guard(200,200,20,20,1,200,500));
    things.add(new Guard(300,500,20,20,1,200,500));
    things.add(new Guard(400,200,20,20,1,200,500));
    things.add(new Guard(500,500,20,20,1,200,500));
    if(mode.equals("PVP") || mode.equals("PVM")) {
	    things.add(new YellowCoin(400, 300, 20, 20, 1));
	    things.add(new YellowCoin(400, 300, 20, 20, 2));
	    zones.add(new Goal(20,450,100,50));
	}
	else {
	    things.add(new YellowCoin(400, 300, 20, 20));
	}
    for(int i = 0; i < players.size(); i++) {
	    Player p = players.get(i);

	    if(i == 0) {
	        p.setRespawnX(40);
	        p.setRespawnY(280);
	        p.setX(40);
	        p.setY(280);
	    }
	    else {
	        p.setRespawnX(620);
	        p.setRespawnY(440);
	        p.setX(620);
	        p.setY(440);
	    }
	}

    actualLevel = new Level(walls,zones,things,size,size);

    levels.add(actualLevel);
}
 
 public Level getActualLevel(){
  return actualLevel;
 }
 
 public ArrayList<Player> getPlayers(){
  return players;
  }
 
 
 public void saveAs(File f, int remainingSeconds)
	        throws HGameException {

	    try {

	        if(!f.getName().endsWith(".dat")) {
	            f = new File(f.getAbsolutePath() + ".dat");
	        }

	        SavedGame save =
	            new SavedGame(this, remainingSeconds);

	        FileOutputStream fos =
	            new FileOutputStream(f);

	        ObjectOutputStream oos =
	            new ObjectOutputStream(fos);

	        oos.writeObject(save);

	        oos.close();
	        fos.close();
	    }

	    catch(FileNotFoundException e) {
	        throw new HGameException(
	            "Could not create the file"
	        );
	    }

	    catch(IOException e) {
	        throw new HGameException(
	            "Error writing the file"
	        );
	    }
	}
 
 public static SavedGame importAs(File f)
	        throws HGameException {

	    try {

	        FileInputStream fis =
	            new FileInputStream(f);

	        ObjectInputStream ois =
	            new ObjectInputStream(fis);

	        SavedGame save =
	            (SavedGame) ois.readObject();

	        ois.close();
	        fis.close();

	        return save;
	    }

	    catch(FileNotFoundException e) {
	        throw new HGameException(
	            "Save file not found"
	        );
	    }

	    catch(IOException e) {
	        throw new HGameException(
	            "Error reading the file"
	        );
	    }

	    catch(ClassNotFoundException e) {
	        throw new HGameException(
	            "Invalid save file"
	        );
	    }
	}
}
 