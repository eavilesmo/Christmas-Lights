public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        Light[][] matrixOfLights = grid.create(1000, 1000);

        // turn on 887,9 through 959,629
        int[] startPosition = {887,9};
        int[] finishPosition = {959,629};
        matrixOfLights = grid.turnOnLights(matrixOfLights, startPosition, finishPosition);

        // turn on 454,398 through 844,448
        int[] startPosition1 = {454,398};
        int[] finishPosition1 = {844,448};
        matrixOfLights = grid.turnOnLights(matrixOfLights, startPosition1, finishPosition1);

        // turn off 539,243 through 559,965
        int[] startPosition2 = {539,243};
        int[] finishPosition2 = {559,965};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPosition2, finishPosition2);

        // turn off 370,819 through 676,868
        int[] startPosition3 = {370,819};
        int[] finishPosition3 = {676,868};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPosition3, finishPosition3);

        // turn off 145,40 through 370,997
        int[] startPosition4 = {145,40};
        int[] finishPosition4 = {370,997};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPosition4, finishPosition4);

        // turn off 301,3 through 808,453
        int[] startPosition5 = {301,3};
        int[] finishPosition5 = {808,453};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPosition5, finishPosition5);

        // turn on 351,678 through 951,908
        int[] startPosition6 = {351,678};
        int[] finishPosition6 = {951,908};
        matrixOfLights = grid.turnOnLights(matrixOfLights, startPosition6, finishPosition6);

        // toggle 720,196 through 897,994
        int[] startPosition7 = {720,196};
        int[] finishPosition7 = {897,994};
        matrixOfLights = grid.toggleLights(matrixOfLights, startPosition7, finishPosition7);

        // toggle 831,394 through 904,860
        int[] startPosition8 = {831,394};
        int[] finishPosition8 = {904,860};
        matrixOfLights = grid.turnOnLights(matrixOfLights, startPosition8, finishPosition8);

        int lightsOn = grid.countLightsOn(matrixOfLights);
        System.out.println(lightsOn + " lights are on");

        Light[][] nexMatrix = grid.create(10, 10);
        int[] start = {1,3};
        int[] finish = {3,6};
        nexMatrix = grid.turnOnLights(nexMatrix, start, finish);
        nexMatrix = grid.turnOffLights(nexMatrix, start, finish);
        nexMatrix = grid.toggleLights(nexMatrix, start, finish);

        int lightsOnTest = grid.countLightsOn(nexMatrix);
        System.out.println(lightsOnTest + " lights are on");

    }
}
