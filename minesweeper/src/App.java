import java.util.Scanner;

import Cell.Cell;
import Grid.Grid;

public class App {

    public static void main(String[] args) {

        Grid testGrid = new Grid();

        testGrid.initGrid();

        Scanner scanner = new Scanner(System.in);
        boolean hitBomb = false;

        while (!hitBomb) {
            testGrid.printGrid();

            System.out.println("Enter row:");
            int row = scanner.nextInt();

            System.out.println("Enter column:");
            int col = scanner.nextInt();

            if (!testGrid.validRowCol(row) || !testGrid.validRowCol(col)) {
                System.out.println("Invalid coordinates");
                continue;
            }

            testGrid.clickCell(row, col);

            Cell clickedCell = testGrid.getCell(row, col);

            hitBomb = clickedCell.isBomb();
        }
        testGrid.printGrid();
        scanner.close();
    }

}