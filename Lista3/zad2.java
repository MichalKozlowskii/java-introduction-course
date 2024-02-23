import java.util.*;

public class Main {

    public static List<Integer> findDuplicates(List<Integer> lst) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : lst) {
            if (!set.add(num) && !result.contains(num)) {
                result.add(num);
            }
        }

        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> lst = List.of(0, 1, 1, 1, 4, 4, 4, 9, 3, 3, 3, 3, 3, 3);

        System.out.println("Before: " + lst);
        System.out.println("After: " + findDuplicates(lst));
    }
}
