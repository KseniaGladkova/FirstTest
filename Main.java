
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        System.out.println("Здравствуйте!");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
                continue;
            }
            if (command == 2) {
                stepTracker.changeStepGoal();
                System.out.println("Цель изменена!");
                continue;
            }
            if (command == 3) {
                stepTracker.printStatistic();
                continue;
            }
            if (command == 0) {
                System.out.println("Всего доброго! Ждём вас снова!" + '♥');
                break;
            }
            System.out.println("Извините, такой команды нет.");

        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определённый месяц");
        System.out.println("0 - Выйти из приложения");
    }
}





