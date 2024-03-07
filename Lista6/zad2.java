import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Main {

    public static <T> boolean isSorted(List<T> aa, BiPredicate<T, T> ordered) {
        if (aa == null || aa.isEmpty() || ordered == null) {
            return false;
        }

        for (int i = 0; i < aa.size() - 1; i++) {
            T current = aa.get(i);
            T next = aa.get(i + 1);

            if (!ordered.test(current, next)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        BiPredicate<Integer, Integer> isAscending = (a, b) -> a <= b;
        System.out.println(isSorted(numbers, isAscending));

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        BiPredicate<String, String> isLexicographic = (a, b) -> a.compareTo(b) <= 0;
        System.out.println(isSorted(words, isLexicographic));
    }
}