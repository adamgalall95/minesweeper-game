package Grid;

import Cell.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    private List<List<Cell>> cellGrid = new ArrayList<>();
    private boolean gridInitiated = false;
    private Random random = new Random();

    private void fillGridWithCells() {
        for (int i = 0; i < 10; i++) {
            List<Cell> cellRow = new ArrayList<Cell>();
            for (int j = 0; j < 10; j++) {
                cellRow.add(new Cell());
            }
            cellGrid.add(cellRow);
        }
    }

    private void fillGridWithBombs() {
        int bombsLimit = 10;
        int bombsPlaced = 0;

        while (bombsPlaced < bombsLimit) {
            int rowIndex = random.nextInt(10);
            int columnIndex = random.nextInt(10);

            Cell cellObj = cellGrid.get(rowIndex).get(columnIndex);

            if (!cellObj.isBomb()) {
                cellObj.setBomb();
                bombsPlaced++;
            }
        }
    }

    public void initGrid() {
        fillGridWithCells();
        fillGridWithBombs();
    }

    public void printGrid() {
        for (int i = 0; i < 10; i++) {
            List<Boolean> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                int rowIndex = random.nextInt(10);
                int columnIndex = random.nextInt(10);

                Cell cellObj = cellGrid.get(rowIndex).get(columnIndex);
                row.add(cellObj.isBomb());
            }
            System.out.println(row);
        }
    }
}