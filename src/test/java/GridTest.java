import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    @Test
    void check_grid_is_filled_with_lights() {
        // arrange
        Grid grid = new Grid();
        boolean areLightsOn = false;
        Light[][] expectedGrid = createExpectedGrid(2, 2, areLightsOn);

        // act
        Light[][] actualGrid = grid.create(2, 2);

        // assert
        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_all_lights_in_grid_are_turned_on() {
        // arrange
        boolean areLightsOn = true;
        Light[][] expectedGrid = createExpectedGrid(2, 2, areLightsOn);

        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(2, 2);
        int[] startPosition = {0,0};
        int[] finishPosition = {1,1};

        // act
        actualGrid = grid.turnOnLights(actualGrid, startPosition, finishPosition);

        // assert
        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_only_certain_lights_are_on(){
        // arrange
        int[] startPosition = {3,5};
        int[] finishPosition = {4,7};

        boolean areLightsOn = false;
        Light[][] expectedGrid = createExpectedGrid(10, 10, areLightsOn);

        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                expectedGrid[row][column].turnOn();
            }
        }

        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(10, 10);

        // act
        grid.turnOnLights(actualGrid, startPosition, finishPosition);

        // assert
        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_only_certain_lights_are_off() {
        // arrange
        int[] startPositionOn = {0,0};
        int[] finishPositionOn = {9,9};
        int[] startPositionOff = {1,2};
        int[] finishPositionOff = {6,7};

        boolean areLightsOn = true;
        Light[][] expectedGrid = createExpectedGrid(10, 10, areLightsOn);

        for (int row = startPositionOff[0]; row <= finishPositionOff[0]; row++) {
            for (int column = startPositionOff[1]; column <= finishPositionOff[1]; column++) {
                expectedGrid[row][column].turnOff();
            }
        }

        Grid grid = new Grid();
        Light[][] actualGrid = grid.create(10, 10);
        grid.turnOnLights(actualGrid, startPositionOn, finishPositionOn);

        // act
        grid.turnOffLights(actualGrid, startPositionOff, finishPositionOff);

        // assert
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

        boolean areLightsOn = false;
        Light[][] expectedGrid = createExpectedGrid(10, 10, areLightsOn);

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
        // arrange
        int expectedLightsOn = 12;
        Grid grid = new Grid();
        Light[][] matrix = grid.create(10, 10);
        int[] startPosition = {1,3};
        int[] finishPosition = {3,6};
        matrix = grid.turnOnLights(matrix, startPosition, finishPosition);

        // act
        int actualLightsOn = grid.countLightsOn(matrix);

        // assert
        assertThat(actualLightsOn).isEqualTo(expectedLightsOn);
    }

    private Light[][] createExpectedGrid(int rows, int columns, boolean areLightsOn) {
        Light[][] expectedGrid = new Light[rows][columns];
        if (areLightsOn) {
            for (int row = 0; row < expectedGrid.length; row++) {
                for (int column = 0; column < expectedGrid[row].length; column++) {
                    Light light = new Light();
                    light.turnOn();
                    expectedGrid[row][column] = light;
                }
            }
        }
        else {
            for (int row = 0; row < expectedGrid.length; row++) {
                for (int column = 0; column < expectedGrid[row].length; column++) {
                    Light light = new Light();
                    expectedGrid[row][column] = light;
                }
            }
        }
        return expectedGrid;
    }
}
