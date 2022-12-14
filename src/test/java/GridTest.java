import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    @Test
    void check_grid_is_filled_with_lights() {
        // arrange
        Grid grid = new Grid(2, 2);
        boolean areLightsOn = false;
        Light[][] expectedGrid = createExpectedGrid(2, 2, areLightsOn);

        // act
        grid.create();
        Light[][] actualGrid = grid.getLightsMatrix();

        // assert
        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_all_lights_in_grid_are_turned_on() {
        // arrange
        boolean areLightsOn = true;
        Light[][] expectedGrid = createExpectedGrid(2, 2, areLightsOn);

        Grid grid = new Grid(2, 2);
        grid.create();
        int[] startPosition = {0,0};
        int[] finishPosition = {1,1};

        // act
        grid.turnOnLights(startPosition, finishPosition);
        Light[][] actualGrid = grid.getLightsMatrix();

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

        expectedGrid = turnOnExpectedGrid(expectedGrid, startPosition, finishPosition);

        Grid grid = new Grid(10, 10);
        grid.create();

        // act
        grid.turnOnLights(startPosition, finishPosition);
        Light[][] actualGrid = grid.getLightsMatrix();

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

        expectedGrid = turnOffExpectedGrid(expectedGrid, startPositionOff, finishPositionOff);

        Grid grid = new Grid(10, 10);
        grid.create();
        grid.turnOnLights(startPositionOn, finishPositionOn);

        // act
        grid.turnOffLights(startPositionOff, finishPositionOff);
        Light[][] actualGrid = grid.getLightsMatrix();

        // assert
        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_toggle_function_works_correctly() {
        // arrange
        int[] startPositionOn = {3,3};
        int[] finishPositionOn = {5,5};


        int[] startPositionToggle = {2,2};
        int[] finishPositionToggle = {4,4};

        boolean areLightsOn = false;
        Light[][] expectedGrid = createExpectedGrid(10, 10, areLightsOn);

        expectedGrid = turnOnExpectedGrid(expectedGrid, startPositionOn, finishPositionOn);
        expectedGrid = toggleExpectedGrid(expectedGrid, startPositionToggle, finishPositionToggle);

        Grid grid = new Grid(10, 10);
        grid.create();
        grid.turnOnLights(startPositionOn, finishPositionOn);

        // act
        grid.toggleLights(startPositionToggle, finishPositionToggle);
        Light[][] actualGrid = grid.getLightsMatrix();

        // assert
        assertThat(actualGrid).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedGrid);
    }

    @Test
    void check_that_count_lights_on_method_works_correctly() {
        // arrange
        int expectedLightsOn = 12;
        Grid grid = new Grid(10, 10);
        grid.create();
        int[] startPosition = {1,3};
        int[] finishPosition = {3,6};
        grid.turnOnLights(startPosition, finishPosition);

        // act
        int actualLightsOn = grid.countLightsOn();

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

    private Light[][] turnOnExpectedGrid(Light[][] expectedGrid, int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                expectedGrid[row][column].turnOn();
            }
        }
        return expectedGrid;
    }

    private Light[][] turnOffExpectedGrid(Light[][] expectedGrid, int[] startPositionOff, int[] finishPositionOff) {
        for (int row = startPositionOff[0]; row <= finishPositionOff[0]; row++) {
            for (int column = startPositionOff[1]; column <= finishPositionOff[1]; column++) {
                expectedGrid[row][column].turnOff();
            }
        }
        return expectedGrid;
    }

    private Light[][] toggleExpectedGrid(Light[][] expectedGrid, int[] startPositionToggle, int[] finishPositionToggle) {
        for (int row = startPositionToggle[1]; row <= finishPositionToggle[0]; row++) {
            for (int column = startPositionToggle[1]; column <= finishPositionToggle[1]; column++) {
                expectedGrid[row][column].toggle();
            }
        }
        return expectedGrid;
    }
}
