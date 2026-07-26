package Cell;

public class Cell {
    private boolean clicked = false;
    private boolean bomb = false;
    private int surroundingBombs = 0;

    public boolean isClicked() {
        return this.clicked;
    }

    public boolean isBomb() {
        return this.bomb;
    }

    public int getSurroundingBomb() {
        return this.surroundingBombs;
    }

    public void setClicked() {
        if (!isClicked()) {
            this.clicked = true;
        }
    }

    public void setBomb() {
        this.bomb = true;
    }

    public void setSurroundingBomb(int num) {
        this.surroundingBombs = num;
    }

}