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
        int[] finishPoint = {1,1};
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

        for (int row = startPoint[0]; row <= finishPoint[0]; row++) {
            for (int column = startPoint[1]; column <= finishPoint[1]; column++) {
                expectedGrid[row][column].turnOn();
            }
        }

        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_only_certain_lights_are_off() {
        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(10, 10);
        int[] startPointOn = {0,0};
        int[] finishPointOn = {9,9};
        grid.turnOnLights(actualGrid, startPointOn, finishPointOn);

        int[] startPointOff = {1,2};
        int[] finishPointOff = {6,7};
        grid.turnOffLights(actualGrid, startPointOff, finishPointOff);

        Light[][] expectedGrid = new Light[10][10];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                light.turnOn();
                expectedGrid[row][column] = light;
            }
        }

        for (int row = startPointOff[0]; row <= finishPointOff[0]; row++) {
            for (int column = startPointOff[1]; column <= finishPointOff[1]; column++) {
                expectedGrid[row][column].turnOff();
            }
        }

        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_toggle_function_works_correctly() {
        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(10, 10);
        int[] startPointOn = {3,3};
        int[] finishPointOn = {5,5};
        grid.turnOnLights(actualGrid, startPointOn, finishPointOn);

        int[] startPointToggle = {2,2};
        int[] finishPointToggle = {4,4};
        grid.toggleLights(actualGrid, startPointToggle, finishPointToggle);

        Light[][] expectedGrid = new Light[10][10];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                expectedGrid[row][column] = light;
            }
        }

        for (int row = startPointOn[1]; row <= finishPointOn[0]; row++) {
            for (int column = startPointOn[1]; column <= finishPointOn[1]; column++) {
                expectedGrid[row][column].turnOn();
            }
        }

        for (int row = startPointToggle[1]; row <= finishPointToggle[0]; row++) {
            for (int column = startPointToggle[1]; column <= finishPointToggle[1]; column++) {
                expectedGrid[row][column].toggle();
            }
        }
        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_count_lights_on_method_works_correctly() {
        Grid grid = new Grid();
        Light[][] matrix = grid.create(10, 10);
        int[] startPosition = {1,3};
        int[] finishPosition = {3,6};
        matrix = grid.turnOnLights(matrix, startPosition, finishPosition);
        int actualLightsOn = grid.countLightsOn(matrix);
        int expectedLightsOn = 12;
        assertThat(actualLightsOn).isEqualTo(expectedLightsOn);
    }
}
