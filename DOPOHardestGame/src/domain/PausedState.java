package domain;

public class PausedState implements GameState {

    public boolean canMove() {
        return false;
    }

    public boolean canPause() {
        return false;
    }

    public boolean canResume() {
        return true;
    }

    public boolean isFinished() {
        return false;
    }
}