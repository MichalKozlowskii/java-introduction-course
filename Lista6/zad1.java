import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <T> List<T> getTail(List<T> list) {
        if (list == null || list.isEmpty() || list.size() == 1) {
            return new ArrayList<>();
        }
        return list.subList(1, list.size());
    }

    public static <T> T getHead(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3);

        System.out.println(integerList);

        List<Integer> tail = getTail(integerList);
        System.out.println("Tail: " + tail);

        int head = getHead(integerList);
        System.out.println("Head: " + head);
    }
}