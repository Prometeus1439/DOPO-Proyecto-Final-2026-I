package domain;

public class PlayingState implements GameState {

    public boolean canMove() {
        return true;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canResume() {
        return false;
    }

    public boolean isFinished() {
        return false;
    }
}