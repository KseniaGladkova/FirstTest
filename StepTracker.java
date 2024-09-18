import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
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
        System.out.println("Введите номер месяца: ");
        int month = scanner.nextInt();
        if ((month < 1) || (month > 12)) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            return;
        }
        System.out.println("Введите номер дня: ");
        int day = scanner.nextInt();
        if ((day < 1) || (day > 30)) {
            System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно");
            return;
        }
        System.out.println("Сколько шагов вы прошли?");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов должно быть положительным числом");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        System.out.println("Данные записаны!");
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель: ");
        int newGoal = scanner.nextInt();
        if (newGoal < 0) {
            System.out.println("Количество шагов должно быть положительным");
            return;
        }
        if (newGoal == 0) {
            System.out.println("Цель должна быть больше нуля");
            return;
        }
        goalByStepsPerDay = newGoal;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if ((month < 1) || (month > 12)) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
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



