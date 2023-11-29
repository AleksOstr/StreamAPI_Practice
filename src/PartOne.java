import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    /*
     * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
     * 1.1 Найти максимальное
     * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
     * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
     */
    public static void main(String[] args) {
        // 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        List<Integer> ints = new Random().ints(1_000, 1, 1_000_000)
                .boxed().toList();
        // 1.1 Найти максимальное
        System.out.println(ints.stream().max(Comparator.comparing(Integer::intValue)));

        // 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        System.out.println(ints.stream()
                .filter(num -> num > 500_000)
                .map(num -> num * 5 - 150)
                .mapToInt(num -> num)
                .sum());

        // 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        System.out.println(ints.stream().filter(num -> num * num < 100_000).count());
    }


}
