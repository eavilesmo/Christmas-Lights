public class Grid {

    private int rows = 0;
    private int columns = 0;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    private Light[][] lightsMatrix;

    public void create() {
        lightsMatrix = new Light[rows][columns];
        for (int row = 0; row < lightsMatrix.length; row++) {
            for (int column = 0; column < lightsMatrix[row].length; column++) {
                Light light = new Light();
                lightsMatrix[row][column] = light;
            }
        }
    }

    public void turnOnLights(int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                lightsMatrix[row][column].turnOn();
            }
        }
    }

    public void turnOffLights(int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                lightsMatrix[row][column].turnOff();
            }
        }
    }

    public void toggleLights(int[] startPosition, int[] finishPosition) {
        for (int row = startPosition[0]; row <= finishPosition[0]; row++) {
            for (int column = startPosition[1]; column <= finishPosition[1]; column++) {
                lightsMatrix[row][column].toggle();
            }
        }
    }

    public int countLightsOn() {
        int lightsOn = 0;
        for (Light[] listOfLights : lightsMatrix) {
            for (Light light : listOfLights) {
                if (light.isOn) {
                    lightsOn++;
                }
            }
        }
        return lightsOn;
    }

    public Light[][] getLightsMatrix() {
        return lightsMatrix;
    }
}
