import java.util.Scanner;
import java.util.HashMap;

public class StepTracker {
    static int newStep;
    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
        newStep = 10000;    //целевой показатель - желаемое количество шагов за 1 день
    }

    void print1(int month) {    //печать информации за выбранный месяц
        MonthData objMonthData = monthToData.get(month);
        objMonthData.printData(month);
    }

    void inputStep() {   //ввод месяца, дня и шагов
        Scanner scanner = new Scanner(System.in);
        int numberMonth = 0;
        int numberDay = 0;
        int varStep = 0;
        System.out.println("Введите порядковый номер месяца в который желайте внести данные");
        numberMonth = scanner.nextInt();
        while (numberMonth > 12 || numberMonth < 1) {
            System.out.println("Число вне тербуемого диапазона, введите снова число");
            numberMonth = scanner.nextInt();
        }
        System.out.println("Введите число в данном месце по которому желайте внести данне о пройденых шагах (от 1 до 30)");
        numberDay = scanner.nextInt();
        while (numberDay > 30 || numberDay < 1) {
            System.out.println("Число вне тербуемого диапазона, введите снова число");
            numberDay = scanner.nextInt();
        }
        System.out.println("Введите количество шагов пройденых в этот день");
        varStep = scanner.nextInt();    //Считывает число шаго в выбранном дне
        while (varStep < 0) {

            System.out.println("Число вне тербуемого диапазона");
            varStep = scanner.nextInt();    //Считывает число шаго в выбранном дне
        }
        MonthData myMonthData = monthToData.get(numberMonth);
        myMonthData.addData(numberDay - 1, varStep);
        monthToData.put(numberMonth - 1, myMonthData);
        System.out.println("Данные внесены.");
        System.out.println();
    }

    void changePurpose() {   //изменение цели по количеству шагов
        System.out.println("Введите цель - желаемое количество шагов за 1  день");
        Scanner scanner = new Scanner(System.in);
        newStep = scanner.nextInt();    //Считывает новую цель по шагам в день
        System.out.println("Цель (желаемое количество шагов за 1  день) - изменена.");
        System.out.println();
    }

    void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("Внести данные о пройденых шагах за опредленный день, введите: input");
        System.out.println("Изменить цель - количество желаемых шагов в 1 день, введите: change");
        System.out.println("Вывести статистику за все мясяца, введите: print");
        System.out.println("Выйти из программы, введите: exit");
    }
}


