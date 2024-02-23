import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String getDivisibility(int num) {
        int[] divisors = {3, 5, 7, 11, 13, 15, 21};

        HashMap<Integer, String> dict = new HashMap<>();
        dict.put(3, "trzy");
        dict.put(5, "pięć");
        dict.put(7, "siedem");
        dict.put(11, "jedenaście");
        dict.put(13, "trzynaście");
        dict.put(15, "piętnaście");
        dict.put(21, "dwadzieściajeden");

        List<Integer> divisibles = new ArrayList<Integer>();

        for (int divisor : divisors) {
            if (num % divisor == 0) {
                divisibles.add(divisor);
            }
        }

        String result = "";

        for (int divisable : divisibles) {
            result += dict.get(divisable);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println("Podzielne przez: " + getDivisibility(num));
    }
}