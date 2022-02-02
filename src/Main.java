import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StepTracker objStepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        int month = 0;
        boolean isMenue = true;
        String choiceConsole;
        while (isMenue) {
            objStepTracker.printMenu();
            choiceConsole = scanner.next();
            switch (choiceConsole) {
                case "input": {
                    objStepTracker.inputStep();
                    break;
                }
                case "change": {
                    objStepTracker.changePurpose();
                    break;
                }
                case "print": {
                    System.out.println("Введите номер месяца за который вывести статистику:");
                    month = scanner.nextInt();
                    while (month > 12 || month < 1) {
                        System.out.println("Число вне тербуемого диапазона, введите снова число");
                        month = scanner.nextInt();
                    }
                    objStepTracker.print1(month);
                    break;
                }
                case "exit": {
                    System.out.println("Выход");
                    isMenue = false;
                    break;
                }
                default: {
                    System.out.println("Извините такой команды нет, повторите ввод:");
                    break;
                }
            }
        }
    }
}



