import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static <T> List<T> tailToHead(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        List<T> result = new ArrayList<>(Collections.singletonList(list.get(list.size() - 1)));
        result.addAll(list.subList(0, list.size() - 1));

        return result;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Before swap");
        System.out.println(test);

        System.out.println("After swap");
        System.out.println(tailToHead(test));
    }
}