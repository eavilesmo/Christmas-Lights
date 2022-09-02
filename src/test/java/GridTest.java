import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

//    @Test
//    void check_grid_is_created() {
//        Grid grid = new Grid();
//        int[][] actualGrid = grid.create(10, 10);
//        int[][] expectedGrid = new int[10][10];
//        assertThat(actualGrid).isEqualTo(expectedGrid);
//    }

    @Test
    void check_grid_is_filled_with_lights() {
        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(2, 2);
        Light[][] expectedGrid = new Light[2][2];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                expectedGrid[row][column] = light;
            }
        }

        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_all_lights_in_grid_are_turned_on() {
        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(2, 2);
        int[] startPoint = {0,0};
        int[] finishPoint = {2,2};
        actualGrid = grid.turnOnLights(actualGrid, startPoint, finishPoint);
        Light[][] expectedGrid = new Light[2][2];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                light.turnOn();
                expectedGrid[row][column] = light;
            }
        }

        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_only_certain_lights_are_on(){
        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(10, 10);
        int[] startPoint = {3,5};
        int[] finishPoint = {4,7};
        grid.turnOnLights(actualGrid, startPoint, finishPoint);

        Light[][] expectedGrid = new Light[10][10];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                expectedGrid[row][column] = light;
            }
        }

        for (int row = startPoint[0]; row < finishPoint[0]; row++) {
            for (int column = startPoint[1]; column < finishPoint[1]; column++) {
                expectedGrid[row][column].turnOn();
            }
        }

        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }
}
