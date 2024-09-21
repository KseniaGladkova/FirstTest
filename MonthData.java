
public class MonthData {
    public static final int DAYS_IN_MONTH = 30;
    int[] days = new int[DAYS_IN_MONTH];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sum = 0;
        for (int i = 0; i < days.length; i++) {
            sum = sum + days[i];
        }
        return sum;
    }

    int maxSteps() {
        int max = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > max) {
                max = days[i];
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
                continue;
            }
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
                currentSeries = 0;
                continue;
            }
            currentSeries = 0;
            continue;

        }
        return finalSeries;
    }
}

