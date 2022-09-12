public class Grid {

    private int rows = 0;
    private int columns = 0;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    private Light[][] matrix;

    public Light[][] create() {
        matrix = new Light[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                Light light = new Light();
                matrix[row][column] = light;
            }
        }
        return matrix;
    }

    public Light[][] turnOnLights(int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                matrix[row][column].turnOn();
            }
        }
        return matrix;
    }

    public Light[][] turnOffLights(int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                matrix[row][column].turnOff();
            }
        }
        return matrix;
    }

    public Light[][] toggleLights(int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                matrix[row][column].toggle();
            }
        }
        return matrix;
    }

    public int countLightsOn() {
        int lightsOn = 0;
        for (Light[] listOfLights : matrix) {
            for (Light light : listOfLights) {
                if (light.isOn) {
                    lightsOn++;
                }
            }
        }
        return lightsOn;
    }
}
