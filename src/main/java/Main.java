public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        Light[][] matrixOfLights = grid.create(1000, 1000);

        // turn on 887,9 through 959,629
        int[] startPoint = {887,9};
        int[] finishPoint = {959,629};
        matrixOfLights = grid.turnOnLights(matrixOfLights, startPoint, finishPoint);

        // turn on 454,398 through 844,448
        int[] startPoint1 = {454,398};
        int[] finishPoint1 = {844,448};
        matrixOfLights = grid.turnOnLights(matrixOfLights, startPoint1, finishPoint1);

        // turn off 539,243 through 559,965
        int[] startPoint2 = {539,243};
        int[] finishPoint2 = {559,965};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPoint2, finishPoint2);

        // turn off 370,819 through 676,868
        int[] startPoint3 = {370,819};
        int[] finishPoint3 = {676,868};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPoint3, finishPoint3);

        // turn off 145,40 through 370,997
        int[] startPoint4 = {145,40};
        int[] finishPoint4 = {370,997};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPoint4, finishPoint4);

        // turn off 301,3 through 808,453
        int[] startPoint5 = {301,3};
        int[] finishPoint5 = {808,453};
        matrixOfLights = grid.turnOffLights(matrixOfLights, startPoint5, finishPoint5);

        // turn on 351,678 through 951,908
        int[] startPoint6 = {351,678};
        int[] finishPoint6 = {951,908};
        matrixOfLights = grid.turnOnLights(matrixOfLights, startPoint6, finishPoint6);

        // toggle 720,196 through 897,994
        int[] startPoint7 = {720,196};
        int[] finishPoint7 = {897,994};
        matrixOfLights = grid.toggleLights(matrixOfLights, startPoint7, finishPoint7);

        // toggle 831,394 through 904,860
        int[] startPoint8 = {831,394};
        int[] finishPoint8 = {904,860};
        matrixOfLights = grid.toggleLights(matrixOfLights, startPoint8, finishPoint8);


        int lightsOn = grid.countLightsOn(matrixOfLights);
        System.out.println(lightsOn +" lights are on");

    }
}
