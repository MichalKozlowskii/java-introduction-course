import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> repeatString = (s, i) -> {
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < i; j++) {
                result.append(s);
            }

            return result.toString();
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input text:");
        String text = scanner.nextLine();

        System.out.println("Input amount of times text should be printed:");
        int n = scanner.nextInt();

        System.out.println(repeatString.apply(text, n));
    }
}