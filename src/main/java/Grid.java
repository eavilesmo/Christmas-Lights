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

    public Light[][] turnOnLights(Light[][] matrix) {
        for (Light[] listOfLights : matrix) {
            for (Light light : listOfLights) {
                light.turnOn();
            }
        }
        return matrix;
    }
}
