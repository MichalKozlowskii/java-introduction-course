import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static Map<String, Integer> countElements(List<List<String>> inputList) {
        return inputList.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        e -> e,
                        HashMap::new,
                        Collectors.summingInt(e -> 1)
                ));
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