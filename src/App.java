import java.util.Scanner;

import Cell.Cell;
import Grid.Grid;

public class App {

    public static void main(String[] args) {

        Grid testGrid = new Grid();

        testGrid.initGrid();

        Scanner scanner = new Scanner(System.in);
        int emptyCells = 90;
        String gameOverText = null;

        while (true) {
            testGrid.printGrid();

            System.out.println("Enter row:");
            int row = scanner.nextInt();

            System.out.println("Enter column:");
            int col = scanner.nextInt();

            if (!testGrid.validRowCol(row) || !testGrid.validRowCol(col)) {
                System.out.println("Invalid coordinates");
                continue;
            }

            boolean hitBomb = testGrid.clickCell(row, col);

            if (hitBomb) {
                gameOverText = "Lost Game";
                break;
            }

            if (testGrid.getClickedCellsCount() == emptyCells) {
                gameOverText = "Game Won";
                break;
            }
        }
        testGrid.printGrid();
        System.out.println(gameOverText);
        scanner.close();
    }

}