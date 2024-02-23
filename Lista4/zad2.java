import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static int suma(List<Integer> a) {
        int sum = a
                .stream()
                .filter(num -> num >= 0)
                .reduce(0, (num1, num2) -> num1 + num2); // albo .sum()

        return sum;
    }
    public static void main(String[] args) {
        List <Integer> a = List.of( 1, -4, 12, 0, -3, 29, -150);

        System.out.println("Lista: " + a);
        System.out.println("Suma dodatnich z listy: " + suma(a));
    }
}
