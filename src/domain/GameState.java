package domain;

import java.io.*;

public interface GameState extends Serializable{
	
	boolean canMove();

    boolean canPause();

    boolean canResume();

    boolean isFinished();

}
