package Cell;

public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }

    public boolean isMine() {
        return isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public int adjacentMines() {
        return adjacentMines;
    }

    public void reveal() {
        isRevealed = true;
    }

    public void setadjacentMines(int count) {
        if (count <= 8 && count >= 0) {
            adjacentMines = count;
        } else {
            return;
        }
    }
}