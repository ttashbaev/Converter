package com.example.timur.converter;

/**
 * Created by Timur on 12.03.2018.
 */

public class MassConverter {

    public double converterMass(int posOne, int posTwo, double value, double result) {
        //double result = 0;

        if (posOne == 0) {
            if (posTwo == 0) {
                result = value;
            }
            if (posTwo == 1) {
                result = value / 100;
            }
            if (posTwo == 2) {
                result = value / 100000;
            }
            if (posTwo == 3) {
                result = value / 100000000;
            }
            if (posTwo == 4) {
                result = value / 453592.3699;
            }
            if (posTwo == 5) {
                result = value / 6350293.1800;
            }
        }


        if (posOne == 1) {
            if (posTwo == 0) {
                result = value / 0.001;
            }
            if (posTwo == 1) {
                result = value;
            }
            if (posTwo == 2) {
                result = value / 1000;
            }
            if (posTwo == 3) {
                result = value / 1000000;
            }
            if (posTwo == 4) {
                result = value / 453.5923;
            }
            if (posTwo == 5) {
                result = value / 6350.2931;

            }
        }

        if (posOne == 2) {
            if (posTwo == 0) {
                result = value / 0.000001;
            }
            if (posTwo == 1) {
                result = value / 0.001;
            }
            if (posTwo == 2) {
                result = value;
            }
            if (posTwo == 3) {
                result = value / 1000;
            }
            if (posTwo == 4) {
                result = value / 0.4535;
            }
            if (posTwo == 5) {
                result = value / 6.3502;
            }
        }


        if (posOne == 3) {
            if (posTwo == 0) {
                result = value / 0.000000001;
            }
            if (posTwo == 1) {
                result = value / 0.000001;
            }
            if (posTwo == 2) {
                result = value / 0.001;
            }
            if (posTwo == 3) {
                result = value;
            }
            if (posTwo == 4) {
                result = value / 0.000453;
            }
            if (posTwo == 5) {
                result = value / 0.0063502;
            }
        }

        if (posOne == 4) {
            if (posTwo == 0) {
                result = value / 0.00000220462262;
            }
            if (posTwo == 1) {
                result = value / 0.00220462262;
            }
            if (posTwo == 2) {
                result = value / 2.20462262;
            }
            if (posTwo == 3) {
                result = value / 2204.62262;
            }
            if (posTwo == 4) {
                result = value;
            }
            if (posTwo == 5) {
                result = value / 14.00000000000017;
            }
        }

        if (posOne == 5) {
            if (posTwo == 0) {
                result = value / 0.000000157473;
            }
            if (posTwo == 1) {
                result = value / 0.000157473044417;
            }
            if (posTwo == 2) {
                result = value / 0.157473044417;
            }
            if (posTwo == 3) {
                result = value / 157.473044417;
            }
            if (posTwo == 4) {
                result = value / 0.071428571428;
            }
            if (posTwo == 5) {
                result = value;
            }
        }
        return result;
    }
}
