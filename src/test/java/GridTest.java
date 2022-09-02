import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

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
        int[] startPosition = {0,0};
        int[] finishPosition = {1,1};
        actualGrid = grid.turnOnLights(actualGrid, startPosition, finishPosition);
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
        int[] startPosition = {3,5};
        int[] finishPosition = {4,7};
        grid.turnOnLights(actualGrid, startPosition, finishPosition);

        Light[][] expectedGrid = new Light[10][10];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                expectedGrid[row][column] = light;
            }
        }

        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                expectedGrid[row][column].turnOn();
            }
        }

        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_only_certain_lights_are_off() {
        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(10, 10);
        int[] startPositionOn = {0,0};
        int[] finishPositionOn = {9,9};
        grid.turnOnLights(actualGrid, startPositionOn, finishPositionOn);

        int[] startPositionOff = {1,2};
        int[] finishPositionOff = {6,7};
        grid.turnOffLights(actualGrid, startPositionOff, finishPositionOff);

        Light[][] expectedGrid = new Light[10][10];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                light.turnOn();
                expectedGrid[row][column] = light;
            }
        }

        for (int row = startPositionOff[0]; row <= finishPositionOff[0]; row++) {
            for (int column = startPositionOff[1]; column <= finishPositionOff[1]; column++) {
                expectedGrid[row][column].turnOff();
            }
        }

        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_toggle_function_works_correctly() {
        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(10, 10);
        int[] startPositionOn = {3,3};
        int[] finishPositionOn = {5,5};
        grid.turnOnLights(actualGrid, startPositionOn, finishPositionOn);

        int[] startPositionToggle = {2,2};
        int[] finishPositionToggle = {4,4};
        grid.toggleLights(actualGrid, startPositionToggle, finishPositionToggle);

        Light[][] expectedGrid = new Light[10][10];
        for (int row = 0; row < expectedGrid.length; row++) {
            for (int column = 0; column < expectedGrid[row].length; column++) {
                Light light = new Light();
                expectedGrid[row][column] = light;
            }
        }

        for (int row = startPositionOn[1]; row <= finishPositionOn[0]; row++) {
            for (int column = startPositionOn[1]; column <= finishPositionOn[1]; column++) {
                expectedGrid[row][column].turnOn();
            }
        }

        for (int row = startPositionToggle[1]; row <= finishPositionToggle[0]; row++) {
            for (int column = startPositionToggle[1]; column <= finishPositionToggle[1]; column++) {
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
