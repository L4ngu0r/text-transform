package fr.languor.valid;

import java.util.ArrayList;

public class Validator {

    private static int REFERENCE_LENGTH = 10;
    private static String[] COLOR_VALUES = {"R", "G", "B"};

    public static Boolean checkColorValues(String color) {
        if (color.length() == 0 || color.length() > 1) {
            return false;
        } else {
            ArrayList<Boolean> bools = new ArrayList<Boolean>();
            for (String refColor : COLOR_VALUES) {
                if (refColor.equals(color)) {
                    bools.add(true);
                }
            }

            return bools.size() == 1;
        }
    }

    public static Boolean checkReferenceLength(String refToCheck) {
        return refToCheck.length() != 0 || refToCheck.length() == REFERENCE_LENGTH;
    }
}
