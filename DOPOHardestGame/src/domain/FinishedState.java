package domain;

public class FinishedState implements GameState {

    public boolean canMove() {
        return false;
    }

    public boolean canPause() {
        return false;
    }

    public boolean canResume() {
        return false;
    }

    public boolean isFinished() {
        return true;
    }
}