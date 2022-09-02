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
        for (int row = startPosition[0]; row < finishPosition[0]; row++) {
            for (int column = startPosition[1]; column < finishPosition[1]; column++) {
                matrix[row][column].turnOn();
            }
        }
        return matrix;
    }
}
