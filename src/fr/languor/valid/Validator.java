package fr.languor.valid;

import java.util.ArrayList;

public class Validator {

    private static int REFERENCE_LENGTH = 10;
    private static String[] COLOR_VALUES = {"R", "G", "B"};

    public static Boolean checkColorValues(String color) {
        if (color.length() == 0 || color.length() > 1) {
            return false;
        } else {
            ArrayList<Boolean> bools = new ArrayList();
            for (int i = 0; i < COLOR_VALUES.length; i++) {
                String oneValue = COLOR_VALUES[i];
                if (oneValue.equals(color)) {
                    bools.add(true);
                }
            }

            if (bools.size() != 1) {
                return false;
            }
            return true;
        }
    }

    public static Boolean checkReferenceLenght(String refToCheck) {
        return refToCheck.length() != 0 || refToCheck.length() == REFERENCE_LENGTH;
    }
}
