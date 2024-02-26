import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, Integer> countElements(List<List<String>> lst) {
        Map<String, Integer> result = new HashMap<>();

        for (List<String> innerList : lst) {
            for (String element : innerList) {
                result.put(element, result.getOrDefault(element, 0) + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> nestedList = List.of(
                List.of("a", "b", "c"),
                List.of("c", "d", "f"),
                List.of("d", "f", "g")
        );

        System.out.println(countElements(nestedList));
    }
}