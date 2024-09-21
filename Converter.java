public class Converter {

    private static final  int CENTIMETERS_IN_STEP = 75;
    private static final int CENTIMETERS_IN_KILOMETER = 100000;
    private static final int CALORIES_IN_STEP = 50;
    private static final int CALORIES_IN_KILOCALORIES = 1000;

    int convertToKm(int steps) {
        return (steps * CENTIMETERS_IN_STEP) / CENTIMETERS_IN_KILOMETER;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * CALORIES_IN_STEP) / CALORIES_IN_KILOCALORIES;
    }
}
