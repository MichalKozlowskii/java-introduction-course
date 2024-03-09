import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static <T> List<T> dropWhile(List<T> list, Predicate<T> predicate) {
        if (list == null || list.isEmpty() || predicate == null) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        while (i < list.size() && predicate.test(list.get(i))) {
            i++;
        }

        return list.subList(i, list.size());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 3, 2, 1, 9);
        Predicate<Integer> lessThanThree = (i) -> i < 3;
        List<Integer> result = dropWhile(list, lessThanThree);

        System.out.println("Before");
        System.out.println(list);

        System.out.println("After");
        System.out.println(result);
    }
}