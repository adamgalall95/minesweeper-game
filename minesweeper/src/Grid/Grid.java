package Grid;

import Cell.Cell;

public class Grid {
    private Cell[][] gridCell = new Cell[10][10];

    public Grid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.gridCell[i][j] = new Cell();
            }
        }
    }

    public Cell cellGetter(int x, int y) {
        return gridCell[x][y];
    }
}