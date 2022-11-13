import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год, месяц и день:");
        LocalDate data = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println(data.getDayOfWeek());
        LocalDate today = LocalDate.now();
        while (today.getDayOfWeek() != DayOfWeek.TUESDAY) {
            today = today.plusDays(1);
        }
        System.out.println(today);

        Predicate<String> isCorrect = str -> ((str.charAt(0) == 'J') || (str.charAt(0) == 'N')) && (str.charAt(str.length() - 1) == 'A');
        System.out.println(isCorrect.test(scanner.next()));
        Consumer<Box> weightOfBox = box -> System.out.println("Отгрузили ящик весом " + box.weight);
        weightOfBox.accept(new Box(6));
        Function<Integer, String> value = digit -> {
            String result;
            if (digit > 0) {
                result = "Положительное";
            } else if (digit == 0) {
                result = "Ноль";
            } else {
                result = "Отрицательное";
            }
            return result;
        };
        System.out.println(value.apply(-5));
        Supplier<Integer> randomInt = () -> new Random().nextInt(1, 11);
        System.out.println(randomInt.get());
    }
}