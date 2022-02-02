import java.util.ArrayList;

class MonthData {
    int days[];

    void addData(int day, int step) {
        days = new int[30];
        days[day] = step;
    }

    void printData(int month) {
        int sum = 0;
        int maxInMonth = 0;
        Converter myConverter = new Converter();  //создали экземпляр класса, для расчета количества калорий, и пересчета в км.
        for (int i = 0; i < 29; i++) {
            System.out.print(" день " + (i + 1) + ": " + days[i] + "; ");
            sum = sum + days[i];            // все пройденное расстояние за месяц - шагов
            if (days[i] > maxInMonth) {     // ищем день когда пройден максимум - шагов
                maxInMonth = days[i];
            }
        }
        System.out.println("Общее количество шагов за за месяц №:" + (month) + ": " + sum);
        System.out.println("Среднее количество шагов за месяц №:" + (month) + ": " + sum / 30);
        System.out.println("Максимальное количество шагов в месяце №:" + (month) + ": " + maxInMonth);
        System.out.println("Пройденная дистанция,(км) в месяце №:" + (month) + ": " + myConverter.stepToMeter(sum));
        System.out.println("Потраченое количество калорий,(кал) за месяц " + (month) + ": " + myConverter.calory(sum));
        bestDay(month);
    }

    void bestDay(int month) {
        int numVar = 0;         // переменная для временного хранения кол-ва подряд идущих дней > целевого (newStep) после каждого дня где >newStep
        ArrayList<Integer> seriesDay = new ArrayList<>();   //создаем список для храранения отрезков дней (количества подряд идущих дней)
        for (int i = 0; i < 30; i++) {      // ищем все отрезки дней с шагами > целевого (newStep) в выбранно месяце
            if (days[i] > StepTracker.newStep) {
                numVar++;
                if (days[i + 1] < StepTracker.newStep) {
                    seriesDay.add(numVar);      //запись найденного отрезка дней с шагами > целевого (newStep) в список
                }
            }
        }
        int seriesMax = 0;    // максимальный отрезок (количество дней > целевого (newStep)) в в выбранно месяце
        if (seriesDay.isEmpty()) { // Проверяем пуст список или нет
            System.out.println("В этом месяце небыло дней с превышением целевого показателя.");
        } else {
            for (int i = 0; i < seriesDay.size(); i++) {
                if (seriesDay.get(i) > seriesMax) {
                    seriesMax = seriesDay.get(i);
                }
            }
        }
        System.out.println("Лучшая серия в месяце № " + month + "  - максимальное кол-во подряд идущих дней с количеством шагов более целевого: " + seriesMax + " - подряд идущих дня.");
        System.out.println();
    }
}
