package Grid;

import Cell.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    private List<List<Cell>> cellGrid = new ArrayList<>();
    private Random random = new Random();
    private int clickedCellsCount = 0;

    // private void setClickedCellsCount(int count) {
    // clickedCellsCount = count;
    // }

    public int getClickedCellsCount() {
        return clickedCellsCount;
    }

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

    public Boolean validRowCol(int rowCol) {
        if (rowCol < 0 || rowCol >= 10) {
            return false;
        } else {
            return true;
        }
    }

    private void checkSurroundingBombs(int i, int j) {
        int numberOfBombs = 0;
        for (int row = i - 1; row <= i + 1; row++) {
            if (!validRowCol(row)) {
                continue;
            } else {
                for (int col = j - 1; col <= j + 1; col++) {
                    if (!validRowCol(col)) {
                        continue;
                    }
                    if (row == i && col == j) {
                        continue;
                    }
                    if (cellGrid.get(row).get(col).isBomb()) {
                        numberOfBombs++;
                    }
                }
            }
        }
        cellGrid.get(i).get(j).setSurroundingBomb(numberOfBombs);
    }

    private void setNumberOfSurroundingBombs() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell cellObj = cellGrid.get(i).get(j);
                if (cellObj.isBomb()) {
                    continue;
                }
                checkSurroundingBombs(i, j);
            }
        }
    }

    public void initGrid() {
        fillGridWithCells();
        fillGridWithBombs();
        setNumberOfSurroundingBombs();
    }

    public Cell getCell(int row, int col) {
        if (!validRowCol(row) || !validRowCol(col)) {
            return null;
        }
        return cellGrid.get(row).get(col);
    }

    public void printGrid() {
        for (int i = 0; i < 10; i++) {

            List<String> row = new ArrayList<>();

            for (int j = 0; j < 10; j++) {

                Cell cellObj = cellGrid.get(i).get(j);

                if (!cellObj.isClicked()) {
                    row.add("-");
                } else if (cellObj.isBomb()) {
                    row.add("B");
                } else {
                    row.add(String.valueOf(cellObj.getSurroundingBomb()));
                }
            }

            System.out.println(row);
        }
    }

    public boolean clickCell(int row, int col) {

        Cell cellObj = cellGrid.get(row).get(col);

        if (cellObj.isClicked()) {
            System.out.println("This cell has already been clicked!");
            return false;
        }

        cellObj.setClicked();

        if (cellObj.isBomb()) {
            return true;
        }

        clickedCellsCount++;
        return false;
    }

    public void printGridSurrBombs() {
        for (int i = 0; i < 10; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Cell cellObj = cellGrid.get(i).get(j);
                row.add(cellObj.getSurroundingBomb());
            }
            System.out.println(row);
        }
    }

}