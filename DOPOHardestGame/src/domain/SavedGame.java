package domain;

import java.io.Serializable;

public class SavedGame implements Serializable {

    private static final long serialVersionUID = 1L;

    private HGame game;
    private int remainingSeconds;

    public SavedGame(HGame game, int remainingSeconds) {
        this.game = game;
        this.remainingSeconds = remainingSeconds;
    }

    public HGame getGame() {
        return game;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }
}