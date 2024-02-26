import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<List<String>> srt(List<String> lst) {
        return lst.stream()
                .sorted()
                .collect(Collectors.groupingBy(
                        s -> String.valueOf(s.charAt(0)),
                        TreeMap::new,
                        Collectors.toList()
                ))
                .entrySet().stream()
                .map(entry -> {
                    List<String> filteredValues = entry.getValue().stream()
                            .filter(s -> s.length() % 2 == 0)
                            .toList();

                    List<String> innerList = new ArrayList<>();
                    innerList.add(entry.getKey());
                    innerList.addAll(filteredValues);
                    return innerList;
                })
                .toList();
    }

    public static void main(String[] args) {
        List<String> wordsList = Arrays.asList(
                "cherry",
                "blueberry",
                "citrus",
                "apple",
                "apricot",
                "banana",
                "coconut"
        );

        System.out.println(srt(wordsList));
    }
}
