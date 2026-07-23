import Grid.Grid;

public class App {

    public static void main(String[] args) {

        Grid gridTest = new Grid();

        for (int i = 0; i < 10; i++) {

            boolean[] output = new boolean[10];

            for (int j = 0; j < 10; j++) {

                output[j] = gridTest.cellGetter(i, j).isMine();

            }

            System.out.println(output);

        }

    }
}