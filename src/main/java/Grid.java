public class Grid {

    public Light[][] create(int rows, int columns) {
        Light[][] matrix = new Light[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                Light light = new Light();
                matrix[row][column] = light;
            }
        }
        return matrix;
    }

    public Light[][] turnOnLights(Light[][] matrix, int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            if (row == startPosition[0] && finishPosition[0] != row){
                for (int column = startPosition[1]; column < matrix[row].length; column++) {
                    matrix[row][column].turnOn();
                }
            } else if (row == finishPosition[0]){
                for (int column = 0; column <= finishPosition[1]; column++) {
                    matrix[row][column].turnOn();
                }
            } else {
                for (int column = 0; column < matrix[row].length; column++) {
                    matrix[row][column].turnOn();
                }
            }
        }
        return matrix;
    }

    public Light[][] turnOffLights(Light[][] matrix, int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            if (row == startPosition[0] && finishPosition[0] != row){
                for (int column = startPosition[1]; column < matrix[row].length; column++) {
                    matrix[row][column].turnOff();
                }
            } else if (row == finishPosition[0]){
                for (int column = 0; column <= finishPosition[1]; column++) {
                    matrix[row][column].turnOff();
                }
            } else {
                for (int column = 0; column < matrix[row].length; column++) {
                    matrix[row][column].turnOff();
                }
            }
        }
        return matrix;
    }

    public Light[][] toggleLights(Light[][] matrix, int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            if (row == startPosition[0] && finishPosition[0] != row){
                for (int column = startPosition[1]; column < matrix[row].length; column++) {
                    matrix[row][column].toggle();
                }
            } else if (row == finishPosition[0]){
                for (int column = 0; column <= finishPosition[1]; column++) {
                    matrix[row][column].toggle();
                }
            } else {
                for (int column = 0; column < matrix[row].length; column++) {
                    matrix[row][column].toggle();
                }
            }
        }
        return matrix;
    }

    public int countLightsOn(Light[][] matrix) {
        int lightsOn = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column].isOn) {
                    lightsOn++;
                }
            }
        }
        return lightsOn;
    }
}
