public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(1000, 1000);
        grid.create();
        Light[][] lightsMatrix = grid.getLightsMatrix();

        // turn on 887,9 through 959,629
        int[] startPosition = {887,9};
        int[] finishPosition = {959,629};
        grid.turnOnLights(startPosition, finishPosition);

        // turn on 454,398 through 844,448
        int[] startPosition1 = {454,398};
        int[] finishPosition1 = {844,448};
        grid.turnOnLights(startPosition1, finishPosition1);

        // turn off 539,243 through 559,965
        int[] startPosition2 = {539,243};
        int[] finishPosition2 = {559,965};
        grid.turnOffLights(startPosition2, finishPosition2);

        // turn off 370,819 through 676,868
        int[] startPosition3 = {370,819};
        int[] finishPosition3 = {676,868};
        grid.turnOffLights(startPosition3, finishPosition3);

        // turn off 145,40 through 370,997
        int[] startPosition4 = {145,40};
        int[] finishPosition4 = {370,997};
        grid.turnOffLights(startPosition4, finishPosition4);

        // turn off 301,3 through 808,453
        int[] startPosition5 = {301,3};
        int[] finishPosition5 = {808,453};
        grid.turnOffLights(startPosition5, finishPosition5);

        // turn on 351,678 through 951,908
        int[] startPosition6 = {351,678};
        int[] finishPosition6 = {951,908};
        grid.turnOnLights(startPosition6, finishPosition6);

        // toggle 720,196 through 897,994
        int[] startPosition7 = {720,196};
        int[] finishPosition7 = {897,994};
        grid.toggleLights(startPosition7, finishPosition7);

        // toggle 831,394 through 904,860
        int[] startPosition8 = {831,394};
        int[] finishPosition8 = {904,860};
        grid.toggleLights(startPosition8, finishPosition8);


        int lightsOn = grid.countLightsOn();
        System.out.println(lightsOn +" lights are on");

    }
}
