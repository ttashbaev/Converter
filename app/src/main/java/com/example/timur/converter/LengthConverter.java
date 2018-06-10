package com.example.timur.converter;

/**
 * Created by Timur on 08.03.2018.
 */

public class LengthConverter {

    /*public static double mToKm (double valueOne, double valueTwo) {
        return valueOne/valueTwo;
    }

    public static double mmToKm (double value) {
        return value/1000;
    }*/

    public double converterLength (int posOne, int posTwo, double value, double result) {
        //double result = 0;

        if (posOne == 0) {
            if (posTwo == 0) {
                result = value;
            }
            if (posTwo == 1) {
                result = value / 10;
            }
            if (posTwo == 2) {
                result = value / 1000;
            }
            if (posTwo == 3) {
                result = value / 1000000;
            }
            if (posTwo == 4) {
                result = value / 25.4;
            }
            if (posTwo == 5) {
                result = value / 1609343.99;
            }
        }

        if (posOne == 1) {
            if (posTwo == 0) {
                result = value * 10;
            }
            if (posTwo == 1) {
                result = value;
            }
            if (posTwo == 2) {
                result = value / 100;
            }
            if (posTwo == 3) {
                result = value / 100000;
            }
            if (posTwo == 4) {
                result = value / 2.54;
            }
            if (posTwo == 5) {
                result = value / 160934.4;

            }
        }

        if (posOne == 2) {
            if (posTwo == 0) {
                result = value * 1000;
            }
            if (posTwo == 1) {
                result = value * 100;
            }
            if (posTwo == 2) {
                result = value;
            }
            if (posTwo == 3) {
                result = value / 1000;
            }
            if (posTwo == 4) {
                result = value * 39.37;
            }
            if (posTwo == 5) {
                result = value * 0.00062;
            }
        }


        if (posOne == 3) {
            if (posTwo == 0) {
                result = value * 1000000;
            }
            if (posTwo == 1) {
                result = value * 100000;
            }
            if (posTwo == 2) {
                result = value * 1000;
            }
            if (posTwo == 3) {
                result = value;
            }
            if (posTwo == 4) {
                result = value * 39370.07;
            }
            if (posTwo == 5) {
                result = value / 1.6;
            }
        }

        if (posOne == 4) {
            if (posTwo == 0) {
                result = value * 25.4;
            }
            if (posTwo == 1) {
                result = value * 2.54;
            }
            if (posTwo == 2) {
                result = value / 39.37;
            }
            if (posTwo == 3) {
                result = value / 39370.07;
            }
            if (posTwo == 4) {
                result = value;
            }
            if (posTwo == 5) {
                result = value / 63359.99;
            }
        }

        if (posOne == 5) {
            if (posTwo == 0) {
                result = value * 1609343.99;
            }
            if (posTwo == 1) {
                result = value * 160934.4;
            }
            if (posTwo == 2) {
                result = value * 1609.34;
            }
            if (posTwo == 3) {
                result = value * 1.6;
            }
            if (posTwo == 4) {
                result = value * 63359.99;
            }
            if (posTwo == 5) {
                result = value;
            }
        }
        return result;
    }
}
