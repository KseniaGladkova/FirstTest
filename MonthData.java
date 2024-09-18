
public class MonthData {
    int[] days = new int[30];

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
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                    currentSeries = 0;
                    continue;
                } else {
                    currentSeries = 0;
                    continue;
                }
            }
        }
        return finalSeries;
    }


}

