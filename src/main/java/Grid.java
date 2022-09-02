public class Grid {

    public Light[][] create(int rows, int columns) {
        Light[][] matrix = new Light[rows][columns];
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                Light light = new Light();
                matrix[row][column] = light;
            }
        }
        return matrix;
    }
}
