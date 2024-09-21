import java.util.Scanner;

public class StepTracker {
    public static final int MONTHS_IN_YEAR = 12;
    public static final String PRINT_MONTH_NUMBER = "Введите номер месяца: ";
    public static final String CONDITION_FOR_THE_MONTH = "Номер вводимого месяца должен быть от 1 до 12 включительно";
    public static final String PRINT_DAY_NUMBER = "Введите номер дня: ";
    public static final String CONDITION_FOR_THE_DAY = "Номер вводимого дня должен быть от 1 до 30 включительно";
    public static final String QUESTION_ABOUT_STEPS = "Сколько шагов вы прошли?";
    public static final String CONDITION_FOR_THE_STEPS = "Количество шагов должно быть положительным числом";
    public static final String FINISH = "Данные записаны!";
    public static final String PRINT_NEW_GOAL = "Введите новую цель: ";
    public static final String CONDITION_FOR_THE_GOAL = "Цель должна быть больше нуля";

    MonthData[] monthToData = new MonthData[MONTHS_IN_YEAR];
    Scanner scanner;
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scanner) {
        this.scanner = scanner;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println(PRINT_MONTH_NUMBER);
        int month = scanner.nextInt();
        if ((month < 1) || (month > 12)) {
            System.out.println(CONDITION_FOR_THE_MONTH);
            return;
        }
        System.out.println(PRINT_DAY_NUMBER);
        int day = scanner.nextInt();
        if ((day < 1) || (day > 30)) {
            System.out.println(CONDITION_FOR_THE_DAY);
            return;
        }
        System.out.println(QUESTION_ABOUT_STEPS);
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println(CONDITION_FOR_THE_STEPS);
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        System.out.println(FINISH);
    }

    void changeStepGoal() {
        System.out.println(PRINT_NEW_GOAL);
        int newGoal = scanner.nextInt();
        if (newGoal < 0) {
            System.out.println(CONDITION_FOR_THE_STEPS);
            return;
        }
        if (newGoal == 0) {
            System.out.println(CONDITION_FOR_THE_GOAL);
            return;
        }
        goalByStepsPerDay = newGoal;
    }

    void printStatistic() {
        System.out.println(PRINT_MONTH_NUMBER);
        int month = scanner.nextInt();
        if ((month < 1) || (month > 12)) {
            System.out.println(CONDITION_FOR_THE_MONTH);
            return;
        }
        MonthData monthData = monthToData[month - 1];
        int sum = monthData.sumStepsFromMonth();
        System.out.println("Статистика за выбранный месяц: ");
        System.out.println("Количество пройденных шагов по дням: ");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sum);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов: " + (sum / 30));
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(sum));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sum));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println("");
    }


}



